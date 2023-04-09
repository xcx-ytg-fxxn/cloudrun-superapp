/*
 * Ant Group
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.alipay.cloudrun.superapp.web;

import com.alipay.api.domain.TechriskInnovateMpcpromoDataSyncModel;
import com.alipay.api.response.TechriskInnovateMpcpromoDataSyncResponse;
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
     * 小程序云智能应用上传数据接口
     *
     * @param dataSyncModel 数据同步模型
     * @return {@link Result}<{@link TechriskInnovateMpcpromoDataSyncResponse}>
     */
    @PostMapping("/syncData")
    @ControllerPointCut
    @SneakyThrows
    Result<TechriskInnovateMpcpromoDataSyncResponse> syncData(@RequestBody TechriskInnovateMpcpromoDataSyncModel dataSyncModel) {

        log.info("/api/promo/syncData POST request, dataSyncModel = {}", dataSyncModel);
        return Result.success(promoService.syncData(dataSyncModel));

    }

}