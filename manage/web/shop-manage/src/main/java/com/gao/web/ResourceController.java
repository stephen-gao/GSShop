package com.gao.web;

import com.gao.base.result.Result;
import com.gao.base.result.ResultEnum;
import com.gao.base.result.ResultFactory;
import com.gao.entity.po.Resource;
import com.gao.service.IResourceHandleService;
import com.gao.service.IResourceService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/resource")
public class ResourceController {

    @Autowired
    private IResourceHandleService resourceHandleService;

    @Autowired
    IResourceService resourceService;

    @GetMapping("resourcetree")
    public Result resourceTree(){
        return resourceHandleService.resourceTree();
    }

    @PostMapping("add")
    public Result add(@RequestBody Resource resource){
        if(resource.getParentId() == null){
            return ResultFactory.getMessgaeResult(ResultEnum.PARAM_ERROR,"请选择父节点");
        }
        if(StringUtils.isBlank(resource.getCode())){
            return ResultFactory.getMessgaeResult(ResultEnum.PARAM_ERROR,"请输入节点编码");
        }
        if(StringUtils.isBlank(resource.getName())){
            return ResultFactory.getMessgaeResult(ResultEnum.PARAM_ERROR,"请输入节点名称");
        }
        Date date = new Date();
        resource.setGmtCreate(date);
        resource.setGmtUpdate(date);
        resourceService.save(resource);
        return ResultFactory.getDefaultResult(ResultEnum.SUCCESS);
    }

    @PostMapping("edit")
    public Result edit(@RequestBody Resource resource){
        if(resource.getParentId() == null){
            return ResultFactory.getMessgaeResult(ResultEnum.PARAM_ERROR,"请选择父节点");
        }
        if(StringUtils.isBlank(resource.getCode())){
            return ResultFactory.getMessgaeResult(ResultEnum.PARAM_ERROR,"请输入节点编码");
        }
        if(StringUtils.isBlank(resource.getName())){
            return ResultFactory.getMessgaeResult(ResultEnum.PARAM_ERROR,"请输入节点名称");
        }
        Date date = new Date();
        resource.setGmtUpdate(date);
        resourceService.updateById(resource);
        return ResultFactory.getDefaultResult(ResultEnum.SUCCESS);
    }

    @GetMapping("del")
    public Result add(@RequestParam String id){
        resourceService.removeById(id);
        return ResultFactory.getDefaultResult(ResultEnum.SUCCESS);
    }
}
