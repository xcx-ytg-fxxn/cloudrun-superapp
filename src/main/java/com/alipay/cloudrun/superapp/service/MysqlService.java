/*
 * Ant Group
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.alipay.cloudrun.superapp.service;

import com.alipay.cloudrun.superapp.dal.model.Record;

import java.util.List;

/**
 * @author siwei
 * @version MysqlService.java, v 0.1 2023年04月06日 19:54 siwei
 */
public interface MysqlService {

    /**
     * 查询记录
     *
     * @return {@link List}<{@link Record}>
     */
    List<Record> queryRecords();

    /**
     * 根据id查询记录
     *
     * @param id id
     * @return {@link Record}
     */
    Record queryRecordById(Long id);

    /**
     * 更新记录
     *
     * @param id     id
     * @param record 记录
     */
    void updateRecord(Long id, String record);

    /**
     * 删除记录
     *
     * @param id id
     */
    void deleteRecords(Long id);

    /**
     * 插入记录
     *
     * @param record 记录
     * @return {@link Long}
     */
    Long insertRecord(String record);

    /**
     * 慢sql查询
     *
     * @param time 慢sql时间
     */
    void slowQuery(Integer time);

}