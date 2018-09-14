package com.sg.system.service.impl;

import com.sg.common.base.service.BaseServiceImpl;
import com.sg.system.service.SysParamService;
import com.sg.system.dao.master.SysParamDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
* Title: 系统参数管理 业务类
* Description: 系统参数
* Company: com.sg920
* author: luomj
* time:2017-09-06 23:34:44
* version 1.0
*/
@Service
public class SysParamServiceImpl extends BaseServiceImpl implements SysParamService {
    @Autowired
    private SysParamDao sysParamDao;

    @PostConstruct
    protected void init(){
        super.setBaseDao(sysParamDao);
    }
}
