package com.sg.account.service.impl;

import com.sg.common.base.service.BaseServiceImpl;
import com.sg.account.service.CustomerService;
import com.sg.account.dao.master.CustomerDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
* Title: 客户 业务类
* Description: 客户信息
* Company: com.sg920
* author: luomj
* time:2017-09-06 23:34:44
* version 1.0
*/
@Service
public class CustomerServiceImpl extends BaseServiceImpl implements CustomerService {
    @Autowired
    private CustomerDao customerDao;

    @PostConstruct
    protected void init(){
        super.setBaseDao(customerDao);
    }
}
