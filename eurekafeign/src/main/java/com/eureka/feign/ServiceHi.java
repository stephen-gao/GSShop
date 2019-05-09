package com.eureka.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author gs
 * @Date created time 2019/5/9 15:12
 * @Description
 */
@FeignClient(value = "service-hi")
public interface ServiceHi {

    @GetMapping("/hi/{name}")
    String sayHiFromServiceHi(@PathVariable(value = "name") String name);
}
