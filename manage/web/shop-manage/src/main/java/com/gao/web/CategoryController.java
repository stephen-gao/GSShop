package com.gao.web;

import com.gao.base.result.Result;
import com.gao.base.result.ResultEnum;
import com.gao.base.result.ResultFactory;
import com.gao.entity.po.Category;
import com.gao.entity.vo.CategoryVO;
import com.gao.service.ICategoryService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 分类表  前端控制器
 * </p>
 *
 * @author gaosheng
 * @since 2019-05-29
 */
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("categorytree")
    public Result categoryTree(){
        List<CategoryVO> tree = categoryService.getCategoryTree();
        return ResultFactory.getDataResult(tree);
    }

    @PostMapping("add")
    public Result add(@RequestBody Category po){
        if(StringUtils.isBlank(po.getCategoryName())){
            return ResultFactory.getMessgaeResult(ResultEnum.PARAM_ERROR,"分类名称不能为空");
        }
        Date date = new Date();
        po.setGmtCreate(date);
        po.setGmtUpdate(date);
        categoryService.save(po);
        return ResultFactory.getDefaultResult(ResultEnum.SUCCESS);
    }

    @PostMapping("edit")
    public Result edit(@RequestBody Category po){
        if(StringUtils.isBlank(po.getCategoryName())){
            return ResultFactory.getMessgaeResult(ResultEnum.PARAM_ERROR,"分类名称不能为空");
        }
        Date date = new Date();
        po.setGmtUpdate(date);
        categoryService.updateById(po);
        return ResultFactory.getDefaultResult(ResultEnum.SUCCESS);
    }

    @GetMapping("del")
    public Result del(@RequestParam String id){
        categoryService.removeById(id);
        return ResultFactory.getDefaultResult(ResultEnum.SUCCESS);
    }

}
