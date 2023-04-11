/*
 * Ant Group
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.alipay.cloudrun.superapp.service.impl;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.TechriskInnovateMpcpromoDataSyncModel;
import com.alipay.api.domain.TechriskInnovateMpcpromoItemQueryModel;
import com.alipay.api.domain.TechriskInnovateMpcpromoSceneCreateModel;
import com.alipay.api.request.TechriskInnovateMpcpromoDataSyncRequest;
import com.alipay.api.request.TechriskInnovateMpcpromoItemQueryRequest;
import com.alipay.api.request.TechriskInnovateMpcpromoSceneCreateRequest;
import com.alipay.api.response.TechriskInnovateMpcpromoDataSyncResponse;
import com.alipay.api.response.TechriskInnovateMpcpromoItemQueryResponse;
import com.alipay.api.response.TechriskInnovateMpcpromoSceneCreateResponse;
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
     * 小程序云智能应用上传数据接口
     *
     * @param dataSyncModel 数据同步模型
     * @return {@link TechriskInnovateMpcpromoDataSyncResponse}
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
     * 小程序云智能应用场景创建接口
     *
     * @param sceneCreateModel 场景创建模型
     * @return {@link TechriskInnovateMpcpromoSceneCreateResponse}
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
     * 小程序云智能应用推荐查询接口
     *
     * @param itemQueryModel 项目查询模型
     * @return {@link TechriskInnovateMpcpromoItemQueryResponse}
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
}