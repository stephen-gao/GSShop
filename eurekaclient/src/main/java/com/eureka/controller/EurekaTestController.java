package com.eureka.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author gs
 * @Date created time 2019/5/9 14:41
 * @Description
 */
@Controller
@EnableEurekaClient
public class EurekaTestController {

    @Value("${server.port}")
    private String port;
    /**
     * 定义一个简单接口
     */
    @ResponseBody
    @GetMapping("/hi/{name}")
    public String home(@PathVariable String name) {
        return "hi " + name + ",I am from port "+port ;
    }
}
