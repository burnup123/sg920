package com.sg.common.syslog.aop;

import com.sg.common.base.context.ServletContextHolder;
import com.sg.common.base.utils.Identities;
import com.sg.common.syslog.anno.SysLogPoint;
import com.sg.common.syslog.domain.entity.SysLog;
import com.sg.common.syslog.domain.support.SysLogSupport;
import com.sg.common.syslog.service.SysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 系统日志切片处理类
 */
public class SysLogAop {
    private static Logger logger = LoggerFactory.getLogger(SysLogAop.class);

    @Autowired
    private SysLogService sysLogService;

    public void after(JoinPoint point) {
        try{
            Signature signature = point.getSignature();
            MethodSignature methodSignature = (MethodSignature) signature;
            Method targetMethod = methodSignature.getMethod();
            SysLogPoint rm = targetMethod.getAnnotation(SysLogPoint.class);

            if (rm != null){
                HttpServletRequest request = ServletContextHolder.getRequest();
                SysLog sysLog = new SysLog();
                sysLog.setId(Identities.uuid2());
                sysLog.setModule(rm.module());
                sysLog.setOptType(signature.getName());
                sysLog.setCreateTime(new Date());
                sysLog.setObjectid(SysLogSupport.getObjectid(point.getArgs()));
                sysLog.setIp(SysLogSupport.getIpAddr(request));
                sysLog.setBrowser(SysLogSupport.getBrowser(request));
                sysLog.setTerminal(SysLogSupport.getTerminal(request));
                sysLog.setUserid(null);
                sysLog.setPosition(null);
                sysLogService.save(sysLog);
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
