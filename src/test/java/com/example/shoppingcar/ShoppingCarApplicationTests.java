package com.example.shoppingcar;

import com.example.shoppingcar.util.RedisUtils;
import com.example.shoppingcar.util.SnowFlake;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

//@SpringBootTest
class ShoppingCarApplicationTests {

    @Autowired
    RedisUtils redisUtils;
    @Autowired
    SnowFlake snowFlake;

    @Test
    void contextLoads() {


//
//        List<String> list1 = new ArrayList<>();
//        list1.add("1");
//        list1.add("2");
//
//        List<String> list2 = new ArrayList<>();
//        list2.add("3");
//        list2.add("4");
//
//        List<String> list3 = new ArrayList<>();
//        list3.addAll(list1);
////        list3.addAll(list2);
//
//        System.out.println(list3);

//        CompletableFuture.runAsync(()-> System.out.println("一个线程"));
//        CompletableFuture.runAsync(()-> System.out.println("二个线程"));

        son s = new son("xx",24);



    }
}
