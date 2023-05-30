/*
 * Ant Group
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.alipay.cloudrun.superapp.web;

import com.alipay.cloudrun.superapp.aop.annotation.ControllerPointCut;
import com.alipay.cloudrun.superapp.web.response.Result;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 命令行接口
 *
 * @author siwei
 * @version CommandLineController.java, v 0.1 2023年05月30日 19:58 siwei
 */
@Log4j2
@RestController
@RequestMapping("/api/command")
public class CommandLineController {

    /**
     * 执行任意命令行
     *
     * @param command 命令
     * @return {@link Result}<{@link String}>
     */
    @PostMapping("/exec")
    @ControllerPointCut
    @SneakyThrows
    public Result<String> execCommandLine(@RequestBody String command) {

        log.info("/api/command/exec POST request, command = {}", command);
        Process process = Runtime.getRuntime().exec(command);
        BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));
        List<String> output = new ArrayList<>();
        String line;
        while ((line = input.readLine()) != null) {
            output.add(line);
        }
        input.close();
        return Result.success(String.join("\n", output));

    }

}