package com.sg.order.service.impl;

import com.sg.common.base.service.BaseServiceImpl;
import com.sg.order.service.OrderService;
import com.sg.order.dao.master.OrderDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
* Title: 订单 业务类
* Description: 订单信息
* Company: com.sg920
* author: luomj
* time:2017-09-06 23:34:44
* version 1.0
*/
@Service
public class OrderServiceImpl extends BaseServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;

    @PostConstruct
    protected void init(){
        super.setBaseDao(orderDao);
    }
}
