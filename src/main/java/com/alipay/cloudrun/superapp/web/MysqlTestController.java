/*
 * Ant Group
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.alipay.cloudrun.superapp.web;

import com.alipay.cloudrun.superapp.aop.annotation.ControllerPointCut;
import com.alipay.cloudrun.superapp.dal.model.Record;
import com.alipay.cloudrun.superapp.service.MysqlService;
import com.alipay.cloudrun.superapp.web.request.UpdateRecordRequest;
import com.alipay.cloudrun.superapp.web.response.Result;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author siwei
 * @version MysqlTestController.java, v 0.1 2023年04月04日 17:26 siwei
 */
@Log4j2
@RestController
@RequestMapping("/api/mysql")
public class MysqlTestController {

    @Autowired
    MysqlService mysqlService;

    /**
     * 查询记录
     *
     * @return {@link Result}<{@link List}<{@link Record}>>
     */
    @GetMapping("/query")
    @ControllerPointCut
    Result<List<Record>> queryRecords() {

        log.info("/api/mysql/query GET request");
        return Result.success(mysqlService.queryRecords());

    }

    /**
     * 根据id查询记录
     *
     * @param id id
     * @return {@link Result}<{@link Record}>
     */
    @GetMapping("/get")
    @ControllerPointCut
    Result<Record> getRecordById(@RequestParam("id") Long id) {

        log.info("/api/mysql/get GET request, id = {}", id);
        return Result.success(mysqlService.queryRecordById(id));

    }

    /**
     * 删除记录
     *
     * @param id id
     * @return {@link Result}<{@link Void}>
     */
    @DeleteMapping("/delete")
    @ControllerPointCut
    Result<Void> deleteRecord(@RequestParam("id") Long id) {

        log.info("/api/mysql/delete DELETE request, id = {}", id);
        mysqlService.deleteRecords(id);
        return Result.success();

    }

    /**
     * 插入记录
     *
     * @param record 记录
     * @return {@link Result}<{@link Void}>
     */
    @PostMapping("/insert")
    @ControllerPointCut
    Result<Void> insertRecord(@RequestBody String record) {

        log.info("/api/mysql/insert GET request, record = {}", record);
        mysqlService.insertRecord(record);
        return Result.success();

    }

    /**
     * 更新记录
     *
     * @param request 请求
     * @return {@link Result}<{@link Void}>
     */
    @PostMapping("/update")
    @ControllerPointCut
    Result<Void> updateRecord(@Valid @RequestBody UpdateRecordRequest request) {

        log.info("/api/mysql/update POST request, request = {}", request);
        mysqlService.updateRecord(request.getId(), request.getRecord());
        return Result.success();

    }

    /**
     * 慢SQL测试
     *
     * @param time 慢sql持续时间
     * @return {@link Result}<{@link Void}>
     */
    @GetMapping("/slow")
    @ControllerPointCut
    Result<Void> slowQueryTest(@RequestParam(name = "time", required = false) Integer time) {

        log.info("/api/mysql/slow GET request, time = {}", time);
        mysqlService.slowQuery(time);
        return Result.success();

    }

}