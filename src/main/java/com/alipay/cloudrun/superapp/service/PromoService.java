/*
 * Ant Group
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.alipay.cloudrun.superapp.service;

import com.alipay.api.AlipayApiException;
import com.alipay.api.domain.TechriskInnovateMpcpromoDataSyncModel;
import com.alipay.api.response.TechriskInnovateMpcpromoDataSyncResponse;

/**
 * @author siwei
 * @version PromoService.java, v 0.1 2023年04月09日 22:55 siwei
 */
public interface PromoService {

    /**
     * 小程序云智能应用上传数据接口
     *
     * @param dataSyncModel 数据同步模型
     * @return {@link TechriskInnovateMpcpromoDataSyncResponse}
     */
    TechriskInnovateMpcpromoDataSyncResponse syncData(TechriskInnovateMpcpromoDataSyncModel dataSyncModel) throws AlipayApiException;

}