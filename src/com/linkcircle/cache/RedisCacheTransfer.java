package com.linkcircle.cache;

import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

/**
 * @className: RedisCacheTransfer
 * @description: redis中间过渡类
 * @author: llj
 * @createDate: 2017年05月24日 22:20:54
 * @version: 1.0
 */
public class RedisCacheTransfer {

    public void setJedisConnectionFactory(JedisConnectionFactory jedisConnectionFactory) {
        RedisCache.setJedisConnectionFactory(jedisConnectionFactory);
    }
}
