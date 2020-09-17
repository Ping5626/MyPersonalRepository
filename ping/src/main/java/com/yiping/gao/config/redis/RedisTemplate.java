package com.yiping.gao.config.redis;

import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnection;

/**
 * @Author: 高一平
 * @Date: 2019/9/10 15:52
 * @Description: 重写RedisTemplate, 加入选库
 * 重写自带的RedisTemplate
 * 该类继承了SpringDataRedis的RedisTemplate类
 * 我们加入indexDB为Redis库的编号
 * 重写了里面的RedisConnection方法
 * 加入是否有库值传递进来的逻辑判断
 * ***********************************************************************************************************
 * 加入int型的indexDB参数，用来接收库编号
 * 通过redisTemplate.indexDB.set(indexDB);完成选库操作
 * 由于我们在内部使用finally清除了选库，所以不必担心下次操作库的缓存问题
 **/
public class RedisTemplate extends org.springframework.data.redis.core.RedisTemplate {

    public static ThreadLocal<Integer> indexDB = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    @Override
    protected RedisConnection preProcessConnection(RedisConnection connection, boolean existingConnection) {
        try {
            Integer dbIndex = indexDB.get();
            //如果设置了dbIndex
            if (dbIndex != null) {
                if (connection instanceof JedisConnection) {
                    if (((JedisConnection) connection).getNativeConnection().getDB().intValue() != dbIndex) {
                        connection.select(dbIndex);
                    }
                } else {
                    connection.select(dbIndex);
                }
            } else {
                connection.select(0);
            }
        } finally {
            indexDB.remove();
        }
        return super.preProcessConnection(connection, existingConnection);
    }

}
