package com.aaronchen.annotationexample.redis;

import io.lettuce.core.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Aaron chen
 * @Date: 2020/5/9 3:10
 */
@Service
public class RedisService {
    @Autowired
    RedisTemplate redisTemplate;

    static final String LOCK_PREFIX = "Distributed_redis_lock";
    static final long LOCK_EXPIRE = 60000;
    static StringBuilder luaScript;
    private RedisSerializer<String> argsSerializer;
    private RedisSerializer<String> resultSerializer;
    static {
        luaScript = new StringBuilder();
        luaScript.append("if redis.call('get', KEYS[1]) == ARGV[1] ");
        luaScript.append("then ");
        luaScript.append("return redis.call('del', KEYS[1]) ");
        luaScript.append("else ");
        luaScript.append("return 0 end");
    }
    {
        argsSerializer = new StringRedisSerializer();
        resultSerializer = new StringRedisSerializer();
    }
    /**
     *  设置有失效期的key锁
     *
     * @param key key值
     * @return 是否获取到
     */
    public boolean lock(String key,String val){
        String lock = key;
        Boolean result = redisTemplate.opsForValue().setIfAbsent(lock,val,LOCK_EXPIRE, TimeUnit.MILLISECONDS);
        return result != null && result;
    }

    /**
     * 使用Lua脚本完成锁删除操作，以保证原子性
     * @param key
     * @param val
     * @return
     */
    public boolean unlock(String key,String val){
        Object o = redisTemplate.execute(RedisScript.of(luaScript.toString(),Long.class),
                argsSerializer,resultSerializer,Arrays.asList(key),val);
        System.out.println(o);
        Integer i = Integer.valueOf(o.toString());
        return i == 0 ? false: true ;
    }

    /**
     * 读取缓存
     *
     * @param key
     * @return
     */
    public Object get(final String key) {
        ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
        Object result = operations.get(key);
        return result;
    }
}
