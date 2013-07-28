package com.weixin.app.web.controller.mgr.mobile.weixin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


/**
 * 提供微信公众平台的html页面的控制器
 * @author pengqiuyuan
 *
 */
@Controller("mobileWeixinController")
@RequestMapping("/mobile/weixin/*")
public class GamePlayController {
	
	private static Logger logger = LoggerFactory.getLogger(GamePlayController.class);
	
	@RequestMapping(value="/play",method=RequestMethod.GET)
	public ModelAndView index(@RequestParam(value = "id", required = true) Integer id) throws Exception{
		ModelAndView mav = new ModelAndView();
		
		return mav;
	}
	
}
