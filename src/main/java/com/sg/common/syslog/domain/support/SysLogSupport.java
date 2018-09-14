package com.sg.common.syslog.domain.support;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SysLogSupport {

    public static String getObjectid(Object[] args) {
        Object arg = args[0];
        if(null == arg){
            return null;
        } else {
            if(arg instanceof String){
                return (String) arg;
            }
            if(arg instanceof Map){
                Object id = ((Map) arg).get("id");
                return id == null ? null : (String) id;
            }
        }
        return null;

    }

    public static String getBrowser(HttpServletRequest request) {
        Map ua = SysLogSupport.getUserAgent(request);
        StringBuffer ret = new StringBuffer();
        ret.append((String) ua.get("type")).append("/").append((String) ua.get("version"));
        return ret.toString();
    }

    public static String getTerminal(HttpServletRequest request) {
        String phoneReg = "\\bNokia|SAMSUNG|MIDP-2|CLDC1.1|SymbianOS|MAUI|UNTRUSTED/1.0"
                + "|Windows CE|iPhone|iPad|Android|BlackBerry|UCWEB|ucweb|BREW|J2ME|YULONG|YuLong|COOLPAD|TIANYU|TY-"
                + "|K-Touch|Haier|DOPOD|Lenovo|LENOVO|HUAQIN|AIGO-|CTC/1.0"
                + "|CTC/2.0|CMCC|DAXIAN|MOT-|SonyEricsson|GIONEE|HTC|ZTE|HUAWEI|webOS|GoBrowser|IEMobile|WAP2.0\\b";
        String tableReg = "\\b(ipad|tablet|(Nexus 7)|up.browser"
                + "|[1-4][0-9]{2}x[1-4][0-9]{2})\\b";

        //移动设备正则匹配：手机端、平板
        Pattern phonePat = Pattern.compile(phoneReg, Pattern.CASE_INSENSITIVE);
        Pattern tablePat = Pattern.compile(tableReg, Pattern.CASE_INSENSITIVE);

        String userAgent = request.getHeader("User-Agent").toLowerCase();

        if (null == userAgent) {
            userAgent = "";
        }
        // 匹配
        Matcher matcherPhone = phonePat.matcher(userAgent);
        Matcher matcherTable = tablePat.matcher(userAgent);
        if (matcherPhone.find() || matcherTable.find()) {
            return "mobile";
        } else {
            return "pc";
        }

    }


    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("X-Real-IP");
        if (ip != null && !"".equals(ip) && !"unknown".equalsIgnoreCase(ip)) {
            return ip;
        }
        ip = request.getHeader("X-Forwarded-For");
        if (ip != null && !"".equals(ip) && !"unknown".equalsIgnoreCase(ip)) {
            int index = ip.indexOf(',');
            if (index != -1) {
                return ip.substring(0, index);
            } else {
                return ip;
            }
        } else {
            return request.getRemoteAddr();
        }
    }

    public static Map<String, String> getUserAgent(HttpServletRequest req) {
        Map<String, String> Sys = new HashMap<String, String>();
        String ua = req.getHeader("User-Agent").toLowerCase();
        String s;
        String msieP = "msie ([\\d.]+)";
        String firefoxP = "firefox\\/([\\d.]+)";
        String chromeP = "chrome\\/([\\d.]+)";
        String operaP = "opera.([\\d.]+)/)";
        String safariP = "version\\/([\\d.]+).*safari";

        Pattern pattern = Pattern.compile(msieP);
        Matcher mat = pattern.matcher(ua);
        if (mat.find()) {
            s = mat.group();
            Sys.put("type", "ie");
            Sys.put("version", s.split(" ")[1]);
            return Sys;
        }
        pattern = Pattern.compile(firefoxP);
        mat = pattern.matcher(ua);
        if (mat.find()) {
            s = mat.group();
            System.out.println(s);
            Sys.put("type", "firefox");
            Sys.put("version", s.split("/")[1]);
            return Sys;
        }
        pattern = Pattern.compile(chromeP);
        mat = pattern.matcher(ua);
        if (mat.find()) {
            s = mat.group();
            Sys.put("type", "chrome");
            Sys.put("version", s.split("/")[1]);
            return Sys;
        }
        pattern = Pattern.compile(operaP);
        mat = pattern.matcher(ua);
        if (mat.find()) {
            s = mat.group();
            Sys.put("type", "opera");
            Sys.put("version", s.split("\\.")[1]);
            return Sys;
        }
        pattern = Pattern.compile(safariP);
        mat = pattern.matcher(ua);
        if (mat.find()) {
            s = mat.group();
            Sys.put("type", "safari");
            Sys.put("version", s.split("/")[1].split(".")[0]);
            return Sys;
        }
        return Sys;
    }
}
