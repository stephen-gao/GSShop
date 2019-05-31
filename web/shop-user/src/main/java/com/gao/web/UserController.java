package com.gao.web;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gao.base.result.Result;
import com.gao.base.result.ResultFactory;
import com.gao.entity.po.User;
import com.gao.entity.vo.UserVO;
import com.gao.service.IUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author gs
 * @Date created time 2019/5/28 16:06
 * @Description
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/userPage")
    public Result<IPage<User>> userPage(@RequestBody UserVO vo){
        Page page = new Page();
        page.setCurrent(vo.getPageNum());
        page.setSize(vo.getPageSize());
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.select("id,username","nickname","tel","balance","gmt_create","gmt_update");
        if(!StringUtils.isBlank(vo.getUsername())){
            wrapper.like("username",vo.getUsername());
        }
        IPage currentPage = userService.page(page, wrapper);
        return ResultFactory.getDataResult(currentPage);
    }
}
