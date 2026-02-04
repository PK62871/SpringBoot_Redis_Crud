package com.redis.command.service;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Service
public class RedisBasicCommand {

    private RedisTemplate<String,Object> redisTemplate;

    public RedisBasicCommand(RedisTemplate<String,Object> redisTemplate){
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    public void basicCommonMethod(){

        //Set Key Value
        redisTemplate.opsForValue().set("trial","Prabhakar");
        System.out.println("Inserted");

        //set Expiry of key
        Boolean expiry = redisTemplate.expire("name", 20, TimeUnit.SECONDS);
        System.out.println("Is Expiry Set :- "+ expiry);

        //Get Remaining  Time ........
        Long ttl = redisTemplate.getExpire("name");
        System.out.println("TTL :- "+ ttl);

        //rename Key
        //Here Value Will get override if key is already present
        redisTemplate.rename("trial","name");

        //Get Remaining Time of key  in Second.....
        Long remaining = redisTemplate.getExpire("name", TimeUnit.SECONDS);
        System.out.println("Remaining :- "+ remaining);

        //Rename The Key If New Keu is not already Present So Value will not get Override
        // In above renamed Value will get override
        Boolean b = redisTemplate.renameIfAbsent("name", "name");
        System.out.println("Renamed If Absent :- "+ b);


        //Remove Expiry From Key..............
        Boolean removedTtl = redisTemplate.persist("name");
        System.out.println("TTL  Removed:- "+ removedTtl);

        //Delete a Single Key or Multiple Key at a Same time...........
        //But This is synchronous command..

       // Boolean deleted = redisTemplate.delete("name");
        //System.out.println("Deleted :- "+ deleted);

        //Delete Key as single or multiple at a time asynchronously
        Boolean name = redisTemplate.unlink("name");
        System.out.println("Unlinked Name :- "+ name);


        //Flush All DB Keys.........................................
        Objects.requireNonNull(redisTemplate.getConnectionFactory(),"Connection Factory Must Required");
        redisTemplate.getConnectionFactory()
                .getConnection()
                .serverCommands()
                .flushDb();
    }
}
