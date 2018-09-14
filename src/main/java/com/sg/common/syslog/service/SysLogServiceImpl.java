package com.sg.common.syslog.service;


import com.sg.common.base.service.BaseServiceImpl;
import com.sg.common.syslog.dao.master.SysLogDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;


/**
 * 日志服务实现类
 * Created by luomj on 2017/9/2.
 */
@Service
public class SysLogServiceImpl extends BaseServiceImpl implements SysLogService {

    private static Logger logger = LoggerFactory.getLogger(SysLogServiceImpl.class);

    @Autowired
    private SysLogDao sysLogDao;

    @PostConstruct
    protected void init() {
        super.setBaseDao(sysLogDao);
    }
}
