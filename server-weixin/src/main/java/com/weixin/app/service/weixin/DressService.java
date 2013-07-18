package com.weixin.app.service.weixin;

import java.util.List;

import com.weixin.app.model.conditions.DressConditions;
import com.weixin.app.model.weixin.Dress;
import com.weixin.app.orm.Page;
import com.weixin.app.orm.PageRequest;

/**
 * 服饰类的接口
 * @author pengqiuyuan
 *
 */
public interface DressService {

	/**
	 * �?��服饰列表，分�?	 * 根据项目查询条件查询结构列表，带分页参数
	 */
	public Page<Dress> findDressByCond(DressConditions cond, PageRequest pageRequest);
	/**
	 * 根据项目查询条件结构列表
	 * @param cond
	 * @return
	 */
	public List<Dress> findDressByCond(DressConditions cond);
	
	public Page<Dress> findDress(DressConditions cond,Page<Dress> page);
	/**
	 * 保存
	 * @param dress
	 */
	public void saveDress(Dress dress);
	/**
	 * 修改
	 * @param dress
	 */
	public void update(Dress dress);
	/**
	 * 删除
	 * @param dress
	 */
	public void delede(Integer id);
	/**
	 * 通过id查找
	 * @param id
	 * @return
	 */
	public Dress findByDressId(Integer id);
	/**
	 * 通过name查询
	 */
	public Dress findByDressName(String id);
}
