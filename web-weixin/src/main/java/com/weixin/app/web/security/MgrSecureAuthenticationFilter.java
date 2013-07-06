package com.weixin.app.web.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

public class MgrSecureAuthenticationFilter extends AbstractAuthenticationProcessingFilter{

    private static Logger logger = LoggerFactory.getLogger(MgrSecureAuthenticationFilter.class);
    public static final String SPRING_SECURITY_FORM_USERNAME_KEY = "j_username";
    public static final String SPRING_SECURITY_FORM_PASSWORD_KEY = "j_password";
    private String usernameParameter = SPRING_SECURITY_FORM_USERNAME_KEY;
    private String passwordParameter = SPRING_SECURITY_FORM_PASSWORD_KEY;

    public MgrSecureAuthenticationFilter() {
        super("/mgr/login_check");
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        logger.debug("start attempt authentication...");
    	request.setCharacterEncoding("UTF-8");
        String username = obtainUsername(request);
        String password = obtainPassword(request);

        if (username == null) {
            username = "";
        }

        if (password == null) {
            password = "";
        }
        //TODO 加入验证码
        
        username = username.trim();

        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);

        authRequest.setDetails(authenticationDetailsSource.buildDetails(request));

        return this.getAuthenticationManager().authenticate(authRequest);
    }


    protected String obtainPassword(HttpServletRequest request) {
        return request.getParameter(passwordParameter);
    }

    protected String obtainUsername(HttpServletRequest request) {
        return request.getParameter(usernameParameter);
    }
}
