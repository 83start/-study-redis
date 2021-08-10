package com.study.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import java.util.HashMap;
import java.util.Set;

/**
 * jedis 操作 jedis
 *
 * @author 83_start
 * @details com.study.redis
 * @create 2021-08-05 2:16
 */
public class TestZSet {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);

        jedis.flushDB();

        // 添加多个元素
        HashMap<String, Double> zaddMap = new HashMap<String, Double>();
        zaddMap.put("caoJun", Double.valueOf("2"));
        zaddMap.put("chenLong", Double.valueOf("4"));
        zaddMap.put("hanXin", Double.valueOf("5"));
        zaddMap.put("huangQiong", Double.valueOf("7"));
        Long zadd = jedis.zadd("zadd", zaddMap);
        System.out.println("添加多个元素：" + zadd);

        // 获取区间内的元素
        // 获取全部元素
        Set<String> zrange0 = jedis.zrange("zadd", 0, -1);
        System.out.println("获取全部元素：" + zrange0);
        // 获取区间元素
        Set<String> zrange1 = jedis.zrange("zadd", 0, 1);
        System.out.println("获取区间元素：" + zrange1);
        // 获取元素带成绩 Score - Val
        Set<Tuple> zrangeWithScores = jedis.zrangeWithScores("zadd", 0, -1);
        System.out.println("获取元素带成绩 Score - Val：" + zrangeWithScores);

        // 获取score[i,j]分数区间的元素 Score-Val
        Set<String> zrangeByScore = jedis.zrangeByScore("zadd", 0, 9);
        System.out.println("获取score[i,j]分数区间的元素 Score-Val：" + zrangeByScore);

        // 获取ZSet里value元素的Score
        Double zscore = jedis.zscore("zadd", "caoJun");
        System.out.println("获取ZSet里value元素的Score：" + zscore);

        // 获取ZSet里value元素的score的排名
        Long zrank = jedis.zrank("zadd", "caoJun");
        System.out.println("获取ZSet里value元素的score的排名：" + zrank);

        // 删除元素
        Long zrem = jedis.zrem("zadd", "caoJun");
        System.out.println("删除元素：" + zrem);

        // 获取元素的个数
        Long zcard = jedis.zcard("zadd");
        System.out.println("获取元素的个数：" + zcard);

        // 获取score在[i,j]区间的元素个数
        Long zcount = jedis.zcount("zadd", 0, 1);
        System.out.println("获取score在[i,j]区间的元素个数：" + zcount);

        // 成绩自增
        Double zincrby = jedis.zincrby("zadd", 4, "caoJun");
        System.out.println("成绩自增：" + zincrby);
    }
}
