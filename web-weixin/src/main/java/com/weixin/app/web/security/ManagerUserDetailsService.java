package com.weixin.app.web.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import com.weixin.app.base.SessionContext;
import com.weixin.app.dao.hibernate.UserDao;
import com.weixin.app.model.User;

public class ManagerUserDetailsService implements UserDetailsService {
	
	private static Logger logger = LoggerFactory.getLogger(ManagerUserDetailsService.class);
	
	private UserDao userDao;
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String arg0)
			throws UsernameNotFoundException {
		
		
		User user = userDao.findUniqueBy("loginName", arg0);
		if( user == null){
			throw new UsernameNotFoundException("用户名或密码错误");
		}
		
		// from User object to SessionContext object.
		SessionContext sc = new SessionContext();
		sc.setContextUserId(user.getId());
		sc.setContextUserName(user.getLoginName());
		sc.setContextUserPassword(user.getPassword());
		sc.setContextUserRoles(user.getRoles());
		sc.setContextUserEmail(user.getEmail());
		
		logger.debug("found auth user:" + user.getLoginName());
		return sc;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
