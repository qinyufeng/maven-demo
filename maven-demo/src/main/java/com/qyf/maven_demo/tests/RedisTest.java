package com.qyf.maven_demo.tests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

public class RedisTest {
	@Autowired
	private  StringRedisTemplate redisTemplate;
	
	/**
	 * redis取值demo
	 */
	private void redisTest() {
		Object test1=get("name") ;
		System.out.println(test1);
	}
    /**
     * 读取缓存
     * @param key
     * @return
     */
    public Object get(final String key) {
        Object result = null;
        ValueOperations<String, String> operations = redisTemplate.opsForValue();
        result = operations.get(key);
        return result;
    }
    /**
     * 写入缓存
     * @param key
     * @param value
     * @return
     */
    private boolean set(String key, String value) {
        boolean result = false;
        try {
            ValueOperations<String, String> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
