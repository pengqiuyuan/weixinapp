package com.weixin.app.web.controller.mgr.mobile;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.weixin.app.base.AppBizException;
import com.weixin.app.web.controller.mgr.BaseController;

public class BasePortalController {
	
	private static Logger logger = LoggerFactory.getLogger(BaseController.class);
	
	@ExceptionHandler({Exception.class, AppBizException.class})
	public ModelAndView handleException(Exception ex, HttpServletRequest request) {
	  
		logger.error("Exception:", ex);
		ModelAndView mav = new ModelAndView();
		mav.addObject("message", ex.getMessage());
		
		mav.setViewName("error");
		
		return mav;
	}
}
