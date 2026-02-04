package com.redis.command.service;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Service
public class RedisStringMethod {

    private RedisTemplate<String,Object> redisTemplate;

    public RedisStringMethod(RedisTemplate<String,Object> redisTemplate){
        this.redisTemplate = redisTemplate;
    }


    @PostConstruct
    public void redisStringMethod(){

        //Set Key Value.........
        redisTemplate.opsForValue().set("name","Prabhakar");

        //Set Multiple Key At Same Time............................
        Map<String,String> map = Map.of(
                "age","24",
                "email","pk@gmail.com",
                "city","Mumbai"
        );
        redisTemplate.opsForValue().multiSet(map);

        // Fetch The Value Of Key......................
        Object name = redisTemplate.opsForValue().get("name");
        System.out.println("Value:"+name);

        //Get Multiple Value Of Keys at time...................
        List<String> keys = List.of("age","email","city");
        List<Object> objects = redisTemplate.opsForValue().multiGet(keys);
        System.out.println("Keys values :-" + objects);


        //Set Key Value With Expiry...........In Sec, Ms, Min, Hours.....etc
        redisTemplate.opsForValue().set("lastName","Kumar",10, TimeUnit.SECONDS);

        //Get The Length Of Value................
        Long length = redisTemplate.opsForValue().size("name");
        System.out.println("Size:"+length);


        //Set The Key If Key is not Present.........................
        Boolean b = redisTemplate.opsForValue().setIfAbsent("name", "Rohit");
        System.out.println("Is New Key Created :- " + b);

        //Set Integer Value.................
        redisTemplate.opsForValue().set("num",10);

        //Increment Value By 1....................................
        Long num = redisTemplate.opsForValue().increment("num");
        System.out.println("Increment:"+num);

        //Increment Value By Specific Number as we want.............
        Long num1 = redisTemplate.opsForValue().increment("num", 20);
        System.out.println("INCR Number By :-"+num1);

        //Decrease The Value By 1................
        Long num2 = redisTemplate.opsForValue().decrement("num");
        System.out.println("DECR Number  :-"+num2);

        //Decrease Value By any Specific Number.................
        Long num3 = redisTemplate.opsForValue().decrement("num", 5);
        System.out.println("DECR Number By :-"+num3);


        //Replace The Old Value Of key With New value...........................
        redisTemplate.opsForValue().set("replace","Value1");
        Boolean replaced = redisTemplate.opsForValue().setIfPresent("replace", "Value2");
        System.out.println("Is Replaced :-"+replaced);


        //Get The Key Value and Delete The Key....................
        Object replace = redisTemplate.opsForValue().getAndDelete("replace");
        System.out.println("Get And Deleted :-" + replace);


        //Flush All DB Keys.........................................
        Objects.requireNonNull(redisTemplate.getConnectionFactory(),"Connection Factory Must Required");
        redisTemplate.getConnectionFactory()
                .getConnection()
                .serverCommands()
                .flushDb();
    }
}
