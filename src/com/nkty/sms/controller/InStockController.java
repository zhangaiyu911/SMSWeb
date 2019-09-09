package com.nkty.sms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nkty.sms.bean.view.ViewInStock;
import com.nkty.sms.bean.view.ViewInStockItem;
import com.nkty.sms.bean.view.ViewPurchaseInStock;
import com.nkty.sms.bean.view.ViewPurchaseInStockItem;
import com.nkty.sms.bean.view.ViewSupplierSystem;
import com.nkty.sms.service.InStockItemService;
import com.nkty.sms.service.InStockService;
import com.nkty.sms.service.SystemSupplierService;
import com.nkty.sms.util.JsonUtil;
import com.nkty.sms.util.Page;
import com.nkty.sms.util.Pageable;
import com.nkty.sms.util.TimeUtil;
/**
 * 入库单
 * @author 刘斌 2017年7月26日14:54:11
 *
 */
@Controller("inStockController")
@RequestMapping("/inStock")
public class InStockController {
	
	@Resource
	private InStockService inStockService;
	
	@Resource
	private InStockItemService inStockItemService;
	
    @Resource
    private SystemSupplierService systemSupplierService;
	
	
    /**
     * 获取入库单数量
     * @author 刘斌 2017年7月26日14:55:17
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping(value="/getInStockCount")
    public String getInStockCount(HttpServletRequest request,HttpServletResponse response,
    		int systemID,int supplierID,String begintime,String endtime,int inStockType) throws IOException{
    	response.setCharacterEncoding("utf-8");
    	PrintWriter out = response.getWriter();
    	int count=0;
    	if (inStockType==1) {
    		count = this.inStockService.getViewInStockCount(systemID,supplierID,begintime,endtime);
		}else {
			count = this.inStockService.getViewPurchaseInStockCount(systemID, supplierID, begintime, endtime);
		}
    	
    	out.print(count);
    	out.flush();
    	out.close();
    	return null;
    }
    
    /**
     * 获取入库单分页信息
     * @author 刘斌 2017年7月26日14:55:24
     * @param request
     * @param response
     * @param pageable
     * @return
     * @throws IOException
     */
    @RequestMapping(value="/getInStockPage")
    public String getInStockPage(HttpServletRequest request,HttpServletResponse response,Pageable pageable,
    		int systemID,int supplierID,String begintime,String endtime,int inStockType) throws IOException{
    	response.setCharacterEncoding("utf-8");
    	PrintWriter out = response.getWriter();
    	String str = "";
    	try{
    		if (inStockType==1) {
    			Page<ViewInStock> cbPage = this.inStockService.getViewInStockPage(pageable,systemID,supplierID,begintime,endtime);
        		str = JsonUtil.toJson(cbPage.getRows());
			}else {
				Page<ViewPurchaseInStock> cbPage = this.inStockService.getViewPurchaseInStockPage(pageable, systemID, supplierID, begintime, endtime);
	    		str = JsonUtil.toJson(cbPage.getRows());
			}
    		
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	out.print(str);
    	out.flush();
    	out.close();
    	return null;
    }
    
    /**
     * 获取入库单详情
     * @author 刘斌 2017年7月26日16:03:48
     * @param request
     * @param response
     * @param pageable
     * @return
     * @throws IOException
     */
    @RequestMapping(value="/getInStockItemList")
    public String getInStockItemList(HttpServletRequest request,HttpServletResponse response,Pageable pageable,int systemID,int instockid,int inStockType) throws IOException{
    	response.setCharacterEncoding("utf-8");
    	PrintWriter out = response.getWriter();
    	String str = "";
    	try{
    		if (inStockType==1) {
    			List<ViewInStockItem> viewOrderingItemList = inStockItemService.getViewInStockItemList(systemID, instockid);
    			str = JsonUtil.toJson(viewOrderingItemList);
			}else {
				List<ViewPurchaseInStockItem> viewPurchaseInInStockItemList = inStockItemService.getViewPurchaseInInStockItemList(systemID, instockid);
				str = JsonUtil.toJson(viewPurchaseInInStockItemList);
			}
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	out.print(str);
    	out.flush();
    	out.close();
    	return null;
    }
    
    /**
     * 获取入库单明细汇总数量
     * @author 刘斌 2017年7月26日14:55:17
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping(value="/getInStockItemCount")
    public String getInStockItemCount(HttpServletRequest request,HttpServletResponse response,
    		int systemID,int supplierID,String begintime,String endtime,int inStockType) throws IOException{
    	response.setCharacterEncoding("utf-8");
    	PrintWriter out = response.getWriter();
    	int count=0;
    	if (inStockType==1) {
    		 count = this.inStockItemService.getViewInStockItemCount(systemID, supplierID, begintime, endtime);
		}else {
			count = this.inStockItemService.getViewPurchaseInStockItemCount(systemID, supplierID, begintime, endtime);
		}
    	out.print(count);
    	out.flush();
    	out.close();
    	return null;
    }
    
    /**
     * 获取入库单明细汇总分页信息
     * @author 刘斌 2017年7月26日14:55:24
     * @param request
     * @param response
     * @param pageable
     * @return
     * @throws IOException
     */
    @RequestMapping(value="/getInStockItemPage")
    public String getInStockItemPage(HttpServletRequest request,HttpServletResponse response,Pageable pageable,
    		int systemID,int supplierID,String begintime,String endtime,int inStockType) throws IOException{
    	response.setCharacterEncoding("utf-8");
    	PrintWriter out = response.getWriter();
    	String str = "";
    	try{
    		if (inStockType==1) {
    			List<ViewInStockItem> cbPage = this.inStockItemService.getViewInStockItemPage(pageable, systemID, supplierID, begintime, endtime);
    			str = JsonUtil.toJson(cbPage);
			}else {
				List<ViewPurchaseInStockItem> cbPage = this.inStockItemService.getViewPurchaseInStockItemPage(pageable, systemID, supplierID, begintime, endtime);
    			str = JsonUtil.toJson(cbPage);
			}
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	out.print(str);
    	out.flush();
    	out.close();
    	return null;
    }
    
	/**
	 * 根据供货商查询系统
	 * 
	 * @author 刘斌 2017年7月27日15:07:34
	 */
	@RequestMapping("/getSystemList")
	@ResponseBody
	public HashMap<String, Object> getSystemList(HttpServletRequest request,
			HttpServletResponse response,int supplierID) throws IOException, ParseException {
 		System.out.println(TimeUtil.getTimeNow()+"进入获取系统方法:getSystemList");
 		HashMap<String, Object> map = new HashMap<String, Object>(); 
 		List<ViewSupplierSystem> systemSupplierList = systemSupplierService.getSystemSupplierList(supplierID);
 		map.put("systemSupplierList", systemSupplierList);
		return map;
	}
	
	/**
	 * 根据系统查询供货商
	 * 
	 * @author 刘斌 2017年8月3日16:04:15
	 */
	@RequestMapping("/getSupplierList")
	@ResponseBody
	public HashMap<String, Object> getSupplierList(HttpServletRequest request,
			HttpServletResponse response,int systemID) throws IOException, ParseException {
 		System.out.println(TimeUtil.getTimeNow()+"进入获取供货商方法:getSupplierList");
 		HashMap<String, Object> map = new HashMap<String, Object>(); 
 		List<ViewSupplierSystem> systemSupplierList = systemSupplierService.getSystemSuppliers(systemID);
 		map.put("systemSupplierList", systemSupplierList);
		return map;
	}

}
