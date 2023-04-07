/*
 * Ant Group
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.alipay.cloudrun.superapp.service.impl;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import com.alipay.cloudrun.superapp.service.NacosService;
import com.alipay.cloudrun.superapp.util.SpringContextUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author siwei
 * @version NacosServiceImpl.java, v 0.1 2023年04月04日 22:34 siwei
 */
@Log4j2
@Service
public class NacosServiceImpl implements NacosService {

    @Autowired
    SpringContextUtil springContextUtil;

    @NacosInjected
    private NamingService namingService;

    /**
     * Nacos作为配置中心使用时
     * 获取指定的配置值
     *
     * @param key 配置对应的key
     * @return {@link String}
     */
    @Override
    public String getNacosConfigValue(String key) {

        log.info("get nacos config value, key = {}", key);
        return springContextUtil.getPropertiesValue(key);

    }

    /**
     * Nacos作为注册中心使用时
     * 获取指定服务名的所有实例
     *
     * @param serviceName 服务名
     * @return {@link List}<{@link Instance}>
     * @throws NacosException NacosException
     */
    @Override
    public List<Instance> getServiceInstance(String serviceName) throws NacosException {

        log.info("get service instance, serviceName = {}", serviceName);
        return namingService.getAllInstances(serviceName);

    }
}