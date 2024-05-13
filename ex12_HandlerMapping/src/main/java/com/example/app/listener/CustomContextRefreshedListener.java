package com.example.app.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.web.context.support.RequestHandledEvent;

// 새로고침 할때마다 감지하는 리스너를 생성
public class CustomContextRefreshedListener implements ApplicationListener<ContextRefreshedEvent>{

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		System.out.println("[ContextRefreshedEvent] EVENT : " + event.getSource());
		
	}
	
	

}
