package com.yiping.gao.common.utils.redis;

import com.yiping.gao.config.redis.RedisTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: 高一平
 * @Date: 2019/9/10 16:05
 * @Description:
 **/
public class RedisUtils {

    @Autowired
    private RedisTemplate redisTemplate;

    public void setRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     * 普通缓存获取
     *
     * @param key 键
     * @return 值
     */
    public Object get(String key, int indexDB) {
        RedisTemplate.indexDB.set(indexDB);
        return key == null ? null : redisTemplate.opsForValue().get(key);
    }

    /**
     * 普通缓存放入
     *
     * @param key   键
     * @param value 值
     * @return true成功 false失败
     */
    public boolean set(String key, Object value, int indexDB) {
        try {
            RedisTemplate.indexDB.set(indexDB);
            redisTemplate.opsForValue().set(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
}
