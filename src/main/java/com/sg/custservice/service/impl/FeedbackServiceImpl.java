package com.sg.custservice.service.impl;

import com.sg.common.base.service.BaseServiceImpl;
import com.sg.custservice.service.FeedbackService;
import com.sg.custservice.dao.master.FeedbackDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
* Title: 客户反馈 业务类
* Description: 客户反馈
* Company: com.sg920
* author: luomj
* time:2017-09-06 23:34:44
* version 1.0
*/
@Service
public class FeedbackServiceImpl extends BaseServiceImpl implements FeedbackService {
    @Autowired
    private FeedbackDao feedbackDao;

    @PostConstruct
    protected void init(){
        super.setBaseDao(feedbackDao);
    }
}
