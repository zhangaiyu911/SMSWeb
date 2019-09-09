package com.nkty.sms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nkty.sms.bean.RelayServer;
import com.nkty.sms.bean.WuliuSystem;
import com.nkty.sms.service.CategoryService;
import com.nkty.sms.service.CustomerService;
import com.nkty.sms.service.DepartmentService;
import com.nkty.sms.service.InStockService;
import com.nkty.sms.service.OrderService;
import com.nkty.sms.service.OrderingService;
import com.nkty.sms.service.ProductService;
import com.nkty.sms.service.RelayServerService;
import com.nkty.sms.service.StockOrderingService;
import com.nkty.sms.service.UserTblService;
import com.nkty.sms.service.WuliuSystemService;

@Controller("syncController")
@RequestMapping("/sync")
public class SyncController {

	@Resource(name = "userTblServiceImpl")
	private UserTblService usertblService;

	@Resource(name = "categoryServiceImpl")
	private CategoryService categoryService;
//
	@Resource(name = "productServiceImpl")
	private ProductService productService;
//
	@Resource(name = "departmentServiceImpl")
	private DepartmentService deptService;
//
	@Resource(name = "customerServiceImpl")
	private CustomerService customerService;
//
	@Resource(name = "orderingServiceImpl")
	private OrderingService orderingService;
//
	@Resource(name = "inStockServiceImpl")
	private InStockService inStockService;
//
	@Resource(name = "orderServiceImpl")
	private OrderService orderService;
	
	@Resource(name="stockOrderingServiceImpl")
	private StockOrderingService stockOrderingService;
	
	@Resource
	private RelayServerService relayServerService;
	
    @Resource
    private WuliuSystemService wuliuSystemService;

