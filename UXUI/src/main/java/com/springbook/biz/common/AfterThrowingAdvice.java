package com.springbook.biz.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

//@Service
//@Aspect
public class AfterThrowingAdvice {

	@Pointcut("execution(* com.springbook.biz..*Impl.*(..))")
	public void allPointcut() {
		
	}
	
	
	@org.aspectj.lang.annotation.AfterThrowing
			(pointcut="allPointcut()",throwing="exceptObj")
	public void afterThrowLog(Exception exceptObj) {
		System.out.println("AfterThrowing : [예외 처리] 비지니스 로직 수행 중 예외 발생");
		
	}
	
	
	
	
	
}
