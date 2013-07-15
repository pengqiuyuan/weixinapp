package com.weixin.app.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.weixin.app.dao.hibernate.DressDao;

import com.weixin.app.model.conditions.DressConditions;
import com.weixin.app.model.weixin.Dress;
import com.weixin.app.orm.Page;
import com.weixin.app.orm.PageRequest;
import com.weixin.app.service.weixin.DressService;

/**
 * 服饰服务的实现 
 * @author pengqiuyuan
 *
 */
@Service("dressService")
@Transactional(readOnly = false)
public class DressServiceImpl implements DressService{
	
	protected static Logger logger = LoggerFactory.getLogger(DressServiceImpl.class);
	
	@Resource(name = "dressDao")
	private DressDao dressDao;
	
	@Override
	public Page<Dress> findDressByCond(DressConditions cond,
			PageRequest pageRequest) {
		// TODO Auto-generated method stub
		return dressDao.excuteSimpleQuery(cond, pageRequest);
	}

	@Override
	public List<Dress> findDressByCond(DressConditions cond) {
		// TODO Auto-generated method stub
		return dressDao.excuteSimpleQuery(cond);
	}

	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	public void saveDress(Dress dress) {
		// TODO Auto-generated method stub
		Assert.notNull(dress.getName() , "name 必须输入");
		dressDao.save(dress);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	public void update(Dress dress) {
		// TODO Auto-generated method stub
		Dress dre = this.dressDao.get(dress.getId());
		dre.setAddress(dress.getAddress());
		dre.setDiscount(dress.getDiscount());
		dre.setDiscountRules(dress.getDiscountRules());
		dre.setDressRecommend(dress.getDressRecommend());
		dre.setLatitude(dress.getLatitude());
		dre.setLongitude(dress.getLongitude());
		dre.setName(dress.getName());
		dre.setOverDate(dress.getOverDate());
		dre.setRating(dress.getRating());
		dre.setStartDate(dress.getStartDate());
		dre.setThumbail(dress.getThumbail());
		this.dressDao.update(dre);
	}

	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	public void delede(Integer id) {
		// TODO Auto-generated method stub
		Assert.notNull(id,"id 必须输入");
		dressDao.delete(id);
		
	}

	@Override
	public Dress findByDressId(Integer id) {
		// TODO Auto-generated method stub
		Assert.notNull(id,"id必须输入");
		return dressDao.get(id);
	}

	@Override
	public Dress findByDressName(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
