package com.yiping.gao.study.annotation.scope;

/**
 * @Author: 高一平
 * @Date: 2019/9/9 19:16
 * @Description: @Scope注解
 * Spring中Scope是一个非常关键的概念，简单说就是对象在spring容器（IOC容器）中的生命周期，也可以理解为对象在spring容器中的创建方式
 * 目前，Scope的取值有5种取值：
 * 1）singleton （单一实例） 容器中创建时只存在一个实例，所有引用此bean都是单一实例。从容器启动到第一次被请求而实例化开始，只要容器不销毁或退出，该类型的bean的单一实例就会一直存活，典型单例模式
 * 2）prototype  在进行输出prototype的bean对象时，会每次都重新生成一个新的对象给请求方
 * *request，session和global session类型只实用于web程序*
 * 3）request
 * 4）session
 * 5）global session
 **/
public class TestScope {
}
