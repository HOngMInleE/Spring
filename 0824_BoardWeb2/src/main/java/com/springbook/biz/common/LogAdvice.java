package com.springbook.biz.common;

public class LogAdvice {
	// AOP (관심지향프로그래밍)
	// 비지니스 로직들의 공통 클래스 (service클래스들의)
	
	public void printLog() {
		System.out.println("[공통 로그] 비즈니스 로직 수행 전 동작");
	}
	
	
	
	
	
}
