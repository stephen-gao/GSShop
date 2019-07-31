package com.gao.service.impl;

import com.alibaba.fastjson.JSON;
import com.gao.base.result.Result;
import com.gao.base.result.ResultEnum;
import com.gao.base.result.ResultFactory;
import com.gao.base.utils.MD5;
import com.gao.base.utils.SaltUtils;
import com.gao.base.utils.TokenProccessor;
import com.gao.entity.po.User;
import com.gao.entity.vo.ResourceVO;
import com.gao.entity.vo.UserVO;
import com.gao.mapper.ResourceMapper;
import com.gao.redis.cache.ICache;
import com.gao.service.ILoginService;
import com.gao.service.IUserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author gs
 * @Date created time 2019/5/28 12:27
 * @Description
 */
@Service
public class LoginServiceImpl implements ILoginService{

    private Logger logger = LogManager.getLogger(this.getClass());

    @Value("${redis.cache.user.key}")
    private String userCacheKey;

    @Autowired
    private IUserService userService;

    @Autowired
    private ResourceMapper resourceMapper;

    @Autowired
    private ICache cache;

    public Result login(User user) {
        User one = userService.selectByUserName(user.getUsername());
        if(one == null){
            return ResultFactory.getMessgaeResult(ResultEnum.PARAM_ERROR,"用户名不存在");
        }
        if(one.getPassword().equals(MD5.encrypt(user.getPassword(),user.getUsername(),one.getSalt()))){
            UserVO vo = new UserVO();
            BeanUtils.copyProperties(one,vo);
            String token = TokenProccessor.makeToken();
            vo.setToken(token);
            cache.setHalfHour(userCacheKey+token,vo);
            List<ResourceVO> menus = getUserMenu(vo.getId());
            vo.setMenus(menus);
            return ResultFactory.getDataResult(vo);
        }else {
            return ResultFactory.getMessgaeResult(ResultEnum.PARAM_ERROR,"密码错误");
        }
    }

    @Override
    public Result logout(String token) {
        cache.remove(userCacheKey+token);
        return ResultFactory.getMessgaeResult(ResultEnum.SUCCESS,"退出成功");
    }

    private List<ResourceVO> getUserMenu(String userId){
        List<ResourceVO> list = resourceMapper.getUserMenu(userId);
        List<ResourceVO> menus = new ArrayList<>();
        ResourceVO root = new ResourceVO();
        root.setId("0");
        List<ResourceVO> children = null;
        for(ResourceVO r : list){
            if(root.getId().equals(r.getParentId())){
                children = new ArrayList<>();
                for(ResourceVO sr: list){
                    if(r.getId().equals(sr.getParentId())){
                        children.add(sr);
                    }
                }
                r.setChildren(children);
                menus.add(r);
            }
        }
        return menus;
    }

}
