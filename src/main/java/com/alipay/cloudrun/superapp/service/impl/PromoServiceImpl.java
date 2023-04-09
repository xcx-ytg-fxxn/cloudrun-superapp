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
import com.alipay.api.request.TechriskInnovateMpcpromoDataSyncRequest;
import com.alipay.api.response.TechriskInnovateMpcpromoDataSyncResponse;
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

        log.info("sync data to promo service, dataSyncModel = {}", dataSyncModel);
        AlipayClient alipayClient = new DefaultAlipayClient(PublicConstant.SERVER_URL, PublicConstant.APP_ID,
                PublicConstant.PRIVATE_KEY, "json", "utf-8", PublicConstant.PUBLIC_KEY, "RSA2");
        TechriskInnovateMpcpromoDataSyncRequest request = new TechriskInnovateMpcpromoDataSyncRequest();
        request.setBizContent(JSON.toJSONString(dataSyncModel));
        TechriskInnovateMpcpromoDataSyncResponse response = alipayClient.execute(request);
        return response;

    }
}