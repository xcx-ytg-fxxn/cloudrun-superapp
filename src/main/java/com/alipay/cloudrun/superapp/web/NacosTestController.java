/*
 * Ant Group
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.alipay.cloudrun.superapp.web;

import com.alibaba.nacos.api.naming.pojo.Instance;
import com.alipay.cloudrun.superapp.service.NacosService;
import com.alipay.cloudrun.superapp.web.response.Result;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 云托管Nacos连接测试
 *
 * @author siwei
 * @version NacosTestController.java, v 0.1 2023年04月04日 17:25 siwei
 */
@Log4j2
@RestController
@RequestMapping("/api/nacos")
public class NacosTestController {

    @Autowired
    NacosService nacosService;

    /**
     * Nacos作为配置中心使用时
     * 获取指定的配置值
     *
     * @param key 配置对应的key
     * @return {@link Result}<{@link String}>
     */
    @GetMapping("/config/get")
    public Result<String> getNacosConfigValue(@RequestParam("key") String key) {

        log.info("/api/nacos/config/get GET request, key = {}", key);
        return Result.success(nacosService.getNacosConfigValue(key));

    }

    /**
     * Nacos作为注册中心使用时
     * 获取指定服务名的所有实例
     *
     * @param serviceName 服务名称
     * @return {@link Result}<{@link List}<{@link Instance}>>
     */
    @GetMapping("/discovery/get")
    @SneakyThrows
    public Result<List<Instance>> getServiceInstances(@RequestParam("serviceName") String serviceName) {

        log.info("/api/nacos/discovery/get GET request, serviceName = {}", serviceName);
        return Result.success(nacosService.getServiceInstance(serviceName));

    }

}