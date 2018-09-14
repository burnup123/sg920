package com.sg.common.codebuilder.builder;

import java.io.File;
import java.util.List;
import java.util.Map;


/**
 * 代码生成器通用类
 * @author hp
 */
public class MapperBuilder extends DTOCodeBuilder {

    public MapperBuilder(Map buildConfig, List<Map> columns){
        this.createMap(buildConfig, columns,null);
    }
    /**
     * 模板路径
     */
    @Override
    public String getTemplateName() {
        return "MapperTemplate.fl";
    }
    /**
     * 创建变量
     */
    @SuppressWarnings("unchecked")
    public Map<String, Object> createMap(Map<String, String> buildConfig, List<Map> columns, Map<String, Object> map) {
        map = super.createMap(buildConfig, columns);
        String classPath = (String) map.get("mapperPath");
        String url = this.getFilePath(classPath, buildConfig.get("name").toLowerCase() + File.separator + buildConfig.get("name") + "Mapper.xml");
        map.put("url", url);
        this.setTemplateData(map);
        return map;
    }
}
