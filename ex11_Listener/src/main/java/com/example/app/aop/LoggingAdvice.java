package com.example.app.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class LoggingAdvice {
	
	// 포인트컷 표현식 (포인트컷 위치 지정)
	// "execution(* com.example.app.domain.service.SimpleServiceImpl.get1())"
	// execution : 메서드 실행
	// * : 모든 리턴 타입
	// com.example.app.domain.service.SimpleServiceImpl.get1() : 실행할 함수 위치
	// get1() 메소드 이전에 처리할 메소드
	@Before("execution(* com.example.app.domain.service.SimpleServiceImpl.get1())")
	public void logBefore(JoinPoint joinPoint) {
		// joinPoint에 포인트 컷 위치가 저장됨
		log.info("[AOP] BEFORE.." + joinPoint);
	}
	
	// get2() 메소드 이후에 처리할 메소드
	@After("execution(* com.example.app.domain.service.SimpleServiceImpl.get2())")
	public void logAfter(JoinPoint joinPoint) {
		log.info("[AOP] AFTER.." + joinPoint);							// 포인트컷 위치
		log.info("[AOP] AFTER.." + joinPoint.getTarget());				// method location
		log.info("[AOP] AFTER.." + joinPoint.getSignature()); 			// method signature
		log.info("[AOP] AFTER.." + joinPoint.getSignature().getName()); // only method name	
	}
	
	// get3() 메소드 실행 제어
	@Around("execution(* com.example.app.domain.service.SimpleServiceImpl.get3())")
	public Object logAround(ProceedingJoinPoint pjp) throws Throwable {
		// pjp = 포인트 컷 표현식
		log.info("[AOP] AROUND.." + pjp);
		// get3() 메소드 실행 전 로깅은 @Before
		log.info("[AOP] AROUND BEFORE.." + pjp.getSignature().getName()+ " START!--");
		long start = System.currentTimeMillis();			// 시작 시간
		Object result = pjp.proceed();						// get3() 메소드 실행
		
		long end = System.currentTimeMillis();				// 종료 시간
		// get3() 메소드 실행 전 로깅은 @After
		log.info("[AOP] TIME : " + (end-start) + " ms");	// 실행 시간
		log.info("[AOP] RESULT.." + result);				// get3() 리턴값 로깅
		log.info("[AOP] AROUND AFTER.." + pjp.getSignature().getName()+ " END!--");
		
		return result;
	}
	
	// 모든 메소드 받기
	@Around("execution(* com.example.app.domain.service.*.*(..) )")
	public Object allServicelogAround(ProceedingJoinPoint pjp) throws Throwable {
		
		// memoRegistration() 메소드 실행 전 로깅은 @Before
		log.info("[AOP] AROUND BEFORE.." + pjp.getSignature().getName()+ " START!--");
		long start = System.currentTimeMillis();			// 시작 시간
		Object result = pjp.proceed();						// memoRegistration() 메소드 실행
		
		long end = System.currentTimeMillis();				// 종료 시간
		log.info("[AOP] TIME : " + (end-start) + " ms");	// 실행 시간
		log.info("[AOP] RESULT.." + result);				// memoRegistration() 리턴값 
		log.info("[AOP] AROUND AFTER.." + pjp.getSignature().getName()+ " END!--");
		
		return result;
	}
	
	
}