	/**
	 * 同步采购订货信息
	 * @param request
	 * @param systemID
	 * @param host
	 * @param port
	 * @param dbname
	 * @param username
	 * @param password
	 * @param response
	 * @return
	 */
	@RequestMapping("/syncStockOrderingInfo")
	public String syncStockOrderingInfo(HttpServletRequest request, String strSystemIDs,
			String host, int port, String dbname, String username,
			String password, HttpServletResponse response) {
		JSONObject jsonObject=new JSONObject();
		String code = "中转服务器向云服务器:";

		int syncFlag = 0;

		
		//同步采购订单信息
		try{
			syncFlag = this.stockOrderingService.syncStockOrderingData(strSystemIDs,host,port,dbname,username,password);
			if(syncFlag == 0){
				code+="同步采购订单信息成功!";
			}else{
				code+="同步采购订单信息失败";
			}
		}catch(Exception e){
			e.printStackTrace();
		}

		jsonObject.put("RESULTSET", "{\"result\":\"success\",\"code\":\""
				+ code + "\"}");

		response.setContentType("text/javascript");
		// response.setHeader("Access-Control-Allow-Origin", "*");

//		try {
//			boolean jsonP = false;
//			String cb = request.getParameter("jsonp");
//			if (cb != null) {
//				jsonP = true;
//				System.out.println("jsonp");
//				response.setContentType("text/javascript");
//			} else {
//				System.out.println("json");
//				response.setContentType("application/x-json");
//			}
//			response.setCharacterEncoding("UTF-8");
//			Writer out = response.getWriter();
//			if (jsonP) {
//				out.write(cb + "(" + jsonObject.toString() + ")");
//				System.out.println(jsonObject.toString());
//			} else {
//				out.write(jsonObject.toString());
//				System.out.println(jsonObject.toString());
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

		return code;
	}
	/**
	 * 同步入库单信息
	 * 
	 * @param request
	 * @param systemID
	 * @param host
	 * @param port
	 * @param dbname
	 * @param username
	 * @param password
	 * @param response
	 * @return
	 */
	@RequestMapping("/syncInStockInfo")
	public String syncInStockInfo(HttpServletRequest request, String strSystemIDs,
			String host, int port, String dbname, String username,
			String password, HttpServletResponse response) {
		JSONObject jsonObject=new JSONObject();
		String code = "中转服务器向云服务器:";

		int syncFlag = 0;

		// 同步商品分类信息
		try {
			syncFlag = this.inStockService.syncInStockData(strSystemIDs, host,
					port, dbname, username, password);
			if (syncFlag == 0) {
				code += "同步入库信息成功!";
			} else {
				code += "同步入库信息失败!";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsonObject.put("RESULTSET", "{\"result\":\"success\",\"code\":\""
				+ code + "\"}");

		response.setContentType("text/javascript");
		// response.setHeader("Access-Control-Allow-Origin", "*");

//		try {
//			boolean jsonP = false;
//			String cb = request.getParameter("jsonp");
//			if (cb != null) {
//				jsonP = true;
//				System.out.println("jsonp");
//				response.setContentType("text/javascript");
//			} else {
//				System.out.println("json");
//				response.setContentType("application/x-json");
//			}
//			response.setCharacterEncoding("UTF-8");
//			Writer out = response.getWriter();
//			if (jsonP) {
//				out.write(cb + "(" + jsonObject.toString() + ")");
//				System.out.println(jsonObject.toString());
//			} else {
//				out.write(jsonObject.toString());
//				System.out.println(jsonObject.toString());
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

		return code;
	}

	/**
	 * 从中转库同步基础数据
	 * 
	 * @param request
	 * @param response
	 * @param systemID 物流系统编号
	 * @param host 中转数据库IP
	 * @param port 中转库端口(1433)
	 * @param dbname 中转数据库名称(AsyncDB)
	 * @param username 数据库登陆用户名
	 * @param password 数据库密码
	 * @return
	 */
	@RequestMapping("syncWuliuBaseInfo")
	public String syncWuliuBaseInfo(HttpServletRequest request,
			HttpServletResponse response, String strSystemIDs, String host, int port,
			String dbname, String username, String password) {
		JSONObject jsonObject=new JSONObject();
		String code = "中转服务器向云服务器:";

		int syncFlag = 0;

		// 同步商品分类信息
		try {
			syncFlag = this.usertblService.syncWuliuUserData(strSystemIDs,host,port,dbname,username,password);
			if(syncFlag==0){
				code+="同步用户信息成功!";
			}else{
				code+="同步用户信息失败!";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 同步商品分类信息
		try {
			syncFlag = this.categoryService.syncCategoryData(strSystemIDs, host,
					port, dbname, username, password);
			if (syncFlag == 0) {
				code += "同步商品类别信息成功!";
			} else {
				code += "同步商品类别信息失败!";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 同步商品信息
		try {
			syncFlag = this.productService.syncProductData(strSystemIDs, host,port,dbname,username,password);
			if (syncFlag == 0) {
				code += "同步商品信息成功!";
			} else {
				code += "同步商品信息失败!";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 同步部门信息
		try {
			syncFlag = this.deptService.syncDeptData(strSystemIDs, host,port,dbname,username,password);
			if (syncFlag == 0) {
				code += "同步部门信息成功!";
			} else {
				code += "同步部门信息失败!";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 同步班组信息
		try {
			syncFlag = this.customerService
					.syncCustomerData(strSystemIDs,host,port,dbname,username,password);
			if (syncFlag == 0) {
				code += "同步班组信息成功!";
			} else {
				code += "同步班组信息失败!";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsonObject.put("RESULTSET", "{\"result\":\"success\",\"code\":\""+code+"\"}");
		
		response.setContentType("text/javascript");
//        response.setHeader("Access-Control-Allow-Origin", "*");
          
//        try{
//			boolean jsonP = false;
//			String cb = request.getParameter("jsonp");
//			if (cb != null) {
//				jsonP = true;
//				System.out.println("jsonp");
//				response.setContentType("text/javascript");
//			} else {
//				System.out.println("json");
//				response.setContentType("application/x-json");
//			}
//			response.setCharacterEncoding("UTF-8");
//			Writer out = response.getWriter();
//			if (jsonP) {
//				out.write(cb + "(" + jsonObject.toString() + ")");
//				System.out.println(jsonObject.toString());
//			} else {
//				out.write(jsonObject.toString());
//				System.out.println(jsonObject.toString());
//			}
//        }catch(Exception e){
//        	e.printStackTrace();  
//        }
		
		return code;
	}
	
	/**
	 * 从中转库向云平台同步食堂订货信息
	 * 
	 * @param request
	 * @param response
	 * @param systemID
	 * @param host
	 * @param port
	 * @param dbname
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping("syncOrderingInfo")
	public String syncOrderingInfo(HttpServletRequest request,
			HttpServletResponse response, String strSystemIDs, String host, int port,
			String dbname, String username, String password){
		JSONObject jsonObject=new JSONObject();
		String code = "中转服务器向云服务器:";
		int syncFlag=0;
		// 同步订单信息
		try {
			syncFlag = this.orderService.syncOrderData(strSystemIDs, host, port,
					dbname, username, password);
			if (syncFlag == 0) {
				code += "同步订单信息成功!";
			} else {
				code += "同步订单信息失败!";
			}
			System.out.println("同步订单信息成功!");
		} catch (Exception e) {
			System.out.println("同步订单信息失败!");
			e.printStackTrace();
		}

		// 同步定单信息
		try {
			syncFlag = this.orderingService.syncOrderingData(strSystemIDs, host,
					port, dbname, username, password);
			if(syncFlag==0){
				code+="同步定单信息成功!";
			}else{
				code+="同步定单信息失败!";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		jsonObject.put("RESULTSET", "{\"result\":\"success\",\"code\":\""
				+ code + "\"}");

		response.setContentType("text/javascript");

//		try {
//			boolean jsonP = false;
//			String cb = request.getParameter("jsonp");
//			if (cb != null) {
//				jsonP = true;
//				System.out.println("jsonp");
//				response.setContentType("text/javascript");
//			} else {
//				System.out.println("json");
//				response.setContentType("application/x-json");
//			}
//			response.setCharacterEncoding("UTF-8");
//			Writer out = response.getWriter();
//			if (jsonP) {
//				out.write(cb + "(" + jsonObject.toString() + ")");
//				System.out.println(jsonObject.toString());
//			} else {
//				out.write(jsonObject.toString());
//				System.out.println(jsonObject.toString());
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

		return code;
	}
	/**
	 * 同步数据
	 * 刘斌 2017年8月29日09:58:46
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("synchronousData")
	public String synchronousData(HttpServletRequest request,
			HttpServletResponse response,int syncType) throws IOException{
		response.setCharacterEncoding("utf-8");
    	PrintWriter out = response.getWriter();
    	String str="";
    	String code="";
		List<RelayServer> relayServerList = relayServerService.getRelayServerList();
		if (relayServerList!=null&&relayServerList.size()>0) {
				if(syncType==1){
					//同步基本信息
					code=syncWuliuBaseInfo(request, response, relayServerList.get(0).getSystemIDS(), relayServerList.get(0).getHost(), relayServerList.get(0).getPort(), relayServerList.get(0).getDbName(), relayServerList.get(0).getUsername(), relayServerList.get(0).getPassword());
				}else if(syncType==2){
					//同步食堂订货
					code=syncOrderingInfo(request, response, relayServerList.get(0).getSystemIDS(), relayServerList.get(0).getHost(), relayServerList.get(0).getPort(), relayServerList.get(0).getDbName(), relayServerList.get(0).getUsername(), relayServerList.get(0).getPassword());
				}else if(syncType==3){
					//同步采购订货
					code=syncStockOrderingInfo(request, relayServerList.get(0).getSystemIDS(), relayServerList.get(0).getHost(), relayServerList.get(0).getPort(), relayServerList.get(0).getDbName(), relayServerList.get(0).getUsername(), relayServerList.get(0).getPassword(), response);
				}else if(syncType==4){
					//同步入库信息
					code=syncInStockInfo(request, relayServerList.get(0).getSystemIDS(), relayServerList.get(0).getHost(), relayServerList.get(0).getPort(), relayServerList.get(0).getDbName(), relayServerList.get(0).getUsername(), relayServerList.get(0).getPassword(), response);
				}
				str ="{\"result\":\"success\",\"code\":\""+code+"\"}";
			
			
		}else {
			str = "{\"result\":\"fail\",\"code\":\"系统参数未配置\"}";
		}
		out.print(str);
    	out.flush();
    	out.close();
		return null;
		
	}

}
