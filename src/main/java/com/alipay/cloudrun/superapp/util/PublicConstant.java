/*
 * Ant Group
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.alipay.cloudrun.superapp.util;

/**
 * @author siwei
 * @version PublicConstant.java, v 0.1 2023年04月05日 12:56 siwei
 */
public class PublicConstant {

    /**
     * 服务Id
     */
    public static final String APP_ID = System.getenv("CLOUDRUN_PAASCORE_APPID");

    /**
     * 环境Id
     */
    public static final String ENV_ID = System.getenv("CLOUDRUN_PAASCORE_ENVID");

    /**
     * 服务网关
     */
    public static final String SERVER_URL = "https://openapi.alipay.com/gateway.do";

    /**
     * 私钥
     *
     */
    public static final String PRIVATE_KEY = System.getenv("APP_PRIVATE_KEY");

    /**
     * 公钥
     *
     */
    public static final String PUBLIC_KEY = System.getenv("APP_PUBLIC_KEY");


}