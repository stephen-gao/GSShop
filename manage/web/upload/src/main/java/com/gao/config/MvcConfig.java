package com.gao.config;

import com.gao.interceptor.AuthorityInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

/**
 * @Author gs
 * @Date created time 2019/6/11 12:05
 * @Description
 */
@Configuration
public class MvcConfig implements WebMvcConfig{

    @Autowired
    private AuthorityInterceptor authorityInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        InterceptorRegistration interceptorRegistration = registry.addInterceptor(authorityInterceptor);
        interceptorRegistration.addPathPatterns("/upload/**");
        interceptorRegistration.excludePathPatterns("/notlogin");
        interceptorRegistration.excludePathPatterns("/noAuthority");
        interceptorRegistration.excludePathPatterns("/image/**");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/image/**").addResourceLocations("file:E:/data/old/");
    }
}
