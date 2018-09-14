package com.sg.common.base.service;

import com.sg.common.base.dao.master.BaseDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 服务层基础类，具体业务服务类继承它
 */
public class BaseServiceImpl implements BaseService {

    private static Logger log = LoggerFactory.getLogger(BaseServiceImpl.class);

    protected BaseDao baseDao;

    public BaseDao getbaseDao() {
        return baseDao;
    }

    public void setBaseDao(BaseDao baseDao) {
        this.baseDao = baseDao;
    }

    @Override
    @Transactional
    public Object save(Object entity) {
        return baseDao.insert(entity);
    }

    @Override
    @Transactional
    public long saveBatch(List list) {
        return baseDao.insertBatch(list);
    }

    @Override
    @Transactional
    public long update(Object entity) {
        return baseDao.update(entity);
    }

    @Override
    @Transactional
    public long updateByMap(Object entity, Map wObject) {
        return baseDao.updateByMap(entity,wObject);
    }

    @Override
    @Transactional
    public long delete(Object id) {
        return baseDao.delete(id);
    }

    @Override
    @Transactional
    public long deleteByMap(Map terms) {
        return baseDao.deleteByMap(terms);
    }

    @Override
    @Transactional
    public long deleteBatch(Object object) {
        return baseDao.deleteBatch(object);
    }

    @Override
    public Map fetch(Object id) {
        return baseDao.fetch(id);
    }

    @Override
    public long count(Object object) {
        return baseDao.count(object);
    }

    @Override
    public List<Map> find(Object object, Sort sort) {
        return baseDao.find(object, sort);
    }

    @Override
    public List<Map> page(PageRequest page, Map terms, Sort sort) {
        return baseDao.page(page, terms, sort);
    }
}
