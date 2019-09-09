package com.nkty.sms.service;

import java.util.List;

import com.nkty.sms.bean.MealCoupon;

public interface MealCouponService extends BaseService<MealCoupon,Integer>{
	
	List<MealCoupon> queryList();
	
	MealCoupon queryOne(int id);
	
	void saveMealCoupon(MealCoupon mc);
	

}
