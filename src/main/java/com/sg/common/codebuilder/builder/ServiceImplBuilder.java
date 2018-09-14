package com.sg.common.codebuilder.builder;

import java.io.File;
import java.util.List;
import java.util.Map;


public class ServiceImplBuilder extends DTOCodeBuilder {
    public ServiceImplBuilder(Map buildConfig, List<Map> columns){
        this.createMap(buildConfig, columns,null);
    }
    /**
     * 模板路径
     */
    @Override
    public String getTemplateName() {
        return "ServiceImplTemplate.fl";
    }

    /**
     * 创建变量
     */
    @SuppressWarnings("unchecked")
    public Map<String, Object> createMap(Map buildConfig, List<Map> columns, Map<String, Object> map) {
        map = super.createMap(buildConfig, columns);
        String classPath = (String) map.get("serviceImplPath");
        String url = this.getFilePath(classPath, buildConfig.get("name") + "ServiceImpl.java");
        map.put("url", "java" + File.separator + url);
        this.setTemplateData(map);
        return map;
    }
}
