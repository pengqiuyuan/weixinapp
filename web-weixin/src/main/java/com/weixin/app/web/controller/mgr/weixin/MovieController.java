package com.weixin.app.web.controller.mgr.weixin;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.weixin.app.base.AppBizException;
import com.weixin.app.model.conditions.MovieCondtions;
import com.weixin.app.model.weixin.Movie;
import com.weixin.app.orm.Page;
import com.weixin.app.service.weixin.MovieService;
import com.weixin.app.web.controller.mgr.BaseController;
/**
 * 电影管理
 * @author pengqiuyuan
 *
 */
@Controller
@RequestMapping("/mgr/weixin/movie/*")
public class MovieController extends BaseController{

	private final static Logger logger = LoggerFactory.getLogger(MovieController.class);
	
	@Resource(name = "movieService")
	private MovieService movieService;
	
	@RequestMapping(value = "/index",method=RequestMethod.GET)
	public ModelAndView movieIndex(@ModelAttribute("movieCondtions")MovieCondtions condtions,@ModelAttribute("pages")Page<Movie> page)throws AppBizException{
		ModelAndView mav = new ModelAndView();
		
		return mav;
	}
}
