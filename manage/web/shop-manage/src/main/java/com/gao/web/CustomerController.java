package com.gao.web;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gao.base.result.Result;
import com.gao.base.result.ResultEnum;
import com.gao.base.result.ResultFactory;
import com.gao.base.utils.MD5;
import com.gao.base.utils.SaltUtils;
import com.gao.entity.po.CustomerLogin;
import com.gao.entity.vo.CustomerVO;
import com.gao.service.ICustomerInfoService;
import com.gao.service.ICustomerLoginService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Author gs
 * @Date created time 2019/6/6 15:25
 * @Description
 */
@RestController
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    private ICustomerInfoService customerInfoService;

    @Autowired
    private ICustomerLoginService customerLoginService;

    @PostMapping("page")
    public Result page(@RequestBody CustomerVO vo){
        IPage page = new Page();
        page.setCurrent(vo.getPageNum());
        page.setSize(vo.getPageSize());
        QueryWrapper wrapper = new QueryWrapper();
        if(!StringUtils.isBlank(vo.getUsername())) {
            wrapper.like("username", vo.getUsername());
        }
        wrapper.orderByDesc("gmt_create");
        page = customerInfoService.page(page, wrapper);
        return ResultFactory.getDataResult(page);
    }

    @PostMapping("resetpwd")
    public Result resetPwd(@RequestBody CustomerVO vo){
        CustomerLogin cl = new CustomerLogin();
        cl.setId(vo.getLoginId());
        cl.setPassword("000000");//暂时写死，后期写入配置或传出
        customerLoginService.changePwd(cl);
        return ResultFactory.getDefaultResult(ResultEnum.SUCCESS);
    }

    @PostMapping("changestate")
    public Result changeState(@RequestBody CustomerVO vo){
        customerInfoService.changeState(vo.getId(),vo.getLoginId(),vo.getState());
        return ResultFactory.getDefaultResult(ResultEnum.SUCCESS);
    }
}
