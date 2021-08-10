package com.study.redis;

import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Jedis 对 String 的操作
 *
 * @author 83_start
 * @details com.study.redis
 * @create 2021-08-04 23:56
 */
public class TestString {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);

        // 添加单个值
        String set = jedis.set("key1", "value1");
        System.out.println("设置单个值：" + set);

        // 键不存在时设置多个值
        Long setnx = jedis.setnx("key1", "value1");
        System.out.println("键不存在时设置多个值：" + setnx);

        // 设置值并设置有效时间
        String setex = jedis.setex("keytime", 6, "value");
        System.out.println("设置值并设置有效时间：" + setex);

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 修改单个值
        String newSet = jedis.set("key1", "v1");
        System.out.println("修改单个值：" + newSet);

        // 追加值
        Long append = jedis.append("key1", "append_value");
        System.out.println("追加值：" + append);

        // 获取单个值
        String key1 = jedis.get("key1");
        System.out.println("获取单个值：" + key1);

        // 删除单个键
        Long del = jedis.del("key1");
        System.out.println("删除单个值：" + del);

        // 添加多个值
        String mset = jedis.mset("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4");
        System.out.println("设置多个值：" + mset);

        // 获取多个值
        List<String> mget = jedis.mget("k1", "k2");
        System.out.println("获取多个值：" + mget);

        // 删除多个值
        Long delList = jedis.del("k1", "k2");
        System.out.println("删除多个值：" + delList);

        // 获取原址，更新为新值
        String newGetSet = jedis.getSet("k1", "newValue");
        System.out.println("获取原址，更新为新值：" + newGetSet);

        // 截取字符串
        String subK1 = jedis.getrange("k1", 2, 4);
        System.out.println("截取字符串：" + subK1);
    }
}
