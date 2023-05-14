/*
 * Ant Group
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.alipay.cloudrun.superapp.aop.reporter;

/**
 * @author siwei
 * @version ReporterConstants.java, v 0.1 2023年05月15日 02:53 siwei
 */
public class ReporterConstants {

    public static String REPORT_HOST = "https://user-simulation-6c33beea-64f7-459f-a9d4-e59600fe2230.dev.cloudbaseapp-sanbox.cn";

    public static String APP_ID = System.getenv("CLOUDRUN_PAASCORE_APPID");

    public static String ENV_ID = System.getenv("CLOUDRUN_PAASCORE_ENVID");

    public static String SERVICE_NAME = System.getenv("ALIPAY_APP_APPNAME");

}