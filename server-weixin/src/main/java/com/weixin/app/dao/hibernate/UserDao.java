package com.weixin.app.dao.hibernate;

import org.springframework.stereotype.Repository;
import com.weixin.app.model.User;
import com.weixin.app.orm.HibernateDao;

/**
 * 管理用户数据处理
 * @author pengqiuyuan 
 *
 */
@Repository("userDao")
public class UserDao extends HibernateDao<User, Integer> {

}
