package com.weixin.app.web.controller.mgr.weixin;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.weixin.app.service.weixin.DressService;
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
}
