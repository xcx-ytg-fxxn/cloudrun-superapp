/*
 * Ant Group
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.alipay.cloudrun.superapp.service.impl;

import com.alipay.cloudrun.superapp.dal.mapper.RecordMapper;
import com.alipay.cloudrun.superapp.dal.model.Record;
import com.alipay.cloudrun.superapp.service.MysqlService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author siwei
 * @version MysqlServiceImpl.java, v 0.1 2023年04月06日 20:02 siwei
 */
@Log4j2
@Service
public class MysqlServiceImpl implements MysqlService {

    @Autowired
    RecordMapper recordMapper;

    /**
     * 查询记录
     *
     * @return {@link List}<{@link Record}>
     */
    @Override
    public List<Record> queryRecords() {
        
        log.info("query records");
        return recordMapper.select();
        
    }

    /**
     * 根据id查询记录
     *
     * @param id id
     * @return {@link Record}
     */
    @Override
    public Record queryRecordById(Long id) {

        log.info("query record by id, id = {}", id);
        return recordMapper.selectById(id);

    }

    /**
     * 更新记录
     *
     * @param id     id
     * @param record 记录
     */
    @Override
    public void updateRecord(Long id, String record) {

        log.info("update record, id = {}, record = {}", id, record);
        recordMapper.update(id, record);

    }

    /**
     * 删除记录
     *
     * @param id id
     */
    @Override
    public void deleteRecords(Long id) {

        log.info("delete record, id = {}", id);
        recordMapper.delete(id);

    }

    /**
     * 插入记录
     *
     * @param record 记录
     * @return {@link Long}
     */
    @Override
    public Long insertRecord(String record) {

        log.info("insert record, record = {}", record);
        return recordMapper.insert(record);

    }

    /**
     * 慢sql查询
     *
     * @param time 慢sql时间
     */
    @Override
    public void slowQuery(Integer time) {

        log.info("slow query test, time = {}", time);
        if (time == null) {
            time = 5;
        }
        recordMapper.slowQuery(time);

    }
}