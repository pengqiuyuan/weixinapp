package com.weixin.app.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.weixin.app.model.weixin.Dress;
import com.weixin.app.orm.HibernateDao;
@Repository("dressDao")
public class DressDao extends HibernateDao<Dress, Integer>{

}
