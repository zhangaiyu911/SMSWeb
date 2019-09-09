package com.nkty.sms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nkty.sms.bean.MealCoupon;
import com.nkty.sms.service.MealCouponService;
import com.nkty.sms.util.TimeUtil;

@Controller
@RequestMapping(value="/coupon")
public class MealCouponController{
	
	@Autowired
	private MealCouponService service;
	
	
	@RequestMapping(value="/mealCoupon")
	public ModelAndView mealCoupon(HttpServletRequest request){
		System.out.println("进入餐券列表");
		List<MealCoupon> list = service.queryList();
		JSONArray object=JSONArray.fromObject(list);
		request.setAttribute("couponList", object);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/coupon/mealCoupon");
		return modelAndView;
	}
	
	
	@RequestMapping(value="/addMealCoupon")
	public ModelAndView addMealCoupon(HttpServletRequest request){
		System.out.println("打开添加餐票窗口");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/coupon/addMealCoupon");
		return modelAndView;
	}
	
	
	@RequestMapping("/saveMealCoupon")
	public String mealCoupon(HttpServletRequest request, HttpServletResponse response,MealCoupon mc) throws IOException{
		System.out.println(TimeUtil.getTimeNow()+"进入保存餐票方法。");
		response.setCharacterEncoding("utf-8");
		PrintWriter out =response.getWriter();
		System.out.println(mc.getCardName());
		mc.setCardName("'测试一号'");
		mc.setCardType(2);
		mc.setTotalMoney(null);
		mc.setServiceMoney(null);
		mc.setRealMoney(null);
		mc.setUseDate(null);
		service.saveMealCoupon(mc);
//		service.save(mc);
		System.out.println("插入成功!");
		out.flush();
		return null;
		
		
	}

	
	
	/**
	 * 将list集合转换成json字符串
	 * @param list
	 * @return
	 */
	/*public static JSONArray listToJSON(List<MealCoupon> list) {
		if(list != null){
			JSONArray array = new JSONArray();
			JSONObject jsonObject = null;
			MealCoupon mc = null;
			for(int i = 0;i<list.size();i++){
				mc = list.get(i);
				jsonObject = new JSONObject();
				jsonObject.put("cardName",mc.getCardName());
				jsonObject.put("cardType",mc.getCardType());
				jsonObject.put("realMoney",mc.getRealMoney());
				jsonObject.put("serviceMoney",mc.getServiceMoney());
				jsonObject.put("totalMoney",mc.getTotalMoney());
				jsonObject.put("useDate",mc.getUseDate());
				array.add(jsonObject);
			}
			
			return array;
		}else{
			return null;
		}
	}*/
}
