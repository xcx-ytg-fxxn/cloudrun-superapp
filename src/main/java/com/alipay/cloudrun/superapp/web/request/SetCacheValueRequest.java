/*
 * Ant Group
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.alipay.cloudrun.superapp.web.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author siwei
 * @version SetCacheValueRequest.java, v 0.1 2023年04月04日 23:58 siwei
 */
@Data
public class SetCacheValueRequest {

    /**
     * key
     */
    @NotBlank(message = "key不能为空！")
    private String key;

    /**
     * value
     */
    @NotBlank(message = "value不能为空！")
    private String value;

    /**
     * 过期时间
     */
    private Long timeout;

}