/*
 * Ant Group
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.alipay.cloudrun.superapp.model.exception;

/**
 * Cloudrun Superapp 异常枚举
 *
 * @author siwei
 * @version AppExceptionCodeEnum.java, v 0.1 2023年04月09日 13:25 siwei
 */
public enum AppExceptionCodeEnum {

    /** 系统异常 */
    SYSTEM_ERROR("SYSTEM_ERROR", "系统异常"),

    /** 缺少参数 */
    MISSING_PARAM("MISSING_PARAM", "缺少参数"),

    /** 对象存储异常 */
    OSS_ERROR("OSS_ERROR", "对象存储异常"),

    /** 文件已存在 */
    FILE_EXISTS("FILE_EXISTS", "文件已存在");

    /** 错误码 */
    private String code;

    /** 错误描述 */
    private String description;

    /**
     * 构造器
     *
     * @param code        错误代码
     * @param description 错误描述
     */
    AppExceptionCodeEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    /**
     * Getter method for property <tt>code</tt>.
     *
     * @return property value of code
     */
    public String getCode() {
        return code;
    }

    /**
     * Getter method for property <tt>description</tt>.
     *
     * @return property value of description
     */
    public String getDescription() {
        return description;
    }
}