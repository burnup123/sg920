package com.sg.common.codebuilder.rest;

import com.sg.common.codebuilder.service.CodeBuilderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/buildcode")
public class BuildCodeRestController {

    @Autowired
    private CodeBuilderService codeBuilderService;

    /**
     * 根据数据库名称获取所有表名称
     *
     * @param dbName
     * @return
     */
    @RequestMapping(value = "/getTables/{dbName}", method = RequestMethod.GET)
    public List getTables(@PathVariable(value = "dbName") String dbName){
        return codeBuilderService.getAllTables(dbName);
    }

    /**
     * 根据数据库名称和表名称获取表的所有字段
     *
     * @param dbName
     * @return
     */
    @RequestMapping(value = "/getTables/{dbName}/{tableName}", method = RequestMethod.GET)
    public List getTables(@PathVariable(value = "dbName") String dbName, @PathVariable(value = "tableName") String tableName){
        return codeBuilderService.getTableColumns(dbName, tableName);
    }
}
