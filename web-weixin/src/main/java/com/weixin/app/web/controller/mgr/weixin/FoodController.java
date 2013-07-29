package com.weixin.app.web.controller.mgr.weixin;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.weixin.app.base.AppBizException;
import com.weixin.app.model.conditions.FoodConditions;
import com.weixin.app.model.conditions.MovieCondtions;
import com.weixin.app.model.weixin.Food;
import com.weixin.app.model.weixin.Movie;
import com.weixin.app.orm.Page;
import com.weixin.app.service.weixin.FoodService;
import com.weixin.app.util.DateQueryIndex;
import com.weixin.app.web.support.DateIndexEditor;
/**
 * 美食管理
 * @author pengqiuyuan
 *
 */
@Controller
@RequestMapping("/mgr/weixin/food/*")
public class FoodController {

	private final static Logger logger = LoggerFactory.getLogger(FoodController.class);
	
	@Resource(name = "foodService")
	private FoodService foodService;
	
	@InitBinder
	protected void initBinder(ServletRequestDataBinder binder){
		binder.registerCustomEditor(Date.class,"startDate",new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
		binder.registerCustomEditor(Date.class,"overDate",new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
		binder.registerCustomEditor(Date.class,"pubDate",new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
		binder.registerCustomEditor(DateQueryIndex.class,new DateIndexEditor());
	}
	
	@RequestMapping(value = "/index",method=RequestMethod.GET)
	public ModelAndView movieIndex(@ModelAttribute("foodCondtions")FoodConditions condtions,@ModelAttribute("pages")Page<Food> page)throws AppBizException{
		page.setPageSize(10);
		Page<Food> movies = this.foodService.findFood(condtions, page);
		ModelAndView mav = new ModelAndView("games/food/index");
		mav.addObject("page",movies);
		return mav;
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public ModelAndView add() {
		ModelAndView mav=new ModelAndView();
		Food food=new Food();
		mav.addObject("food",food);
		mav.setViewName("games/food/add");
		return mav;
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String onCreate(@ModelAttribute("food") Food food,BindingResult result,SessionStatus status){
		ModelAndView mav = new ModelAndView();
		foodService.saveFood(food);
		return "redirect:/mgr/weixin/food/index";
	}
	
	@RequestMapping(value="/{id}/delete",method=RequestMethod.GET)
	public String delete(@PathVariable final Integer id){
		this.foodService.deleteFood(id);
		return "redirect:/mgr/weixin/food/index";
	}
	
	@RequestMapping(value="/{id}/get",method=RequestMethod.GET)
	public ModelAndView get(@PathVariable final Integer id) throws AppBizException{
		ModelAndView mav=new ModelAndView();
		Food food = this.foodService.findByFoodId(id);
		mav.addObject("food",food);
		mav.setViewName("games/food/show");
		return mav;
	}
	
	@RequestMapping(value="/{id}/edit",method=RequestMethod.GET)
	public ModelAndView edit(@PathVariable final Integer id){
		ModelAndView mav=new ModelAndView();
		Food food = this.foodService.findByFoodId(id);
		mav.addObject("food",food);
		mav.setViewName("games/food/add");
		return mav;
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(@ModelAttribute Food food,BindingResult result,SessionStatus status) throws AppBizException{
		ModelAndView mav=new ModelAndView();
		this.foodService.updateFood(food);
		return "redirect:/mgr/weixin/food/index";
	}
	
}
