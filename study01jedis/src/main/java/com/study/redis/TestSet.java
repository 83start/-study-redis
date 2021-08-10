package com.study.redis;

import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * Jedis 对 Set 操作
 *
 * @author 83_start
 * @details com.study.redis
 * @create 2021-08-05 1:09
 */
public class TestSet {
    public static void main(String[] args) {

        Jedis jedis = new Jedis("127.0.0.1", 6379);

        // 添加值
        Long sadd = jedis.sadd("set", "v1", "v2");
        System.out.println("添加值：" + sadd);

        // 查询所有的值
        Set<String> set = jedis.smembers("set");
        System.out.println("查询所有的值：" + set);

        // 随机的移除集合中的一个元素
        String spopset = jedis.spop("set");
        System.out.println("随机的移除集合中的一个元素：" + spopset);

        // 查询元素个数
        Long scard = jedis.scard("set");
        System.out.println("查询元素个数：" + scard);

        // 判断元素是否存在
        Boolean sismember = jedis.sismember("set", "v1");
        System.out.println("判断元素是否存在：" + sismember);

        // 将set中删除v1并存入set1中：
        Long smove = jedis.smove("set", "set1", "v1");
        System.out.println("将set中删除v1并存入set1中：" + smove);

        // ===================== 集合运算 =====================
        jedis.sadd("eleSet1", "e1", "e2", "e4", "e3", "e0", "e8", "e7", "e5");
        jedis.sadd("eleSet2", "e1", "e2", "e4", "e3", "e0", "e8");

        // 交集
        Set<String> sinter = jedis.sinter("eleSet1", "eleSet2");
        System.out.println("交集：" + sinter);
        // 并集
        Set<String> sunion = jedis.sunion("eleSet1", "eleSet2");
        System.out.println("并集：" + sunion);
        // 差集
        Set<String> sdiff = jedis.sdiff("eleSet1", "eleSet2");
        System.out.println("差集：" + sdiff);
        // 求交集并将交集保存到 dstkey 的集合
        Long sinterstore = jedis.sinterstore("eleSet", "eleSet1", "eleSet2");
        System.out.println("求交集并将交集保存到 dstkey 的集合：" + sinterstore + " " + jedis.smembers("eleSet"));
    }
}
