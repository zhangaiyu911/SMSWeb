package com.nkty.sms.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.nkty.sms.bean.Certificates;
import com.nkty.sms.bean.CertificatesOrdering;
import com.nkty.sms.bean.Ordering;
import com.nkty.sms.bean.view.ViewCertificatesOrdering;
import com.nkty.sms.bean.view.ViewOrdering;
import com.nkty.sms.bean.view.ViewOrderingItem;
import com.nkty.sms.service.CertificatesOrderingService;
import com.nkty.sms.service.CertificatesService;
import com.nkty.sms.service.OrderingItemService;
import com.nkty.sms.service.OrderingService;
import com.nkty.sms.util.JsonUtil;
import com.nkty.sms.util.Page;
import com.nkty.sms.util.Pageable;

/**
 * 订单
 * @author 刘斌 2017年7月26日09:09:08
 *
 */
@Controller("orderController")
@RequestMapping("/order")
public class OrderController {
	
	@Resource
	private OrderingService orderingService;
	
	@Resource
	private OrderingItemService orderingItemService;
	
    @Resource(name="certificatesServiceImpl")
    private CertificatesService certificatesService;
    
    @Resource
    private CertificatesOrderingService certificatesOrderingService;
    

	
    /**
     * 获取订单数量
     * @author 刘斌 2017年7月26日09:10:24
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping(value="/getOrderingCount")
    public String getOrderingCount(HttpServletRequest request,HttpServletResponse response,
    		int systemID,int supplierID,String begintime,String endtime,int orderingFlag) throws IOException{
    	response.setCharacterEncoding("utf-8");
    	PrintWriter out = response.getWriter();
    	int count = this.orderingService.getViewOrderCount(systemID,supplierID, begintime, endtime,orderingFlag);
    	out.print(count);
    	out.flush();
    	out.close();
    	return null;
    }
    
    /**
     * 获取订单分页信息
     * @author 刘斌 2017年7月26日09:10:33
     * @param request
     * @param response
     * @param pageable
     * @return
     * @throws IOException
     */
    @RequestMapping(value="/getOrderingPage")
    public String getOrderingPage(HttpServletRequest request,HttpServletResponse response,Pageable pageable,
    		int systemID,int supplierID,String begintime,String endtime,int orderingFlag) throws IOException{
    	response.setCharacterEncoding("utf-8");
    	PrintWriter out = response.getWriter();
    	String str = "";
    	try{
    		Page<ViewOrdering> cbPage = this.orderingService.getViewOrderPage(pageable,systemID,supplierID, begintime, endtime,orderingFlag);
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
     * 获取订单详情
     * @author 刘斌 2017年7月26日11:18:52
     * @param request
     * @param response
     * @param pageable
     * @return
     * @throws IOException
     */
    @RequestMapping(value="/getOrderingItemList")
    public String getOrderingItemList(HttpServletRequest request,HttpServletResponse response,Pageable pageable,int systemID,int orderingID) throws IOException{
    	response.setCharacterEncoding("utf-8");
    	PrintWriter out = response.getWriter();
    	String str = "";
    	Map<String, Object> map=new HashMap<String, Object>();
    	try{
    		List<ViewOrderingItem> viewOrderingItemList = orderingItemService.getViewOrderingItemList(systemID, orderingID);
    		List<Certificates> certificatesList = certificatesService.getCertificatesList(2);
    		map.put("viewOrderingItemList", viewOrderingItemList);
    		map.put("count", viewOrderingItemList.size());
    		map.put("systemID", systemID);
    		map.put("orderingID", orderingID);
    		map.put("certificatesList", certificatesList);
    		str = JsonUtil.toJson(map);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	out.print(str);
    	out.flush();
    	out.close();
    	return null;
    }
    
    /**
     * 配置日期
     * @author 刘斌 2017年7月31日09:47:40
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping(value="/configureDate")
    public String configureDate(HttpServletRequest request,HttpServletResponse response,String array,int systemID,int orderingID,int supplierID) throws IOException{
    	response.setCharacterEncoding("utf-8");
    	PrintWriter out = response.getWriter();
    	String str = "";
    	int result = 0;
    	int count=0;
    	try{
    		JSONArray jsonArray = JSONArray.fromObject(array);
    		for (int i = 0; i < jsonArray.size(); i++) {
    			JSONObject jsonJ = jsonArray.getJSONObject(i);
    			String itemID=jsonJ.getString("itemID");
    			String productionDate=jsonJ.getString("productionDate");
    			String shelfLife=jsonJ.getString("shelfLife");
    			result=orderingItemService.configureDate(Integer.parseInt(itemID), productionDate, shelfLife);
    			if (result!=0) {
    				str = "{\"result\":\"fail\",\"code\":\"保存失败\"}";
    				out.print(str);
    		    	out.flush();
    		    	out.close();
    		    	return null;
				}
    			count++;
			}
    		
    		List<ViewOrderingItem> viewOrderingItemList = orderingItemService.getViewOrderingItemList(systemID, orderingID);
    		if (count==viewOrderingItemList.size()) {
    			result=orderingService.updateFlag(systemID, supplierID, orderingID);
    			if (result!=0) {
    				str = "{\"result\":\"fail\",\"code\":\"保存失败\"}";
    				out.print(str);
    		    	out.flush();
    		    	out.close();
    		    	return null;
				}
			}
    		str = "{\"result\":\"success\"}";
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	out.print(str);
    	out.flush();
    	out.close();
    	return null;
    }
    
    
	/**
	 * 保存索证
	 * @author 刘斌 2017年7月31日16:18:08
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value="/saveCertificatesOrdering")
	public String saveCertificatesOrdering(HttpServletRequest request,HttpServletResponse response,
			int supplierID,int certificatesID,int orderingID,int orderingItemID,int systemID) throws IOException{
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		//返回strJson
		String strJson = "";
		String filename="";
		try{
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request; 
			MultipartFile up_img = multipartRequest.getFile("infile");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
			filename=sdf.format(new Date())+".jpg"; 
			SaveFileFromInputStream(up_img.getInputStream(),request.getRealPath("certificates"),filename);				
			String result = "/certificates/"+filename+"";	
			System.out.println(result);
			CertificatesOrdering c=new CertificatesOrdering();
			c.setCertificatesID(certificatesID);
			c.setOrderingID(orderingID);
			c.setOrderingItemID(orderingItemID);
			c.setSavePath(filename);
			c.setSupplierID(supplierID);
			c.setSystemID(systemID);
			c.setOrderingType(1);
			certificatesOrderingService.save(c);
			strJson ="{\"result\":\"success\",\"code\":\"保存成功,可继续上传!\"}";
		}catch(Exception e){
			strJson = "{\"result\":\"error\",\"code\":\"获取参数有误!\"}";
			e.printStackTrace();
		}
		
		out.print(strJson);
		out.flush();
		out.close();
		return null;
	}
	/**
	 *  将MultipartFile 转换为File
	 * @author 刘斌 
	 * @date 创建时间：2017年4月20日17:12:14
	 * @param stream
	 * @param path
	 * @param savefile
	 * @throws IOException
	 */
	public void SaveFileFromInputStream(InputStream stream,String path,String savefile) throws IOException
	   {      
	       FileOutputStream fs=new FileOutputStream( path + "/"+ savefile);
	       System.out.println("------------"+path + "/"+ savefile);
	       byte[] buffer =new byte[1024*1024];
	       int bytesum = 0;
	       int byteread = 0; 
	       while ((byteread=stream.read(buffer))!=-1)
	       {
	          bytesum+=byteread;
	          fs.write(buffer,0,byteread);
	          fs.flush();
	       } 
	       fs.close();
	       stream.close();      
	   } 
	
	/**
	 * 索证展示
	 * 刘斌 2017年7月31日17:16:18
	 * @param request
	 * @param ids
	 * @param supplierID
	 * @return
	 */
	@RequestMapping(value="showCertificates")
	public ModelAndView showCertificates(HttpServletRequest request,
			int supplierID,int orderingID,int orderingItemID,int systemID){
		ModelAndView modelAndView = new ModelAndView();
		List<ViewCertificatesOrdering> viewCertificatesOrderingList = certificatesOrderingService.getViewCertificatesOrderingList(systemID, supplierID, orderingID, orderingItemID,1);
		if (viewCertificatesOrderingList!=null&&viewCertificatesOrderingList.size()>0) {
			modelAndView.addObject("certificatesItemList", viewCertificatesOrderingList);
			modelAndView.addObject("supplierID", supplierID);
			modelAndView.addObject("orderingID", orderingID);
			modelAndView.addObject("orderingItemID", orderingItemID);
			modelAndView.addObject("systemID", systemID);
			modelAndView.setViewName("/ordering/uploadFile");
		}else {
			modelAndView.addObject("errorcode", "未上传索证");
		}
		return modelAndView;
	}
	
	/**
	 * 检测索证是否上传
	 * 刘斌 2017年8月1日09:30:29
	 * @param request
	 * @param orderingID
	 * @param supplierID
	 * @param orderingItemID
	 * @param systemID
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value="checkCertificates")
	public String checkCertificates(HttpServletRequest request,HttpServletResponse response,
			int supplierID,int orderingID,int orderingItemID,int systemID) throws IOException{
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String strJson = "";
		List<ViewCertificatesOrdering> viewCertificatesOrderingList = certificatesOrderingService.getViewCertificatesOrderingList(systemID, supplierID, orderingID, orderingItemID,1);
		strJson=JsonUtil.toJson(viewCertificatesOrderingList.size());
		out.print(strJson);
		out.flush();
		out.close();
		return null;
	}
	
	/**
	 * 删除索证
	 * @author 刘斌 2017年7月31日16:18:08
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value="/delCertificatesOrdering")
	public String delCertificatesOrdering(HttpServletRequest request,HttpServletResponse response,
			String ids) throws IOException{
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		//返回strJson
		String strJson = "";
		int result=0;
		try{
			result=certificatesOrderingService.delCertificatesOrdering(ids);
			if (result==0) {
				strJson ="{\"result\":\"success\",\"code\":\"保存成功!\"}";
			}else {
				strJson ="{\"result\":\"fail\",\"code\":\"保存失败!\"}";
			}
		}catch(Exception e){
			strJson = "{\"result\":\"error\",\"code\":\"获取参数有误!\"}";
			e.printStackTrace();
		}
		
		out.print(strJson);
		out.flush();
		out.close();
		return null;
	}
	
    /**
     * 获取未下载订单数量
     * @author 刘斌 2017年7月26日09:10:24
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping(value="/getNotDownloadOrderingCount")
    public String getNotDownloadOrderingCount(HttpServletRequest request,HttpServletResponse response,
    		int systemID,int supplierID,String begintime,String endtime) throws IOException{
    	response.setCharacterEncoding("utf-8");
    	PrintWriter out = response.getWriter();
    	int count = this.orderingService.getViewOrderCount(systemID,supplierID, begintime, endtime,0);
    	out.print(count);
    	out.flush();
    	out.close();
    	return null;
    }
    
    /**
     * 获取未下载订单分页信息
     * @author 刘斌 2017年7月26日09:10:33
     * @param request
     * @param response
     * @param pageable
     * @return
     * @throws IOException
     */
    @RequestMapping(value="/getNotDownloadOrderingPage")
    public String getNotDownloadOrderingPage(HttpServletRequest request,HttpServletResponse response,Pageable pageable,
    		int systemID,int supplierID,String begintime,String endtime) throws IOException{
    	response.setCharacterEncoding("utf-8");
    	PrintWriter out = response.getWriter();
    	String str = "";
    	try{
    		Page<ViewOrdering> cbPage = this.orderingService.getViewOrderPage(pageable,systemID,supplierID, begintime, endtime,0);
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
     * 下载订单
     * @author 刘斌 2017年8月2日09:44:21
     * @param request
     * @param response
     * @param pageable
     * @return
     * @throws IOException
     */
    @RequestMapping(value="/downloadOrdering")
    public String downloadOrdering(HttpServletRequest request,HttpServletResponse response,Pageable pageable,
    		String ids) throws IOException{
    	response.setCharacterEncoding("utf-8");
    	PrintWriter out = response.getWriter();
    	String str = "";
    	try{
    		List<Ordering> noDownloadOrderingList = this.orderingService.getNoDownloadOrderingList(ids);
    		String array[]=ids.split(",");
    		if (array.length!=noDownloadOrderingList.size()) {
    			str ="{\"result\":\"fail\",\"code\":\"下载数量不符合!\"}";
			}else {
				int updateOrderingFlag = orderingService.updateOrderingFlag(ids, 5);
				if (updateOrderingFlag==0) {
					str ="{\"result\":\"success\",\"code\":\"下载成功!\"}";
				}else {
					str ="{\"result\":\"fail\",\"code\":\"下载失败!\"}";
				}
			}
    	}catch(Exception e){
    		str = "{\"result\":\"error\",\"code\":\"获取参数有误!\"}";
    		e.printStackTrace();
    	}
    	out.print(str);
    	out.flush();
    	out.close();
    	return null;
    }

}
