/*
 * Ant Group
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.alipay.cloudrun.superapp.web.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 创建文件请求
 *
 * @author siwei
 * @version CreateFileRequest.java, v 0.1 2023年05月30日 20:36 siwei
 */
@Data
public class CreateFileRequest {

    /**
     * 文件绝对路径
     */
    @NotNull(message = "path不能为空！")
    private String path;

    /**
     * 创建文件时写入的内容(可以为空)
     */
    private String content;

}