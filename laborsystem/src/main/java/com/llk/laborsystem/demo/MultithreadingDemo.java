package com.llk.laborsystem.demo;


import com.llk.laborsystem.utils.redis.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

public class MultithreadingDemo {

//    private static RedisUtil redisUtil;

    public static void main(String[] args) {
        RedisUtils redisUtils=new RedisUtils();
        String name = redisUtils.get("name");
        System.out.println(name);
    }

}
