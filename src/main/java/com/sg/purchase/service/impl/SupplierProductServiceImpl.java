package com.sg.purchase.service.impl;

import com.sg.common.base.service.BaseServiceImpl;
import com.sg.purchase.service.SupplierProductService;
import com.sg.purchase.dao.master.SupplierProductDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
* Title: 供应商商品 业务类
* Description: 供应商商品信息
* Company: com.sg920
* author: luomj
* time:2017-09-06 23:34:44
* version 1.0
*/
@Service
public class SupplierProductServiceImpl extends BaseServiceImpl implements SupplierProductService {
    @Autowired
    private SupplierProductDao supplierProductDao;

    @PostConstruct
    protected void init(){
        super.setBaseDao(supplierProductDao);
    }
}
