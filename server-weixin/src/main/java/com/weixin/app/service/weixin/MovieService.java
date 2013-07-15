package com.weixin.app.service.weixin;

import java.util.List;

import com.weixin.app.model.conditions.MovieCondtions;
import com.weixin.app.model.weixin.Movie;
import com.weixin.app.orm.Page;
import com.weixin.app.orm.PageRequest;

/**
 * 电影类的接口
 * @author asus
 *
 */
public interface MovieService {
	/**
	 * 所有服饰列表，分页
	 * 根据项目查询条件查询结构列表，带分页参数
	 */
	public Page<Movie> findDressByCond(MovieCondtions cond, PageRequest pageRequest);
	/**
	 * 根据项目查询条件结构列表
	 * @param cond
	 * @return
	 */
	public List<Movie> findMovieByCond(MovieCondtions cond);
	
	public Page<Movie> findMovie(MovieCondtions cond,Page<Movie> page);
	/**
	 * 保存
	 * @param 
	 */
	public void saveMovie(Movie movie);
	/**
	 * 修改
	 * @param 
	 */
	public void updateMovie(Movie movie);
	/**
	 * 删除
	 * @param
	 */
	public void deleteMovie(Integer id);
	/**
	 * 通过name查询
	 */
	public Movie findByMovieName(Movie movie);
	/**
	 * 通过id查找
	 * @param id
	 * @return
	 */
	public Movie findByMovieId(Integer id);
}
