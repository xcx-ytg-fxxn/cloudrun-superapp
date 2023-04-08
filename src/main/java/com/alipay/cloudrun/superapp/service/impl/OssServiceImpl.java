/*
 * Ant Group
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.alipay.cloudrun.superapp.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.FileItem;
import com.alipay.api.request.AlipayOpenMiniCloudFileDeleteRequest;
import com.alipay.api.request.AlipayOpenMiniCloudFileQueryRequest;
import com.alipay.api.request.AlipayOpenMiniCloudFileUploadRequest;
import com.alipay.api.request.AlipayOpenMiniCloudFilelistQueryRequest;
import com.alipay.api.response.AlipayOpenMiniCloudFileDeleteResponse;
import com.alipay.api.response.AlipayOpenMiniCloudFileQueryResponse;
import com.alipay.api.response.AlipayOpenMiniCloudFileUploadResponse;
import com.alipay.api.response.AlipayOpenMiniCloudFilelistQueryResponse;
import com.alipay.cloudrun.superapp.service.OssService;
import com.alipay.cloudrun.superapp.util.PublicConstant;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author siwei
 * @version OssServiceImpl.java, v 0.1 2023年04月05日 14:46 siwei
 */
@Log4j2
@Service
public class OssServiceImpl implements OssService {

    /**
     * 上传文件
     *
     * @param localFile 本地文件
     * @param fileName  OSS文件名称
     * @param filePath  OSS文件路径
     * @return {@link AlipayOpenMiniCloudFileUploadResponse}
     */
    @Override
    public AlipayOpenMiniCloudFileUploadResponse uploadFile(String localFile, String fileName, String filePath) {

        log.info("upload file to alipay cloudrun oss, localFile = {}, fileName = {}, filePath = {}", localFile, fileName, filePath);
        AlipayClient alipayClient = new DefaultAlipayClient(PublicConstant.SERVER_URL, PublicConstant.APP_ID,
                PublicConstant.PRIVATE_KEY, "json", "utf-8", PublicConstant.PUBLIC_KEY, "RSA2");
        AlipayOpenMiniCloudFileUploadRequest request = new AlipayOpenMiniCloudFileUploadRequest();
        request.setCloudId(PublicConstant.ENV_ID);
        request.setType("File");
        request.setPath(filePath);
        request.setFileName(fileName);
        request.setFileContent(new FileItem(localFile));
        try {
            AlipayOpenMiniCloudFileUploadResponse response = alipayClient.execute(request);
            return response;
        } catch (AlipayApiException e) {
            log.error("upload file fail, AlipayApiException", e);
            throw new RuntimeException(e.getMessage(), e);
        }

    }

    /**
     * 上传文件
     *
     * @param bytes    文件字节码
     * @param fileName OSS文件名称
     * @param filePath OSS文件名称
     * @return {@link AlipayOpenMiniCloudFileUploadResponse}
     */
    @Override
    public AlipayOpenMiniCloudFileUploadResponse uploadFile(byte[] bytes, String fileName, String filePath) {

        log.info("upload file bytes to alipay cloudrun oss, fileName = {}, filePath = {}", fileName, filePath);
        AlipayClient alipayClient = new DefaultAlipayClient(PublicConstant.SERVER_URL, PublicConstant.APP_ID,
                PublicConstant.PRIVATE_KEY, "json", "utf-8", PublicConstant.PUBLIC_KEY, "RSA2");
        AlipayOpenMiniCloudFileUploadRequest request = new AlipayOpenMiniCloudFileUploadRequest();
        request.setCloudId(PublicConstant.ENV_ID);
        request.setType("File");
        request.setPath(filePath);
        request.setFileName(fileName);
        request.setFileContent(new FileItem(fileName, bytes));
        try {
            AlipayOpenMiniCloudFileUploadResponse response = alipayClient.execute(request);
            return response;
        } catch (AlipayApiException e) {
            log.error("upload file fail, AlipayApiException", e);
            throw new RuntimeException(e.getMessage(), e);
        }

    }

