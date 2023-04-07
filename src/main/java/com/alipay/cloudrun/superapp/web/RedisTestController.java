/*
 * Ant Group
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.alipay.cloudrun.superapp.web;

import com.alipay.cloudrun.superapp.service.RedisService;
import com.alipay.cloudrun.superapp.web.request.SetCacheValueRequest;
import com.alipay.cloudrun.superapp.web.response.Result;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

/**
 * 云托管缓存测试
 *
 * @author siwei
 * @version RedisTestController.java, v 0.1 2023年04月04日 17:40 siwei
 */
@Log4j2
@RestController
@RequestMapping("/api/redis")
public class RedisTestController {

    @Autowired
    RedisService redisService;

    /**
     * 获取缓存值
     *
     * @param key key
     * @return {@link Result}<{@link String}>
     */
    @GetMapping("/get")
    public Result<String> getCacheValue(@RequestParam("key") String key) {

        log.info("/api/redis/get GET request, key = {}", key);
        return Result.success(redisService.get(key));

    }

    /**
     * 设置缓存值
     *
     * @param request 请求体
     * @return {@link Result}<{@link Void}>
     */
    @PostMapping("/set")
    public Result<Void> setCacheValue(@Valid @RequestBody SetCacheValueRequest request) {

        log.info("/api/redis/set POST request, request = {}", request);
        redisService.set(request.getKey(), request.getValue(), request.getTimeout());
        return Result.success();

    }

    /**
     * 获取多个缓存值
     *
     * @param pattern pattern
     * @return {@link Result}<{@link Map}<{@link String}, {@link String}>>
     */
    @GetMapping("/getByPattern")
    public Result<Map<String, String>> getCacheValueByPattern(@RequestParam(name = "pattern", required = false) String pattern) {

        log.info("/api/redis/getByPattern GET request, pattern = {}", pattern);
        return Result.success(redisService.getByPattern(pattern));

    }

    /**
     * 删除缓存值
     *
     * @param key key
     * @return {@link Result}<{@link Boolean}>
     */
    @DeleteMapping("/delete")
    public Result<Boolean> deleteCacheValue(@RequestParam("key") String key) {

        log.info("/api/redis/delete DELETE request, key = {}", key);
        return Result.success(redisService.delete(key));

    }

}