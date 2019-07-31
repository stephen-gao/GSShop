package com.gao.web;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gao.base.result.Result;
import com.gao.base.result.ResultEnum;
import com.gao.base.result.ResultFactory;
import com.gao.entity.po.User;
import com.gao.entity.vo.UserVO;
import com.gao.service.IUserHandleService;
import com.gao.service.IUserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author gs
 * @Date created time 2019/5/28 16:06
 * @Description
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private Logger logger = LogManager.getLogger(UserController.class);

    @Autowired
    private IUserService userService;

    @Autowired
    private IUserHandleService userHandleService;

    @PostMapping("/userPage")
    public Result<IPage<User>> userPage(@RequestBody UserVO vo) {
        return userHandleService.userPage(vo);
    }

    @PostMapping("/add")
    public Result add(@RequestBody UserVO vo){
        if(StringUtils.isBlank(vo.getUsername())){
            return ResultFactory.getMessgaeResult(ResultEnum.PARAM_ERROR,"用户名不能为空");
        }
        if(StringUtils.isBlank(vo.getPassword())){
            return ResultFactory.getMessgaeResult(ResultEnum.PARAM_ERROR,"密码不能为空");
        }
        User old = userService.selectByUserName(vo.getUsername());
        if(null != old && null != old.getId()){
            return ResultFactory.getMessgaeResult(ResultEnum.PARAM_ERROR,"用户名已存在");
        }
        logger.info(vo.getUsername() +" " + vo.getPassword());
        userHandleService.addUser(vo);
        return ResultFactory.getDefaultResult(ResultEnum.SUCCESS);
    }

    @PostMapping("/edit")
    public Result edit(@RequestBody UserVO vo){
        if(StringUtils.isBlank(vo.getUsername())){
            return ResultFactory.getMessgaeResult(ResultEnum.PARAM_ERROR,"用户名不能为空");
        }
        if(StringUtils.isBlank(vo.getPassword())){
            return ResultFactory.getMessgaeResult(ResultEnum.PARAM_ERROR,"密码不能为空");
        }
        logger.info(vo.getUsername() +" " + vo.getPassword());
        userHandleService.updUser(vo);
        return ResultFactory.getDefaultResult(ResultEnum.SUCCESS);
    }

    @GetMapping("get")
    public Result get(@RequestParam("id") String id){
        return userHandleService.get(id);
    }

    @GetMapping("del")
    public Result del(@RequestParam("id") String id){
        userHandleService.del(id);
        return ResultFactory.getDefaultResult(ResultEnum.SUCCESS);
    }
}
