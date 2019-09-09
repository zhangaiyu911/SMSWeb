package com.nkty.sms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nkty.sms.bean.Certificates;
import com.nkty.sms.bean.CertificatesItem;
import com.nkty.sms.bean.RegistCode;
import com.nkty.sms.bean.Supplier;
import com.nkty.sms.bean.SystemSupplier;
import com.nkty.sms.bean.UserSysSupplier;
import com.nkty.sms.bean.WuliuSystem;
import com.nkty.sms.bean.view.ViewCertificatesItem;
import com.nkty.sms.bean.view.ViewSupplierSystem;
import com.nkty.sms.service.CertificatesItemService;
import com.nkty.sms.service.CertificatesService;
import com.nkty.sms.service.RegistCodeService;
import com.nkty.sms.service.SupplierService;
import com.nkty.sms.service.SystemSupplierService;
import com.nkty.sms.service.UserSysSupplierService;
import com.nkty.sms.service.WuliuSystemService;
import com.nkty.sms.util.JsonUtil;
import com.nkty.sms.util.Page;
import com.nkty.sms.util.Pageable;
import com.nkty.sms.util.TimeUtil;

@Controller("supplierController")
@RequestMapping("/supplier")
public class SupplierController {
	
	@Resource(name="supplierServiceImpl")
	private SupplierService supplierService;
	
    @Resource
    private CertificatesItemService certificatesItemService;
    
    @Resource
    private UserSysSupplierService userSysSupplierService;
    
    @Resource(name="certificatesServiceImpl")
    private CertificatesService certificatesService;
    
    @Resource
    private SystemSupplierService systemSupplierService;
    
    @Resource
    private WuliuSystemService wuliuSystemService;
    
    @Resource(name="registCodeServiceImpl")
    private RegistCodeService registCodeService;
	
