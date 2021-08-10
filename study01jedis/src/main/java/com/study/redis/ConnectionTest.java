package com.study.redis;

import redis.clients.jedis.Jedis;

/**
 * redis 连接数据库操作
 *
 * @author 83_start
 * @details com.study.redis
 * @create 2021-08-04 22:45
 */
public class ConnectionTest {
    /**
     * 连接数据库测试
     */
    public void connectRedis() {
        // 连接数据库
        Jedis jedis = new Jedis("127.0.0.1", 6379);

        // 测试连接
        String ping = jedis.ping();
        System.out.println(ping);
    }
}
