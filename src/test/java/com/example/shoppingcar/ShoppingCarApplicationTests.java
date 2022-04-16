package com.example.shoppingcar;

import com.example.shoppingcar.util.RedisUtils;
import com.example.shoppingcar.util.SnowFlake;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ShoppingCarApplicationTests {

    @Autowired
    RedisUtils redisUtils;
    @Autowired
    SnowFlake snowFlake;
    @Test
    void contextLoads() {

//        redisUtils.set("ee",2233);
        System.out.println(snowFlake.getNextId());
    }

}
