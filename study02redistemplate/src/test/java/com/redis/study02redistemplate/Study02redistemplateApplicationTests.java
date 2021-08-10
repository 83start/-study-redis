package com.redis.study02redistemplate;

import com.redis.study02redistemplate.Utils.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class Study02redistemplateApplicationTests {

    @Autowired
    private RedisUtil redisUtil;
    @Test
    public void contextLoads() {
        redisUtil.set("python", "huangqiong");
        String python = (String)redisUtil.get("python");
        System.out.println(python);
    }
}
