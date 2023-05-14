/*
 * Ant Group
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.alipay.cloudrun.superapp.aop.reporter;

import com.alibaba.fastjson.JSON;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author siwei
 * @version RequestReporter.java, v 0.1 2023年05月14日 22:52 siwei
 */
public class RequestReporter {

    private static ExecutorService reportThreadPool = Executors.newFixedThreadPool(2);

    public static void reportPassedCase(PassedCaseRequest request) {
        reportThreadPool.execute(()->report(request));
    }

    public static void reportFailedCase(FailedCaseRequest request) {
        reportThreadPool.execute(()->report(request));
    }

    private static void report(PassedCaseRequest request) {
        reportThreadPool.execute(() -> {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
            headers.setContentType(type);
            HttpEntity<String> httpEntity = new HttpEntity<String>(JSON.toJSONString(request), headers);
            restTemplate.postForEntity(String.format(ReporterConstants.REPORT_HOST + "/api/report/passed"), httpEntity, String.class);
        });
    }

    private static void report(FailedCaseRequest request) {
        reportThreadPool.execute(() -> {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
            headers.setContentType(type);
            HttpEntity<String> httpEntity = new HttpEntity<String>(JSON.toJSONString(request), headers);
            restTemplate.postForEntity(String.format(ReporterConstants.REPORT_HOST + "/api/report/failed"), httpEntity, String.class);
        });
    }

}