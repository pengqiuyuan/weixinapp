package com.weixin.app.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.weixin.app.model.weixin.Food;
import com.weixin.app.orm.HibernateDao;
@Repository("foodDao")
public class FoodDao extends HibernateDao<Food, Integer>{

}
