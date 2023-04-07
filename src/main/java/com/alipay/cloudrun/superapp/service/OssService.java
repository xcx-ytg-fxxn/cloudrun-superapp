/*
 * Ant Group
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.alipay.cloudrun.superapp.service;

import com.alipay.api.response.AlipayOpenMiniCloudFileDeleteResponse;
import com.alipay.api.response.AlipayOpenMiniCloudFileQueryResponse;
import com.alipay.api.response.AlipayOpenMiniCloudFileUploadResponse;
import com.alipay.api.response.AlipayOpenMiniCloudFilelistQueryResponse;

import java.util.List;

/**
 * @author siwei
 * @version OssService.java, v 0.1 2023年04月04日 17:51 siwei
 */
public interface OssService {

    /**
     * 上传文件
     *
     * @param localFile 本地文件
     * @param fileName  OSS文件名称
     * @param filePath  OSS文件路径
     * @return {@link AlipayOpenMiniCloudFileUploadResponse}
     */
    AlipayOpenMiniCloudFileUploadResponse uploadFile(String localFile, String fileName, String filePath);

    /**
     * 列举文件
     *
     * @param path      文件路径
     * @param nextToken 下一个令牌
     * @return {@link AlipayOpenMiniCloudFilelistQueryResponse}
     */
    AlipayOpenMiniCloudFilelistQueryResponse queryFileList(String path, String nextToken);

    /**
     * 查询文件详细信息
     *
     * @param fileId 文件Id
     * @return {@link AlipayOpenMiniCloudFileQueryResponse}
     */
    AlipayOpenMiniCloudFileQueryResponse queryFileInfo(String fileId);

    /**
     * 删除文件
     *
     * @param path         文件路径
     * @param fileNameList 文件名称列表
     * @return {@link AlipayOpenMiniCloudFileDeleteResponse}
     */
    AlipayOpenMiniCloudFileDeleteResponse deleteFile(String path, List<String> fileNameList);

}