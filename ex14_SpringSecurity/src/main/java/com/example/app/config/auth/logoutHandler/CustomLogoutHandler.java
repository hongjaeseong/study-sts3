package com.example.app.config.auth.logoutHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;

public class CustomLogoutHandler implements LogoutHandler {

	// 로그아웃 작접
	@Override
	public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
		System.out.println("CustomLououtHandler's logout() invoke...");
		// 세션 초기화
		HttpSession session = (HttpSession)request.getSession(false);
		if(session!=null)
				session.invalidate();
		
	}

}
