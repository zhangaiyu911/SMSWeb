/**
 * ExcelUtil.java
 * Copyright 2012 HTKR(Tianjin) Technology Development Ltd. 
 * All rights reserved. 
 * Created on 2012-7-2 下午09:21:33
 */
package com.nkty.sms.export;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * Excel工具类.
 * <p><br>
 * @author 陈荣盛 2012-7-2 下午09:21:33
 * @version 1.0.0
 */
public class ExcelUtil {
	/**
	 * 取得标题单元格样式.
	 * <p><b>创建人：</b><br>&nbsp;&nbsp; 陈荣盛 2012-7-2 下午10:56:15<br>
	 * <p><b>修改人：</b><br>&nbsp;&nbsp; 2012-7-2 下午10:56:15<br>
	 * <p><b>修改说明：</b><br>&nbsp;&nbsp;<br>
	 * @param wb
	 * @return
	 */
	private static HSSFCellStyle getTitleCellStyle(HSSFWorkbook wb){
		//创建单元格样式
		HSSFCellStyle styleTemp = wb.createCellStyle();
		
		//创建字体
		HSSFFont fontTemp = wb.createFont(); 
		//字号   
		fontTemp.setFontHeightInPoints((short) 11);
		//粗体宽度  
		fontTemp.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		
		//设置对齐方式
		styleTemp.setAlignment((short)2);
		//将文字样式设置给样式
		styleTemp.setFont(fontTemp);
		//设置边框
		styleTemp.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		styleTemp.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		styleTemp.setBorderRight(HSSFCellStyle.BORDER_THIN);
		styleTemp.setBorderTop(HSSFCellStyle.BORDER_THIN);
		
		return styleTemp;
	}
	
	/**
	 * 取得内容单元格样式.
	 * <p><b>创建人：</b><br>&nbsp;&nbsp; 陈荣盛 2012-7-2 下午10:56:43<br>
	 * <p><b>修改人：</b><br>&nbsp;&nbsp; 2012-7-2 下午10:56:43<br>
	 * <p><b>修改说明：</b><br>&nbsp;&nbsp;<br>
	 * @param wb
	 * @return
	 */
	private static HSSFCellStyle getContentCellStyle(HSSFWorkbook wb){
		//创建单元格样式
		HSSFCellStyle styleTemp = wb.createCellStyle();
		
		//设置边框
		styleTemp.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		styleTemp.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		styleTemp.setBorderRight(HSSFCellStyle.BORDER_THIN);
		styleTemp.setBorderTop(HSSFCellStyle.BORDER_THIN);
		
		return styleTemp;
	}
	
	/**
	 * 创建单元格.
	 * <p><b>创建人：</b><br>&nbsp;&nbsp; 陈荣盛 2011-10-18 下午02:56:06<br>
	 * <p><b>修改人：</b><br>&nbsp;&nbsp; 2011-10-18 下午02:56:06<br>
	 * <p><b>修改说明：</b><br>&nbsp;&nbsp;<br>
	 * @param row			行
	 * @param cellNo		列号，从0开始
	 * @param cellContent	列内容
	 * @return	列
	 */
	private static HSSFCell createCell(HSSFRow row, HSSFCellStyle style, int cellNo, String cellContent){
		//创建第一列：注册号
		HSSFCell cell=row.createCell(cellNo);
		//将样式设置给单元格
		cell.setCellStyle(style);  
		//设置单元格的值
		HSSFRichTextString rts = new HSSFRichTextString(cellContent);
		cell.setCellValue(rts);
		
		return cell;
	}
	
