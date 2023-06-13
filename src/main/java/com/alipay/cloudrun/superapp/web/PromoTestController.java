/*
 * Ant Group
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.alipay.cloudrun.superapp.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alipay.api.domain.*;
import com.alipay.api.response.*;
import com.alipay.cloudrun.superapp.aop.annotation.ControllerPointCut;
import com.alipay.cloudrun.superapp.service.PromoService;
import com.alipay.cloudrun.superapp.web.response.Result;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 个性化推荐测试
 *
 * @author siwei
 * @version PromoTestController.java, v 0.1 2023年04月09日 19:09 siwei
 */
@Log4j2
@RestController
@RequestMapping("/api/promo")
public class PromoTestController {

    @Autowired
    PromoService promoService;

    /**
     * 小程序云个性化推荐上传数据接口
     *
     * @param dataSyncModel 数据同步模型
     * @return {@link Result}<{@link TechriskInnovateMpcpromoDataSyncResponse}>
     */
    @PostMapping("/syncData")
    @ControllerPointCut
    @SneakyThrows
    Result<TechriskInnovateMpcpromoDataSyncResponse> syncData(@RequestBody TechriskInnovateMpcpromoDataSyncModel dataSyncModel) {

        log.info("/api/promo/syncData POST request, dataSyncModel = {}", JSON.toJSONString(dataSyncModel));
        return Result.success(promoService.syncData(dataSyncModel));

    }

    /**
     * 小程序云个性化推荐场景创建接口
     *
     * @param sceneCreateModel 场景创建模型
     * @return {@link Result}<{@link TechriskInnovateMpcpromoSceneCreateResponse}>
     */
    @PostMapping("/createScene")
    @ControllerPointCut
    @SneakyThrows
    Result<TechriskInnovateMpcpromoSceneCreateResponse> createScene(@RequestBody TechriskInnovateMpcpromoSceneCreateModel sceneCreateModel) {

        log.info("/api/promo/createScene POST request, sceneCreateModel = {}", JSON.toJSONString(sceneCreateModel));
        return Result.success(promoService.createScene(sceneCreateModel));

    }

    /**
     * 小程序云个性化推荐推荐查询接口
     *
     * @param itemQueryModel 项目查询模型
     * @return {@link Result}<{@link TechriskInnovateMpcpromoItemQueryResponse}>
     */
    @PostMapping("/queryItem")
    @ControllerPointCut
    @SneakyThrows
    Result<TechriskInnovateMpcpromoItemQueryResponse> queryItem(@RequestBody TechriskInnovateMpcpromoItemQueryModel itemQueryModel) {

        log.info("/api/promo/queryItem POST request, itemQueryModel = {}", JSON.toJSONString(itemQueryModel));
        return Result.success(promoService.queryItem(itemQueryModel));

    }

    /**
     * 小程序云个性化推荐场景中商品删除接口
     *
     * @param sceneReleaseModel 删除场景商品模型
     * @return {@link Result}<{@link TechriskInnovateMpcpromoItemQueryResponse}>
     */
    @PostMapping("/releaseScene")
    @ControllerPointCut
    @SneakyThrows
    Result<TechriskInnovateMpcpromoSceneReleaseResponse> releaseScene(@RequestBody TechriskInnovateMpcpromoSceneReleaseModel sceneReleaseModel) {

        log.info("/api/promo/releaseScene POST request, sceneReleaseModel = {}", JSON.toJSONString(sceneReleaseModel));
        return Result.success(promoService.releaseScene(sceneReleaseModel));

    }

    /**
     * 小程序云个性化推荐商品数据删除接口
     *
     * @param dataDeleteModel 删除场景商品模型
     * @return {@link Result}<{@link TechriskInnovateMpcpromoItemQueryResponse}>
     */
    @PostMapping("/deleteData")
    @ControllerPointCut
    @SneakyThrows
    Result<TechriskInnovateMpcpromoDataDeleteResponse> deleteData(@RequestBody TechriskInnovateMpcpromoDataDeleteModel dataDeleteModel) {

        log.info("/api/promo/dataDeleteModel POST request, dataDeleteModel = {}", JSON.toJSONString(dataDeleteModel));
        return Result.success(promoService.deleteData(dataDeleteModel));

    }

    /**
     * 小程序云个性化推荐用户行为上报接口
     *
     * @param behaviorSyncModel 删除场景商品模型
     * @return {@link Result}<{@link TechriskInnovateMpcpromoItemQueryResponse}>
     */
    @PostMapping("/syncBehavior")
    @ControllerPointCut
    @SneakyThrows
    Result<TechriskInnovateMpcpromoBehaviorSyncResponse> syncBehavior(@RequestBody TechriskInnovateMpcpromoBehaviorSyncModel behaviorSyncModel) {

        log.info("/api/promo/syncBehavior POST request, behaviorSyncModel = {}", JSON.toJSONString(behaviorSyncModel));
        return Result.success(promoService.syncBehavior(behaviorSyncModel));

    }

