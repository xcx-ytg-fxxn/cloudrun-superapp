/*
 * Ant Group
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.alipay.cloudrun.superapp.dal.mapper;

import com.alipay.cloudrun.superapp.dal.model.Record;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author siwei
 * @version RecordMapper.java, v 0.1 2023年04月06日 17:48 siwei
 */
@Mapper
public interface RecordMapper {

    /**
     * 插入一条记录
     *
     * @param record 记录
     * @return int
     */
    @Insert({
            "insert into record (record) values (#{record})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID() as id", keyProperty="id", before=false, resultType=Long.class)
    long insert(Record record);

    /**
     * 更新记录
     *
     * @param id     id
     * @param record 记录
     * @return int
     */
    @Update({
            "update record set record = #{record} where id = #{id}"
    })
    int update(@Param("id") Long id, @Param("record") String record);

    /**
     * 删除记录
     *
     * @param id id
     * @return int
     */
    @Delete({
            "delete from record where id = #{id}"
    })
    int delete(@Param("id") Long id);

    /**
     * 查询
     *
     * @return {@link List}<{@link String}>
     */
    @Select({
            "select id, gmt_create, gmt_modified, record from record"
    })
    List<Record> select();

    /**
     * 根据Id查询
     *
     * @param id id
     * @return {@link Record}
     */
    @Select({
            "select id, gmt_create, gmt_modified, record from record where id = #{id}"
    })
    Record selectById(@Param("id") Long id);

    /**
     * 慢sql查询
     *
     * @param time 时间
     * @return int
     */
    @Select({
            "select sleep(#{time})"
    })
    int slowQuery(@Param("time") Integer time);
}