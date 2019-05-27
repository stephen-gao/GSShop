package com.eureka.controller;

import com.eureka.feign.ServiceHi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ServiceHi serviceHi;

    @GetMapping("/index/{name}")
    public String home(@PathVariable String name) {
        logger.info(name);
        return serviceHi.sayHiFromServiceHi(name) ;
    }


}
