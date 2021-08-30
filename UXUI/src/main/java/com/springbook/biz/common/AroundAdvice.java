package com.springbook.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

//@Service
//@Aspect
public class AroundAdvice {

	@Pointcut("execution(* com.springbook.biz..*Impl.*(..))")
	public void allPointcut() {
		
	}
	
	@Around("allPointcut()")
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("Around : [BEFORE] : 비즈니스 메소드 수행 전에 처리할 내용 ...");
		Object returnObj = pjp.proceed();
			// 공통관심사에 대한 내용을 구분지어줌 // Pointcut에 해당하는 메소드 호출
		System.out.println("Around : [AFTER] : 비즈니스 메소드 수행 후에 처리할 내용 ...");
		System.out.println(returnObj); // Pointcut 메소드 반환값
		return returnObj;
		
	}//aroundLog()
	
	
	
	
	
}
