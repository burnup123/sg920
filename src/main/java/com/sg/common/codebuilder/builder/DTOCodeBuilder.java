package com.sg.common.codebuilder.builder;

import com.sg.common.base.dao.MysqlJdbcType;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;


/**
 * 代码生成器通用类
 * @author hp
 */
public class DTOCodeBuilder extends BaseCodeBuilder {

    /**
     * 返回模板的基础路径
     */
    public String getTemplateDir() {
        return "codebuilderTemplate";
    }

    /**
     * 返回模板的名称
     */
    @Override
    public String getTemplateName() {
        return "DTOTemplate.html";
    }

    /**
     * 源代码根路径
     */
    @Override
    public String getRootFilePath() {
        StringBuffer sb = new StringBuffer(this.getClass().getResource("/").getPath().replace("/target/classes/",""));
        System.out.println(this.getClass().getResource("/").getPath().replace("/target/classes/",""));
        return sb.append(File.separator).append("src").append(File.separator).append("main").append(File.separator).toString();
    }

    @Override
    public Map<String, Object> createMap(Map buildConfig, List<Map> columns) {
        Map<String, Object> map = new HashMap<String, Object>();

        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = format.format(date);

        map.put("ctime", time);

        map.put("table", buildConfig.get("table"));
        map.put("title", buildConfig.get("title"));
        map.put("author", buildConfig.get("author"));
        map.put("name", buildConfig.get("name"));
        map.put("description", buildConfig.get("description"));
        map.put("package", buildConfig.get("package"));
        map.put("key", buildConfig.get("key"));
        map.put("keyColum", buildConfig.get("keyColum"));


        map.put("restPath",buildConfig.get("package") + ".rest" );
        map.put("servicePath", buildConfig.get("package") + ".service");
        map.put("serviceImplPath", buildConfig.get("package") + ".service.impl" );
        map.put("daoPath" , buildConfig.get("package") + ".dao.master");
        map.put("mapperPath", "resources.mapper.master");

        String classPath = (String) map.get("package");
        String url = this.getFilePath(classPath, buildConfig.get("name") + ".java");
        map.put("url", url);

        map.put("importClass", new HashSet<String>());
        map.put("importTypes", new HashSet<String>());

        List<Map<String, Object>> fsList = new ArrayList<Map<String, Object>>();

        for (Map field: columns) {

            if (field != null) {
                setField(field,fsList);
            }
        }
        map.put("fields", fsList);
        this.setTemplateData(map);
        return map;
    }
    @SuppressWarnings("unchecked")
    protected void setField(Map<String, String> field, List<Map<String, Object>> fsList) {
        Map fMap = new HashMap();
        String name = (String) field.get("columnName");
        String[] nameKeys = name.split("_");
        StringBuffer propertyName = new StringBuffer();
        for(int i=0; i < nameKeys.length;i++ ) {
            if(i>0){
                propertyName.append(nameKeys[i].substring(0, 1).toUpperCase() + nameKeys[i].substring(1));
            }else{
                propertyName.append(nameKeys[i]);
            }
        }
        fMap.put("name", propertyName.toString());
        fMap.put("colum", name);
        fMap.put("jdbcType", MysqlJdbcType.valueOf(((String) field.get("dataType")).toUpperCase()).toString());
        fsList.add(fMap);
    }
    public static void main(String[] args){
        DTOCodeBuilder a = new DTOCodeBuilder();
        System.out.println(a.getClass().getClassLoader().getResource("/").getPath());
    }
}
