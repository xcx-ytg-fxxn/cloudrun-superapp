/*
 * Ant Group
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.alipay.cloudrun.superapp.service;

import com.alipay.api.AlipayApiException;
import com.alipay.api.domain.*;
import com.alipay.api.response.*;

/**
 * @author siwei
 * @version PromoService.java, v 0.1 2023年04月09日 22:55 siwei
 */
public interface PromoService {

    /**
     * 小程序云个性化推荐上传数据接口
     *
     * @param dataSyncModel 数据同步模型
     * @return {@link TechriskInnovateMpcpromoDataSyncResponse}
     * @throws AlipayApiException AlipayApiException
     */
    TechriskInnovateMpcpromoDataSyncResponse syncData(TechriskInnovateMpcpromoDataSyncModel dataSyncModel) throws AlipayApiException;

    /**
     * 小程序云个性化推荐场景创建接口
     *
     * @param sceneCreateModel 场景创建模型
     * @return {@link TechriskInnovateMpcpromoSceneCreateResponse}
     * @throws AlipayApiException AlipayApiException
     */
    TechriskInnovateMpcpromoSceneCreateResponse createScene(TechriskInnovateMpcpromoSceneCreateModel sceneCreateModel) throws AlipayApiException;

    /**
     * 小程序云个性化推荐推荐查询接口
     *
     * @param itemQueryModel 项目查询模型
     * @return {@link TechriskInnovateMpcpromoItemQueryResponse}
     * @throws AlipayApiException AlipayApiException
     */
    TechriskInnovateMpcpromoItemQueryResponse queryItem(TechriskInnovateMpcpromoItemQueryModel itemQueryModel) throws AlipayApiException;

    /**
     * 小程序云个性化推荐场景中商品删除接口
     *
     * @param sceneReleaseModel 删除场景商品模型
     * @return {@link TechriskInnovateMpcpromoSceneReleaseResponse}
     * @throws AlipayApiException AlipayApiException
     */
    TechriskInnovateMpcpromoSceneReleaseResponse releaseScene(TechriskInnovateMpcpromoSceneReleaseModel sceneReleaseModel) throws AlipayApiException;

    /**
     * 小程序云个性化推荐商品数据删除接口
     *
     * @param dataDeleteModel 商品删除模型
     * @return {@link TechriskInnovateMpcpromoDataDeleteResponse}
     * @throws AlipayApiException AlipayApiException
     */
    TechriskInnovateMpcpromoDataDeleteResponse deleteData(TechriskInnovateMpcpromoDataDeleteModel dataDeleteModel) throws AlipayApiException;

    /**
     * 小程序云个性化推荐用户行为上报接口
     *
     * @param behaviorSyncModel 行为同步模型
     * @return {@link TechriskInnovateMpcpromoBehaviorSyncResponse}
     * @throws AlipayApiException AlipayApiException
     */
    TechriskInnovateMpcpromoBehaviorSyncResponse syncBehavior(TechriskInnovateMpcpromoBehaviorSyncModel behaviorSyncModel) throws AlipayApiException;

    /**
     * 小程序云个性化推荐上传数据接口
     *
     * @param dataSyncModelString 数据同步模型-JSON字符串类型
     * @return {@link TechriskInnovateMpcpromoDataSyncResponse}
     * @throws AlipayApiException AlipayApiException
     */
    TechriskInnovateMpcpromoDataSyncResponse syncData(String dataSyncModelString) throws AlipayApiException;

    /**
     * 小程序云个性化推荐场景创建接口-JAR包未发布时JSON调用
     *
     * @param sceneCreateModelString 场景创建模型-JSON字符串类型
     * @return {@link TechriskInnovateMpcpromoSceneCreateResponse}
     * @throws AlipayApiException AlipayApiException
     */
    TechriskInnovateMpcpromoSceneCreateResponse createScene(String sceneCreateModelString) throws AlipayApiException;

    /**
     * 小程序云个性化推荐推荐查询接口-JAR包未发布时JSON调用
     *
     * @param itemQueryModelString 项目查询模型-JSON字符串类型
     * @return {@link TechriskInnovateMpcpromoItemQueryResponse}
     * @throws AlipayApiException AlipayApiException
     */
    TechriskInnovateMpcpromoItemQueryResponse queryItem(String itemQueryModelString) throws AlipayApiException;

    /**
     * 小程序云个性化推荐场景中商品删除接口-JAR包未发布时JSON调用
     *
     * @param sceneReleaseModelString 删除场景商品模型-JSON字符串类型
     * @return {@link TechriskInnovateMpcpromoSceneReleaseResponse}
     * @throws AlipayApiException AlipayApiException
     */
    TechriskInnovateMpcpromoSceneReleaseResponse releaseScene(String sceneReleaseModelString) throws AlipayApiException;

    /**
     * 小程序云个性化推荐商品数据删除接口-JAR包未发布时JSON调用
     *
     * @param dataDeleteModelString 商品删除模型-JSON字符串类型
     * @return {@link TechriskInnovateMpcpromoDataDeleteResponse}
     * @throws AlipayApiException AlipayApiException
     */
    TechriskInnovateMpcpromoDataDeleteResponse deleteData(String dataDeleteModelString) throws AlipayApiException;

    /**
     * 小程序云个性化推荐用户行为上报接口-JAR包未发布时JSON调用
     *
     * @param behaviorSyncModelString 行为同步模型-JSON字符串类型
     * @return {@link TechriskInnovateMpcpromoBehaviorSyncResponse}
     * @throws AlipayApiException AlipayApiException
     */
    TechriskInnovateMpcpromoBehaviorSyncResponse syncBehavior(String behaviorSyncModelString) throws AlipayApiException;

}