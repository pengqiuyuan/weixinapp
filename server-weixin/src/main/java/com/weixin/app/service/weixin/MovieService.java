package com.weixin.app.service.weixin;

import com.weixin.app.model.Page;
import com.weixin.app.model.PageRequest;
import com.weixin.app.model.conditions.MovieCondtions;
import com.weixin.app.model.weixin.Movie;

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
}
