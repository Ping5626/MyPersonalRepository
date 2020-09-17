package com.yiping.gao.study.annotation.configuration;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * @Author: 高一平
 * @Date: 2019/9/9 17:42
 * @Description:
 **/
@Configuration
@ImportResource("classpath:applicationContext-configuration.xml")
@Import(TestConfiguration.class)
public class WebConfig {
}
