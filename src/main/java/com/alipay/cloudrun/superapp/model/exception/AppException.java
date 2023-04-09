/*
 * Ant Group
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.alipay.cloudrun.superapp.model.exception;

import org.slf4j.helpers.FormattingTuple;
import org.slf4j.helpers.MessageFormatter;

/**
 * Cloudrun superapp 异常
 *
 * @author siwei
 * @version AppException.java, v 0.1 2023年04月09日 13:52 siwei
 */
public class AppException extends RuntimeException{

    /** 错误码 */
    private AppExceptionCodeEnum errorCode;

    /**
     * 默认构造器
     */
    public AppException () {

    }

    /**
     * 构造器
     *
     * @param errorCode 错误码
     */
    public AppException (AppExceptionCodeEnum errorCode) {
        super(errorCode.getDescription());
        this.errorCode = errorCode;
    }

    /**
     * 构造器
     *
     * @param errorCode 错误码
     * @param message   异常信息
     */
    public AppException (AppExceptionCodeEnum errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    /**
     * 构造器
     *
     * @param errorCode 错误码
     * @param throwable 原始异常
     */
    public AppException (AppExceptionCodeEnum errorCode, Throwable throwable) {
        super(throwable);
        this.errorCode = errorCode;
    }

    /**
     * 构造器
     *
     * @param errorCode 错误码
     * @param message   异常信息
     * @param throwable 原始异常
     */
    public AppException(AppExceptionCodeEnum errorCode, String message, Throwable throwable) {
        super(message, throwable);
        this.errorCode = errorCode;
    }

    /**
     * Getter method for property <tt>errorCode</tt>.
     *
     * @return property value of errorCode
     */
    public AppExceptionCodeEnum getErrorCode() {
        return errorCode;
    }

    /**
     * 异常构造器
     *
     * @param errorCode 错误码
     * @param format    异常信息格式
     * @param args      异常信息参数
     * @return 异常
     */
    public static AppException valueOf(AppExceptionCodeEnum errorCode, String format,
                                               Object... args) {
        FormattingTuple tf = MessageFormatter.arrayFormat(format, args);
        return new AppException(errorCode, tf.getMessage());
    }

    /**
     * 异常构造器
     *
     * @param throwable 原始异常
     * @param errorCode 错误码
     * @param format    异常摘要信息格式
     * @param args      异常信息参数值
     * @return 异常
     */
    public static AppException valueOf(Throwable throwable, AppExceptionCodeEnum errorCode,
                                               String format, Object... args) {
        FormattingTuple tf = MessageFormatter.arrayFormat(format, args);
        return new AppException(errorCode, tf.getMessage(), throwable);
    }


}