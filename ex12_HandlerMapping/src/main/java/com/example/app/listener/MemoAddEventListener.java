package com.example.app.listener;

import org.springframework.context.ApplicationListener;

public class MemoAddEventListener implements ApplicationListener<MemoAddEvent>{

	@Override
	public void onApplicationEvent(MemoAddEvent event) {
		System.out.println("[EVENT] MemoAdd : " + event);
		
	}

}
