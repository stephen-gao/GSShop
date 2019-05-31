package com.gao.config;

/**
 * @Author gs
 * @Date created time 2019/5/28 14:48
 * @Description
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer{

    @Autowired
    private AuthorityInterceptor authorityInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        InterceptorRegistration interceptorRegistration = registry.addInterceptor(authorityInterceptor);
        interceptorRegistration.addPathPatterns("/user/**/*");
        interceptorRegistration.addPathPatterns("/logout");
        interceptorRegistration.excludePathPatterns("/login");
        interceptorRegistration.excludePathPatterns("/noAuthority");
        interceptorRegistration.excludePathPatterns("/user/add");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "POST", "PUT", "OPTIONS", "DELETE", "PATCH")
                .allowCredentials(true).maxAge(3600);
    }
}