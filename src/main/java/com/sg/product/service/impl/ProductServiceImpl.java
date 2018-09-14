package com.sg.product.service.impl;

import com.sg.common.base.service.BaseServiceImpl;
import com.sg.product.service.ProductService;
import com.sg.product.dao.master.ProductDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
* Title: 产品管理 业务类
* Description: 产品信息
* Company: com.sg920
* author: luomj
* time:2017-10-04 08:57:10
* version 1.0
*/
@Service
public class ProductServiceImpl extends BaseServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;

    @PostConstruct
    protected void init(){
        super.setBaseDao(productDao);
    }
}
