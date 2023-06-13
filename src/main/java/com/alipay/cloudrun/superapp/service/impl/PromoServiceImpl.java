/*
 * Ant Group
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.alipay.cloudrun.superapp.service.impl;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.*;
import com.alipay.api.request.*;
import com.alipay.api.response.*;
import com.alipay.cloudrun.superapp.service.PromoService;
import com.alipay.cloudrun.superapp.util.PublicConstant;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

/**
 * @author siwei
 * @version PromoServiceImpl.java, v 0.1 2023年04月09日 22:56 siwei
 */
@Log4j2
@Service
public class PromoServiceImpl implements PromoService {

    /**
     * 小程序云个性化推荐上传数据接口
     *
     * @param dataSyncModel 数据同步模型
     * @return {@link TechriskInnovateMpcpromoDataSyncResponse}
     * @throws AlipayApiException AlipayApiException
     */
    @Override
    public TechriskInnovateMpcpromoDataSyncResponse syncData(TechriskInnovateMpcpromoDataSyncModel dataSyncModel) throws AlipayApiException {

        log.info("sync data to promo service, dataSyncModel = {}", JSON.toJSONString(dataSyncModel));
        AlipayClient alipayClient = new DefaultAlipayClient(PublicConstant.SERVER_URL, PublicConstant.APP_ID,
                PublicConstant.PRIVATE_KEY, "json", "utf-8", PublicConstant.PUBLIC_KEY, "RSA2");
        TechriskInnovateMpcpromoDataSyncRequest request = new TechriskInnovateMpcpromoDataSyncRequest();
        request.setBizModel(dataSyncModel);
        TechriskInnovateMpcpromoDataSyncResponse response = alipayClient.execute(request);
        return response;

    }

    /**
     * 小程序云个性化推荐场景创建接口
     *
     * @param sceneCreateModel 场景创建模型
     * @return {@link TechriskInnovateMpcpromoSceneCreateResponse}
     * @throws AlipayApiException AlipayApiException
     */
    @Override
    public TechriskInnovateMpcpromoSceneCreateResponse createScene(TechriskInnovateMpcpromoSceneCreateModel sceneCreateModel) throws AlipayApiException {

        log.info("create scene for promo service, sceneCreateModel = {}", JSON.toJSONString(sceneCreateModel));
        AlipayClient alipayClient = new DefaultAlipayClient(PublicConstant.SERVER_URL, PublicConstant.APP_ID,
                PublicConstant.PRIVATE_KEY, "json", "utf-8", PublicConstant.PUBLIC_KEY, "RSA2");
        TechriskInnovateMpcpromoSceneCreateRequest request = new TechriskInnovateMpcpromoSceneCreateRequest();
        request.setBizModel(sceneCreateModel);
        TechriskInnovateMpcpromoSceneCreateResponse response = alipayClient.execute(request);
        return response;

    }

    /**
     * 小程序云个性化推荐推荐查询接口
     *
     * @param itemQueryModel 项目查询模型
     * @return {@link TechriskInnovateMpcpromoItemQueryResponse}
     * @throws AlipayApiException AlipayApiException
     */
    @Override
    public TechriskInnovateMpcpromoItemQueryResponse queryItem(TechriskInnovateMpcpromoItemQueryModel itemQueryModel) throws AlipayApiException {

        log.info("item query from promo service, itemQueryModel = {}", JSON.toJSONString(itemQueryModel));
        AlipayClient alipayClient = new DefaultAlipayClient(PublicConstant.SERVER_URL, PublicConstant.APP_ID,
                PublicConstant.PRIVATE_KEY, "json", "utf-8", PublicConstant.PUBLIC_KEY, "RSA2");
        TechriskInnovateMpcpromoItemQueryRequest request = new TechriskInnovateMpcpromoItemQueryRequest();
        request.setBizModel(itemQueryModel);
        TechriskInnovateMpcpromoItemQueryResponse response = alipayClient.execute(request);
        return response;

    }

    /**
     * 小程序云个性化推荐场景中商品删除接口
     *
     * @param sceneReleaseModel 删除场景商品模型
     * @return {@link TechriskInnovateMpcpromoSceneReleaseResponse}
     * @throws AlipayApiException AlipayApiException
     */
    @Override
    public TechriskInnovateMpcpromoSceneReleaseResponse releaseScene(TechriskInnovateMpcpromoSceneReleaseModel sceneReleaseModel) throws AlipayApiException {

        log.info("scene release from promo service, sceneReleaseModel = {}", JSON.toJSONString(sceneReleaseModel));
        AlipayClient alipayClient = new DefaultAlipayClient(PublicConstant.SERVER_URL, PublicConstant.APP_ID,
                PublicConstant.PRIVATE_KEY, "json", "utf-8", PublicConstant.PUBLIC_KEY, "RSA2");
        TechriskInnovateMpcpromoSceneReleaseRequest request = new TechriskInnovateMpcpromoSceneReleaseRequest();
        request.setBizModel(sceneReleaseModel);
        TechriskInnovateMpcpromoSceneReleaseResponse response = alipayClient.execute(request);
        return response;
    }


