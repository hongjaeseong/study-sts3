package com.example.app.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.example.app.domain.dto.MemoDto;
import com.example.app.domain.service.MemoServiceImpl;
import com.example.app.domain.service.SimpleServiceImpl;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@WebAppConfiguration
@Slf4j
public class aopTests {
	
	@Autowired
	private SimpleServiceImpl simpleServiceImpl;
	@Autowired
	private MemoServiceImpl memoServiceImpl; 
	
	@Test
	public void test() {
		simpleServiceImpl.get1();
	}
	@Test
	public void test2() {
		simpleServiceImpl.get2();
	}
	@Test
	public void test3() {
		int result =  simpleServiceImpl.get3();
		log.info("TEST3  : "  + result);
	}
	@Test
	public void test4() throws Exception {
		boolean result = memoServiceImpl.memoRegistration(new MemoDto(1105,"HONG"));
		log.info("TEST4 : " + result);
	}

}
