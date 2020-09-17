package com.yiping.gao.study.annotation.configuration;


import org.springframework.stereotype.Component;

/**
 * @Author: 高一平
 * @Date: 2019/9/9 16:18
 * @Description: @Bean标注在方法上(返回某个实例的方法)，等价于Spring的xml配置文件中的<bean>，作用为：注册bean对象
 **/
public class TestBean2 {

    private String username;
    private String url;
    private String password;

    public void sayHello() {
        System.out.println("TestBean2 sayHello...");
    }

    @Override
    public String toString() {
        return "username:" + this.username + ",url:" + this.url + ",password:" + this.password;
    }

    public void start() {
        System.out.println("TestBean2 初始化。。。");
    }

    public void cleanUp() {
        System.out.println("TestBean2 销毁。。。");
    }

}
