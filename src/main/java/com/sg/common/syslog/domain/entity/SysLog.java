package com.sg.common.syslog.domain.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 日志实体
 * Created by wangmz on 2015/7/1.
 */
public class SysLog implements Serializable {

    private String id;       //日志编号

    private String module;    //模块名称

    private String userid;   //操作用户id

    private String position;    //操作用户岗位

    private String optType;   //操作类型 增删改查

    private String objectid;  //操作类型 增删改查

    private String ip;        //输出日志机器IP

    private String terminal;  //终端类型 pc/mobile

    private String browser;   //浏览器类型

    private Date createTime;  //创建时间

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getOptType() {
        return optType;
    }

    public void setOptType(String optType) {
        this.optType = optType;
    }

    public String getObjectid() {
        return objectid;
    }

    public void setObjectid(String objectid) {
        this.objectid = objectid;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
