package com.example.app.domain.service;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SimpleServiceImpl {

	// aop 사용해서 부수적으로 들어가는 코드를 생략해보기
	
	public void get1() {
		log.info("SimpleServiceImpl get1..");
	}
	
	public void get2() {
		log.info("SimpleServiceImpl get2..");
	}
	
	public int get3() {
		log.info("SimpleServiceImpl get3..");
		return 101;
	}
}
