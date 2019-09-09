package com.nkty.sms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nkty.sms.bean.MealCoupon;
import com.nkty.sms.dao.MealCouponDao;
import com.nkty.sms.service.MealCouponService;

@Service
public class MealCouponServiceImpl extends BaseServiceImpl<MealCoupon,Integer> implements MealCouponService {

	
	@Autowired
	private MealCouponDao mealCouponDao;

	@Override
	public List<MealCoupon> queryList() {
		String sql1 = "SELECT mc FROM MealCoupon mc";
		List<MealCoupon> list = mealCouponDao.findList(sql1, null);
//		String sql2 = "SELECT * FROM MealCoupon";
//		List<MealCoupon> list = mealCouponDao.findList(sql2);
		return list;
	}

	@Override
	public MealCoupon queryOne(int id) {
		String sql = "select m from MealCoupon m where id = "+id;
		MealCoupon mc = mealCouponDao.find(id);
		return mc;
	}

	@Override
	public void saveMealCoupon(MealCoupon mc) {
		String sql = "update m from MealCoupon m set m.cardName="+mc.getCardName()+" and m.cardType="+mc.getCardType()+
				" and m.totalMoney="+mc.getTotalMoney()+" and m.serviceMoney="+mc.getServiceMoney()+" and m.realMoney="+mc.getRealMoney()+
				" and m.useDate="+mc.getUseDate();
		mealCouponDao.findList(sql, null);
		
//		mealCouponDao.execProcedure(sql);
//		mealCouponDao.execute(sql, null);
		
	}
	
	
}
