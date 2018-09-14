package com.sg.common.codebuilder.builder;

import java.util.List;
import java.util.Map;


/**
 * 代码生成器工厂
 * @author luomj
 */
public class CodeBuilderFactory {
    public static ICodeBuilder createRestBuilder(Map buildConfig, List<Map> columns){
        return new RestBuilder(buildConfig, columns);
    }
    public static ICodeBuilder createServiceBuilder(Map buildConfig, List<Map> columns){
        return new ServiceBuilder(buildConfig, columns);
    }
    public static ICodeBuilder createServiceImplBuilder(Map buildConfig, List<Map> columns){
        return new ServiceImplBuilder(buildConfig, columns);
    }
    public static ICodeBuilder createDaoBuilder(Map buildConfig, List<Map> columns){
        return new DaoBuilder(buildConfig, columns);
    }
    public static ICodeBuilder createMapperBuilder(Map buildConfig, List<Map> columns){
        return new MapperBuilder(buildConfig, columns);
    }
}
