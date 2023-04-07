/*
 * Ant Group
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.alipay.cloudrun.superapp.web;

import com.alipay.api.response.AlipayOpenMiniCloudFileDeleteResponse;
import com.alipay.api.response.AlipayOpenMiniCloudFileQueryResponse;
import com.alipay.api.response.AlipayOpenMiniCloudFileUploadResponse;
import com.alipay.api.response.AlipayOpenMiniCloudFilelistQueryResponse;
import com.alipay.cloudrun.superapp.service.OssService;
import com.alipay.cloudrun.superapp.web.response.Result;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author siwei
 * @version OssTestController.java, v 0.1 2023年04月04日 17:26 siwei
 */
@Log4j2
@RestController
@RequestMapping("/api/oss")
public class OssTestController {

    @Autowired
    OssService ossService;

    /**
     * 上传文件
     *
     * @param file 文件
     * @param path 上传路径
     * @return {@link Result}<{@link AlipayOpenMiniCloudFileUploadResponse}>
     */
    @PostMapping("/upload")
    public Result<AlipayOpenMiniCloudFileUploadResponse> uploadFile(@RequestParam("file")MultipartFile file,
                                                                    @RequestParam("path") String path) throws IOException {
        log.info("/api/oss/upload POST request, fileName = {}, path = {}", file.getOriginalFilename(), path);
        if (path.trim().isEmpty()) {
            path = "/temp/";
        }
        String fileName = file.getOriginalFilename();
        //生成带时间戳的文件名 防止文件名重复
        String randomFileName = System.currentTimeMillis() + fileName;
        //本地临时保存文件路径
        String localPath = "/tmp/upload/" + randomFileName;
        File targetFile = new File(localPath);
        file.transferTo(targetFile);
        AlipayOpenMiniCloudFileUploadResponse response = ossService.uploadFile(localPath, randomFileName, path);
        targetFile.delete();
        return Result.success(response);

    }

    /**
     * 列举文件
     *
     * @param path    文件路径
     * @param nextToken 文件列表游标索引
     * @return {@link Result}<{@link AlipayOpenMiniCloudFilelistQueryResponse}>
     */
    @GetMapping("/list")
    public Result<AlipayOpenMiniCloudFilelistQueryResponse> queryFileList(@RequestParam("path") String path,
                                                                          @RequestParam(name = "nextToken",required = false) String nextToken) {
        log.info("/api/oss/list GET request, path = {}, nextToken = {}", path, nextToken);
        if (path == null || path.trim().isEmpty()) {
            path = "/";
        }
        return Result.success(ossService.queryFileList(path, nextToken));
    }

    /**
     * 查询文件详细信息
     *
     * @param fileId 文件Id
     * @return {@link Result}<{@link AlipayOpenMiniCloudFileQueryResponse}>
     */
    @GetMapping("/get")
    public Result<AlipayOpenMiniCloudFileQueryResponse> queryFileInfo(@RequestParam("fileId") String fileId) {

        log.info("/api/oss/get GET request, fileId = {}", fileId);
        return Result.success(ossService.queryFileInfo(fileId));

    }

    /**
     * 删除文件
     *
     * @param path         文件路径
     * @param fileName     需要删除的文件，多个文件以英文逗号相隔
     * @return {@link Result}<{@link AlipayOpenMiniCloudFileDeleteResponse}>
     */
    @DeleteMapping("/delete")
    public Result<AlipayOpenMiniCloudFileDeleteResponse> deleteFile(@RequestParam("path") String path, @RequestParam("fileName") String fileName) {

        log.info("/api/oss/delete DELETE request, path = {}, fileName = {}", path, fileName);
        List<String> fileNameList = Arrays.asList(fileName.split(","));
        return Result.success(ossService.deleteFile(path, fileNameList));

    }

}