    /**
     * 小程序云个性化推荐上传数据接口-JSON格式
     *
     * @param dataSyncModelString 数据同步模型-JSONString格式
     * @return {@link Result}<{@link TechriskInnovateMpcpromoDataSyncResponse}>
     */
    @PostMapping("/syncData/json")
    @ControllerPointCut
    @SneakyThrows
    Result<TechriskInnovateMpcpromoDataSyncResponse> syncData(@RequestBody JSONObject dataSyncModelString) {

        log.info("/api/promo/syncData POST request, dataSyncModelString = {}", JSON.toJSONString(dataSyncModelString));
        return Result.success(promoService.syncData(dataSyncModelString.toJSONString()));

    }

    /**
     * 小程序云个性化推荐场景创建接口-JSON格式
     *
     * @param sceneCreateModelString 场景创建模型-JSONString格式
     * @return {@link Result}<{@link TechriskInnovateMpcpromoSceneCreateResponse}>
     */
    @PostMapping("/createScene/json")
    @ControllerPointCut
    @SneakyThrows
    Result<TechriskInnovateMpcpromoSceneCreateResponse> createScene(@RequestBody JSONObject sceneCreateModelString) {

        log.info("/api/promo/createScene POST request, sceneCreateModelString = {}", JSON.toJSONString(sceneCreateModelString));
        return Result.success(promoService.createScene(sceneCreateModelString.toJSONString()));

    }

    /**
     * 小程序云个性化推荐推荐查询接口-JSON格式
     *
     * @param itemQueryModelString 项目查询模型-JSONString格式
     * @return {@link Result}<{@link TechriskInnovateMpcpromoItemQueryResponse}>
     */
    @PostMapping("/queryItem/json")
    @ControllerPointCut
    @SneakyThrows
    Result<TechriskInnovateMpcpromoItemQueryResponse> queryItem(@RequestBody JSONObject itemQueryModelString) {

        log.info("/api/promo/queryItem POST request, itemQueryModelString = {}", JSON.toJSONString(itemQueryModelString));
        return Result.success(promoService.queryItem(itemQueryModelString.toJSONString()));

    }

    /**
     * 小程序云个性化推荐场景中商品删除接口-JSON格式
     *
     * @param sceneReleaseModelString 删除场景商品模型-JSONString格式
     * @return {@link Result}<{@link TechriskInnovateMpcpromoItemQueryResponse}>
     */
    @PostMapping("/releaseScene/json")
    @ControllerPointCut
    @SneakyThrows
    Result<TechriskInnovateMpcpromoSceneReleaseResponse> releaseScene(@RequestBody JSONObject sceneReleaseModelString) {

        log.info("/api/promo/releaseScene POST request, sceneReleaseModelString = {}", JSON.toJSONString(sceneReleaseModelString));
        return Result.success(promoService.releaseScene(sceneReleaseModelString.toJSONString()));

    }

    /**
     * 小程序云个性化推荐商品数据删除接口-JSON格式
     *
     * @param dataDeleteModelString 删除场景商品模型
     * @return {@link Result}<{@link TechriskInnovateMpcpromoItemQueryResponse}>
     */
    @PostMapping("/deleteData/json")
    @ControllerPointCut
    @SneakyThrows
    Result<TechriskInnovateMpcpromoDataDeleteResponse> deleteData(@RequestBody JSONObject dataDeleteModelString) {

        log.info("/api/promo/dataDeleteModel POST request, dataDeleteModelString = {}", JSON.toJSONString(dataDeleteModelString));
        return Result.success(promoService.deleteData(dataDeleteModelString.toJSONString()));

    }

    /**
     * 小程序云个性化推荐用户行为上报接口-JSON格式
     *
     * @param behaviorSyncModelString 删除场景商品模型
     * @return {@link Result}<{@link TechriskInnovateMpcpromoItemQueryResponse}>
     */
    @PostMapping("/syncBehavior/json")
    @ControllerPointCut
    @SneakyThrows
    Result<TechriskInnovateMpcpromoBehaviorSyncResponse> syncBehavior(@RequestBody JSONObject behaviorSyncModelString) {

        log.info("/api/promo/syncBehavior POST request, behaviorSyncModelString = {}", JSON.toJSONString(behaviorSyncModelString));
        return Result.success(promoService.syncBehavior(behaviorSyncModelString.toJSONString()));

    }

}