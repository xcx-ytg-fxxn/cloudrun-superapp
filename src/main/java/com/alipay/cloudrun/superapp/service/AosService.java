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
 * @version AosService.java, v 0.1 2023年04月09日 20:26 siwei
 */
public interface AosService {

    /**
     * aos数据同步接口
     *
     * @param dataSyncModel 数据同步模型
     * @return {@link AlipayOpenMiniCloudAosdataSyncResponse}
     */
    AlipayOpenMiniCloudAosdataSyncResponse dataSync(AlipayOpenMiniCloudAosdataSyncModel dataSyncModel) throws AlipayApiException;

    /**
     * aos下拉提示
     *
     * @param suggestQueryModel 下拉提示查询模型
     * @return {@link AlipayOpenMiniCloudAossuggestQueryResponse}
     */
    AlipayOpenMiniCloudAossuggestQueryResponse suggestQuery(AlipayOpenMiniCloudAossuggestQueryModel suggestQueryModel) throws AlipayApiException;

    /**
     * aos智能搜索
     *
     * @param itemQueryModel 智能查询模型
     * @return {@link AlipayOpenMiniCloudAositemQueryResponse}
     */
    AlipayOpenMiniCloudAositemQueryResponse itemQuery(AlipayOpenMiniCloudAositemQueryModel itemQueryModel) throws AlipayApiException;

    /**
     * aos热门搜索
     *
     * @param hotQueryModel 热搜查询模型
     * @return {@link AlipayOpenMiniCloudAoshotQueryResponse}
     */
    AlipayOpenMiniCloudAoshotQueryResponse hotQuery(AlipayOpenMiniCloudAoshotQueryModel hotQueryModel) throws AlipayApiException;

    /**
     * aos底纹搜索
     *
     * @param hintQueryModel 提示查询模型
     * @return {@link AlipayOpenMiniCloudAoshintQueryResponse}
     */
    AlipayOpenMiniCloudAoshintQueryResponse hintQuery(AlipayOpenMiniCloudAoshintQueryModel hintQueryModel) throws AlipayApiException;

    /**
     * aos行为上报
     *
     * @param behaviorSyncModel 行为同步模式
     * @return {@link AlipayOpenMiniCloudAosbehaviorSyncResponse}
     */
    AlipayOpenMiniCloudAosbehaviorSyncResponse behaviorSync(AlipayOpenMiniCloudAosbehaviorSyncModel behaviorSyncModel) throws AlipayApiException;
}