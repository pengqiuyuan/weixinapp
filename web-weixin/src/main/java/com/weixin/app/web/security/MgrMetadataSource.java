package com.weixin.app.web.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.DefaultFilterInvocationSecurityMetadataSource;

@Deprecated
public class MgrMetadataSource extends DefaultFilterInvocationSecurityMetadataSource {

	public MgrMetadataSource(){
		super(null);
	}
	
	@Override
	public Collection<ConfigAttribute> getAttributes(Object object)
			throws IllegalArgumentException {
		return null;
	}

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return Collections.unmodifiableCollection(new ArrayList<ConfigAttribute>());
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return FilterInvocation.class.isAssignableFrom(clazz);
	}

}
