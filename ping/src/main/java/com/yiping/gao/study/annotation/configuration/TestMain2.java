package com.yiping.gao.study.annotation.configuration;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: 高一平
 * @Date: 2019/9/9 16:14
 * @Description:
 **/
public class TestMain2 {
    public static void main(String[] args) {
        /**
         * @Configuration注解的Spring容器加载方式，用AnnotationConfigApplicationContext替换ClassPathXmlApplicationContext
         */
        ApplicationContext context = new AnnotationConfigApplicationContext(WebConfig.class);

        /**
         * 获取bean
         */
        TestBean2 tb2 = (TestBean2) context.getBean("testBean2");
        tb2.sayHello();

        TestBean tb = (TestBean) context.getBean("testBean");
        tb.sayHello();
    }
}


