package com.study.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisSentinelPool;
import redis.clients.jedis.SortingParams;

import java.util.List;

/**
 * Jedis 排序操作
 *
 * @author 83_start
 * @details com.study.redis
 * @create 2021-08-05 3:02
 */
public class TestSort {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);

        jedis.flushDB();

        SortingParams sortingParams = new SortingParams();

        jedis.lpush("numList", "4", "5", "2", "1", "-92", "98", "7");
        // 队列按数字升序排列
        List<String> numListUp = jedis.sort("numList", sortingParams.asc());
        System.out.println("队列按数字升序排列：" + numListUp);
        // 队列按数字升序降列
        List<String> numListDown = jedis.sort("numList", sortingParams.desc());
        System.out.println("队列按数字降序排列：" + numListDown);

        jedis.lpush("nameList", "caoJun", "xieWei", "chenHe", "huangQiong", "hanXin", "liBai", "zhenZiDan");
        // 首字母排序
        List<String> nameList = jedis.sort("nameList", sortingParams.alpha());
        System.out.println("首字母排序：" + nameList);
    }
}
