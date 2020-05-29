package com.ruiheng.utils.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
//
//@Configuration
//public class SystemConfig extends WebMvcConfigurationSupport {
//
//    @Autowired
//    private JwtInterceptor jwtInterceptor;
//
//    /**
//     * 添加拦截器
//     */
//    @Override
//    protected void addInterceptors(InterceptorRegistry registry) {
//        System.out.println("拦截器-------------");
//        //1.添加自定义拦截器
//        registry.addInterceptor(jwtInterceptor)
//                .addPathPatterns("/**")//指定拦截所有url
//                .excludePathPatterns("/user/login","/user/prefile");//指定不拦截的url
//    }
//}
