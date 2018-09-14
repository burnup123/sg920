package com.sg.common.base.dao.master;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Map;

/**
 * MyBatis 基础类接口，继承它的子类必须要和MyBatis Mapper文件同名，直接映射其实现方法
 * 实现主要接口如下： insert，insertBatch，update,updateByMap,delete,deleteByMap,deleteBatch,fetch,find,count,page
 * Created by luomj on 2017/09/02.
 */
public interface BaseDao {

    /**
     * 插入记录
     * @param entity
     * @return
     */
    long insert(@Param("entity") Object entity);

    /**
     * 批量新增
     * @param list
     * @return 新增对象的个数
     */
    long insertBatch(@Param("list") List list);

    /**
     * 修改一个实体对象（UPDATE一条记录）
     * @param entity 实体对象
     * @return 修改的对象个数，正常情况=1
     */
    long update(@Param("entity") Object entity);

    /**
     * 根据map条件修改
     * @param entity
     * @param wObject
     * @return 修改的对象个数
     */
    long updateByMap(@Param("entity") Object entity, @Param("terms") Map wObject);

    /**
     * 按主键删除记录
     * @param id 主键对象
     * @return 删除的对象个数，正常情况=1
     */
    long delete(@Param("id")Object id);

    /**
     * 删除符合条件的记录
     * <p><strong>此方法一定要慎用，如果条件设置不当，可能会删除有用的记录！</strong></p>
     * @param terms 用于产生SQL的参数值，包括WHERE条件（其他参数内容不起作用）
     * @return
     */
    long deleteByMap(@Param("terms") Map terms);

    /**
     * 批量删除
     * 执行语句 delete from table_name where id in (ids)
     * @param ids 需要删除的id数组
     */
    long deleteBatch(@Param("ids") Object ids);

    /**
     * 按主键取记录
     * @param id 主键值
     * @return 记录实体对象，如果没有符合主键条件的记录，则返回null
     */
    Map fetch(@Param("id") Object id);

    /**
     * 按条件查询记录
     * @param object 查询条件参数
     * @return 全部记录实体对象的List
     */
    List<Map> find(@Param("terms") Object object, @Param("sort") Sort sort);

    /**
     * 查询整表总记录数
     * @param object
     * @return 整表总记录数
     */
    long count(@Param("terms") Object object);

    /**
     * 按条件查询记录，并处理成分页结果
     * @param page pageRequest
     * @param sort 每页记录数
     * @param object   查询条件参数，包括WHERE条件、分页条件、排序条件
     * @return 实体对象的List
     */
    List<Map> page(@Param("page")PageRequest page, @Param("terms") Map object, @Param("sort") Sort sort);
}
