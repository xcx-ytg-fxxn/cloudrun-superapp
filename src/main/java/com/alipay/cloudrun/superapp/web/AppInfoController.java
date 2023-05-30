/*
 * Ant Group
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.alipay.cloudrun.superapp.web;

import com.alipay.cloudrun.superapp.aop.annotation.ControllerPointCut;
import com.alipay.cloudrun.superapp.web.response.Result;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;
import java.util.HashMap;
import java.util.Map;

/**
 * 基础功能
 *
 * @author siwei
 * @version AppInfoController.java, v 0.1 2023年04月04日 17:57 siwei
 */
@Log4j2
@RestController
@RequestMapping("/api/app")
public class AppInfoController {

    /**
     * 获取应用信息
     * 返回当前应用的所有环境变量信息
     *
     * @return {@link Result}<{@link Map}<{@link String}, {@link String}>>
     */
    @GetMapping("/info")
    @ControllerPointCut
    public Result<Map<String, String>> getAppInfo() {

        log.info("/api/app/info GET request");
        return Result.success(System.getenv());

    }

    /**
     * 获取当前CPU核数
     *
     * @return {@link Result}<{@link Integer}>
     */
    @GetMapping("/cpu")
    @ControllerPointCut
    public Result<Integer> getProcessorsCount() {

        log.info("/api/app/cpu GET request");
        return Result.success(Runtime.getRuntime().availableProcessors());
    }

    /**
     * 获取当前内存状态
     * Total memory:总内存
     * Free  memory:空闲内存
     *
     * @return {@link Result}<{@link Map}<{@link String}, {@link Long}>>
     */
    @GetMapping("/memory")
    @ControllerPointCut
    @SneakyThrows
    public Result<Map<String, Long>> getMemoryStatus() {

        log.info("/api/app/memory GET request");
        Map<String, Long> memoryStatus = new HashMap<>();
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        Object attribute = mBeanServer.getAttribute(new ObjectName("java.lang","type","OperatingSystem"), "TotalPhysicalMemorySize");
        Object attribute2 = mBeanServer.getAttribute(new ObjectName("java.lang","type","OperatingSystem"), "FreePhysicalMemorySize");
        memoryStatus.put("Total memory", Long.parseLong(attribute.toString()));
        memoryStatus.put("Free  memory", Long.parseLong(attribute2.toString()));

        return Result.success(memoryStatus);

    }

}