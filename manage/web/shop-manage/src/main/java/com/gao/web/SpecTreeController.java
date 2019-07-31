package com.gao.web;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gao.base.result.Result;
import com.gao.base.result.ResultEnum;
import com.gao.base.result.ResultFactory;
import com.gao.entity.po.SpecTree;
import com.gao.entity.vo.SpecTreeVO;
import com.gao.service.ISpecTreeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * <p>
 *   前端控制器
 * </p>
 *
 * @author gaosheng
 * @since 2019-05-29
 */
@RestController
@RequestMapping("/spectree")
public class SpecTreeController {
    @Autowired
    private ISpecTreeService specTreeService;

    @GetMapping("tree")
    public Result specTree(@RequestParam("type")Integer type){
        List<SpecTreeVO> tree = specTreeService.specTree(type);
        return ResultFactory.getDataResult(tree);
    }

    @PostMapping("list")
    public Result list(@RequestBody SpecTreeVO vo){
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("type",vo.getType());
        wrapper.eq("parent_id",vo.getParentId());
        List list = specTreeService.list(wrapper);
        return ResultFactory.getDataResult(list);
    }

    @PostMapping("add")
    public Result add(@RequestBody SpecTree po){
        if(StringUtils.isBlank(po.getSpecName())){
            return ResultFactory.getMessgaeResult(ResultEnum.PARAM_ERROR,"请填写规格名称");
        }
        if(StringUtils.isBlank(po.getSpecValue())){
            return ResultFactory.getMessgaeResult(ResultEnum.PARAM_ERROR,"请填写规格值");
        }
        if(StringUtils.isBlank(po.getParentId())){
            return ResultFactory.getMessgaeResult(ResultEnum.PARAM_ERROR,"请填选择父节点");
        }
        Date date = new Date();
        po.setGmtCreate(date);
        po.setGmtUpdate(date);
        specTreeService.save(po);
        return ResultFactory.getDefaultResult(ResultEnum.SUCCESS);
    }

    @PutMapping("edit")
    public Result edit(@RequestBody SpecTree po){
        if(StringUtils.isBlank(po.getSpecName())){
            return ResultFactory.getMessgaeResult(ResultEnum.PARAM_ERROR,"请填写规格名称");
        }
        if(StringUtils.isBlank(po.getSpecValue())){
            return ResultFactory.getMessgaeResult(ResultEnum.PARAM_ERROR,"请填写规格值");
        }
        if(StringUtils.isBlank(po.getParentId())){
            return ResultFactory.getMessgaeResult(ResultEnum.PARAM_ERROR,"请填选择父节点");
        }
        po.setGmtUpdate(new Date());
        specTreeService.updateById(po);
        return ResultFactory.getDefaultResult(ResultEnum.SUCCESS);
    }

    @DeleteMapping("del")
    public Result del(@RequestParam("id") String id){
        specTreeService.removeById(id);
        return ResultFactory.getDefaultResult(ResultEnum.SUCCESS);
    }
}
