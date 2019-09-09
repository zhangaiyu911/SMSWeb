/**
 * ServerFileUtil.java
 * Copyright 2012 HTKR(Tianjin) Technology Development Ltd. 
 * All rights reserved. 
 * Created on 2012-6-2 下午02:42:42
 */
package com.nkty.sms.util;

import java.io.File;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * 服务器文件工具.
 * <p><br>
 * @author 陈荣盛 2012-6-2 下午02:42:42
 * @version 1.0.0
 */
public class ServerFileUtil {
	
	/**
	 * 取得应用在服务器上路径.
	 * <p><b>创建人：</b><br>&nbsp;&nbsp; 陈荣盛 2012-5-27 下午02:50:01<br>
	 * <p><b>修改人：</b><br>&nbsp;&nbsp; 2012-5-27 下午02:50:01<br>
	 * <p><b>修改说明：</b><br>&nbsp;&nbsp;<br>
	 * @param request
	 * @return	路径
	 */
	public static String getServerPath(HttpServletRequest request){
		return request.getSession().getServletContext().getRealPath("/").replace("/", File.separator);
	}

	/**
	 * 删除服务器上的文件.
	 * <p><b>创建人：</b><br>&nbsp;&nbsp; 陈荣盛 2012-5-27 下午02:50:01<br>
	 * <p><b>修改人：</b><br>&nbsp;&nbsp; 2012-5-27 下午02:50:01<br>
	 * <p><b>修改说明：</b><br>&nbsp;&nbsp;<br>
	 * @param request
	 * @param fileName	文件名，不包括完整的路径
	 * @return	true: 成功<br>
	 * 		   false: 失败
	 */
	public static boolean delFile(HttpServletRequest request, String fileName){
		if (null != fileName && !"".equals(fileName)) {
			//服务器上文件路径
			String path = ServerFileUtil.getServerPath(request);
			
			//删除原来的文件
			return FileUtil.deleteFile(path + fileName);
		}
		
		return true;
	}
	
	/**
	 * 保存文件到服务器上.
	 * <p><b>创建人：</b><br>&nbsp;&nbsp; 陈荣盛 2012-6-2 下午02:52:55<br>
	 * <p><b>修改人：</b><br>&nbsp;&nbsp; 2012-6-2 下午02:52:55<br>
	 * <p><b>修改说明：</b><br>&nbsp;&nbsp;<br>
	 * @param request
	 * @param file	文件数据对象
	 * @param fileType		文件类型，用于指定文件保存在服务器上的位置
	 * @return	文件名，包括路径 
	 */
	public static String saveFile(HttpServletRequest request, CommonsMultipartFile file) {
		//服务器上文件路径
		String path = ServerFileUtil.getServerPath(request);
		
		//取得上传的文件名
		String fileName = file.getOriginalFilename();
		//取得文件后缀名
		String fileExt = fileName.substring(fileName.lastIndexOf(".")).toLowerCase();
	
		//得到保存的文件名
		String fName = FileUtil.getTempFileName(fileExt);
		//文件路径
		String fileDir = "uploadfile";
		try {
			fName = FileUtil.saveFile(path + fileDir, fName, file.getBytes());
		} catch (Exception e) {
			fName = "";
		}
		
		fName = (fileDir + File.separator).replace("\\", "/") + fName;
		
		return fName;
	}
}