    /**
     * 小程序云个性化推荐商品数据删除接口
     *
     * @param dataDeleteModel 商品删除模型
     * @return {@link TechriskInnovateMpcpromoDataDeleteResponse}
     * @throws AlipayApiException AlipayApiException
     */
    @Override
    public TechriskInnovateMpcpromoDataDeleteResponse deleteData(TechriskInnovateMpcpromoDataDeleteModel dataDeleteModel) throws AlipayApiException {

        log.info("data delete from promo service, dataDeleteModel = {}", JSON.toJSONString(dataDeleteModel));
        AlipayClient alipayClient = new DefaultAlipayClient(PublicConstant.SERVER_URL, PublicConstant.APP_ID,
                PublicConstant.PRIVATE_KEY, "json", "utf-8", PublicConstant.PUBLIC_KEY, "RSA2");
        TechriskInnovateMpcpromoDataDeleteRequest request = new TechriskInnovateMpcpromoDataDeleteRequest();
        request.setBizModel(dataDeleteModel);
        TechriskInnovateMpcpromoDataDeleteResponse response = alipayClient.execute(request);
        return response;

    }

    /**
     * 小程序云个性化推荐用户行为上报接口
     *
     * @param behaviorSyncModel 行为同步模型
     * @return {@link TechriskInnovateMpcpromoBehaviorSyncResponse}
     * @throws AlipayApiException AlipayApiException
     */
    @Override
    public TechriskInnovateMpcpromoBehaviorSyncResponse syncBehavior(TechriskInnovateMpcpromoBehaviorSyncModel behaviorSyncModel) throws AlipayApiException {

        log.info("behavior sync from promo service, behaviorSyncModel = {}", JSON.toJSONString(behaviorSyncModel));
        AlipayClient alipayClient = new DefaultAlipayClient(PublicConstant.SERVER_URL, PublicConstant.APP_ID,
                PublicConstant.PRIVATE_KEY, "json", "utf-8", PublicConstant.PUBLIC_KEY, "RSA2");
        TechriskInnovateMpcpromoBehaviorSyncRequest request = new TechriskInnovateMpcpromoBehaviorSyncRequest();
        request.setBizModel(behaviorSyncModel);
        TechriskInnovateMpcpromoBehaviorSyncResponse response = alipayClient.execute(request);
        return response;

    }

    /**
     * 小程序云个性化推荐上传数据接口
     *
     * @param dataSyncModelString 数据同步模型-JSON字符串类型
     * @return {@link TechriskInnovateMpcpromoDataSyncResponse}
     * @throws AlipayApiException AlipayApiException
     */
    @Override
    public TechriskInnovateMpcpromoDataSyncResponse syncData(String dataSyncModelString) throws AlipayApiException {

        log.info("sync data to promo service, dataSyncModelString = {}", JSON.toJSONString(dataSyncModelString));
        AlipayClient alipayClient = new DefaultAlipayClient(PublicConstant.SERVER_URL, PublicConstant.APP_ID,
                PublicConstant.PRIVATE_KEY, "json", "utf-8", PublicConstant.PUBLIC_KEY, "RSA2");
        TechriskInnovateMpcpromoDataSyncRequest request = new TechriskInnovateMpcpromoDataSyncRequest();
        request.setBizContent(dataSyncModelString);
        TechriskInnovateMpcpromoDataSyncResponse response = alipayClient.execute(request);
        return response;

    }

    /**
     * 小程序云个性化推荐场景创建接口-JAR包未发布时JSON调用
     *
     * @param sceneCreateModelString 场景创建模型-JSON字符串类型
     * @return {@link TechriskInnovateMpcpromoSceneCreateResponse}
     * @throws AlipayApiException AlipayApiException
     */
    @Override
    public TechriskInnovateMpcpromoSceneCreateResponse createScene(String sceneCreateModelString) throws AlipayApiException {

        log.info("create scene for promo service, sceneCreateModelString = {}", JSON.toJSONString(sceneCreateModelString));
        AlipayClient alipayClient = new DefaultAlipayClient(PublicConstant.SERVER_URL, PublicConstant.APP_ID,
                PublicConstant.PRIVATE_KEY, "json", "utf-8", PublicConstant.PUBLIC_KEY, "RSA2");
        TechriskInnovateMpcpromoSceneCreateRequest request = new TechriskInnovateMpcpromoSceneCreateRequest();
        request.setBizContent(sceneCreateModelString);
        TechriskInnovateMpcpromoSceneCreateResponse response = alipayClient.execute(request);
        return response;

    }

