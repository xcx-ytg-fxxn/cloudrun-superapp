/*
 * Ant Group
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.alipay.cloudrun.superapp.service;

import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.pojo.Instance;

import java.util.List;

/**
 * @author siwei
 * @version NacosService.java, v 0.1 2023年04月04日 22:30 siwei
 */
public interface NacosService {

    /**
     * Nacos作为配置中心使用时
     * 获取指定的配置值
     *
     * @param key 配置对应的key
     * @return {@link String}
     */
    String getNacosConfigValue(String key);

    /**
     * Nacos作为注册中心使用时
     * 获取指定服务名的所有实例
     *
     * @param serviceName 服务名
     * @return {@link List}<{@link Instance}>
     * @throws NacosException NacosException
     */
    List<Instance> getServiceInstance(String serviceName) throws NacosException;

}