package com.nkty.sms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nkty.sms.bean.RegistCode;
import com.nkty.sms.service.RegistCodeService;
import com.nkty.sms.util.JsonUtil;
import com.nkty.sms.util.Page;
import com.nkty.sms.util.Pageable;
import com.nkty.sms.util.TimeUtil;

@Controller("registCodeController")
@RequestMapping("/registCode")
public class RegistCodeController {
	
    @Resource
    private RegistCodeService registCodeService;
    
    /**
     * 获取验证码数量
     * @author 刘斌 2017年8月28日11:48:02
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping(value="/getRegistCodeCount")
    public String getRegistCodeCount(HttpServletRequest request,HttpServletResponse response,int systemID) throws IOException{
    	response.setCharacterEncoding("utf-8");
    	PrintWriter out = response.getWriter();
    	int count = this.registCodeService.getRegistCodeCount(systemID, 2, 1);
    	out.print(count);
    	out.flush();
    	out.close();
    	return null;
    }
    
    /**
     * 获取验证分页信息
     * @author 刘斌 2017年8月28日11:48:13
     * @param request
     * @param response
     * @param pageable
     * @return
     * @throws IOException
     */
    @RequestMapping(value="/getRegistCodePage")
    public String getRegistCodePage(HttpServletRequest request,HttpServletResponse response,Pageable pageable,int systemID,String supplierName) throws IOException{
    	response.setCharacterEncoding("utf-8");
    	PrintWriter out = response.getWriter();
    	String str = "";
    	try{
    		Page<RegistCode> cbPage = this.registCodeService.getRegistCodePage(pageable,systemID,2,1);
    		str = JsonUtil.toJson(cbPage.getRows());
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	out.print(str);
    	out.flush();
    	out.close();
    	return null;
    }
    
	/**
	 * 生产验证码
	 * 刘斌 2017年8月28日14:16:55
	 * @param request
	 * @param roleId
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value="/saveRegistCode")
	public String saveRegistCode(HttpServletRequest request, HttpServletResponse response,int systemID) throws IOException{
 		System.out.println(TimeUtil.getTimeNow()+"进入生产验证码方法:saveRegistCode");
		response.setCharacterEncoding("utf-8");
		PrintWriter out =response.getWriter();
		String str = "";
		try {
			for (int i = 0; i < 100; i++) {
				RegistCode rc=new RegistCode();
				String s = UUID.randomUUID().toString();
				s =  s.substring(0,8)+s.substring(9,13)+s.substring(14,18)+s.substring(19,23)+s.substring(24); 
				s=s.substring(0, 12).toUpperCase();
				System.out.println(s);
				rc.setRegistCodeStr(s);
				rc.setRegistCodeType(2);
				rc.setUsingFlag(1);
				rc.setSystemID(systemID);
				registCodeService.save(rc);
			}
			str="{\"result\":\"success\",\"code\":\"生产成功\"}";
		} catch (Exception e) {
			str = "{\"result\":\"fail\",\"code\":\"生产失败\"}";
		}
		System.out.println("str"+str);
		out.print(str);
		out.flush();
		return null;
	}
	
}
