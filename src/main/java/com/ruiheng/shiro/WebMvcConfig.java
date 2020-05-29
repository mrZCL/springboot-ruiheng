package com.ruiheng.shiro;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;


/**
 * 跨域配置cors
 */
@Configuration
public class WebMvcConfig extends CorsFilter {

    public WebMvcConfig() {
        super(configurationSource());
    }


    private static UrlBasedCorsConfigurationSource configurationSource() {
        System.out.println("进入跨域配置cors过滤器");
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return source;
    }
}