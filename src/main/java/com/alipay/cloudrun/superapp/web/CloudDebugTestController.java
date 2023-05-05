/*
 * Ant Group
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.alipay.cloudrun.superapp.web;

import com.alibaba.fastjson.JSON;
import com.alipay.cloudrun.superapp.web.response.HttpRequestInfo;
import com.alipay.cloudrun.superapp.web.response.Result;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * 小程序云托管云端调试测试
 *
 * @author siwei
 * @version CloudDebugTestController.java, v 0.1 2023年05月05日 16:31 siwei
 */
@Log4j2
@RestController
@RequestMapping("/api/cloud/debug")
public class CloudDebugTestController {

    /**
     * HTTP GET方法请求测试
     *
     * @param request 请求
     * @return {@link Result}<{@link HttpRequestInfo}>
     */
    @GetMapping("/get")
    public Result<HttpRequestInfo> testGetMethod(HttpServletRequest request) {
        return Result.success(getHttpRequestInfo(request, HttpMethod.GET));
    }

    /**
     * HTTP POST方法请求测试
     *
     * @param request 请求
     * @return {@link Result}<{@link HttpRequestInfo}>
     */
    @PostMapping("/post")
    public Result<HttpRequestInfo> testPostMethod(HttpServletRequest request) {
        return Result.success(getHttpRequestInfo(request, HttpMethod.POST));
    }

    /**
     * HTTP DELETE方法请求测试
     *
     * @param request 请求
     * @return {@link Result}<{@link HttpRequestInfo}>
     */
    @DeleteMapping("/delete")
    public Result<HttpRequestInfo> testDeleteMethod(HttpServletRequest request) {
        return Result.success(getHttpRequestInfo(request, HttpMethod.DELETE));
    }

    /**
     * HTTP PUT方法请求测试
     *
     * @param request 请求
     * @return {@link Result}<{@link HttpRequestInfo}>
     */
    @PutMapping("/put")
    public Result<HttpRequestInfo> testPutMethod(HttpServletRequest request) {
        return Result.success(getHttpRequestInfo(request, HttpMethod.PUT));
    }

    /**
     * 获取http请求信息
     *
     * @param request 请求
     * @param method  http方法
     * @return {@link HttpRequestInfo}
     */
    private HttpRequestInfo getHttpRequestInfo(HttpServletRequest request, HttpMethod method) {

        HttpRequestInfo httpRequestInfo = new HttpRequestInfo();
        httpRequestInfo.setMethod(method.name());

        //获取请求的header
        Map<String, String> headers = new HashMap<>();
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            String value = request.getHeader(headerName);
            headers.put(headerName, value);
        }
        httpRequestInfo.setHeaders(headers);

        //获取请求的parameter
        Map<String, String> requestParams = new HashMap<>();
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String parameterName = parameterNames.nextElement();
            String value = request.getParameter(parameterName);
            requestParams.put(parameterName, value);
        }
        httpRequestInfo.setRequestParams(requestParams);

        //获取请求body
        try {
            BufferedReader reader = request.getReader();
            StringBuilder requestBody = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                requestBody.append(line);
            }
            httpRequestInfo.setRequestBody(JSON.parseObject(requestBody.toString()));
        } catch (Exception e) {
            log.error("get http request body fail, e = {}", e.getMessage(), e);
        }

        return httpRequestInfo;

    }

}