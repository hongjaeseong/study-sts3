package com.example.app.scheduled;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component	// component 스캔을 실행에 bean에 주입 (component 스캔을 수행하게 작업 root-context.xml에서 작업)
@EnableScheduling		// 스케쥴링 가능하게 하는 어노테이션
public class Scheduling {
	
	// 1초마다 반복 실행
//	@Scheduled(fixedRate=1000)
//	public void t1() {
//		System.out.println("@Scheduled's t1() invoke!!");
//	}
	
	// 크론식을 이용해서 반복 실행
//	@Scheduled(cron="*/20 * * * * *")
//	public void t2() {
//		System.out.println("@Scheduled's t2() invoke!!");
//	}

}
// 크론식
//
