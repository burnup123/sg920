package com.sg.product.service.impl;

import com.sg.common.base.service.BaseServiceImpl;
import com.sg.product.service.CategoryService;
import com.sg.product.dao.master.CategoryDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
* Title: 商品分类 业务类
* Description: 商品分类
* Company: com.sg920
* author: luomj
* time:2017-09-06 23:34:44
* version 1.0
*/
@Service
public class CategoryServiceImpl extends BaseServiceImpl implements CategoryService {
    @Autowired
    private CategoryDao categoryDao;

    @PostConstruct
    protected void init(){
        super.setBaseDao(categoryDao);
    }
}
