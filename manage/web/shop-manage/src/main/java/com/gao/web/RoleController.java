package com.gao.web;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gao.base.result.Result;
import com.gao.base.result.ResultEnum;
import com.gao.base.result.ResultFactory;
import com.gao.entity.po.Role;
import com.gao.entity.vo.RoleVO;
import com.gao.service.IRoleHandleService;
import com.gao.service.IRoleService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author gs
 * @Date created time 2019/6/3 18:11
 * @Description
 */
@RestController
@RequestMapping("role")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    @Autowired
    private IRoleHandleService roleHandleService;

    @PostMapping("page")
    public Result rolePage(@RequestBody RoleVO vo){
        Page<Role> page = new Page<>();
        page.setCurrent(vo.getPageNum());
        page.setSize(vo.getPageSize());
        QueryWrapper wrapper = new QueryWrapper();
        if(!StringUtils.isBlank(vo.getName())) {
            wrapper.like("name", vo.getName());
        }
        wrapper.orderByAsc("sort");
        IPage currentPage = roleService.page(page,wrapper);
        return ResultFactory.getDataResult(currentPage);
    }

    @GetMapping("list")
    public Result list(){
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.orderByAsc("sort");
        return ResultFactory.getDataResult(roleService.list(wrapper));
    }

    @PostMapping("add")
    public Result add(@RequestBody RoleVO vo){
        if(StringUtils.isBlank(vo.getName())){
            return ResultFactory.getMessgaeResult(ResultEnum.PARAM_ERROR,"权限名称不能为空");
        }
        roleHandleService.addRole(vo);
        return ResultFactory.getDefaultResult(ResultEnum.SUCCESS);
    }

    @GetMapping("get")
    public Result get(@RequestParam("id") String id){
        return roleHandleService.getRole(id);
    }

    @PostMapping("edit")
    public Result edit(@RequestBody RoleVO vo){
        if(StringUtils.isBlank(vo.getName())){
            return ResultFactory.getMessgaeResult(ResultEnum.PARAM_ERROR,"权限名称不能为空");
        }
        roleHandleService.updateRole(vo);
        return ResultFactory.getDefaultResult(ResultEnum.SUCCESS);
    }

    @GetMapping("del")
    public Result del(@RequestParam("id") String id){
        roleHandleService.delRole(id);
        return ResultFactory.getDefaultResult(ResultEnum.SUCCESS);
    }

}