	/**
	 * 创建单元格.
	 * <p><b>创建人：</b><br>&nbsp;&nbsp; 陈荣盛 2011-10-18 下午02:51:58<br>
	 * <p><b>修改人：</b><br>&nbsp;&nbsp; 2011-10-18 下午02:51:58<br>
	 * <p><b>修改说明：</b><br>&nbsp;&nbsp;<br>
	 * @param wb			工作簿
	 * @param sheet			工作表
	 * @param style		单位格样式
	 * @param row			行
	 * @param cellNo		列号，从0开始
	 * @param cellWidth		列宽
	 * @param cellContent	列内容
	 * @return	列对象
	 */
	private static HSSFCell createCell(HSSFWorkbook wb, HSSFSheet sheet, HSSFRow row, HSSFCellStyle style, 
		int cellNo, int cellWidth, String cellContent){
		//创建列
		HSSFCell cell=row.createCell(cellNo);
		//将样式设置给单元格
		cell.setCellStyle(style);  
		//设置列宽
		sheet.setColumnWidth(cellNo, cellWidth * 256);
		//设置单元格的值
		HSSFRichTextString rts = new HSSFRichTextString(cellContent);
		cell.setCellValue(rts);
		
		return cell;
	}
	
	/**
	 * 取得单元格数据.
	 * <p><b>创建人：</b><br>&nbsp;&nbsp; 陈荣盛 2011-8-15 下午05:07:00<br>
	 * <p><b>修改人：</b><br>&nbsp;&nbsp; 2011-8-15 下午05:07:00<br>
	 * <p><b>修改说明：</b><br>&nbsp;&nbsp;<br>
	 * @param cell	单元格对象
	 * @return	单元格数据，字符串
	 */
	@SuppressWarnings({ "deprecation", "unused" })
	private static String getCellStringValue(HSSFCell cell) {  
		if(cell == null) {
			return "";
		}
		
        String cellValue = "";      
        switch (cell.getCellType()) {      
        case HSSFCell.CELL_TYPE_STRING://字符串类型   
            cellValue = cell.getStringCellValue();      
            if(cellValue.trim().equals("")||cellValue.trim().length() <= 0)      
                cellValue = "";      
            break;      
        case HSSFCell.CELL_TYPE_NUMERIC: //数值类型   
        	// 判断当前的cell是否为Date   
            if (HSSFDateUtil.isCellDateFormatted(cell)){   
               // 如果是Date类型则，取得该Cell的Date值   
               Date date = cell.getDateCellValue();   
               
               SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
               cellValue = sdf.format(date);
            } else{  // 如果是纯数字   
            	DecimalFormat df = new DecimalFormat("#");//转换成整型
            	cellValue = String.valueOf(df.format(cell.getNumericCellValue()));     
            }
            break;      
        case HSSFCell.CELL_TYPE_FORMULA: //公式   
            cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);      
            cellValue = String.valueOf(cell.getNumericCellValue());      
            break;      
        case HSSFCell.CELL_TYPE_BLANK:      
            cellValue = "";      
            break;      
        case HSSFCell.CELL_TYPE_BOOLEAN:      
            break;      
        case HSSFCell.CELL_TYPE_ERROR:      
            break;      
        default:      
            break;      
        }   
        
