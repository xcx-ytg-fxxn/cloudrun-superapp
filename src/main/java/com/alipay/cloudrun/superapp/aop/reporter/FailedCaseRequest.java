/*
 * Ant Group
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.alipay.cloudrun.superapp.aop.reporter;

import lombok.Data;

/**
 * @author siwei
 * @version FailedCaseRequest.java, v 0.1 2023年05月14日 22:46 siwei
 */
@Data
public class FailedCaseRequest {

    /**
     * appId
     */
    private String appId;

    /**
     * envId
     */
    private String envId;

    /**
     * serviceName
     */
    private String serviceName;

    /**
     * requestProduct
     */
    private String requestProduct;

    /**
     * requestPath
     */
    private String requestPath;

    /**
     * response
     */
    private String response;

}