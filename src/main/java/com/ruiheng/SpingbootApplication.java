package com.ruiheng;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
//扫描dao层
@MapperScan("com.ruiheng.mapper")
@ServletComponentScan(basePackages = {"com.ruiheng.filters"})
@EnableTransactionManagement//开启事务管理
public class SpingbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpingbootApplication.class, args);
        System.err.println("------------------【项目启动成功】------------------");
    }

//    //解决jpa no session问题
//    @Bean
//    public OpenEntityManagerInViewFilter openEntityManagerInViewFilter(){
//        return new OpenEntityManagerInViewFilter();
//    }
}
