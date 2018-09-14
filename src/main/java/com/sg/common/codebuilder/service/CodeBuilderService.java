package com.sg.common.codebuilder.service;

import org.apache.ibatis.annotations.Param;

import java.util.Map;
import java.util.List;

/**
 * 代码生成器业务接口层
 *
 * Created by luomj on 09/02/2017.
 */
public interface CodeBuilderService {

    /**
     * 获取数据库下的所有表
     * @param dbName
     * @return
     */
    List getAllTables(@Param("dbName") String dbName);

    /**
     * 获取数据库下某表的所有字段
     * @param tableName
     * @param dbName
     * @return
     */
    List getTableColumns(@Param("tableName") String tableName, @Param("dbname") String dbName);

    /**
     * 根据表信息和配置自动生成代码
     * @param buildConfig
     */
    void buildTables(List<Map> buildConfig);

}
