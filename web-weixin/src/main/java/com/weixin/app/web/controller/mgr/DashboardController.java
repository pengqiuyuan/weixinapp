package com.weixin.app.web.controller.mgr;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/mgr/*")
public class DashboardController {

	private static final Logger logger = LoggerFactory.getLogger(DashboardController.class);
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
    public String home() {
		logger.debug("admin dashboard views loaded.");
        return "index";
    } 
	
}
