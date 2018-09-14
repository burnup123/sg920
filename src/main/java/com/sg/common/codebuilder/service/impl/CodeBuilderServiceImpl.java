package com.sg.common.codebuilder.service.impl;


import com.sg.common.codebuilder.builder.CodeBuilderFactory;
import com.sg.common.codebuilder.dao.cluster.CodeBuilderDao;
import com.sg.common.codebuilder.service.CodeBuilderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;

/**
 * 代码生成器业务逻辑层
 *
 * Created by luomj on 09/02/2017.
 */
@Service
public class CodeBuilderServiceImpl implements CodeBuilderService {

    @Autowired
    private CodeBuilderDao codeBuilderDao;

    /**
     * 获取数据库下的所有表
     * @param dbName
     * @return
     */
    public List getAllTables(String dbName) {
        return codeBuilderDao.getAllTables(dbName);
    }

    /**
     * 获取数据库下某表的所有字段
     * @param tableName
     * @param dbName
     * @return
     */
    public List getTableColumns(String dbName, String tableName) {
        return codeBuilderDao.getColumns(tableName);
    }

    /**
     * 根据表信息和配置自动生成代码
     * @param buildConfigs
     * {
     *
     * }
     */
    public void buildTables(List<Map> buildConfigs){
        if (!CollectionUtils.isEmpty(buildConfigs)) {
            for(Map buildConfig : buildConfigs){
                String table = (String) buildConfig.get("table");
                List<Map> columns = codeBuilderDao.getColumns(table);
                CodeBuilderFactory.createRestBuilder(buildConfig, columns).buildCode();
                CodeBuilderFactory.createServiceBuilder(buildConfig, columns).buildCode();
                CodeBuilderFactory.createServiceImplBuilder(buildConfig, columns).buildCode();
                CodeBuilderFactory.createDaoBuilder(buildConfig, columns).buildCode();
                CodeBuilderFactory.createMapperBuilder(buildConfig, columns).buildCode();

            }
        }
    }
}
