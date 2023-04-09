/*
 * Ant Group
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.alipay.cloudrun.superapp.aop;

import com.alipay.cloudrun.superapp.model.exception.AppException;
import com.alipay.cloudrun.superapp.model.exception.AppExceptionCodeEnum;
import com.alipay.cloudrun.superapp.web.response.Result;
import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

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
        } catch (Throwable t) {
            log.error("http request process fail: ", t);
            res = handledException(t);

        } finally {
            Long cost = System.currentTimeMillis() - startTime;
            ((Result) res).setTimeCost(cost + "ms");
            return res;
        }

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

}