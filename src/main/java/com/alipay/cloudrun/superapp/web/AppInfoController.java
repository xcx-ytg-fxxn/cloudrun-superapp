/*
 * Ant Group
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.alipay.cloudrun.superapp.web;

import com.alipay.cloudrun.superapp.web.response.Result;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public Result<Map<String, String>> getAppInfo() {

        log.info("/api/app/info GET request");
        return Result.success(System.getenv());

    }

}