package com.gao.web;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gao.base.result.Result;
import com.gao.base.result.ResultFactory;
import com.gao.entity.vo.SysDicVO;
import com.gao.service.ISysDicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
