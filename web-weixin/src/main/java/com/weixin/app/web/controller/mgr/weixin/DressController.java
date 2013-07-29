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
import com.weixin.app.model.conditions.DressConditions;
import com.weixin.app.model.weixin.Dress;
import com.weixin.app.orm.Page;
import com.weixin.app.service.weixin.DressService;
import com.weixin.app.util.DateQueryIndex;
import com.weixin.app.web.support.DateIndexEditor;
/**
 * 服饰管理
 * @author pengqiuyuan
 *
 */
@Controller
@RequestMapping("/mgr/weixin/dress/*")
public class DressController{
	
	private  final static Logger logger = LoggerFactory.getLogger(DressController.class);
	
	@Resource(name = "dressService")
	private DressService dressService;
	
	@InitBinder
	protected void initBinder(ServletRequestDataBinder binder){
		binder.registerCustomEditor(Date.class,"startDate",new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
		binder.registerCustomEditor(Date.class,"overDate",new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
		binder.registerCustomEditor(Date.class,"pubDate",new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
		binder.registerCustomEditor(DateQueryIndex.class,new DateIndexEditor());
	}
	
	@RequestMapping(value = "/index",method=RequestMethod.GET)
	public ModelAndView movieIndex(@ModelAttribute("dressCondtions")DressConditions condtions,@ModelAttribute("pages")Page<Dress> page)throws AppBizException{
		page.setPageSize(10);
		Page<Dress> dress = this.dressService.findDress(condtions, page);
		ModelAndView mav = new ModelAndView("games/dress/index");
		mav.addObject("page",dress);
		return mav;
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public ModelAndView add() {
		ModelAndView mav=new ModelAndView();
		Dress dress = new Dress();
		mav.addObject("dress",dress);
		mav.setViewName("games/dress/add");
		return mav;
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String onCreate(@ModelAttribute("dress") Dress dress,BindingResult result,SessionStatus status){
		dressService.saveDress(dress);
		return "redirect:/mgr/weixin/dress/index";
	}
	
	@RequestMapping(value="/{id}/delete",method=RequestMethod.GET)
	public String delete(@PathVariable final Integer id){
		this.dressService.delede(id);
		return "redirect:/mgr/weixin/dress/index";
	}
	
	@RequestMapping(value="/{id}/get",method=RequestMethod.GET)
	public ModelAndView get(@PathVariable final Integer id) throws AppBizException{
		ModelAndView mav=new ModelAndView();
		Dress dress = this.dressService.findByDressId(id);
		mav.addObject("dress",dress);
		mav.setViewName("games/dress/show");
		return mav;
	}
	
	@RequestMapping(value="/{id}/edit",method=RequestMethod.GET)
	public ModelAndView edit(@PathVariable final Integer id){
		ModelAndView mav=new ModelAndView();
		Dress dress = this.dressService.findByDressId(id);
		mav.addObject("dress",dress);
		mav.setViewName("games/dress/add");
		return mav;
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(@ModelAttribute Dress dress,BindingResult result,SessionStatus status) throws AppBizException{
		this.dressService.update(dress);
		return "redirect:/mgr/weixin/dress/index";
	}
	
}
