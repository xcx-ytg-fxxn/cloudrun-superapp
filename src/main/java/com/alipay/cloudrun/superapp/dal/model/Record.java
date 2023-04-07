/*
 * Ant Group
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.alipay.cloudrun.superapp.dal.model;

import lombok.Data;

import java.util.Date;

/**
 * @author siwei
 * @version Record.java, v 0.1 2023年04月06日 19:47 siwei
 */
@Data
public class Record {

    /**
     * 主键id
     */
    Long id;

    /**
     * 创建时间
     */
    Date gmtCreate;

    /**
     * 修改时间
     */
    Date gmtModified;

    /**
     * 记录
     */
    String record;

}