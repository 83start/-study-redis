package com.study.redis;

import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * Jedis 对 key 的操作
 *
 * @author 83_start
 * @details com.study.redis
 * @create 2021-08-04 22:53
 */
public class TestKey {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);


        // 判断某个值是否存在
        Boolean user = jedis.exists("user");
        System.out.println("判断某个值是否存在：" + user);

        // 匹配数据库中的键
        Set<String> keys = jedis.keys("*");
        System.out.println("匹配数据库中的键：" + keys);

        // 查看值的类型
        String type = jedis.type("key");
        System.out.println("查看值的类型：" + type);

        // 随机返回key空间的一个
        String randomKey = jedis.randomKey();
        System.out.println("随机返回key空间的一个：" + randomKey);

        // 重命名key
        String rename = jedis.rename("oldName", "newName");
        System.out.println("重命名key：" + rename);

        // 按索引查询
        String select = jedis.select(7);
        System.out.println("按索引查询：" + select);

        // 查询数据中的key 的数量
        Long aLong = jedis.dbSize();
        System.out.println("查询数据中的key 的数量" + aLong);

        // 清空当前数据库
        String flushDB = jedis.flushDB();
        System.out.println("清空当前数据库：" + flushDB);

        // 清空所有的数据库
        String flushAll = jedis.flushAll();
        System.out.println("清空所有数据库：" + flushAll);
    }
}
