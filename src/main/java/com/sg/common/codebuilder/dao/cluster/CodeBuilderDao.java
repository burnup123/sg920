package com.sg.common.codebuilder.dao.cluster;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface CodeBuilderDao {
    /**
     * 获取数据库下的所有表
     * @param dbName 数据库名称
     * @return
     */
    List getAllTables(@Param("dbName") String dbName);

    /**
     * 获取表信息
     * @param tableName 数据表名称
     * @return
     */
    Map getTable(@Param("tableName") String tableName);
    /**
     * 获取数据库下某表的所有字段
     * @param tableName 表名称
     * @return
     */
    List getColumns(@Param("tableName") String tableName);

}
