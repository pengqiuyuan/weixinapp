package com.weixin.app.service.weixin;

import com.weixin.app.model.Page;
import com.weixin.app.model.PageRequest;
import com.weixin.app.model.conditions.DressConditions;
import com.weixin.app.model.weixin.Dress;

/**
 * 服饰类的接口
 * @author pengqiuyuan
 *
 */
public interface DressService {

	/**
	 * 所有服饰列表，分页
	 * 根据项目查询条件查询结构列表，带分页参数
	 */
	public Page<Dress> findDressByCond(DressConditions cond, PageRequest pageRequest);
}
