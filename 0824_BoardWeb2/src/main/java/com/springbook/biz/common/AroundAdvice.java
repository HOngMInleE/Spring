package com.springbook.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Service
@Aspect
public class AroundAdvice {

//	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
//		System.out.println("[BEFORE] : 비즈니스 메소드 수행 전에 처리할 내용 ...");
//		Object returnObj = pjp.proceed();
//			// 공통관심사에 대한 내용을 구분지어줌 // Pointcut에 해당하는 메소드 호출
//		System.out.println("[AFTER] : 비즈니스 메소드 수행 후에 처리할 내용 ...");
//		System.out.println(returnObj); // Pointcut 메소드 반환값
//		return returnObj;
//	}
	
	
	@Pointcut("execution(* com.springbook.biz..*Impl.*(..))")
	public void allPointcut() {
		
	}
	
	@Around("allPointcut()")
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
//		System.out.println("Around : [BEFORE] : 비즈니스 메소드 수행 전에 처리할 내용 ...");
//		Object returnObj = pjp.proceed();
//			// 공통관심사에 대한 내용을 구분지어줌 // Pointcut에 해당하는 메소드 호출
//		System.out.println("Around : [AFTER] : 비즈니스 메소드 수행 후에 처리할 내용 ...");
//		System.out.println(returnObj); // Pointcut 메소드 반환값
//		return returnObj;
		
// 응용 / 비즈니스 로직이 작동하는데 걸린 시간 출력
		StopWatch stopwatch = new StopWatch();
		stopwatch.start();
		
		Object obj = pjp.proceed();
		
		stopwatch.stop();
		System.out.println("() 메소드 수행에 걸린 시간 : " + stopwatch.getTotalTimeMillis() + "(ms)초");
		
		return obj;
		
	}//aroundLog()
	
	
	
	
	
}