    /**
     * 小程序云个性化推荐推荐查询接口-JAR包未发布时JSON调用
     *
     * @param itemQueryModelString 项目查询模型-JSON字符串类型
     * @return {@link TechriskInnovateMpcpromoItemQueryResponse}
     * @throws AlipayApiException AlipayApiException
     */
    @Override
    public TechriskInnovateMpcpromoItemQueryResponse queryItem(String itemQueryModelString) throws AlipayApiException {

        log.info("item query from promo service, itemQueryModelString = {}", JSON.toJSONString(itemQueryModelString));
        AlipayClient alipayClient = new DefaultAlipayClient(PublicConstant.SERVER_URL, PublicConstant.APP_ID,
                PublicConstant.PRIVATE_KEY, "json", "utf-8", PublicConstant.PUBLIC_KEY, "RSA2");
        TechriskInnovateMpcpromoItemQueryRequest request = new TechriskInnovateMpcpromoItemQueryRequest();
        request.setBizContent(itemQueryModelString);
        TechriskInnovateMpcpromoItemQueryResponse response = alipayClient.execute(request);
        return response;

    }

    /**
     * 小程序云个性化推荐场景中商品删除接口-JAR包未发布时JSON调用
     *
     * @param sceneReleaseModelString 删除场景商品模型-JSON字符串类型
     * @return {@link TechriskInnovateMpcpromoSceneReleaseResponse}
     * @throws AlipayApiException AlipayApiException
     */
    @Override
    public TechriskInnovateMpcpromoSceneReleaseResponse releaseScene(String sceneReleaseModelString) throws AlipayApiException {

        log.info("scene release from promo service, sceneReleaseModelString = {}", JSON.toJSONString(sceneReleaseModelString));
        AlipayClient alipayClient = new DefaultAlipayClient(PublicConstant.SERVER_URL, PublicConstant.APP_ID,
                PublicConstant.PRIVATE_KEY, "json", "utf-8", PublicConstant.PUBLIC_KEY, "RSA2");
        TechriskInnovateMpcpromoSceneReleaseRequest request = new TechriskInnovateMpcpromoSceneReleaseRequest();
        request.setBizContent(sceneReleaseModelString);
        TechriskInnovateMpcpromoSceneReleaseResponse response = alipayClient.execute(request);
        return response;

    }

    /**
     * 小程序云个性化推荐商品数据删除接口-JAR包未发布时JSON调用
     *
     * @param dataDeleteModelString 商品删除模型-JSON字符串类型
     * @return {@link TechriskInnovateMpcpromoDataDeleteResponse}
     * @throws AlipayApiException AlipayApiException
     */
    @Override
    public TechriskInnovateMpcpromoDataDeleteResponse deleteData(String dataDeleteModelString) throws AlipayApiException {

        log.info("data delete from promo service, dataDeleteModelString = {}", JSON.toJSONString(dataDeleteModelString));
        AlipayClient alipayClient = new DefaultAlipayClient(PublicConstant.SERVER_URL, PublicConstant.APP_ID,
                PublicConstant.PRIVATE_KEY, "json", "utf-8", PublicConstant.PUBLIC_KEY, "RSA2");
        TechriskInnovateMpcpromoDataDeleteRequest request = new TechriskInnovateMpcpromoDataDeleteRequest();
        request.setBizContent(dataDeleteModelString);
        TechriskInnovateMpcpromoDataDeleteResponse response = alipayClient.execute(request);
        return response;

    }

    /**
     * 小程序云个性化推荐用户行为上报接口-JAR包未发布时JSON调用
     *
     * @param behaviorSyncModelString 行为同步模型-JSON字符串类型
     * @return {@link TechriskInnovateMpcpromoBehaviorSyncResponse}
     * @throws AlipayApiException AlipayApiException
     */
    @Override
    public TechriskInnovateMpcpromoBehaviorSyncResponse syncBehavior(String behaviorSyncModelString) throws AlipayApiException {

        log.info("behavior sync from promo service, behaviorSyncModelString = {}", JSON.toJSONString(behaviorSyncModelString));
        AlipayClient alipayClient = new DefaultAlipayClient(PublicConstant.SERVER_URL, PublicConstant.APP_ID,
                PublicConstant.PRIVATE_KEY, "json", "utf-8", PublicConstant.PUBLIC_KEY, "RSA2");
        TechriskInnovateMpcpromoBehaviorSyncRequest request = new TechriskInnovateMpcpromoBehaviorSyncRequest();
        request.setBizContent(behaviorSyncModelString);
        TechriskInnovateMpcpromoBehaviorSyncResponse response = alipayClient.execute(request);
        return response;

    }
}