package com.sg.purchase.service.impl;

import com.sg.common.base.service.BaseServiceImpl;
import com.sg.purchase.service.SupplierService;
import com.sg.purchase.dao.master.SupplierDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
* Title: 供应商 业务类
* Description: 供应商信息
* Company: com.sg920
* author: luomj
* time:2017-09-06 23:34:44
* version 1.0
*/
@Service
public class SupplierServiceImpl extends BaseServiceImpl implements SupplierService {
    @Autowired
    private SupplierDao supplierDao;

    @PostConstruct
    protected void init(){
        super.setBaseDao(supplierDao);
    }
}
