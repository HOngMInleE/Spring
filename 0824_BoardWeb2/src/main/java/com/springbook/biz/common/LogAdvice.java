package com.springbook.biz.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

public class LogAdvice {
// AOP (관심지향프로그래밍)
	// 비지니스 로직들의 공통 클래스 (service클래스들의)
	
//	public void printLog() {
//		System.out.println("[공통 로그] 비즈니스 로직 수행 전 동작");
//	}

	
// 어노테이션 방식으로 aspect(AOP) 구성 방법
	
	@Pointcut("execution(* com.springbook.biz..*Impl.*(..))")
	public void allPointcut() { // id 값 역할
		
	}
	
	@Pointcut("execution(* com.springbook.biz..*Impl.get*(..))")
	public void getPointcut() {
		
	}
	
	@Before("allPointcut()")
	public void printLog() {
		System.out.println("Default Before : [공통 로그] 비즈니스 로직 수행 전 동작");
	}
	
	
	
	
}