    /**
     * 列举文件
     *
     * @param path    文件路径
     * @param nextToken 文件列表游标索引
     * @return {@link AlipayOpenMiniCloudFilelistQueryResponse}
     */
    @Override
    public AlipayOpenMiniCloudFilelistQueryResponse queryFileList(String path, String nextToken) {

        log.info("query file list from alipay cloudrun oss, path = {}, nextToken = {}", path, nextToken);
        AlipayClient alipayClient = new DefaultAlipayClient(PublicConstant.SERVER_URL, PublicConstant.APP_ID,
                PublicConstant.PRIVATE_KEY, "json", "utf-8", PublicConstant.PUBLIC_KEY, "RSA2");
        AlipayOpenMiniCloudFilelistQueryRequest request = new AlipayOpenMiniCloudFilelistQueryRequest();
        JSONObject bizContent = new JSONObject();
        bizContent.put("cloud_id", PublicConstant.ENV_ID);
        bizContent.put("path", path);
        if (nextToken != null && !nextToken.trim().isEmpty()) {
            bizContent.put("next_token", nextToken);
        }
        request.setBizContent(bizContent.toJSONString());
        try {
            AlipayOpenMiniCloudFilelistQueryResponse response = alipayClient.execute(request);
            return response;
        } catch (AlipayApiException e) {
            log.error("query file list fail, AlipayApiException", e);
            throw new RuntimeException(e.getMessage(), e);
        }

    }

    /**
     * 查询文件详细信息
     *
     * @param fileId 文件Id
     * @return {@link AlipayOpenMiniCloudFileQueryResponse}
     */
    @Override
    public AlipayOpenMiniCloudFileQueryResponse queryFileInfo(String fileId) {

        log.info("query file info from alipay cloudrun oss, fileId = {}", fileId);
        AlipayClient alipayClient = new DefaultAlipayClient(PublicConstant.SERVER_URL, PublicConstant.APP_ID,
                PublicConstant.PRIVATE_KEY, "json", "utf-8", PublicConstant.PUBLIC_KEY, "RSA2");
        AlipayOpenMiniCloudFileQueryRequest request = new AlipayOpenMiniCloudFileQueryRequest();
        JSONObject bizContent = new JSONObject();
        bizContent.put("cloud_id", PublicConstant.ENV_ID);
        bizContent.put("file_id", fileId);
        request.setBizContent(bizContent.toJSONString());
        try {
            AlipayOpenMiniCloudFileQueryResponse response = alipayClient.execute(request);
            return response;
        } catch (AlipayApiException e) {
            log.error("query file info fail, AlipayApiException", e);
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    /**
     * 删除文件
     *
     * @param path         文件路径
     * @param fileNameList 文件名称列表
     * @return {@link AlipayOpenMiniCloudFileDeleteResponse}
     */
    @Override
    public AlipayOpenMiniCloudFileDeleteResponse deleteFile(String path, List<String> fileNameList) {

        log.info("delete file from alipay cloudrun oss, path = {}, fileNameList = {}", path, fileNameList);
        AlipayClient alipayClient = new DefaultAlipayClient(PublicConstant.SERVER_URL, PublicConstant.APP_ID,
                PublicConstant.PRIVATE_KEY, "json", "utf-8", PublicConstant.PUBLIC_KEY, "RSA2");
        if (path == null || path.trim().isEmpty()) {
            path = "/";
        }
        AlipayOpenMiniCloudFileDeleteRequest request = new AlipayOpenMiniCloudFileDeleteRequest();
        JSONObject bizContent = new JSONObject();
        bizContent.put("cloud_id", PublicConstant.ENV_ID);
        bizContent.put("path", path);
        bizContent.put("file_name_list", fileNameList);
        request.setBizContent(bizContent.toJSONString());
        try {
            AlipayOpenMiniCloudFileDeleteResponse response = alipayClient.execute(request);
            return response;
        } catch (AlipayApiException e) {
            log.error("delete file info fail, AlipayApiException", e);
            throw new RuntimeException(e.getMessage(), e);
        }

    }
}