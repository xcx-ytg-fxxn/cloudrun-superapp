/*
 * Ant Group
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.alipay.cloudrun.superapp.web.handler;

import com.alipay.cloudrun.superapp.model.exception.AppExceptionCodeEnum;
import com.alipay.cloudrun.superapp.web.response.Result;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author siwei
 * @version WebExceptionHandler.java, v 0.1 2023年04月09日 16:17 siwei
 */
@RestControllerAdvice
@Log4j2
public class WebExceptionHandler {

    /**
     * 通用异常处理
     */
    @ExceptionHandler(Exception.class)
    public Result<String> commonExceptionHandler(Exception e) {
        log.error("system error exception", e);
        return Result.fail(AppExceptionCodeEnum.SYSTEM_ERROR.getCode(), e.getMessage());
    }

    /**
     * 缺少参数异常处理
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public Result<String> missingServletRequestParameterExceptionHandler(MissingServletRequestParameterException e) {
        log.warn("missing servlet request parameter exception", e);
        return Result.fail(String.valueOf(AppExceptionCodeEnum.MISSING_PARAM.getCode()),
                "参数" + e.getParameterName() + "不能为空!");
    }

}