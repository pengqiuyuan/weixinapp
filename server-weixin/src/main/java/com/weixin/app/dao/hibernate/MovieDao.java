package com.weixin.app.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.weixin.app.model.weixin.Movie;
import com.weixin.app.orm.HibernateDao;
@Repository("movieDao")
public class MovieDao extends HibernateDao<Movie, Integer>{

}
