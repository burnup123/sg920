package com.sg.common.codebuilder.builder;

import java.util.List;
import java.util.Map;


/**
 * 图南代码生成器接口
 * @author hp
 */
public interface ICodeBuilder {
    /**
     * description:	通过注解获得解析的信息集合
     * @param buildConfig 生成器配置
     * @param columns    数据列
     * @return 信息集合(对应模板文件需要的信息)
     */
    public Map<String, Object> createMap(Map buildConfig, List<Map> columns);

    /**
     * description:		输入对象解析后的参数信息生成代码
     */
    public void buildCode();

}
