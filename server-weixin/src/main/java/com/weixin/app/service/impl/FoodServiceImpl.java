package com.weixin.app.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.weixin.app.dao.hibernate.FoodDao;
import com.weixin.app.model.conditions.FoodConditions;
import com.weixin.app.model.weixin.Food;
import com.weixin.app.orm.Page;
import com.weixin.app.orm.PageRequest;
import com.weixin.app.service.weixin.FoodService;


/**
 * 美食服务的实�? * @author pengqiuyuan
 *
 */
@Service("foodService")
@Transactional(readOnly = false)
public class FoodServiceImpl implements FoodService{
	
	protected static Logger logger = LoggerFactory.getLogger(FoodServiceImpl.class);
	
	@Resource(name = "foodDao")
	private FoodDao foodDao;

	@Override
	public Page<Food> findFoodByCond(FoodConditions cond,
			PageRequest pageRequest) {
		// TODO Auto-generated method stub
		return foodDao.excuteSimpleQuery(cond, pageRequest);
	}

	@Override
	public List<Food> findFoodByCond(FoodConditions cond) {
		// TODO Auto-generated method stub
		return foodDao.excuteSimpleQuery(cond);
	}

	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	public void saveFood(Food food) {
		// TODO Auto-generated method stub
		Assert.notNull(food.getName() , "name 必须输入");
		foodDao.save(food);
	}

	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	public void updateFood(Food food) {
		// TODO Auto-generated method stub
		Food fo = this.foodDao.get(food.getId());
		fo.setAddress(food.getAddress());
		fo.setDiscount(food.getDiscount());
		fo.setDiscountRules(food.getDiscountRules());
		fo.setFoodRecommend(food.getFoodRecommend());
		fo.setLatitude(food.getLatitude());
		fo.setLongitude(food.getLongitude());
		fo.setName(food.getName());
		fo.setOverDate(food.getOverDate());
		fo.setRating(food.getRating());
		fo.setStartDate(food.getStartDate());
		fo.setThumbail(food.getThumbail());
		fo.setLargeThumbail(food.getLargeThumbail());
		this.foodDao.update(fo);
	}

	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	public void deleteFood(Integer id) {
		// TODO Auto-generated method stub
		Assert.notNull(id,"id 必须输入");
		foodDao.delete(id);
	}

	@Override
	public Food findByFoodName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Food findByFoodId(Integer id) {
		// TODO Auto-generated method stub
		Assert.notNull(id,"id 必须输入");
		return foodDao.get(id);
	}

	@Override
	public Page<Food> findFood(FoodConditions cond, Page<Food> page) {
		// TODO Auto-generated method stub
		return foodDao.excuteSimpleQuery(cond, page);
	}

}
