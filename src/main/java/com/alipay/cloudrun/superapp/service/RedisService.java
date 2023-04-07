/*
 * Ant Group
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.alipay.cloudrun.superapp.service;

import java.util.Map;

/**
 * @author siwei
 * @version RedisService.java, v 0.1 2023年04月04日 23:47 siwei
 */
public interface RedisService {

    /**
     * 获取缓存值
     *
     * @param key 关键
     * @return {@link String}
     */
    String get(String key);

    /**
     * 设置缓存值
     *
     * @param key     key
     * @param value   value
     * @param timeout 过期时间
     */
    void set(String key, String value, Long timeout);

    /**
     * 获取匹配的缓存KV
     *
     * @param pattern pattern
     * @return {@link Map}<{@link String}, {@link String}>
     */
    Map<String, String> getByPattern(String pattern);

    /**
     * 删除缓存值
     *
     * @param key key
     * @return boolean
     */
    boolean delete(String key);

}