package com.weixin.app.web.controller.mgr.weixin;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.weixin.app.service.weixin.FoodService;
import com.weixin.app.web.controller.mgr.BaseController;
/**
 * 美食管理
 * @author pengqiuyuan
 *
 */
@Controller
@RequestMapping("/mgr/weixin/food/*")
public class FoodController extends  BaseController{

	private final static Logger logger = LoggerFactory.getLogger(FoodController.class);
	
	@Resource(name = "foodService")
	private FoodService foodService;
	
}
