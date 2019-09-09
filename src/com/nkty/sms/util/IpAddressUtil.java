package com.nkty.sms.util;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.servlet.http.HttpServletRequest;

public class IpAddressUtil {
	//获得客户端真实IP地址的方法一：
	public static String getRemortIP(HttpServletRequest request) {  
	    if (request.getHeader("x-forwarded-for") == null) {  
	        return request.getRemoteAddr();  
	    }  
	    return request.getHeader("x-forwarded-for");  
	}  

//	//获得客户端真实IP地址的方法二：
//	public static String getIpAddr(HttpServletRequest request) { 
//	    String ip = request.getHeader("x-forwarded-for");   
//	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
//	        ip = request.getHeader("Proxy-Client-IP");  
//	    }  
//	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
//	        ip = request.getHeader("WL-Proxy-Client-IP");  
//	    }  
//	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
//	        ip = request.getRemoteAddr();  
//	    }  
//	    return ip;  
//	}  
	
	/**
	 * 获取当前网络ip
	 * @param request
	 * @return
	 */
	public static String getIpAddr(HttpServletRequest request){
		System.out.println(request.getRemoteHost());
		String ipAddress = request.getHeader("x-forwarded-for");
		System.out.println(ipAddress);
		System.out.println(request.getHeader("Proxy-Client-IP"));
		System.out.println(request.getHeader("WL-Proxy-Client-IP"));
		System.out.println(request.getHeader("HTTP_CLIENT_IP"));
		System.out.println(request.getHeader("HTTP_X_FORWARDED_FOR"));
		System.out.println(request.getRemoteAddr());
		if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getHeader("Proxy-Client-IP");
		}
		if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getHeader("WL-Proxy-Client-IP");
		}
		if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getRemoteAddr();
			if(ipAddress.equals("127.0.0.1") || ipAddress.equals("0:0:0:0:0:0:0:1")){
				//根据网卡取本机配置的IP
				InetAddress inet=null;
				try {
					inet = InetAddress.getLocalHost();
				} catch (UnknownHostException e) {
					e.printStackTrace();
				}
				ipAddress= inet.getHostAddress();
			}
		}
		//对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
		if(ipAddress!=null && ipAddress.length()>15){ //"***.***.***.***".length() = 15
			if(ipAddress.indexOf(",")>0){
				ipAddress = ipAddress.substring(0,ipAddress.indexOf(","));
			}
		}
		return ipAddress; 
	}
	
	public static String getIp2(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if(null != ip && !"unKnown".equalsIgnoreCase(ip)){
            //多次反向代理后会有多个ip值，第一个ip才是真实ip
            int index = ip.indexOf(",");
            if(index != -1){
                return ip.substring(0,index);
            }else{
                return ip;
            }
        }
        ip = request.getHeader("X-Real-IP");
        if(null != ip && !"unKnown".equalsIgnoreCase(ip)){
            return ip;
        }
        return request.getRemoteAddr();
    }
}
