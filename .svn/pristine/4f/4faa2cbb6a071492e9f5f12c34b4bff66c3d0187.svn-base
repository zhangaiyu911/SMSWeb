package com.nkty.sms.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.nkty.sms.bean.Certificates;
import com.nkty.sms.bean.CertificatesItem;
import com.nkty.sms.bean.RegistCode;
import com.nkty.sms.bean.Role;
import com.nkty.sms.bean.Supplier;
import com.nkty.sms.bean.SystemSupplier;
import com.nkty.sms.bean.T_User_Role_Department;
import com.nkty.sms.bean.User;
import com.nkty.sms.bean.UserSysSupplier;
import com.nkty.sms.bean.view.ViewCertificatesItem;
import com.nkty.sms.bean.view.ViewUser;
import com.nkty.sms.service.CertificatesItemService;
import com.nkty.sms.service.CertificatesService;
import com.nkty.sms.service.RegistCodeService;
import com.nkty.sms.service.RoleService;
import com.nkty.sms.service.SupplierService;
import com.nkty.sms.service.SystemSupplierService;
import com.nkty.sms.service.T_User_Role_DepartmentService;
import com.nkty.sms.service.UserService;
import com.nkty.sms.service.UserSysSupplierService;
import com.nkty.sms.util.JsonUtil;
import com.nkty.sms.util.Page;
import com.nkty.sms.util.Pageable;
import com.nkty.sms.util.TimeUtil;

@Controller("userController")
@RequestMapping("/user")
public class UserController {
	/**
     * 注入用户业务接口
     */
    @Resource(name = "userServiceImpl")
    private UserService userService;
    
    
    @Resource(name="roleServiceImpl")
    private RoleService roleService;
    
    @Resource(name="t_User_Role_DepartmentServiceImpl")
    private T_User_Role_DepartmentService userRoleDeptService;
    
    @Resource(name="certificatesServiceImpl")
    private CertificatesService certificatesService;
    
    @Resource(name="registCodeServiceImpl")
    private RegistCodeService registCodeService;
    
    @Resource(name="supplierServiceImpl")
    private SupplierService supplierService;
    
    @Resource(name="systemSupplierServiceImpl")
    private SystemSupplierService systemSupplierService;
    
    @Resource
    private CertificatesItemService certificatesItemService;
    
    @Resource
    private UserSysSupplierService userSysSupplierService;
    
