package com.sg.common.base.context;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class ServletContextHolder
{
    public static HttpServletRequest getRequest()
    {
        return ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
    }
}