/*
 * Ant Group
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.alipay.cloudrun.superapp.service.impl;

import com.alipay.cloudrun.superapp.service.RedisService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author siwei
 * @version RedisServiceImpl.java, v 0.1 2023年04月05日 00:11 siwei
 */
@Log4j2
@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    StringRedisTemplate redisTemplate;

    /**
     * 获取缓存值
     *
     * @param key 关键
     * @return {@link String}
     */
    @Override
    public String get(String key) {

        log.info("get cache value, key = {}", key);
        return redisTemplate.opsForValue().get(key);

    }

    /**
     * 设置缓存值
     *
     * @param key     key
     * @param value   value
     * @param timeout 过期时间
     */
    @Override
    public void set(String key, String value, Long timeout) {

        log.info("set cache value, key = {}, value = {}, timeout = {}", key, value, timeout);
        if (timeout == null || timeout == 0) {
            redisTemplate.opsForValue().set(key, value);
        } else {
            redisTemplate.opsForValue().set(key, value, timeout, TimeUnit.SECONDS);
        }

    }

    /**
     * 获取匹配的缓存KV
     *
     * @param pattern pattern
     * @return {@link Map}<{@link String}, {@link String}>
     */
    @Override
    public Map<String, String> getByPattern(String pattern) {

        log.info("get cache value by pattern, pattern = {}", pattern);
        if (pattern == null || pattern.trim().isEmpty()) {
            pattern = "*";
        }
        Set<String> keys = redisTemplate.keys(pattern);
        return keys.stream().collect(Collectors.toMap(key -> key, key -> redisTemplate.opsForValue().get(key)));

    }

    /**
     * 删除缓存值
     *
     * @param key key
     * @return boolean
     */
    @Override
    public boolean delete(String key) {

        log.info("delete cache value, key = {}", key);
        return redisTemplate.delete(key);

    }
}