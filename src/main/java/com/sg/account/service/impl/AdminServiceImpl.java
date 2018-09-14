package com.sg.account.service.impl;

import com.sg.common.base.service.BaseServiceImpl;
import com.sg.account.service.AdminService;
import com.sg.account.dao.master.AdminDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
* Title: 系统管理员 业务类
* Description: 系统管理员账号管理
* Company: com.sg920
* author: luomj
* time:2017-09-06 23:30:12
* version 1.0
*/
@Service
public class AdminServiceImpl extends BaseServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;

    @PostConstruct
    protected void init(){
        super.setBaseDao(adminDao);
    }
}