    /**
     * 获取用户数量
     * @author 刘雪成 2017年4月5日17:43:47
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping(value="/getUserCount")
    public String getUserCount(HttpServletRequest request,HttpServletResponse response) throws IOException{
    	response.setCharacterEncoding("utf-8");
    	PrintWriter out = response.getWriter();
    	int type=0;
    	try{
    		type=Integer.parseInt(request.getParameter("stype"));
    	}catch(Exception e){
    		type=0;
    	}
    	String username = request.getParameter("sUserName").trim();
    	int count = this.userService.getViewUserCount(type,username);
    	out.print(count);
    	out.flush();
    	out.close();
    	return null;
    }
    
    /**
     * 获取用户分页信息
     * @author 刘雪成 2017年4月5日17:43:44
     * @param request
     * @param response
     * @param pageable
     * @return
     * @throws IOException
     */
    @RequestMapping(value="/getUserPage")
    public String getUserPage(HttpServletRequest request,HttpServletResponse response,Pageable pageable) throws IOException{
    	int type=0;
    	try{
    		type=Integer.parseInt(request.getParameter("stype"));
    	}catch(Exception e){
    		type=0;
    	}
    	String username = request.getParameter("sUserName").trim();
    	String str = "";
    	try{
    		Page<ViewUser> cbPage = this.userService.getViewUserList(pageable,type,username);
    		str = JsonUtil.toJson(cbPage.getRows());
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	response.setCharacterEncoding("utf-8");
    	PrintWriter out = response.getWriter();
    	out.print(str);
    	out.flush();
    	out.close();
    	return null;
    }
    
    /**
     * 用户编辑初始化页面跳转
     * 
     * @author 刘雪成 2017年4月6日10:53:45
     * @param request
     * @param response
     * @param userID 用户编号
     * @return
     */
    @RequestMapping(value="/editUserInit")
    public ModelAndView editUserInit(HttpServletRequest request,int userID){
    	User user = new User();
    	if(userID!=0){
    		user = this.userService.find(userID);
    	}else{
    		user.setUsingFlag(1);
    	}
//    	int type=1;
//    	List<Department> deptList = this.deptService.getDeptList(type);
    	ModelAndView modelAndView = new ModelAndView();
//    	modelAndView.addObject("deptList", deptList);
    	modelAndView.addObject("user", user);
    	modelAndView.setViewName("/system/user/userEdit");
    	return modelAndView;
    }
    
   
    
    /**
     * 启用用户(批量)
     * 
     * @author 刘雪成 2017年4月7日15:15:24
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping(value="/openUser")
    public String openUser(HttpServletRequest request,HttpServletResponse response) throws IOException{
    	response.setCharacterEncoding("utf-8");
    	PrintWriter out = response.getWriter();
    	String str="";
    	String ids = request.getParameter("ids");
    	int rs = this.userService.openUsers(ids);
    	str="{\"result\":\"success\",\"code\":\"成功启用"+rs+"条记录\"}";
    	out.print(str);
    	out.flush();
    	out.close();
    	return null;
    }
    
    /**
     * 禁用用户(批量)
     * 
     * @author 刘雪成 2017年4月7日15:15:24
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping(value="/closeUser")
    public String closeUser(HttpServletRequest request,HttpServletResponse response) throws IOException{
    	response.setCharacterEncoding("utf-8");
    	PrintWriter out = response.getWriter();
    	String str="";
    	String ids = request.getParameter("ids");
    	int rs = this.userService.closeUsers(ids);
    	str="{\"result\":\"success\",\"code\":\"成功禁用"+rs+"条记录\"}";
    	out.print(str);
    	out.flush();
    	out.close();
    	return null;
    }
    
    /**
     * 跳转到
     * @author 刘雪成
     * @param request
     * @param userID
     * @return
     */
    @RequestMapping(value="editUserRoleInit")
    public ModelAndView editUserRoleInit(HttpServletRequest request,int userID){
    	ModelAndView modelAndView = new ModelAndView();
    	int usingFlag=1;
    	List<Role> roleList = this.roleService.getRoleList(userID,usingFlag);
    	User user = this.userService.find(userID);
    	modelAndView.addObject("roleList", roleList);
    	modelAndView.addObject("user", user);
    	modelAndView.setViewName("system/user/userRoleEdit");
    	return modelAndView;
    }
    
    
    /**
	 * 角色功能配置页面初始化功能列表
	 * @author 刘雪成
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "userRoleAuthConfigInit")
	public String userRoleAuthConfigInit(HttpServletRequest request,HttpServletResponse response) throws IOException{
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		int userID=0;
		int roleID=0;
		try{
			userID=Integer.parseInt(request.getParameter("userID"));
			roleID=Integer.parseInt(request.getParameter("roleID"));
		}catch(Exception e){
			//获取账套编号有误
			String str = "{\"result\":\"error\",\"code\":\"获取用户编号/角色编号有误!\"}";
			out.print(str);
			out.flush();
			out.close();
			return null;
		}
		int level=2;
		int type=0;
//		List<Dept> deptList=new ArrayList<Dept>();
//		List<Department> departmentList = this.deptService.getDeptList(type,level);
//		for (int i = 0; i < departmentList.size(); i++) {
//			Dept dept=new Dept();
//			dept.setDepartmentID(departmentList.get(i).getDepartmentID());
//			dept.setDepartmentName(departmentList.get(i).getDepartmentName());
//			deptList.add(dept);
//		}
		Role role = roleService.find(roleID);
		List<T_User_Role_Department> userRoleDeptList = this.userRoleDeptService.getUserRoleDeptList(userID,roleID);
		String deptItem = JsonUtil.toJson("");
		if(userID!=0&&roleID!=0){
			userRoleDeptList = this.userRoleDeptService.getUserRoleDeptList(userID,roleID);
		}
		String userRoleDeptItem = JsonUtil.toJson(userRoleDeptList);
		String str = "{\"result\":\"success\",\"deptList\":"+deptItem+",\"userRoleDeptList\":"+userRoleDeptItem+"}";
		out.print(str);
		out.flush();
		out.close();
		return null;
	}
	
    /**
	 * 角色功能配置页面初始化功能列表
	 * @author 刘雪成
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "userRoleAuthConfigInit2")
	public String userRoleAuthConfigInit2(HttpServletRequest request,HttpServletResponse response) throws IOException{
		HashMap<String, Object> map = new HashMap<String, Object>(); 
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		int userID=0;
		int roleID=0;
		try{
			userID=Integer.parseInt(request.getParameter("userID"));
			roleID=Integer.parseInt(request.getParameter("roleID"));
		}catch(Exception e){
			//获取账套编号有误
			map.put("result", "error");
			map.put("code", "获取用户编号/角色编号有误!");
			return null;
		}
		int level=2;
		int type=0;
//		List<Dept> deptList=new ArrayList<Dept>();
//		List<Department> departmentList = this.deptService.getDeptList(type,level);
//		for (int i = 0; i < departmentList.size(); i++) {
//			Dept dept=new Dept();
//			dept.setDepartmentID(departmentList.get(i).getDepartmentID());
//			dept.setDepartmentName(departmentList.get(i).getDepartmentName());
//			deptList.add(dept);
//			List<Department> findChildren = deptService.findChildren(departmentList.get(i).getDepartmentID());
//			map.put(departmentList.get(i).getDepartmentID()+"", findChildren);
//		}
		Role role = roleService.find(roleID);
		List<T_User_Role_Department> userRoleDeptList = this.userRoleDeptService.getUserRoleDeptList(userID,roleID);
		String deptItem = JsonUtil.toJson("");
		if(userID!=0&&roleID!=0){
			userRoleDeptList = this.userRoleDeptService.getUserRoleDeptList(userID,roleID);
		}
		String userRoleDeptItem = JsonUtil.toJson(userRoleDeptList);
		map.put("result", "success");
		map.put("deptList", "");
		map.put("userRoleDeptList", userRoleDeptList);
		String str=JsonUtil.toJson(map);
		out.print(str);
		out.flush();
		out.close();
		return null;
	}
    
	/**
	 * 保存用户角色权限部门信息
	 * @author 刘雪成
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value="/saveUserRoleDeptList")
	public String saveUserRoleDeptList(HttpServletRequest request,HttpServletResponse response) throws IOException{
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		//返回strJson
		String strJson = "";
		int userID=0;
		int roleID=0;
		String ids="";
		try{
			userID = Integer.parseInt(request.getParameter("userID"));
			roleID = Integer.parseInt(request.getParameter("roleID"));
			ids=request.getParameter("ids");
			this.userRoleDeptService.deleteUserRoleDeptList(userID,roleID);
			this.userRoleDeptService.saveUserRoleDeptList(userID,roleID,ids);
			strJson ="{\"result\":\"success\",\"code\":\"保存成功!\"}";
		}catch(Exception e){
			strJson = "{\"result\":\"error\",\"code\":\"获取参数有误!\"}";
			e.printStackTrace();
		}
		
		out.print(strJson);
		out.flush();
		out.close();
		return null;
	}
	/**********************武大云订货平台************************/	
	@RequestMapping(value="userRegist")
	public ModelAndView userRegist(HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView();
		List<Certificates> certificatesList = certificatesService.getCertificatesList(1);
		modelAndView.addObject("certificatesList", certificatesList);
		modelAndView.setViewName("/system/user/userRegist");
		return modelAndView;
	}
	
	
	/**
	 * 保存用户
	 * @author 刘斌 2017年7月20日09:49:21
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException 
	 */
	@Transactional
	@RequestMapping(value="/saveUser")
	public String saveUser(HttpServletRequest request,HttpServletResponse response,String ids,User user,
			String registCodeStr,Supplier supplier,int wuliuSupplierID) throws IOException{
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		//返回strJson
		String strJson = "";
		int result=0;
		try{
			RegistCode registCode = registCodeService.getRegistCode(registCodeStr);
			if (registCode!=null) {
				User checkUser = userService.getUser(user.getUserName());
				if (checkUser!=null) {
					strJson ="{\"result\":\"fail\",\"code\":\"用户名存在!\"}";
				}else {
					Supplier checkSupplier = supplierService.checkSupplier(supplier.getSupplierName());
					if (checkSupplier!=null) {
						strJson ="{\"result\":\"fail\",\"code\":\"供货商名称存在!\"}";
					}else {
						SystemSupplier checkSystemSupplier = systemSupplierService.checkSystemSupplier(registCode.getSystemID(), wuliuSupplierID);
						if (checkSystemSupplier!=null) {
							strJson ="{\"result\":\"fail\",\"code\":\"供货商存在!\"}";
						}else {
							
				result = userService.saveUser(user);
				if (result==0) {
					result=supplierService.saveSupplier(supplier);
					if (result==0) {
						SystemSupplier systemSupplier=new SystemSupplier();
						systemSupplier.setClouldSupplierID(supplier.getSupplierID());
						systemSupplier.setSystemID(registCode.getSystemID());
						systemSupplier.setWuliuSupplierID(wuliuSupplierID);
						result=systemSupplierService.saveSystemSupplier(systemSupplier);
						if (result==0) {
							UserSysSupplier userSysSupplier=new UserSysSupplier();
							userSysSupplier.setCurrencyID(supplier.getSupplierID());
							userSysSupplier.setUserID(user.getUserID());
							userSysSupplier.setUserType(2);
							userSysSupplier.setUsingFlag(1);
							result=userSysSupplierService.saveUserSysSupplier(userSysSupplier);
							if (result==0) {
								result=certificatesItemService.saveCertificatesItem(supplier.getSupplierID(), ids);
								if (result==0) {
									result=registCodeService.updateFlag(registCode.getRegistCodeID());
									if (result==0) {
										strJson ="{\"result\":\"success\",\"code\":\"保存成功!\",\"ids\":\""+ids+"\",\"supplierID\":\""+supplier.getSupplierID()+"\"}";
									}else{
										strJson ="{\"result\":\"fail\",\"code\":\"修改验证码失败!\"}";
									}
								}else {
									strJson ="{\"result\":\"fail\",\"code\":\"证件保存失败!\"}";
								}
							}else {
								strJson ="{\"result\":\"fail\",\"code\":\"用户关系保存失败!\"}";
							}
						}else {
							strJson ="{\"result\":\"fail\",\"code\":\"供货商存在!\"}";
						}
					}else {
						strJson ="{\"result\":\"fail\",\"code\":\"供货商名称存在!\"}";
					}
				}else {
					strJson ="{\"result\":\"fail\",\"code\":\"用户名存在!\"}";
				}
			}
				}
					}
			}else {
				strJson ="{\"result\":\"fail\",\"code\":\"验证码错误!\"}";
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
	
	@RequestMapping(value="updateCertificates")
	public ModelAndView updateCertificates(HttpServletRequest request,String ids,int supplierID){
		ModelAndView modelAndView = new ModelAndView();
		List<ViewCertificatesItem> certificatesItemList = certificatesItemService.getViewCertificatesItemList(supplierID, ids);
		modelAndView.addObject("certificatesItemList", certificatesItemList);
		modelAndView.addObject("supplierID", supplierID);
		modelAndView.addObject("ids", ids);
		modelAndView.addObject("index", request.getParameter("index"));
		modelAndView.setViewName("/system/user/uploadFile");
		return modelAndView;
	}
	@RequestMapping(value="openImagesUploadInit")
	public ModelAndView openImagesUploadInit(HttpServletRequest request,int sqid){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("sqid", sqid);
		modelAndView.setViewName("/system/user/imagesFileUpload");
		return modelAndView;
	}
	
	/**
	 * 上传证件图片
	 * @author 刘斌 2017年7月20日16:34:26
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value="/QualificationsPhotoFileUpload")
	public String QualificationsPhotoFileUpload(HttpServletRequest request,HttpServletResponse response,int itemID) throws IOException{
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		//返回strJson
		String strJson = "";
		String filename="";
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request; 
		MultipartFile up_img = multipartRequest.getFile("onefile"+itemID);
		try{
			CertificatesItem certificatesItem = certificatesItemService.find(itemID);
			if (certificatesItem!=null) {
				if (certificatesItem.getSavePath()!=null&&!certificatesItem.getSavePath().equals("")) {
					filename=certificatesItem.getSavePath();
				}else {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
					filename=sdf.format(new Date())+".jpg"; 
				}
				SaveFileFromInputStream(up_img.getInputStream(),request.getRealPath("certificates"),filename);				
				String result = "/certificates/"+filename+"";	
				System.out.println(result);
				strJson ="{\"result\":\"success\",\"code\":\"保存成功!\",\"certificates\":\""+filename+"\"}";
			}else {
				strJson = "{\"result\":\"fail\",\"code\":\"证件不存在!\"}";
			}
		}catch(Exception e){
			strJson = "{\"result\":\"error\",\"code\":\"获取参数有误!\"}";
			e.printStackTrace();
		}
		System.out.println(strJson);
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
	 * 保存证件
	 * @author 刘斌 2017年7月21日10:16:56
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value="/saveCertificatesItem")
	public String saveCertificatesItem(HttpServletRequest request,HttpServletResponse response,int supplierID,String ids) throws IOException{
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		//返回strJson
		String strJson = "";
		try{
			List<ViewCertificatesItem> certificatesItemList = certificatesItemService.getViewCertificatesItemList(supplierID, ids);
			if (certificatesItemList!=null&&certificatesItemList.size()>0) {
				for (int i = 0; i < certificatesItemList.size(); i++) {
					ViewCertificatesItem v=certificatesItemList.get(i);
					CertificatesItem certificatesItem=new CertificatesItem();
					certificatesItem.setCertificatesID(v.getCertificatesID());
					certificatesItem.setCertificatesName(request.getParameter("certificatenum"+v.getItemID()));
					certificatesItem.setEndDate(request.getParameter("stopdate"+v.getItemID()));
					certificatesItem.setItemID(v.getItemID());
					certificatesItem.setSavePath(request.getParameter("photourl"+v.getItemID()));
					certificatesItem.setSupplierID(supplierID);
					certificatesItemService.update(certificatesItem);
				}
				strJson ="{\"result\":\"success\",\"code\":\"保存成功!\"}";
			}else {
				strJson = "{\"result\":\"fail\",\"code\":\"查无证件!\"}";
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
	 * 修改密码
	 * @param request
	 * @param departmentID
	 * @return
	 */
	@RequestMapping(value = "/editUserPassword")
	public ModelAndView editUserPassword(HttpServletRequest request,
			int userID) {
		System.out.println(TimeUtil.getTimeNow()+"进入修改密码方法:editUserPassword" + userID);
		User user = new User();
    	if(userID!=0){
    		user = this.userService.find(userID);
    	}else{
    		user.setUsingFlag(1);
    	}
    	ModelAndView modelAndView = new ModelAndView();
    	modelAndView.addObject("user", user);
    	modelAndView.setViewName("/system/user/userPasswordEdit");
    	return modelAndView;
	}
	/**
	 * 修改密码保存
	 * @param request
	 * @param response
	 * @return String
	 * @throws IOException
	 */
	@RequestMapping("/saveUserPassword")
	public String saveUserPassword(HttpServletRequest request,HttpServletResponse response) throws IOException{
		System.out.println(TimeUtil.getTimeNow()+"进入保存修改密码方法：saveUserPassword");
		PrintWriter out=response.getWriter();
		String str="";
		int userID=0;
		try {
			userID=Integer.parseInt(request.getParameter("userID"));
		} catch (Exception e) {
			str = "{\"result\":\"fail\",\"code\":\"修改失败\"}";
			out.print(str);
			out.flush();
			return null;
		}
		String password="";
		try {
			password=request.getParameter("password");
		} catch (Exception e) {
			str = "{\"result\":\"fail\",\"code\":\"修改失败\"}";
			out.print(str);
			out.flush();
			return null;
		}
		int res=userService.editUserPassword(password, userID);
		if(res>0){
			str="{\"result\":\"success\",\"code\":\"修改成功\"}";
		}else{
			str = "{\"result\":\"fail\",\"code\":\"修改失败\"}";
		}
		out.print(str);
		out.flush();
		return null;
	}
}
