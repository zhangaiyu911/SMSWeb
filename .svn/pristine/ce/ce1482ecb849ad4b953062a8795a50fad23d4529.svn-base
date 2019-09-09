package com.nkty.sms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nkty.sms.bean.Function;
import com.nkty.sms.bean.Module;
import com.nkty.sms.bean.Supplier;
import com.nkty.sms.bean.User;
import com.nkty.sms.bean.UserSysSupplier;
import com.nkty.sms.bean.WuliuSystem;
import com.nkty.sms.bean.view.ViewSupplierSystem;
import com.nkty.sms.service.FunctionService;
import com.nkty.sms.service.ModuleService;
import com.nkty.sms.service.SupplierService;
import com.nkty.sms.service.SystemSupplierService;
import com.nkty.sms.service.UserService;
import com.nkty.sms.service.UserSysSupplierService;
import com.nkty.sms.service.WuliuSystemService;
import com.nkty.sms.util.JsonUtil;
/**
 * 用户登录控制器.
 * @author 刘雪成 2017年4月7日15:30:49
 */
@Controller("loginController")
@RequestMapping("/login")
public class LoginController {
	/**
     * 注入用户业务接口
     */
    @Resource(name = "userServiceImpl")
    private UserService userService;
	
    @Resource(name="moduleServiceImpl")
    private ModuleService moduleService;
    
    @Resource(name="functionServiceImpl")
    private FunctionService functionService;
    
    @Resource
    private UserSysSupplierService userSysSupplierService;
    
    @Resource
    private SystemSupplierService systemSupplierService;
    
    @Resource
    private SupplierService supplierService;
    
    @Resource
    private WuliuSystemService wuliuSystemService;
    
    
    
    /**
     * 用户登录
     * @author 刘雪成 
     * @param request
     * @param username 用户名
     * @param password 密码
     * @return 
     */
	@RequestMapping(value = "/login")
	public ModelAndView login(HttpServletRequest request){
		//返回页面数据
	    ModelAndView modelAndView = new ModelAndView();
	    //获取登录用户名、密码
	    String username = request.getParameter("username");
	    String password = request.getParameter("password");
	    
	    System.out.println("用户登录：用户名："+username);
	    if (null == username || null == password) {
	    	modelAndView.setViewName("../../login");
	    	modelAndView.addObject("errorcode", "请输入用户名/密码。");
	    	return modelAndView;
	    }
	    //验证用户名密码是否正确
	    User user = userService.getUser(username);
	    if(user==null){
	    	modelAndView.addObject("errorcode", "该账户不存在！请重新输入。");
	    	modelAndView.setViewName("../../login");
	    }else if(user.getUsingFlag()==2){
	    	modelAndView.addObject("errorcode","该账户已冻结！请与管理员联系。");
	    	modelAndView.setViewName("../../login");
	    }else if(!user.getPassword().equals(password)){
	    	modelAndView.addObject("errorcode", "密码不正确！请重新输入。");
	    	modelAndView.addObject("username", username);
	    	modelAndView.setViewName("../../login");
	    }else{
	    	if (user.getUserType()==2) {
	    		UserSysSupplier userSysSupplier = userSysSupplierService.getUserSysSupplier(user.getUserID(), 2);
	    		List<ViewSupplierSystem> systemSupplierList = systemSupplierService.getSystemSupplierList(userSysSupplier.getCurrencyID());
	    		if (systemSupplierList!=null&&systemSupplierList.size()>0) {
	    			modelAndView.addObject("usingFlag", 1);
				}else {
					modelAndView.addObject("usingFlag", 2);
				}
			}
	    	modelAndView.addObject("errorcode", "欢迎你：'+username+'");
	    	modelAndView.addObject("username", username);
	    	modelAndView.addObject("user", user);
	    	modelAndView.setViewName("../../index");
	    }
	    return modelAndView;
	}
	
