/*
 * Ant Group
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.alipay.cloudrun.superapp.web;

import com.alibaba.fastjson.JSON;
import com.alipay.api.domain.*;
import com.alipay.api.response.*;
import com.alipay.cloudrun.superapp.aop.annotation.ControllerPointCut;
import com.alipay.cloudrun.superapp.service.AosService;
import com.alipay.cloudrun.superapp.web.response.Result;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 蚂蚁开放搜索服务AOS测试
 *
 * @author siwei
 * @version AosTestController.java, v 0.1 2023年04月09日 19:22 siwei
 */
@Log4j2
@RestController
@RequestMapping("/api/aos")
public class AosTestController {

    @Autowired
    AosService aosService;

    /**
     * aos数据同步接口
     *
     * @param dataSyncRequest 数据同步请求
     * @return {@link Result}<{@link AlipayOpenMiniCloudAosdataSyncResponse}>
     */
    @PostMapping("/dataSync")
    @ControllerPointCut
    @SneakyThrows
    Result<AlipayOpenMiniCloudAosdataSyncResponse> dataSync(@RequestBody AlipayOpenMiniCloudAosdataSyncModel dataSyncRequest) {

        log.info("/api/aos/dataSync POST request, dataSyncRequest = {}", JSON.toJSONString(dataSyncRequest));
        return Result.success(aosService.dataSync(dataSyncRequest));

    }

    /**
     * aos下拉提示接口
     *
     * @param suggestQueryRequest 下拉提示查询请求
     * @return {@link Result}<{@link AlipayOpenMiniCloudAossuggestQueryResponse}>
     */
    @PostMapping("/suggestQuery")
    @ControllerPointCut
    @SneakyThrows
    Result<AlipayOpenMiniCloudAossuggestQueryResponse> suggestQuery(@RequestBody AlipayOpenMiniCloudAossuggestQueryModel suggestQueryRequest) {

        log.info("/api/aos/suggestQuery POST request, suggestQueryRequest = {}", JSON.toJSONString(suggestQueryRequest));
        return Result.success(aosService.suggestQuery(suggestQueryRequest));

    }

    /**
     * aos智能搜索接口
     *
     * @param itemQueryRequest 智能搜索查询请求
     * @return {@link Result}<{@link AlipayOpenMiniCloudAositemQueryResponse}>
     */
    @PostMapping("/itemQuery")
    @ControllerPointCut
    @SneakyThrows
    Result<AlipayOpenMiniCloudAositemQueryResponse> itemQuery(@RequestBody AlipayOpenMiniCloudAositemQueryModel itemQueryRequest) {

        log.info("/api/aos/itemQuery POST request, itemQueryRequest = {}", JSON.toJSONString(itemQueryRequest));
        return Result.success(aosService.itemQuery(itemQueryRequest));

    }

    /**
     * aos热门搜索接口
     *
     * @param hotQueryRequest 热门搜索查询请求
     * @return {@link Result}<{@link AlipayOpenMiniCloudAoshotQueryResponse}>
     */
    @PostMapping("/hotQuery")
    @ControllerPointCut
    @SneakyThrows
    Result<AlipayOpenMiniCloudAoshotQueryResponse> hotQuery(@RequestBody AlipayOpenMiniCloudAoshotQueryModel hotQueryRequest) {

        log.info("/api/aos/hotQuery POST request, hotQueryRequest = {}", JSON.toJSONString(hotQueryRequest));
        return Result.success(aosService.hotQuery(hotQueryRequest));

    }

    /**
     * aos底纹搜索接口
     *
     * @param hintQueryModel 底纹搜索查询请求
     * @return {@link Result}<{@link AlipayOpenMiniCloudAoshintQueryResponse}>
     */
    @PostMapping("/hintQuery")
    @ControllerPointCut
    @SneakyThrows
    Result<AlipayOpenMiniCloudAoshintQueryResponse> hintQuery(@RequestBody AlipayOpenMiniCloudAoshintQueryModel hintQueryModel) {

        log.info("/api/aos/hintQuery POST request, hintQueryModel = {}", JSON.toJSONString(hintQueryModel));
        return Result.success(aosService.hintQuery(hintQueryModel));

    }

    /**
     * aos行为上报接口
     *
     * @param behaviorSyncRequest 行为上报请求
     * @return {@link Result}<{@link AlipayOpenMiniCloudAosbehaviorSyncResponse}>
     */
    @PostMapping("/behaviorSync")
    @ControllerPointCut
    @SneakyThrows
    Result<AlipayOpenMiniCloudAosbehaviorSyncResponse> behaviorSync(@RequestBody AlipayOpenMiniCloudAosbehaviorSyncModel behaviorSyncRequest) {

        log.info("/api/aos/behaviorSync POST request, behaviorSyncRequest = {}", JSON.toJSONString(behaviorSyncRequest));
        return Result.success(aosService.behaviorSync(behaviorSyncRequest));

    }

}