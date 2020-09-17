package com.yiping.gao.study.annotation.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: 高一平
 * @Date: 2019/9/9 15:26
 * @Description: @Configuration注解
 * ************************************************************************************************************
 * 用于定义配置类，可替换xml配置文件
 * 被注解的类内部包含有一个或多个被@Bean注解的方法
 * 这些方法将会被AnnotationConfigApplicationContext或AnnotationConfigWebApplicationContext类进行扫描
 * 并用于构建bean定义，初始化Spring容器。
 * ************************************************************************************************************
 * 注意：@Configuration注解的配置类有如下要求：
 * 1、 @Configuration不可以是final类型；
 * 2、 @Configuration不可以是匿名类；
 * 3、 嵌套的configuration必须是静态类。
 * ************************************************************************************************************
 **/
@Configuration
// 添加自动扫描注解，basePackages为TestBean包路径
@ComponentScan(basePackages = "yiping.gao.annotation")
public class TestConfiguration {
    public TestConfiguration() {
        System.out.println("TestConfiguration容器启动初始化。。。");
    }

    @Configuration
    static class DatabaseConfig {
        @Bean
        DataSource dataSource() {
            return new DataSource();
        }
    }
}
