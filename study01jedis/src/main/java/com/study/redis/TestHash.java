package com.study.redis;

import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Jedis 操作 Hash
 *
 * @author 83_start
 * @details com.study.redis
 * @create 2021-08-05 1:37
 */
public class TestHash {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);

        // 添加多个元素
        HashMap<String, String> stringHashMap = new HashMap<String, String>();
        stringHashMap.put("k1", "v1");
        stringHashMap.put("k2", "v1");
        stringHashMap.put("k3", "v1");
        stringHashMap.put("k4", "v1");
        stringHashMap.put("k5", "v1");
        String hash = jedis.hmset("hash", stringHashMap);
        System.out.println("添加多个元素：" + hash);

        // 获取多个值
        List<String> hmget = jedis.hmget("hash", "k1", "k3");
        System.out.println("获取多个值：" + hmget);

        // 添加单个元素
        Long hset = jedis.hset("hash", "k6", "v6");
        System.out.println("添加单个元素：" + hset);

        // 获取单个值
        String hget = jedis.hget("hash", "k1");
        System.out.println("获取单个值：" + hget);

        // 获取所有的键值对
        Map<String, String> hgetAll = jedis.hgetAll("hash");
        System.out.println("获取所有的键值对：" + hgetAll);

        // 获取所有的键
        Set<String> hkeys = jedis.hkeys("hash");
        System.out.println("获取所有的键：" + hkeys);

        // 获取所有的值
        List<String> hvals = jedis.hvals("hash");
        System.out.println("获取所有的值：" + hvals);

        // 将key6保存的值加上一个整数，如果key6不存在则添加key6
        Long k7 = jedis.hincrBy("hash", "k7", 6);
        System.out.println("自增初始化：" + k7);
        Long k7_1 = jedis.hincrBy("hash", "k7", 6);
        System.out.println("自增：" + k7_1);

        // 删除键值对
        Long hdel = jedis.hdel("hash", "k3", "k4");
        System.out.println("删除键值对：" + hdel);

        // 获取键值对的个数
        Long hlen = jedis.hlen("hash");
        System.out.println("获取键值对的个数：" + hlen);

        // 判断值是否存在
        Boolean hexists = jedis.hexists("hash", "k1");
        System.out.println("判断值是否存在：" + hexists);
    }
}
