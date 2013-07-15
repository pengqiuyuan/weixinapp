package com.weixin.app.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.weixin.app.dao.hibernate.MovieDao;
import com.weixin.app.model.conditions.MovieCondtions;
import com.weixin.app.model.weixin.Movie;
import com.weixin.app.orm.Page;
import com.weixin.app.orm.PageRequest;
import com.weixin.app.service.weixin.MovieService;

/**
 * 电影服务的实现
 * @author pengqiuyuan
 *
 */
@Service("movieService")
@Transactional(readOnly = false)
public class MovieServiceImpl implements MovieService{

	protected static Logger logger = LoggerFactory.getLogger(MovieServiceImpl.class);
	
	@Resource(name = "movieDao")
	private MovieDao movieDao;
	
	@Override
	public Page<Movie> findDressByCond(MovieCondtions cond,
			PageRequest pageRequest) {
		// TODO Auto-generated method stub
		return movieDao.excuteSimpleQuery(cond, pageRequest);
	}

	@Override
	public List<Movie> findMovieByCond(MovieCondtions cond) {
		// TODO Auto-generated method stub
		return movieDao.excuteSimpleQuery(cond);
	}

	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	public void saveMovie(Movie movie) {
		// TODO Auto-generated method stub
		Assert.notNull(movie.getName() , "name 必须输入");
		movieDao.save(movie);
	}

	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	public void updateMovie(Movie movie) {
		// TODO Auto-generated method stub
		Movie mov = this.movieDao.get(movie.getId());
		mov.setActor(movie.getActor());
		mov.setAddress(movie.getAddress());
		mov.setCountry(movie.getCountry());
		mov.setDirector(movie.getDirector());
		mov.setDuration(movie.getDuration());
		mov.setDiscount(movie.getDiscount());
		mov.setDiscountRules(movie.getDiscountRules());
		mov.setLatitude(movie.getLatitude());
		mov.setLongitude(movie.getLongitude());
		mov.setFocus(movie.getFocus());
		mov.setLanguage(movie.getLanguage());
		mov.setPubDate(movie.getPubDate());
		mov.setName(movie.getName());
		mov.setOverDate(movie.getOverDate());
		mov.setRating(movie.getRating());
		mov.setSummary(movie.getSummary());
		mov.setStartDate(movie.getStartDate());
		mov.setThumbail(movie.getThumbail());
		mov.setType(movie.getType());
		movieDao.update(mov);
	}

	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	public void deleteMovie(Integer id) {
		// TODO Auto-generated method stub
		Assert.notNull(id,"id 必须输入");
		movieDao.delete(id);
	}

	@Override
	public Movie findByMovieName(Movie movie) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Movie findByMovieId(Integer id) {
		// TODO Auto-generated method stub
		Assert.notNull(id,"id 必须输入");
		return movieDao.get(id);
	}

}
