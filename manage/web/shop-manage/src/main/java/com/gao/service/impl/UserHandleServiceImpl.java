package com.gao.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gao.base.result.Result;
import com.gao.base.result.ResultFactory;
import com.gao.base.utils.MD5;
import com.gao.base.utils.SaltUtils;
import com.gao.entity.po.User;
import com.gao.entity.po.UserRole;
import com.gao.entity.vo.UserVO;
import com.gao.mapper.UserMapper;
import com.gao.mapper.UserRoleMapper;
import com.gao.service.IUserHandleService;
import com.gao.service.IUserRoleService;
import com.gao.service.IUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @Author gs
 * @Date created time 2019/6/4 17:20
 * @Description
 */
@Service
public class UserHandleServiceImpl implements IUserHandleService {

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public Result userPage(UserVO vo) {
        Page page = new Page();
        page.setCurrent(vo.getPageNum());
        page.setSize(vo.getPageSize());
        QueryWrapper wrapper = new QueryWrapper();
        if (!StringUtils.isBlank(vo.getUsername())) {
            wrapper.like("username", vo.getUsername());
        }
        page.setRecords(userMapper.pageList(page, wrapper));
        return ResultFactory.getDataResult(page);
    }

    @Override
    @Transactional
    public void addUser(UserVO vo) {
        User po = new User();
        BeanUtils.copyProperties(vo,po);
        Date date = new Date();
        po.setGmtCreate(date);
        po.setGmtUpdate(date);
        String salt = SaltUtils.getSalt();
        po.setSalt(salt);
        String encrypt = MD5.encrypt(po.getPassword(),po.getUsername(),po.getSalt());
        po.setPassword(encrypt);
        userMapper.insert(po);
        UserRole userRole = new UserRole();
        userRole.setRoleId(vo.getRoleId());
        userRole.setUserId(po.getId());
        userRoleMapper.insert(userRole);
    }

    @Override
    public void updUser(UserVO vo) {
        User po = new User();
        BeanUtils.copyProperties(vo,po);
        Date date = new Date();
        po.setGmtUpdate(date);
        String salt = SaltUtils.getSalt();
        po.setSalt(salt);
        String encrypt = MD5.encrypt(po.getPassword(),po.getUsername(),po.getSalt());
        po.setPassword(encrypt);
        userMapper.updateById(po);
        UpdateWrapper wrapper = new UpdateWrapper();
        wrapper.eq("user_id",po.getId());
        UserRole userRole = new UserRole();
        userRole.setRoleId(vo.getRoleId());
        userRoleMapper.update(userRole,wrapper);
    }

    @Override
    public Result get(String id) {
        User user = userMapper.selectById(id);
        UserVO vo = new UserVO();
        BeanUtils.copyProperties(user,vo);
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("user_id",id);
        UserRole role = userRoleMapper.selectOne(wrapper);
        vo.setRoleId(role.getRoleId());
        return ResultFactory.getDataResult(vo);
    }

    @Override
    public void del(String id) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("user_id",id);
        userRoleMapper.delete(wrapper);
        userMapper.deleteById(id);
    }
}
