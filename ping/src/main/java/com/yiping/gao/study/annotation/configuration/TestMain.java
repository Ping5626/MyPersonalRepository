package com.yiping.gao.study.annotation.configuration;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: 高一平
 * @Date: 2019/9/9 16:14
 * @Description:
 **/
public class TestMain {
    public static void main(String[] args) {
        /**
         * @Configuration注解的Spring容器加载方式，用AnnotationConfigApplicationContext替换ClassPathXmlApplicationContext
         */
        ApplicationContext context = new AnnotationConfigApplicationContext(TestConfiguration.class);

        /**
         * 获取bean
         */
        TestBean tb = (TestBean) context.getBean("testBean");
        tb.sayHello();

        DataSource ds = (DataSource) context.getBean("dataSource");
        System.out.println(ds);
    }
}
