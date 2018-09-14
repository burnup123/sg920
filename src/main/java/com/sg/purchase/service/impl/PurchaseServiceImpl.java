package com.sg.purchase.service.impl;

import com.sg.common.base.service.BaseServiceImpl;
import com.sg.purchase.service.PurchaseService;
import com.sg.purchase.dao.master.PurchaseDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
* Title: 采购单 业务类
* Description: 采购单记录
* Company: com.sg920
* author: luomj
* time:2017-09-06 23:34:44
* version 1.0
*/
@Service
public class PurchaseServiceImpl extends BaseServiceImpl implements PurchaseService {
    @Autowired
    private PurchaseDao purchaseDao;

    @PostConstruct
    protected void init(){
        super.setBaseDao(purchaseDao);
    }
}
