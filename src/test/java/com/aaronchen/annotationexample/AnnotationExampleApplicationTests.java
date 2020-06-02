package com.aaronchen.annotationexample;

import com.aaronchen.annotationexample.redis.RedisService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class AnnotationExampleApplicationTests {

    @Autowired
    RedisService redisService;

    @Test
    void contextLoads() {
        boolean flag = redisService.lock("test","123");
        System.out.println("插入结果 = "+flag);
        System.out.println("get="+redisService.get("test"));
        flag = redisService.unlock("test","1231");
        System.out.println("删除结果 = "+flag);
    }

    public static void main(String[] args) {
        println(System.getProperties());
        println(System.getProperty("user.home"));
        println(System.getProperty("user.age","3"));
    }

    static void println(Object object){
        System.out.println(object);
    }
}
