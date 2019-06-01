package com.gao.web;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gao.base.result.Result;
import com.gao.base.result.ResultEnum;
import com.gao.base.result.ResultFactory;
import com.gao.entity.po.SysDicItem;
import com.gao.entity.po.SysDicType;
import com.gao.entity.vo.SysDicVO;
import com.gao.service.ISysDicService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("sysdic")
public class SysDicController {

    @Autowired
    private ISysDicService sysDicService;

    @PostMapping("sysdicpage")
    public Result sysdicPage(@RequestBody SysDicVO vo){
        IPage page = sysDicService.sysDicTypePage(vo);
        return ResultFactory.getDataResult(page);
    }

    @PostMapping("adddictype")
    public Result addDicType(@RequestBody SysDicType po){
        sysDicService.addSysDicType(po);
        return ResultFactory.getDefaultResult(ResultEnum.SUCCESS);
    }

    @PostMapping("adddicitem")
    public Result addDicItem(@RequestBody SysDicItem po){
        sysDicService.addSysDicItem(po);
        return ResultFactory.getDefaultResult(ResultEnum.SUCCESS);
    }

    @GetMapping("deldictype")
    public Result delDicType(@RequestParam("id") String id){
        sysDicService.delSysDicType(id);
        return ResultFactory.getDefaultResult(ResultEnum.SUCCESS);
    }

    @GetMapping("deldicitem")
    public Result delDicItem(@RequestParam("id") String id){
        sysDicService.delSysDicItem(id);
        return ResultFactory.getDefaultResult(ResultEnum.SUCCESS);
    }

    @GetMapping("dicitemsbtypeid")
    public Result getDicItemsByTypeId(@RequestParam("typeId") String typeId){
        List list = sysDicService.sysDicItemListByTypeId(typeId);
        return ResultFactory.getDataResult(list);
    }

}
