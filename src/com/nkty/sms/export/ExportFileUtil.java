/**
= * ExportUtil.java
 * Copyright 2012 HTKR(Tianjin) Technology Development Ltd. 
 * All rights reserved. 
 * Created on 2012-6-19 下午08:29:47
 */
package com.nkty.sms.export;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * 导出文件工具.
 * <p><br>
 * @author 陈荣盛 2012-6-19 下午08:29:47
 * @version 1.0.0
 */
public class ExportFileUtil {
	/**
	 * 将文件写到客户端.
	 * <p><b>创建人：</b><br>&nbsp;&nbsp; 陈荣盛 2012-6-19 下午08:32:44<br>
	 * <p><b>修改人：</b><br>&nbsp;&nbsp; 2012-6-19 下午08:32:44<br>
	 * <p><b>修改说明：</b><br>&nbsp;&nbsp;<br>
	 * @param response
	 * @param mimeType		MIMI类型
	 * @param fileName		文件名
	 * @param bos			文件字节数组
	 * @throws Exception
	 */
	public static void writeToClient(HttpServletResponse response, String mimeType, String fileName, ByteArrayOutputStream bos) throws Exception{
		response.reset();
		response.setContentType(mimeType);
		response.setHeader("Content-disposition", "attachment; filename=" + new String(fileName.getBytes("GBK"), "iso8859-1") );
		response.setContentLength(bos.size());
		//禁止页面缓存
		response.setHeader("Pragma", "no-cache"); 
		response.setHeader("Cache-Control", "no-cache"); 
		response.setDateHeader("Expires", 0); 
		
		ServletOutputStream sos = response.getOutputStream();
		bos.writeTo(sos);
		sos.flush();
		sos.close(); 
		bos.close();
	}
	
	/**
	 * 将Excel文件在客户端导出.
	 * <p><b>创建人：</b><br>&nbsp;&nbsp; 陈荣盛 2012-7-2 下午09:40:06<br>
	 * <p><b>修改人：</b><br>&nbsp;&nbsp; 2012-7-2 下午09:40:06<br>
	 * <p><b>修改说明：</b><br>&nbsp;&nbsp;<br>
	 * @param response
	 * @param wb
	 * @param defaultFileName  客户端保存时显示的文件名称
	 */
	public static void writeToClient(HttpServletResponse response, HSSFWorkbook wb, String defaultFileName){
		OutputStream toClient = null;
		ByteArrayOutputStream bOut = null;
		try {
			bOut = new ByteArrayOutputStream();
			
			//把相应的Excel工作簿写入内存流
			wb.write(bOut);

			response.reset();
			response.addHeader("Content-Disposition", "attachment;filename="
				+ new String(defaultFileName.getBytes("GBK"), "iso8859-1"));
			response.setContentLength(bOut.size());
			//得到向客户端输出二进制数据的对象
			toClient = new BufferedOutputStream(response.getOutputStream());    
			//设置浏览器mime类型   
			response.setContentType("application/vnd.ms-excel; charset=GBK");
			
			//输出数据  
			toClient.write(bOut.toByteArray());
			toClient.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				bOut.close();
				
				toClient.close();
			} catch (Exception e) {
				e.printStackTrace();
			}	
		}
	}
}
