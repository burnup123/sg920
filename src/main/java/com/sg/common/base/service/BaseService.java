package com.sg.common.base.service;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Map;

/**
 * 服务层基础接口，具体业务服务层接口继承它
 */

public interface BaseService {

    /**
     * 保存记录
     * @param entity
     * @return
     */
    Object save(Object entity);

    /**
     * 批量保存
     * @param list
     * @return 新增对象的个数
     */
    long saveBatch(List list);

    /**
     * 修改一个实体对象（UPDATE一条记录）
     * @param entity 实体对象
     * @return 修改的对象个数，正常情况=1
     */
    long update(Object entity);

    /**
     * 根据map条件修改
     * @param entity
     * @param terms
     * @return 修改的对象个数
     */
    long updateByMap(Object entity, Map terms);

    /**
     * 按主键删除记录
     * @param id 主键对象
     * @return 删除的对象个数，正常情况=1
     */
    long delete(Object id);

    /**
     * 删除符合条件的记录
     * <p><strong>此方法一定要慎用，如果条件设置不当，可能会删除有用的记录！</strong></p>
     * @param terms 用于产生SQL的参数值，包括WHERE条件（其他参数内容不起作用）
     * @return
     */
    long deleteByMap(Map terms);

    /**
     * 批量删除
     * @param object
     */
    long deleteBatch(Object object);

    /**
     * 按主键取记录
     * @param id 主键值
     * @return 记录实体对象，如果没有符合主键条件的记录，则返回null
     */
    Map fetch(Object id);

    /**
     * 按条件查询记录
     * @param object 查询条件参数
     * @return 全部记录实体对象的List
     */
    List<Map> find(Object object, Sort sort);

    /**
     * 查询整表总记录数
     * @param object
     * @return 整表总记录数
     */
    long count(Object object);


    /**
     * 按条件查询记录，并处理成分页结果
     * @param page 当前记录行
     * @param terms   查询条件参数，WHERE条件
     * @Param sort  排序字段
     * @return 实体对象的List
     */
    List<Map> page(PageRequest page, Map terms, Sort sort);


}

