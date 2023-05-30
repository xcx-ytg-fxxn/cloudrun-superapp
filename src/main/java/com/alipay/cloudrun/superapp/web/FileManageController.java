/*
 * Ant Group
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.alipay.cloudrun.superapp.web;

import com.alipay.cloudrun.superapp.aop.annotation.ControllerPointCut;
import com.alipay.cloudrun.superapp.model.exception.AppExceptionCodeEnum;
import com.alipay.cloudrun.superapp.web.request.CreateFileRequest;
import com.alipay.cloudrun.superapp.web.response.Result;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


/**
 * 文件管理接口
 *
 * @author siwei
 * @version FileManageController.java, v 0.1 2023年05月30日 20:18 siwei
 */
@Log4j2
@RestController
@RequestMapping("/api/file")
public class FileManageController {

    /**
     * 查看指定路径是否存在及类型
     *
     * @param path 路径
     * @return {@link Result}<{@link String}>
     */
    @GetMapping("/exist")
    @ControllerPointCut
    public Result<String> fileExists(@RequestParam("path") String path) {

        log.info("/api/file/exist GET request, path = {}", path);
        File file = new File(path);
        if (file.isFile()) {
            return Result.success("FILE");
        } else if (file.isDirectory()) {
            if (file.list().length > 0) {
                return Result.success("FOLDER");
            } else {
                return Result.success("EMPTY_FOLDER");
            }
        }
        return Result.success("NOT_EXIST");

    }

    /**
     * 创建文件
     *
     * @param request 请求体
     * @return {@link Result}
     * @throws IOException ioexception
     */
    @PostMapping("/create")
    @ControllerPointCut
    public Result createFile(@RequestBody CreateFileRequest request) throws IOException {

        log.info("/api/file/create POST request, request = {}", request);
        File file = new File(request.getPath());

        if (!file.createNewFile()) {
            return Result.fail(AppExceptionCodeEnum.FILE_EXISTS.getCode(), "创建文件失败，文件已存在");
        }

        if (request.getContent() != null) {
            try (FileWriter writer = new FileWriter(file)) {
                writer.write(request.getContent());
            }
        }

        return Result.success();

    }

}