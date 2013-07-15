package com.weixin.app.service.weixin;

import java.util.List;

import com.weixin.app.model.conditions.FoodConditions;
import com.weixin.app.model.weixin.Food;
import com.weixin.app.orm.Page;
import com.weixin.app.orm.PageRequest;

/**
 * 美食类的接口
 * @author pengqiuyuan
 *
 */
public interface FoodService {
	/**
	 * 所有服饰列表，分页
	 * 根据项目查询条件查询结构列表，带分页参数
	 */
	public Page<Food> findFoodByCond(FoodConditions cond, PageRequest pageRequest);
	/**
	 * 根据项目查询条件结构列表
	 * @param cond
	 * @return
	 */
	public List<Food> findFoodByCond(FoodConditions cond);
	
	public Page<Food> findFood(FoodConditions cond,Page<Food> page);
	/**
	 * 保存
	 * @param 
	 */
	public void saveFood(Food food);
	/**
	 * 修改
	 * @param 
	 */
	public void updateFood(Food food);
	/**
	 * 删除
	 * @param
	 */
	public void deleteFood(Integer id);
	/**
	 * 通过name查询
	 */
	public Food findByFoodName(String name);
	/**
	 * 通过id查找
	 * @param id
	 * @return
	 */
	public Food findByFoodId(Integer id);
}
