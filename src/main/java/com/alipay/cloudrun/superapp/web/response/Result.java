/*
 * Ant Group
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.alipay.cloudrun.superapp.web.response;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * HTTP接口返回对象
 *
 * @author siwei
 * @version Result.java, v 0.1 2023年04月04日 22:28 siwei
 */
@Data
@RequiredArgsConstructor
public class Result<T> {

    /**
     * 是否成功
     */
    private boolean success;

    /**
     * 结果数据
     */
    private T data;

    /**
     * 错误码
     */
    private String errorCode;

    /**
     * 错误提示
     */
    private String errorMessage;

    /**
     * 请求耗时
     */
    private String timeCost;


    public Result(boolean success) {
        this.success = success;
    }

    public static <T> Result<T> success() {
        return new Result<>(true);
    }

    public static <T> Result<T> success(T data) {
        Result<T> response = new Result<>(true);
        response.setData(data);
        return response;
    }

    public static <T> Result<T> fail(String errorCode, String errorMessage) {
        Result<T> result = new Result<>(false);
        result.setErrorCode(errorCode);
        result.setErrorMessage(errorMessage);
        return result;
    }

}