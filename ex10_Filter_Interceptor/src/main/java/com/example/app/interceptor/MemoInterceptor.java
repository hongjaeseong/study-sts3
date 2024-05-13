package com.example.app.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

// bean 등록 필요 없음. 즉, 어노테이션 불필요
// MvcConfig에 등록 필요 > WebMvcConfig.java
public class MemoInterceptor implements HandlerInterceptor {
	
	// MemoController로 이동하기 전 처리되는 로직
	// return false라면 MemoController로 이동하지 못한다.
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("[MemoInterceptor] preHandle() invoke..");
		return true;	// false라면 MemoController로 이동 불가 
	}
	
	// MemoController의 작업이 끝난 이후 처리되는 로직
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("[MemoInterceptor] postHandle() invoke..");
	}
	
	// View Page 랜더링 된 이후 처리되는 로직
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("[MemoInterceptor] afterCompletion() invoke..");
	}
	
	
}
