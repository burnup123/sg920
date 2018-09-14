package com.sg.order.service.impl;

import com.sg.common.base.service.BaseServiceImpl;
import com.sg.order.service.OrderProductService;
import com.sg.order.dao.master.OrderProductDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
* Title: 订单商品 业务类
* Description: 订单商品信息
* Company: com.sg920
* author: luomj
* time:2017-09-06 23:34:44
* version 1.0
*/
@Service
public class OrderProductServiceImpl extends BaseServiceImpl implements OrderProductService {
    @Autowired
    private OrderProductDao orderProductDao;

    @PostConstruct
    protected void init(){
        super.setBaseDao(orderProductDao);
    }
}
