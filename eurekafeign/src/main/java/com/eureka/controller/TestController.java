package com.eureka.controller;

import com.eureka.feign.ServiceHi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author gs
 * @Date created time 2019/5/9 15:10
 * @Description
 */
@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private ServiceHi serviceHi;

    @GetMapping("/index/{name}")
    public String home(@PathVariable String name) {
        return serviceHi.sayHiFromServiceHi(name) ;
    }
}
