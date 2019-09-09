package com.nkty.sms.dao.impl;

import org.springframework.stereotype.Repository;

import com.nkty.sms.bean.MealCoupon;
import com.nkty.sms.dao.MealCouponDao;

@Repository(value="mealCouponDaoImpl")
public class MealCouponDaoImpl extends BaseDaoImpl<MealCoupon,Integer> implements MealCouponDao {

}
