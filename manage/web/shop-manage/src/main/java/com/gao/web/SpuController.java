package com.gao.web;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gao.base.result.Result;
import com.gao.base.result.ResultFactory;
import com.gao.entity.vo.SpuVO;
import com.gao.service.ISpuService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *   前端控制器
 * </p>
 *
 * @author gaosheng
 * @since 2019-05-29
 */
@RestController
@RequestMapping("/spu")
public class SpuController {

    @Autowired
    private ISpuService spuService;

    @PostMapping("page")
    public Result page(@RequestBody SpuVO vo){
        IPage page = new Page();
        page.setCurrent(vo.getPageNum());
        page.setSize(vo.getPageSize());
        QueryWrapper wrapper = new QueryWrapper();
        if(!StringUtils.isBlank(vo.getId())){
            wrapper.eq("id",vo.getId());
        }
        if(!StringUtils.isBlank(vo.getTitle())){
            wrapper.like("title",vo.getTitle());
        }
        if(!StringUtils.isBlank(vo.getBrand())){
            wrapper.like("brand",vo.getBrand());
        }
        if(!StringUtils.isBlank(vo.getCategoryId())){
            wrapper.eq("category_id",vo.getCategoryId());
        }
        page  = spuService.page(page, wrapper);

        return ResultFactory.getDataResult(page);
    }
	
}
