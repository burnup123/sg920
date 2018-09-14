package com.sg.common.base.utils;

import java.util.HashMap;
import java.util.Map;

public final class ReturnUtil {
    private static String SUCCESS_CODE = "1";
    private static String ERROR_CODE = "0";
    public static Map getSucessInfo(Object data){
        Map ret = new HashMap();
        ret.put("code", SUCCESS_CODE);
        ret.put("msg", "success");
        ret.put("data", data);
        return ret;
    }
    public static Map getErrorInfo(String msg){
        Map ret = new HashMap();
        ret.put("code", ERROR_CODE);
        ret.put("msg", msg);
        return ret;
    }
}
