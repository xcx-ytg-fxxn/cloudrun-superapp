/*
 * Ant Group
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.alipay.cloudrun.superapp.aop;

import com.alibaba.fastjson.JSON;
import com.alipay.cloudrun.superapp.aop.reporter.FailedCaseRequest;
import com.alipay.cloudrun.superapp.aop.reporter.PassedCaseRequest;
import com.alipay.cloudrun.superapp.aop.reporter.ReporterConstants;
import com.alipay.cloudrun.superapp.aop.reporter.RequestReporter;
import com.alipay.cloudrun.superapp.model.enums.AlipayCloudrunProductEnum;
import com.alipay.cloudrun.superapp.model.exception.AppException;
import com.alipay.cloudrun.superapp.model.exception.AppExceptionCodeEnum;
import com.alipay.cloudrun.superapp.web.response.Result;
import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Controller层切面
 * 用于记录访问时间及捕获异常
 *
 * @author siwei
 * @version ControllerAspect.java, v 0.1 2023年04月09日 14:40 siwei
 */
@Aspect
@Log4j2
@Component
public class ControllerAspect {

    /**
     * 在Controller层方法上的切面
     * 记录请求调用时间及异常处理
     *
     * @param joinPoint joinPoint
     * @return {@link Object}
     */
    @Around("@annotation(com.alipay.cloudrun.superapp.aop.annotation.ControllerPointCut)")
    public Object doAround(ProceedingJoinPoint joinPoint) {

        Long startTime = System.currentTimeMillis();
        Object res = null;

        try {
            res = joinPoint.proceed();
            handleSuccess();
        } catch (Throwable t) {
            log.error("http request process fail: ", t);
            res = handledException(t);
            handleFailure(JSON.toJSONString(res));
        } finally {
            Long cost = System.currentTimeMillis() - startTime;
            ((Result) res).setTimeCost(cost + "ms");
        }
        return res;
    }

    /**
     * 异常处理
     *
     * @param t 异常
     * @return {@link Result}
     */
    private Result handledException(Throwable t) {

        //APP定义的异常
        if (t instanceof AppException) {
            return Result.fail(((AppException) t).getErrorCode().getCode(), t.getMessage());
        }

        //其他异常
        return Result.fail(AppExceptionCodeEnum.SYSTEM_ERROR.getCode(), t.getMessage());

    }

    private void handleSuccess() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest httpServletRequest = requestAttributes.getRequest();
        String uri = httpServletRequest.getRequestURI();
        PassedCaseRequest request = new PassedCaseRequest();
        request.setRequestPath(uri);
        request.setRequestProduct(getRequestProduct(uri));
        RequestReporter.reportPassedCase(request);
    }

    private void handleFailure(String response) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest httpServletRequest = requestAttributes.getRequest();
        String uri = httpServletRequest.getRequestURI();
        FailedCaseRequest request = new FailedCaseRequest();
        request.setAppId(ReporterConstants.APP_ID);
        request.setEnvId(ReporterConstants.ENV_ID);
        request.setServiceName(ReporterConstants.SERVICE_NAME);
        request.setRequestPath(uri);
        request.setRequestProduct(getRequestProduct(uri));
        request.setResponse(response);
        RequestReporter.reportFailedCase(request);
    }

    private String getRequestProduct(String uri) {
        if (uri == null || uri.isEmpty()) {
            return AlipayCloudrunProductEnum.OTHER.name();
        } else if (uri.startsWith("/api/mysql")) {
            return AlipayCloudrunProductEnum.MYSQL.name();
        } else if (uri.startsWith("/api/redis")) {
            return AlipayCloudrunProductEnum.REDIS.name();
        } else if (uri.startsWith("/api/oss")) {
            return AlipayCloudrunProductEnum.OSS.name();
        } else if (uri.startsWith("/api/nacos")) {
            return AlipayCloudrunProductEnum.CPT_NACOS.name();
        } else if (uri.startsWith("/api/promo")) {
            return AlipayCloudrunProductEnum.PROMO.name();
        } else if (uri.startsWith("/api/aos")) {
            return AlipayCloudrunProductEnum.AOS.name();
        } else if (uri.startsWith("/api/cloud/debug")) {
            return AlipayCloudrunProductEnum.CLOUD_DEBUG.name();
        } else if (uri.startsWith("/api/cpu")) {
            return AlipayCloudrunProductEnum.CHAOS_CPU.name();
        } else if (uri.startsWith("/api/memory")) {
            return AlipayCloudrunProductEnum.CHAOS_MEM.name();
        } else {
            return AlipayCloudrunProductEnum.OTHER.name();
        }
    }

}