	/**
	 * 根据用户编号获取权限模块
	 * 
	 * @author 刘雪成
	 * @param request
	 * @param response
	 * @param userID 用户编号
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value="/getModulesByUserID")
	public String getModulesByUserID(HttpServletRequest request,HttpServletResponse response,int userID) throws IOException{
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String str="";
		//查询用户权限模块
		List<Module> moduleList = this.moduleService.getModuleListByUserID(userID);
		if(moduleList!=null&&moduleList.size()>0){
			str=JsonUtil.toJson(moduleList);
		}
		out.print(str);
		out.flush();
		out.close();
		return null;
	}
	
	/**
	 * 获取功能列表
	 * 
	 * @author 刘雪成 2017年4月5日16:10:12
	 * @param request
	 * @param response
	 * @param userID 用户编号
	 * @param moduleID 模块编号
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value="/getFunctionList")
	public String getFunctionList(HttpServletRequest request,HttpServletResponse response,int userID,int moduleID) throws IOException{
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String str="";
		//获取功能列表
		List<Function> functionList=this.functionService.getUserFunctionList(userID,moduleID);
		if(functionList!=null&&functionList.size()>0){
			str=JsonUtil.toJson(functionList);
		}
		out.print(str);
		out.flush();
		out.close();
		return null;
	}
	
	//集中处理桌面按钮跳转操作
	/**
	 * 用户管理
	 * 
	 * @author 刘雪成
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/searchUserList")
	public ModelAndView searchUserList(HttpServletRequest request){
		System.out.println("进入用户管理页面");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/system/user/userList");
		return modelAndView;
	}
	
	/**
	 * 模块管理
	 * 
	 * @author 刘雪成
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/searchModuleList")
	public ModelAndView searchModuleList(HttpServletRequest request){
		System.out.println("进入模块管理页面");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/system/user/moduleList");
		return modelAndView;
	}
	/**
	 * 功能管理
	 * 
	 * @author 刘雪成
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/searchFunctionList")
	public ModelAndView searchFunctionList(HttpServletRequest request){
		System.out.println("进入功能管理页面");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/system/user/functionList");
		return modelAndView;
	}
	
	/**
	 * 角色管理
	 * 
	 * @author 刘雪成
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/searchRoleList")
	public ModelAndView searchRoleList(HttpServletRequest request){
		System.out.println("进入角色管理页面");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/system/user/roleList");
		return modelAndView;
	}
	

	
	/**
	 * 跳转到供货商审核页面
	 * @author 刘斌 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "supplierList")
	public ModelAndView supplierList(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		List<WuliuSystem> wuliuSystemList = wuliuSystemService.getWuliuSystemList(null);
		modelAndView.addObject("wuliuSystemList", wuliuSystemList);
		modelAndView.setViewName("/supplier/supplierList");
		return modelAndView;
	}
	
	/**
	 * 跳转到订单页面
	 * @author 刘斌 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "orderList")
	public ModelAndView orderList(HttpServletRequest request,HttpServletResponse response,int userID) {
		response.setCharacterEncoding("utf-8");
		ModelAndView modelAndView = new ModelAndView();
		UserSysSupplier userSysSupplier = userSysSupplierService.getUserSysSupplier(userID, 2);
		if (userSysSupplier==null) {
			modelAndView.addObject("errorcode", "无用户！");
		}else {
			List<ViewSupplierSystem> systemSupplierList = systemSupplierService.getSystemSupplierList(userSysSupplier.getCurrencyID());
			User userById = userService.getUserById(userID);
			modelAndView.addObject("systemSupplierList", systemSupplierList);
			modelAndView.addObject("supplierID", userSysSupplier.getCurrencyID());
			modelAndView.addObject("supplierName", systemSupplierList.get(0).getSupplierName());
			if (userById!=null) {
				modelAndView.addObject("userName", userById.getUserName());
			}
		}
		modelAndView.setViewName("/ordering/orderingList");
		return modelAndView;
	}
	
	/**
	 * 跳转到入库单页面
	 * @author 刘斌 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "inStockList")
	public ModelAndView inStockList(HttpServletRequest request,int userID,int inStockType) {
		ModelAndView modelAndView = new ModelAndView();
		UserSysSupplier userSysSupplier = userSysSupplierService.getUserSysSupplier(userID, 2);
		if (userSysSupplier==null) {
			modelAndView.addObject("errorcode", "无用户！");
		}else {
			List<ViewSupplierSystem> systemSupplierList = systemSupplierService.getSystemSupplierList(userSysSupplier.getCurrencyID());
			modelAndView.addObject("systemSupplierList", systemSupplierList);
			modelAndView.addObject("supplierID", userSysSupplier.getCurrencyID());
			modelAndView.addObject("inStockType", inStockType);
		}
		modelAndView.setViewName("/inStock/inStockList");
		return modelAndView;
	}
	
	/**
	 * 跳转到入库单明细汇总页面
	 * @author 刘斌 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "inStockItemSummary")
	public ModelAndView inStockItemSummary(HttpServletRequest request,int userID,int inStockType) {
		ModelAndView modelAndView = new ModelAndView();
		List<UserSysSupplier> userSysSupplierList = userSysSupplierService.getUserSysSupplierList(userID, 2);
		if (userSysSupplierList!=null&&userSysSupplierList.size()>0) {
			String ids="";
			for (int i = 0; i < userSysSupplierList.size(); i++) {
				if (i==0) {
					ids+=userSysSupplierList.get(i).getCurrencyID()+"";
				}else {
					ids+=","+userSysSupplierList.get(i).getCurrencyID();
				}
			}
			List<Supplier> supplierList = supplierService.getSupplierList(ids);
			modelAndView.addObject("supplierList", supplierList);
			modelAndView.addObject("inStockType", inStockType);
		}else {
			modelAndView.addObject("errorcode", "无用户！");
		}
		
		modelAndView.setViewName("/inStock/inStockItemSummary");
		return modelAndView;
	}
	
	/**
	 * 跳转到未下载订单页面
	 * @author 刘斌 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "notDownloadOrderList")
	public ModelAndView notDownloadOrderList(HttpServletRequest request,int userID) {
		ModelAndView modelAndView = new ModelAndView();
		UserSysSupplier userSysSupplier = userSysSupplierService.getUserSysSupplier(userID, 2);
		if (userSysSupplier==null) {
			modelAndView.addObject("errorcode", "无用户！");
		}else {
			List<ViewSupplierSystem> systemSupplierList = systemSupplierService.getSystemSupplierList(userSysSupplier.getCurrencyID());
			modelAndView.addObject("systemSupplierList", systemSupplierList);
			modelAndView.addObject("supplierID", userSysSupplier.getCurrencyID());
		}
		modelAndView.setViewName("/ordering/notDownloadOrderList");
		return modelAndView;
	}
	
	/**
	 * 跳转到未下载采购订单页面
	 * @author 刘斌 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "notDownloadStockOrderList")
	public ModelAndView notDownloadStockOrderList(HttpServletRequest request,int userID) {
		ModelAndView modelAndView = new ModelAndView();
		UserSysSupplier userSysSupplier = userSysSupplierService.getUserSysSupplier(userID, 2);
		if (userSysSupplier==null) {
			modelAndView.addObject("errorcode", "无用户！");
		}else {
			List<ViewSupplierSystem> systemSupplierList = systemSupplierService.getSystemSupplierList(userSysSupplier.getCurrencyID());
			modelAndView.addObject("systemSupplierList", systemSupplierList);
			modelAndView.addObject("supplierID", userSysSupplier.getCurrencyID());
		}
		modelAndView.setViewName("/stockOrdering/notDownloadOrderList");
		return modelAndView;
	}
	
	/**
	 * 跳转到采购订单页面
	 * @author 刘斌 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "stockOrderList")
	public ModelAndView stockOrderList(HttpServletRequest request,int userID) {
		ModelAndView modelAndView = new ModelAndView();
		UserSysSupplier userSysSupplier = userSysSupplierService.getUserSysSupplier(userID, 2);
		if (userSysSupplier==null) {
			modelAndView.addObject("errorcode", "无用户！");
		}else {
			List<ViewSupplierSystem> systemSupplierList = systemSupplierService.getSystemSupplierList(userSysSupplier.getCurrencyID());
			User userById = userService.getUserById(userID);
			modelAndView.addObject("systemSupplierList", systemSupplierList);
			modelAndView.addObject("supplierID", userSysSupplier.getCurrencyID());
			modelAndView.addObject("supplierName", systemSupplierList.get(0).getSupplierName());
			if (userById!=null) {
				modelAndView.addObject("userName",userById.getUserName() );
			}
		}
		modelAndView.setViewName("/stockOrdering/stockorderingList");
		return modelAndView;
	}
	
	/**
	 * 管理员跳转到入库单页面
	 * @author 刘斌 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "systemInStockList")
	public ModelAndView systemInStockList(HttpServletRequest request,int userID,int inStockType) {
		ModelAndView modelAndView = new ModelAndView();
		UserSysSupplier userSysSupplier = userSysSupplierService.getUserSysSupplier(userID, 1);
		if (userSysSupplier==null) {
			modelAndView.addObject("errorcode", "无用户！");
		}else {
			List<WuliuSystem> wuliuSystemList = wuliuSystemService.getWuliuSystemList(null);
//			List<ViewSupplierSystem> systemSupplierList = systemSupplierService.getSystemSuppliers(userSysSupplier.getCurrencyID());
//			modelAndView.addObject("systemSupplierList", systemSupplierList);
			modelAndView.addObject("systemID", userSysSupplier.getCurrencyID());
			modelAndView.addObject("inStockType", inStockType);
			modelAndView.addObject("wuliuSystemList", wuliuSystemList);
		}
		modelAndView.setViewName("/inStock/systemInStockList");
		return modelAndView;
	}
	
	/**
	 * 管理员跳转到入库单明细汇总页面
	 * @author 刘斌 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "systemInStockItemSummary")
	public ModelAndView systemInStockItemSummary(HttpServletRequest request,int userID,int inStockType) {
		ModelAndView modelAndView = new ModelAndView();
		List<UserSysSupplier> userSysSupplierList = userSysSupplierService.getUserSysSupplierList(userID, 1);
		if (userSysSupplierList!=null&&userSysSupplierList.size()>0) {
//			String ids="";
//			for (int i = 0; i < userSysSupplierList.size(); i++) {
//				if (i==0) {
//					ids+=userSysSupplierList.get(i).getCurrencyID()+"";
//				}else {
//					ids+=","+userSysSupplierList.get(i).getCurrencyID();
//				}
//			}
			List<WuliuSystem> wuliuSystemList = wuliuSystemService.getWuliuSystemList(null);
			modelAndView.addObject("wuliuSystemList", wuliuSystemList);
			modelAndView.addObject("inStockType", inStockType);
		}else {
			modelAndView.addObject("errorcode", "无用户！");
		}
		
		modelAndView.setViewName("/inStock/systemInStockItemSummary");
		return modelAndView;
	}
	
	/**
	 * 管理员跳转到验证码页面
	 * @author 刘斌 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "registCodeList")
	public ModelAndView registCodeList(HttpServletRequest request,int userID) {
		ModelAndView modelAndView = new ModelAndView();
		List<UserSysSupplier> userSysSupplierList = userSysSupplierService.getUserSysSupplierList(userID, 1);
		if (userSysSupplierList!=null&&userSysSupplierList.size()>0) {
			String ids="";
			for (int i = 0; i < userSysSupplierList.size(); i++) {
				if (i==0) {
					ids+=userSysSupplierList.get(i).getCurrencyID()+"";
				}else {
					ids+=","+userSysSupplierList.get(i).getCurrencyID();
				}
			}
			List<WuliuSystem> wuliuSystemList = wuliuSystemService.getWuliuSystemList(null);
			modelAndView.addObject("wuliuSystemList", wuliuSystemList);
		}else {
			modelAndView.addObject("errorcode", "无用户！");
		}
		
		modelAndView.setViewName("/supplier/registCodeList");
		return modelAndView;
	}

}
