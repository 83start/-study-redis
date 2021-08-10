package com.study.redis;

import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * Jedis 对 List 操作
 *
 * @author 83_start
 * @details com.study.redis
 * @create 2021-08-05 0:30
 */
public class TestList {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);

        // 向 List 中添加元素(左)
        Long list0 = jedis.lpush("list", "java");
        System.out.println("(左)添加一个元素：" + list0);
        Long list1 = jedis.lpush("list", "python", "c++");
        System.out.println("(左)添加多个元素：" + list1);

        // 向 List 中添加元素(右)
        Long list2 = jedis.rpush("list", "java");
        System.out.println("(右)添加一个元素：" + list2);
        Long list3 = jedis.rpush("list", "python", "c++");
        System.out.println("(右)添加多个元素：" + list3);

        // 获得区间的列表
        List<String> lrange0 = jedis.lrange("list", 0, 3);
        System.out.println("获取[0,3]的区间列表：" + lrange0);
        //-1代表倒数第一个元素，-2代表倒数第二个元素,end为-1表示查询全部
        List<String> lrange1 = jedis.lrange("list", 0, -1);
        System.out.println("获取全部的区间列表：" + lrange1);

        // 左出栈
        String lpop = jedis.lpop("list");
        System.out.println("左出栈：" + lpop);

        // 右出栈
        String rpop = jedis.rpop("list");
        System.out.println("右出栈：" + rpop);

        // 删除列表中的指定值
        // 第二个参数为删除的个数（有重复时），后add进去的值先被删，类似于出栈
        Long lrem = jedis.lrem("list", 1, "java");
        System.out.println("删除列表中的指定值：" + lrem);

        // 截取列表的中的值
        String list = jedis.ltrim("list", 0, 2);
        System.out.println("截取列表的中的值：" + list);

        // 设置指定下标的内容
        String lset = jedis.lset("list", 1, "newValue");
        System.out.println("设置指定下标的内容：" + lset);

        // 获取列表中元素个数
        Long llen = jedis.llen("list");
        System.out.println("获取列表中元素个数：" + llen);

        // 获取指定下标的内容
        String lindex = jedis.lindex("list", 0);
        System.out.println("获取指定下标的内容：" + lindex);

        // 排序并返回一个新的集合
        jedis.lpush("sortedList", "3", "6", "2", "0", "7", "4");
        System.out.println("sortedList排序前：" + jedis.lrange("sortedList", 0, -1));
        List<String> sortedList = jedis.sort("sortedList");
        System.out.println("sortedList排序前：" + sortedList);
    }
}
