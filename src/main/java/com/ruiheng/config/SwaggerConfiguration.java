package com.ruiheng.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2     // Swagger的开关，表示已经启用Swagger
@Configuration      // 声明当前配置类
public class SwaggerConfiguration {

    /**
     * controller接口所在的包
     */
    @Value("com.ruiheng.controller")
    private String basePackage;
    /**
     * 当前文档的标题
     */
    @Value("接口API")
    private String title;
    /**
     * 当前文档的详细描述
     */
    @Value("接口文档")
    private String description;
    /**
     * 当前文档的版本
     */
    @Value("${swagger.version}")
    private String version;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(basePackage))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(title)
                .description(description)
                .version(version)
                .build();
    }

}
