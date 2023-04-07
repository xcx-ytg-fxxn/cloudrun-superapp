/*
 * Ant Group
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.alipay.cloudrun.superapp.web.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author siwei
 * @version UpdateRecordRequest.java, v 0.1 2023年04月06日 20:59 siwei
 */
@Data
public class UpdateRecordRequest {

    /**
     * 主键id
     */
    @NotNull(message = "id不能为空！")
    Long id;

    /**
     * 记录
     */
    @NotNull(message = "record不能为空！")
    String record;

}