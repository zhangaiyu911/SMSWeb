package com.nkty.sms.util;

import java.util.ArrayList;
import java.util.List;

public class STRUtil {
	/*
	 * 生成x位随机字符串
	 */
	public static String getRadX(int x) {
		List<String> chars = new ArrayList<String>();
		String result = "";
		for(int i=0;i<62;i++){
			if(i<10){
				chars.add(""+i);
			}else if(i<36){
				chars.add(""+(char)(i+55));
			}else{
				chars.add(""+(char)(i+61));
			}
		}
		for(int i=0;i<x;i++){
			int rdm= (int) (Math.random()*62);
			result+= chars.get(rdm);
		}
		return result;
	}
}