        return cellValue;      
    }
	
	/**
	 * 导出报表.
	 * <p><b>创建人：</b><br>&nbsp;&nbsp; 陈荣盛 2012-7-6 下午11:43:57<br>
	 * <p><b>修改人：</b><br>&nbsp;&nbsp; 2012-7-6 下午11:43:57<br>
	 * <p><b>修改说明：</b><br>&nbsp;&nbsp;<br>
	 * @param response
	 * @param reportFileName	报表文件名
	 * @param colWidths			列宽度
	 * @param titles			标题列数组
	 * @param contents			内容数组
	 */
	public static void ExportReport(HttpServletResponse response, String reportFileName, 
		int[] colWidths, String[] titles, String[][] contents){
		//创建HSSFWorkbook对象
		HSSFWorkbook wb = new HSSFWorkbook();
		//创建HSSFSheet对象
		HSSFSheet sheet = wb.createSheet("sheet1");
		
		//取得标题单元格样式
		HSSFCellStyle styleTitle = getTitleCellStyle(wb);
		//创建HSSFRow对象
		HSSFRow row = sheet.createRow((short)0);
		row.setHeight((short) (1.5 * 256));
		//创建列头
		for(int i=0;i<colWidths.length;i++) {
			createCell(wb, sheet, row, styleTitle, i, colWidths[i], titles[i]);
		}
		
		if(contents != null && contents.length > 0) {
			//取得内容单元格样式
			HSSFCellStyle styleContent = getContentCellStyle(wb);

			for(int i=0;i<contents.length;i++) {
				//创建HSSFRow对象
				row = sheet.createRow((short)(i + 1));
				row.setHeight((short) (1.2 * 256));
				
				for(int j=0;j<contents[i].length;j++) {
					createCell(row, styleContent, j, contents[i][j]);
				}
			}
		}
		try	{
			//将Excel数据发送到客户端浏览器
			ExportFileUtil.writeToClient(response, wb, reportFileName + ".xls");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
//	/**
//	 * 取得旅客信息列表.
//	 * <p><b>创建人：</b><br>&nbsp;&nbsp; 陈荣盛 2014年10月16日 上午12:47:01<br>
//	 * <p><b>修改人：</b><br>&nbsp;&nbsp; 2014年10月16日 上午12:47:01<br>
//	 * <p><b>修改说明：</b><br>&nbsp;&nbsp;<br>
//	 * @param groupNo  团号
//	 * @param tourname 线路名称
//	 * @param custcode 客户代码
//	 * @param kickdate 日期
//	 * @param maker    制单人
//	 * @param idNos	        当前团队的身份证号列表字符串
//	 * @param fileName	文件名
//	 * @return	旅客信息列表，如果没有返回null
//	 */
//	@SuppressWarnings("static-access")
//	public static List<Personlst> getPersonlstList(String groupNo, String tourname, 
//		String custcode, String kickdate, String maker, String idNos, String fileName, 
//		List<Psptype> psptypeList){
//		try { 
//			POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(fileName)); 
//            // 创建工作簿 
//            HSSFWorkbook workBook = new HSSFWorkbook(fs); 
//            // 创建工作表 
//            HSSFSheet sheet = workBook.getSheetAt(0); 
//            // 获得行数 
//            int rows = sheet.getPhysicalNumberOfRows();
//                        
//            //判断是否大于1行(第一行为标题)
//            if (rows <= 1) {
//            	return null;
//            }
//            
//            String gdnoteno = "";
//            String name = "";
//            String familyname = "";
//            String givenname = "";
//            String sex = "";
//            String birthday = "";
//            String birthsite = "";
//            String passno = "";
//            String visatype = "";
//            String signsite = "";
//            String idno = "";
//            String suretype = "";
//            String suretypea = "";
//            String suretypeb = "";
//            String occupation = "";
//            String seatno = "";
//            String dept = "";
//            String skshNo = "待定";
//            String passtype = "";
//            boolean b = false;
//            
//    		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//    		Date d;
//    		Date kd;
//    		try {
//				kd = sdf.parse(kickdate);
//			} catch(Exception e) {
//				kd = sdf.parse("1900-01-01");
//			}
//    		
//    		IDCard idcard = new IDCard();
//            List<Personlst> pList = new ArrayList<Personlst>();
//            sheet.getMargin(HSSFSheet.TopMargin); 
//            for (int j = 1; j < rows; j++) { // 行循环
//            	gdnoteno = "";
//                name = "";
//                familyname = "";
//                givenname = "";
//                sex = "";
//                birthday = "";
//                birthsite = "";
//                passno = "";
//                visatype = "";
//                signsite = "";
//                idno = "";
//                suretype = "";
//                suretypea = "";
//                suretypeb = "";
//                occupation = "";
//                seatno = "";
//                dept = "";
//        		
//        		//取得当前行
//            	HSSFRow row = sheet.getRow(j); 
//            	if (row != null) { //行不为空
//            		//获得列数
//            		int cells = row.getLastCellNum(); 
//                    
//            		//判断列是否小于17列
//            		if (cells < 17) {
//                		return pList;
//            		}
//            		
//            		//报名编号列
//            		HSSFCell cell = row.getCell(0);
//            		if (cell != null) {
//            			gdnoteno = getCellStringValue(cell);
//            		}
//            		
//            		if("".equals(gdnoteno)) {//报名编号为空，表示已到最后一条，跳出循环
//            			break;
//            		}
//            		
//            		//姓名列
//            		cell = row.getCell(1);
//            		if (cell != null) {
//            			name = getCellStringValue(cell);
//            		}
//            		
//            		//英文姓列
//            		cell = row.getCell(2);
//            		if (cell != null) {
//            			familyname = getCellStringValue(cell);
//            		}
//            		
//            		//英文名列
//            		cell = row.getCell(3);
//            		if (cell != null) {
//            			givenname = getCellStringValue(cell);
//            		}
//            		
//            		//性别列
//            		cell = row.getCell(4);
//            		if (cell != null) {
//            			sex = getCellStringValue(cell);
//            		}
//            		
//            		//出生日期列
//            		cell = row.getCell(5);
//            		if (cell != null) {
//            			birthday = getCellStringValue(cell);
//            		}
//            		
//            		//出生地
//            		cell = row.getCell(6);
//            		if (cell != null) {
//            			birthsite = getCellStringValue(cell);
//            		}
//            		
//            		//证件类型
//            		cell = row.getCell(7);
//            		if (cell != null) {
//            			passtype = getCellStringValue(cell);
//            		}
//            		
//            		b = false;
//            		for (Psptype psptype : psptypeList) {
//						if (psptype.getPsptype().trim().equals(passtype))
//							b = true;
//					}
//            		
//            		if (!b) {
//            			passtype = "护照";
//            		}
//            		
//            		//护照号码
//            		cell = row.getCell(8);
//            		if (cell != null) {
//            			passno = getCellStringValue(cell);
//            		}
//            		
//            		//签证
//            		cell = row.getCell(9);
//            		if (cell != null) {
//            			visatype = getCellStringValue(cell);
//            		}
//
//            		//签发地
//            		cell = row.getCell(10);
//            		if (cell != null) {
//            			signsite = getCellStringValue(cell);
//            		}
//            		
//            		//身份证号
//            		cell = row.getCell(11);
//            		if (cell != null) {
//            			idno = getCellStringValue(cell);
//            		}
//            		
//            		if (!"外籍人士".equals(passtype)) {
//            			//身份证号已存在
//                		if(-1 != idNos.indexOf(idno.trim() + ",")) {
//                			continue;
//                		}
//                		
//                		//身份证号不合法
//                		if(!"".equals(idcard.IDCardValidate(idno.trim()))) {
//                			continue;
//                		}
//            		}
//            		
//            		//保险种类1
//            		cell = row.getCell(12);
//            		if (cell != null) {
//            			suretype = getCellStringValue(cell);
//            		}
//            		
//            		//保险种类3
//            		cell = row.getCell(13);
//            		if (cell != null) {
//            			suretypea = getCellStringValue(cell);
//            		}
//
//            		//保险种类3
//            		cell = row.getCell(14);
//            		if (cell != null) {
//            			suretypeb = getCellStringValue(cell);
//            		}
//
//            		//职业
//            		cell = row.getCell(15);
//            		if (cell != null) {
//            			occupation = getCellStringValue(cell);
//            		}
//            		
//            		//车座号
//            		cell = row.getCell(16);
//            		if (cell != null) {
//            			seatno = getCellStringValue(cell);
//            		}
//            		
//            		//收客部门
//            		cell = row.getCell(17);
//            		if (cell != null) {
//            			dept = getCellStringValue(cell);
//            		}
//
//            		try {
//        				d = sdf.parse(birthday);
//        			} catch(Exception e) {
//        				d = sdf.parse("1900-01-01");
//        			}
//            		Personlst p = new Personlst(skshNo, groupNo, name, familyname, givenname, 
//        				sex, passno, signsite, d, occupation, visatype, 
//        				birthsite, tourname, custcode, idno, kd, gdnoteno, 
//        				maker, seatno, dept, suretype, suretypea, suretypeb, "");
//            		
//					pList.add(p);
//            	}
//            }
//            
//            return pList;
//		} catch (Exception ex) { 
//    		return null;
//        } finally {
//        }
//	}
	
}
