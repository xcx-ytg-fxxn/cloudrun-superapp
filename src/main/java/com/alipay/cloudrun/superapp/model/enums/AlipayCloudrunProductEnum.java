/*
 * Ant Group
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.alipay.cloudrun.superapp.model.enums;

/**
 * 云托管产品/异常注入类型枚举类
 *
 * @author siwei
 * @version AlipayCloudrunProductEnum.java, v 0.1 2023年05月14日 22:29 siwei
 */
public enum AlipayCloudrunProductEnum {

    /**
     * mysql数据库服务
     */
    MYSQL,

    /**
     * 缓存服务
     */
    REDIS,

    /**
     * 对象存储服务
     */
    OSS,

    /**
     * CPT相关-NACOS
     */
    CPT_NACOS,

    /**
     * 个性化推荐
     */
    PROMO,

    /**
     * 智能搜索
     */
    AOS,

    /**
     * 云端调试
     */
    CLOUD_DEBUG,

    /**
     * 异常注入-CPU
     */
    CHAOS_CPU,

    /**
     * 异常注入-内存
     */
    CHAOS_MEM,

    /**
     * 其他产品
     */
    OTHER

}