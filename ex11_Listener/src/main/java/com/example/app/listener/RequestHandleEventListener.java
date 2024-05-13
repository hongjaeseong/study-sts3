package com.example.app.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.web.context.support.RequestHandledEvent;

// 사용자의 요청이 들어왔을 때 요청을 감지하는 리스너를 만드는 작업


public class RequestHandleEventListener implements ApplicationListener<RequestHandledEvent> {
	// RequestHandledEvent : 이것이 계속 변경됨
	
	@Override
	public void onApplicationEvent(RequestHandledEvent event) {
		System.out.println("[RequestHandledEvent] EVENT : " + event.getSource());
		
	}

}
