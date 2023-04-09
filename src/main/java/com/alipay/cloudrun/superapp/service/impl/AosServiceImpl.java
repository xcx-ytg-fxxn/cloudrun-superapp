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
import com.alipay.cloudrun.superapp.service.AosService;
import com.alipay.cloudrun.superapp.util.PublicConstant;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

/**
 * @author siwei
 * @version AosServiceImpl.java, v 0.1 2023年04月09日 20:38 siwei
 */
@Log4j2
@Service
public class AosServiceImpl implements AosService {

    /**
     * aos数据同步接口
     *
     * @param dataSyncModel 数据同步模型
     * @return {@link AlipayOpenMiniCloudAosdataSyncResponse}
     */
    @Override
    public AlipayOpenMiniCloudAosdataSyncResponse dataSync(AlipayOpenMiniCloudAosdataSyncModel dataSyncModel) throws AlipayApiException {

        log.info("aos data sync, dataSyncModel = {}", dataSyncModel);
        AlipayClient alipayClient = new DefaultAlipayClient(PublicConstant.SERVER_URL, PublicConstant.APP_ID,
                PublicConstant.PRIVATE_KEY, "json", "utf-8", PublicConstant.PUBLIC_KEY, "RSA2");
        AlipayOpenMiniCloudAosdataSyncRequest request = new AlipayOpenMiniCloudAosdataSyncRequest();
        request.setBizContent(JSON.toJSONString(dataSyncModel));
        AlipayOpenMiniCloudAosdataSyncResponse response = alipayClient.execute(request);
        return response;

    }

    /**
     * aos下拉提示
     *
     * @param suggestQueryModel 下拉提示查询模型
     * @return {@link AlipayOpenMiniCloudAossuggestQueryResponse}
     */
    @Override
    public AlipayOpenMiniCloudAossuggestQueryResponse suggestQuery(AlipayOpenMiniCloudAossuggestQueryModel suggestQueryModel) throws AlipayApiException {

        log.info("aos suggest query, suggestQueryModel = {}", suggestQueryModel);
        AlipayClient alipayClient = new DefaultAlipayClient(PublicConstant.SERVER_URL, PublicConstant.APP_ID,
                PublicConstant.PRIVATE_KEY, "json", "utf-8", PublicConstant.PUBLIC_KEY, "RSA2");
        AlipayOpenMiniCloudAossuggestQueryRequest request = new AlipayOpenMiniCloudAossuggestQueryRequest();
        request.setBizContent(JSON.toJSONString(suggestQueryModel));
        AlipayOpenMiniCloudAossuggestQueryResponse response = alipayClient.execute(request);
        return response;

    }

    /**
     * aos智能搜索
     *
     * @param itemQueryModel 智能查询模型
     * @return {@link AlipayOpenMiniCloudAositemQueryResponse}
     */
    @Override
    public AlipayOpenMiniCloudAositemQueryResponse itemQuery(AlipayOpenMiniCloudAositemQueryModel itemQueryModel) throws AlipayApiException {

        log.info("aos item query, itemQueryModel = {}", itemQueryModel);
        AlipayClient alipayClient = new DefaultAlipayClient(PublicConstant.SERVER_URL, PublicConstant.APP_ID,
                PublicConstant.PRIVATE_KEY, "json", "utf-8", PublicConstant.PUBLIC_KEY, "RSA2");
        AlipayOpenMiniCloudAositemQueryRequest request = new AlipayOpenMiniCloudAositemQueryRequest();
        request.setBizContent(JSON.toJSONString(itemQueryModel));
        AlipayOpenMiniCloudAositemQueryResponse response = alipayClient.execute(request);
        return response;

    }

    /**
     * aos热门搜索
     *
     * @param hotQueryModel 热搜查询模型
     * @return {@link AlipayOpenMiniCloudAoshotQueryResponse}
     */
    @Override
    public AlipayOpenMiniCloudAoshotQueryResponse hotQuery(AlipayOpenMiniCloudAoshotQueryModel hotQueryModel) throws AlipayApiException {

        log.info("aos hot query, hotQueryModel = {}", hotQueryModel);
        AlipayClient alipayClient = new DefaultAlipayClient(PublicConstant.SERVER_URL, PublicConstant.APP_ID,
                PublicConstant.PRIVATE_KEY, "json", "utf-8", PublicConstant.PUBLIC_KEY, "RSA2");
        AlipayOpenMiniCloudAoshotQueryRequest request = new AlipayOpenMiniCloudAoshotQueryRequest();
        request.setBizContent(JSON.toJSONString(hotQueryModel));
        AlipayOpenMiniCloudAoshotQueryResponse response = alipayClient.execute(request);
        return response;

    }

    /**
     * aos底纹搜索
     *
     * @param hintQueryModel 提示查询模型
     * @return {@link AlipayOpenMiniCloudAoshintQueryResponse}
     */
    @Override
    public AlipayOpenMiniCloudAoshintQueryResponse hintQuery(AlipayOpenMiniCloudAoshintQueryModel hintQueryModel) throws AlipayApiException {

        log.info("aos hint query, hintQueryModel = {}", hintQueryModel);
        AlipayClient alipayClient = new DefaultAlipayClient(PublicConstant.SERVER_URL, PublicConstant.APP_ID,
                PublicConstant.PRIVATE_KEY, "json", "utf-8", PublicConstant.PUBLIC_KEY, "RSA2");
        AlipayOpenMiniCloudAoshintQueryRequest request = new AlipayOpenMiniCloudAoshintQueryRequest();
        request.setBizContent(JSON.toJSONString(hintQueryModel));
        AlipayOpenMiniCloudAoshintQueryResponse response = alipayClient.execute(request);
        return response;

    }

    /**
     * aos行为上报
     *
     * @param behaviorSyncModel 行为同步模式
     * @return {@link AlipayOpenMiniCloudAosbehaviorSyncResponse}
     */
    @Override
    public AlipayOpenMiniCloudAosbehaviorSyncResponse behaviorSync(AlipayOpenMiniCloudAosbehaviorSyncModel behaviorSyncModel) throws AlipayApiException {

        log.info("aos behavior sync, behaviorSyncModel = {}" , behaviorSyncModel);
        AlipayClient alipayClient = new DefaultAlipayClient(PublicConstant.SERVER_URL, PublicConstant.APP_ID,
                PublicConstant.PRIVATE_KEY, "json", "utf-8", PublicConstant.PUBLIC_KEY, "RSA2");
        AlipayOpenMiniCloudAosbehaviorSyncRequest request = new AlipayOpenMiniCloudAosbehaviorSyncRequest();
        request.setBizContent(JSON.toJSONString(behaviorSyncModel));
        AlipayOpenMiniCloudAosbehaviorSyncResponse response = alipayClient.execute(request);
        return response;

    }
}