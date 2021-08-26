package com.springbook.biz.common;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

//@Service
//@Aspect
public class AfterReturningAdvice {

//	public void afterLog() {
//		System.out.println("[사후 처리] 비지니스 로직 수행 후 동작");
//	}
	
	@Pointcut("execution(* com.springbook.biz..*Impl.*(..))")
	public void allPointcut() {
		
	}
	
	@Pointcut("execution(* com.springbook.biz..*Impl.get*(..))")
	public void getPointcut() {
		
	}
	
	@AfterReturning(pointcut="getPointcut()", returning="returnObj")
	public void afterReturnLog(Object returnObj) {
		System.out.println("AfterReturning : [사후 처리] 비지니스 로직 수행 후 동작");
		System.out.println("AfterReturning : [사후 처리] " + returnObj.toString());
	}
	
	
	
	
}
