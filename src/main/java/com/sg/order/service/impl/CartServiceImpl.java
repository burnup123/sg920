package com.sg.order.service.impl;

import com.sg.common.base.service.BaseServiceImpl;
import com.sg.order.service.CartService;
import com.sg.order.dao.master.CartDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
* Title: 购物车 业务类
* Description: 购物车
* Company: com.sg920
* author: luomj
* time:2017-09-06 23:34:44
* version 1.0
*/
@Service
public class CartServiceImpl extends BaseServiceImpl implements CartService {
    @Autowired
    private CartDao cartDao;

    @PostConstruct
    protected void init(){
        super.setBaseDao(cartDao);
    }
}
