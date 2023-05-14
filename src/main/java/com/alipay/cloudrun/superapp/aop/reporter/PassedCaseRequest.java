/*
 * Ant Group
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.alipay.cloudrun.superapp.aop.reporter;

import lombok.Data;

/**
 * 调用成功的请求通知
 *
 * @author siwei
 * @version PassedCaseRequest.java, v 0.1 2023年05月14日 22:37 siwei
 */
@Data
public class PassedCaseRequest {

    /**
     * requestProduct
     */
    private String requestProduct;

    /**
     * requestProduct
     */
    private String requestPath;

}