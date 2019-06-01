package com.eureka.feign.hystrix;

import com.eureka.feign.ServiceHi;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

@Component
public class ServiceHiHystrix implements ServiceHi {


    @Override
    public String sayHiFromServiceHi(@PathVariable(value = "name") String name) {
        return "hi "+ name + " this messge send failed ";
    }
}
