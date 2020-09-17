package com.yiping.gao.controller;

import com.yiping.gao.common.utils.redis.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.yiping.gao.pojo.dto.Result;
import com.yiping.gao.common.utils.ResultUtils;

/**
 * @Author: 高一平
 * @Date: 2019/9/10 20:52
 * @Description:
 **/
@RestController
@Slf4j
public class RedisController {

    @Autowired
    private RedisUtils redisUtil;

    @RequestMapping("/redis")
    public Result redisTest(){
        redisUtil.set("redis_test", "测试数据1", 2);
        log.info("测试1存储成功");
        String value1 = (String) redisUtil.get("redis_test", 2);
        log.info(value1);
        redisUtil.set("redis_test", "测试数据2", 4);
        String value2 = (String) redisUtil.get("redis_test", 4);
        log.info("测试2存储成功");
        log.info(value2);
        return ResultUtils.success();
    }

}