    /**
     * 获取供货商数量
     * @author 刘斌 2017年7月24日09:41:47
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping(value="/getSupplierCount")
    public String getSupplierCount(HttpServletRequest request,HttpServletResponse response,int systemID,String supplierName) throws IOException{
    	response.setCharacterEncoding("utf-8");
    	PrintWriter out = response.getWriter();
    	int count = this.supplierService.getViewSupplierSystemCount(systemID,supplierName);
    	out.print(count);
    	out.flush();
    	out.close();
    	return null;
    }
    
    /**
     * 获取供货商分页信息
     * @author 刘斌 2017年7月24日09:42:11
     * @param request
     * @param response
     * @param pageable
     * @return
     * @throws IOException
     */
    @RequestMapping(value="/getSupplierPage")
    public String getSupplierPage(HttpServletRequest request,HttpServletResponse response,Pageable pageable,int systemID,String supplierName) throws IOException{
    	response.setCharacterEncoding("utf-8");
    	PrintWriter out = response.getWriter();
    	String str = "";
    	try{
    		Page<ViewSupplierSystem> cbPage = this.supplierService.getViewSupplierSystemPage(pageable,systemID,supplierName);
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
	 * 不通过
	 * 刘斌 2017年7月24日10:55:15
	 * @param request
	 * @param roleId
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value="/delSupplier")
	public String delSupplier(HttpServletRequest request, HttpServletResponse response, String ids,String memo) throws IOException{
 		System.out.println(TimeUtil.getTimeNow()+"进入审核不通过方法:delSupplier");
		response.setCharacterEncoding("utf-8");
		PrintWriter out =response.getWriter();
		int result = supplierService.delSupplier(ids,memo);
		String str = "";
		if(0==result){
			str="{\"result\":\"success\",\"code\":\"审核成功\"}";
		}else{
			str = "{\"result\":\"fail\",\"code\":\"保存失败\"}";
		}
		System.out.println("str"+str);
		out.print(str);
		out.flush();
		return null;
	}
	/**
	 * 通过  2017年7月24日10:55:21
	 * 刘斌
	 * @param request
	 * @param roleId
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value="/successSupplier")
	public String successSupplier(HttpServletRequest request, HttpServletResponse response, String ids) throws IOException{
 		System.out.println(TimeUtil.getTimeNow()+"进入审核通过方法:successSupplier");
		response.setCharacterEncoding("utf-8");
		PrintWriter out =response.getWriter();
		int result = supplierService.successSupplier(ids);
		String str = "";
		if(0==result){
			str="{\"result\":\"success\",\"code\":\"审核成功\"}";
		}else{
			str = "{\"result\":\"fail\",\"code\":\"保存失败\"}";
		}
		System.out.println("str"+str);
		out.print(str);
		out.flush();
		return null;
	}
	
	/**
	 * 获取供货商详情，证件图
	 * @param request
	 * @param supplierID
	 * @return
	 */
	@RequestMapping(value="updateCertificates")
	public ModelAndView updateCertificates(HttpServletRequest request,int supplierID,int itemID,int page){
		ModelAndView modelAndView = new ModelAndView();
		List<ViewCertificatesItem> certificatesItemList = certificatesItemService.getViewCertificatesItemList(supplierID, null);
		List<ViewSupplierSystem> systemSupplierList = systemSupplierService.getSystemSupplierListByID(supplierID);
		if (systemSupplierList!=null&&systemSupplierList.size()>0) {
			modelAndView.addObject("systemSupplier", systemSupplierList.get(0));
		}else {
			modelAndView.addObject("systemSupplier", null);
		}
		modelAndView.addObject("certificatesItemList", certificatesItemList);
		modelAndView.addObject("supplierID", supplierID);
		modelAndView.addObject("itemID", itemID);
		modelAndView.addObject("page", page);
		modelAndView.setViewName("/supplier/uploadFile");
		return modelAndView;
	}
	
	/**
	 * 供货商登录获取详情
	 * @param request
	 * @param supplierID
	 * @return
	 */
	@RequestMapping(value="getSupplier")
	public ModelAndView getSupplier(HttpServletRequest request,int userID){
		ModelAndView modelAndView = new ModelAndView();
		UserSysSupplier userSysSupplier = userSysSupplierService.getUserSysSupplier(userID, 2);
		if (userSysSupplier==null) {
			modelAndView.addObject("errorcode", "无用户！");
		}else {
			Supplier supplier = supplierService.find(userSysSupplier.getCurrencyID());
			List<ViewCertificatesItem> certificatesItemList = certificatesItemService.getViewCertificatesItemList(supplier.getSupplierID(), null);
			List<ViewSupplierSystem> allSystemSupplierList = systemSupplierService.getAllSystemSupplierList(userSysSupplier.getCurrencyID());
			modelAndView.addObject("certificatesItemList", certificatesItemList);
			modelAndView.addObject("systemList", allSystemSupplierList);
			modelAndView.addObject("systemSupplierList", JsonUtil.toJson(allSystemSupplierList));
			modelAndView.addObject("supplier", supplier);
		}
		List<Certificates> certificatesList = certificatesService.getCertificatesList(1);
		modelAndView.addObject("certificatesList", certificatesList);
		modelAndView.setViewName("/supplier/supplier");
		return modelAndView;
	}

	/**
	 * 修改供货商  2017年7月25日11:14:27
	 * 刘斌
	 * @param request
	 * @param roleId
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value="/updateSupplier")
	public String updateSupplier(HttpServletRequest request, HttpServletResponse response, String ids,Supplier supplier) throws IOException{
 		System.out.println(TimeUtil.getTimeNow()+"进入审核通过方法:successSupplier");
		response.setCharacterEncoding("utf-8");
		PrintWriter out =response.getWriter();
		int result = 0;
		String str = "";
		result=supplierService.saveSupplier(supplier);
		if (result==0) {
			List<ViewCertificatesItem> certificatesItemList = certificatesItemService.getViewCertificatesItemList(supplier.getSupplierID(), null);
			Set<Integer> same = new HashSet<Integer>();  //用来存放两个数组中相同的元素  
			Set<Integer> temp = new HashSet<Integer>();  //用来存放数组ids中的元素 
			List<Integer> temp2=new ArrayList<Integer>();
			List<Integer> temp3=new ArrayList<Integer>();
			String []arr=ids.split(",");
			int []arr2=new int[arr.length];
			for (int i = 0; i < arr.length; i++) {
				arr2[i]=Integer.parseInt(arr[i]);
				temp.add(Integer.parseInt(arr[i]));
			}
		    for (int i = 0; i < certificatesItemList.size(); i++) {
				if (!temp.add(certificatesItemList.get(i).getCertificatesID())) {
					same.add(certificatesItemList.get(i).getCertificatesID());
				}
			}
		    
		    for (int i:arr2) {
				if (!same.contains(i)) {
					temp2.add(i);
				}
			}
		    for (ViewCertificatesItem v:certificatesItemList) {
				if (!same.contains(v.getCertificatesID())) {
					temp3.add(v.getCertificatesID());
				}
			}
		    for (int i = 0; i < temp2.size(); i++) {
		    	CertificatesItem certificatesItem=new CertificatesItem();
		    	certificatesItem.setCertificatesID(temp2.get(i));
		    	certificatesItem.setCertificatesName("");
		    	certificatesItem.setEndDate("");
		    	certificatesItem.setSavePath("");
		    	certificatesItem.setSupplierID(supplier.getSupplierID());
		    	certificatesItemService.save(certificatesItem);
			}
		    for (int i = 0; i < temp3.size(); i++) {
		    	for (int j = 0; j < certificatesItemList.size(); j++) {
					if (temp3.get(i)==certificatesItemList.get(j).getCertificatesID()) {
						certificatesItemService.delete(certificatesItemList.get(j).getItemID());
					}
				}
			}
		    str="{\"result\":\"success\",\"code\":\"修改成功\"}";
		}else {
			str = "{\"result\":\"fail\",\"code\":\"修改失败\"}";
		}
		
		System.out.println("str"+str);
		out.print(str);
		out.flush();
		return null;
	}
	
	/**
	 * 供货商登录获取证件详情
	 * 刘斌 2017年7月25日14:39:49
	 * @param request
	 * @param supplierID
	 * @return
	 */
	@RequestMapping(value="getCertificatesItems")
	public ModelAndView getCertificatesItems(HttpServletRequest request,int userID){
		ModelAndView modelAndView = new ModelAndView();
		UserSysSupplier userSysSupplier = userSysSupplierService.getUserSysSupplier(userID, 2);
		if (userSysSupplier==null) {
			modelAndView.addObject("errorcode", "无用户！");
		}else {
			Supplier supplier = supplierService.find(userSysSupplier.getCurrencyID());
			List<ViewCertificatesItem> certificatesItemList = certificatesItemService.getViewCertificatesItemList(supplier.getSupplierID(), null);
			String ids="";
			for (int i = 0; i < certificatesItemList.size(); i++) {
				if (i==0) {
					ids+=certificatesItemList.get(i).getCertificatesID()+"";
				}else {
					ids+=","+certificatesItemList.get(i).getCertificatesID();
				}
			}
			modelAndView.addObject("certificatesItemList", certificatesItemList);
			modelAndView.addObject("supplierID", supplier.getSupplierID());
			modelAndView.addObject("ids", ids);
		}
		List<Certificates> certificatesList = certificatesService.getCertificatesList(1);
		modelAndView.addObject("certificatesList", certificatesList);
		modelAndView.setViewName("/supplier/updateUploadFile");
		return modelAndView;
	}
	
	/**
	 * 供货商新增物流系统
	 * 刘斌 2017年8月28日15:41:27
	 * @param request
	 * @param supplierID
	 * @return
	 */
	@RequestMapping(value="addSystemSupplierInit")
	public ModelAndView addSystemSupplierInit(HttpServletRequest request,int supplierID){
		ModelAndView modelAndView = new ModelAndView();
		List<ViewSupplierSystem> systemSupplierList = systemSupplierService.getSystemSupplierList(supplierID);
		String ids="";
		if (systemSupplierList!=null&&systemSupplierList.size()>0) {
			for (int i = 0; i < systemSupplierList.size(); i++) {
				if (i==0) {
					ids=systemSupplierList.get(i).getSystemID()+"";
				}else {
					ids+=","+systemSupplierList.get(i).getSystemID();
				}
			}
		}else {
			ids=null;
		}
		List<WuliuSystem> wuliuSystemList = wuliuSystemService.getWuliuSystemListNoIds(ids);
		modelAndView.addObject("wuliuSystemList", wuliuSystemList);
		modelAndView.addObject("supplierID", supplierID);
		modelAndView.setViewName("/supplier/addSystemSupplier");
		return modelAndView;
	}
	
	/**
	 * 保存供货商新增物流系统
	 * 刘斌 2017年8月28日16:30:04
	 * @param request
	 * @param roleId
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value="/saveSystemSupplier")
	public String saveSystemSupplier(HttpServletRequest request, HttpServletResponse response, int systemID,int supplierID,String registCodeStr,
			int wuliuSupplierID) throws IOException{
 		System.out.println(TimeUtil.getTimeNow()+"进入保存供货商新增物流系统方法:saveSystemSupplier");
		response.setCharacterEncoding("utf-8");
		PrintWriter out =response.getWriter();
		String str = "";
		RegistCode registCode = registCodeService.getRegistCode(registCodeStr);
		int result=0;
		if (registCode!=null) {
			SystemSupplier systemSupplier=new SystemSupplier();
			systemSupplier.setClouldSupplierID(supplierID);
			systemSupplier.setSystemID(systemID);
			systemSupplier.setWuliuSupplierID(wuliuSupplierID);
			systemSupplier.setMemo("");
			systemSupplier.setUsingFlag(0);
			result=systemSupplierService.saveSystemSupplier(systemSupplier);
			if(0==result){
				result=registCodeService.updateFlag(registCode.getRegistCodeID());
				if (0==result) {
					str="{\"result\":\"success\",\"code\":\"新增成功\"}";
				}
			}else{
				str = "{\"result\":\"fail\",\"code\":\"保存失败\"}";
			}
		}else {
			str ="{\"result\":\"fail\",\"code\":\"验证码错误!\"}";
		}
		
		System.out.println("str"+str);
		out.print(str);
		out.flush();
		return null;
	}
	
}
