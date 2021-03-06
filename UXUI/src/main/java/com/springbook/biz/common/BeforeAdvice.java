package com.springbook.biz.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

//@Service
//@Aspect
public class BeforeAdvice {

	
	@Pointcut("execution(* com.springbook.biz..*Impl.*(..))")
	public void allPointcut() { // id 값 역할
		
	}
	
	@Pointcut("execution(* com.springbook.biz..*Impl.get*(..))")
	public void getPointcut() {
		
	}
	
	@Before("allPointcut()")
	public void beforeLog() {
		System.out.println("Before : [사전 처리] 비지니스 로직 수행 전 동작");
	}
	
	
}
