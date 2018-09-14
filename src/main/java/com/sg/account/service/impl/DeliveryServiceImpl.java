package com.sg.account.service.impl;

import com.sg.common.base.service.BaseServiceImpl;
import com.sg.account.service.DeliveryService;
import com.sg.account.dao.master.DeliveryDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
* Title: 配送地址 业务类
* Description: 配送地址
* Company: com.sg920
* author: luomj
* time:2017-09-06 23:34:44
* version 1.0
*/
@Service
public class DeliveryServiceImpl extends BaseServiceImpl implements DeliveryService {
    @Autowired
    private DeliveryDao deliveryDao;

    @PostConstruct
    protected void init(){
        super.setBaseDao(deliveryDao);
    }
}
