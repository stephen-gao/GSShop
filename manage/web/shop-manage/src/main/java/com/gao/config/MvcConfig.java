package com.gao.config;

import com.gao.interceptor.AuthorityInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

@Configuration
public class MvcConfig implements WebMvcConfig{
    @Autowired
    private AuthorityInterceptor authorityInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        InterceptorRegistration interceptorRegistration = registry.addInterceptor(authorityInterceptor);
        interceptorRegistration.addPathPatterns("/user/**");
        interceptorRegistration.addPathPatterns("/resource/**");
        interceptorRegistration.addPathPatterns("/sysdic/**");
        interceptorRegistration.addPathPatterns("/role/**");
        interceptorRegistration.addPathPatterns("/customer/**");
        interceptorRegistration.addPathPatterns("/spu/**");
        interceptorRegistration.addPathPatterns("/logout");
        interceptorRegistration.excludePathPatterns("/login");
        interceptorRegistration.excludePathPatterns("/notlogin");
        interceptorRegistration.excludePathPatterns("/noAuthority");
    }
}