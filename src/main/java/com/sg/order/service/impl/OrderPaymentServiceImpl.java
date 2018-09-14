package com.sg.order.service.impl;

import com.sg.common.base.service.BaseServiceImpl;
import com.sg.order.service.OrderPaymentService;
import com.sg.order.dao.master.OrderPaymentDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
* Title: 订单支付 业务类
* Description: 订单支付信息
* Company: com.sg920
* author: luomj
* time:2017-09-06 23:34:44
* version 1.0
*/
@Service
public class OrderPaymentServiceImpl extends BaseServiceImpl implements OrderPaymentService {
    @Autowired
    private OrderPaymentDao orderPaymentDao;

    @PostConstruct
    protected void init(){
        super.setBaseDao(orderPaymentDao);
    }
}
