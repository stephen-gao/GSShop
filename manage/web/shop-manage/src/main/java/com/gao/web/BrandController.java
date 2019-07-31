package com.gao.web;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gao.base.result.Result;
import com.gao.base.result.ResultEnum;
import com.gao.base.result.ResultFactory;
import com.gao.entity.po.Brand;
import com.gao.entity.vo.BrandVO;
import com.gao.service.IBrandService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.Date;

/**
 * <p>
 *   前端控制器
 * </p>
 *
 * @author gaosheng
 * @since 2019-05-29
 */
@RestController
@RequestMapping("/brand")
public class BrandController {

    @Autowired
    private IBrandService brandService;

    @PostMapping("page")
    public Result page(@RequestBody BrandVO vo){
        IPage page = new Page();
        page.setCurrent(vo.getPageNum());
        page.setSize(vo.getPageSize());
        QueryWrapper wrapper = new QueryWrapper();
        if(!StringUtils.isBlank(vo.getBrandName())){
            wrapper.like("brand_name",vo.getBrandName());
        }
        if(!StringUtils.isBlank(vo.getLetter())){
            wrapper.eq("letter",vo.getLetter());
            wrapper.orderByAsc("sort");
        }
        if(StringUtils.isBlank(vo.getLetter())){
            wrapper.orderByAsc("sort","letter");
        }
        page = brandService.page(page, wrapper);
        return ResultFactory.getDataResult(page);
    }

    @PostMapping("add")
    public Result add(@RequestBody Brand po){
        if(StringUtils.isBlank(po.getBrandName())){
            return ResultFactory.getMessgaeResult(ResultEnum.PARAM_ERROR,"品牌名称不能为空");
        }
        Date date = new Date();
        po.setGmtCreate(date);
        po.setGmtUpdate(date);
        brandService.save(po);
        return ResultFactory.getDefaultResult(ResultEnum.SUCCESS);
    }

    @PutMapping("edit")
    public Result edit(@RequestBody Brand po){
        if(StringUtils.isBlank(po.getBrandName())){
            return ResultFactory.getMessgaeResult(ResultEnum.PARAM_ERROR,"品牌名称不能为空");
        }
        po.setGmtUpdate(new Date());
        brandService.updateById(po);
        return ResultFactory.getDefaultResult(ResultEnum.SUCCESS);
    }

    @DeleteMapping("del")
    public Result del(@RequestParam("id") String id){
        brandService.removeById(id);
        return ResultFactory.getDefaultResult(ResultEnum.SUCCESS);
    }
}
