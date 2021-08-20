package com.springbook.biz;

import java.util.Scanner;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.springbook.biz.user.UserService;
import com.springbook.biz.user.UserVO;

public class UserServiceClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//xml 파일 불러오기(?)
			//AbstractXml이 아님. 주의
		AbstractApplicationContext factory = 
				new GenericXmlApplicationContext("applicationContext.xml");
		
		// bean 가져와 대입
		UserService userService = (UserService) factory.getBean("userService");

		// 객체 생성
		UserVO vo = new UserVO();
		Scanner sc = new Scanner(System.in);
		
		// 변수 선언 및 초기화
		String id = "";
		String password = "";
		String name = "";
		String role = "";
		
		// 입력 및 변수에 값 저장
		System.out.println(" ===== 사용자를 등록하세요 ===== ");
		System.out.println("아이디를 입력하세요.");
		id = sc.nextLine();
		System.out.println("비밀번호를 입력하세요.");
		password = sc.nextLine();
		System.out.println("이름을 입력하세요.");
		name = sc.nextLine();
		System.out.println("역할을 입력하세요.");
		role = sc.nextLine();
		
		// vo객체에 값 저장된 변수 저장
		vo.setId(id);
		vo.setPassword(password);
		vo.setName(name);
		vo.setRole(role);
		
		// 사용자 등록 메소드 실행
		userService.insertUser(vo);
		
		// 연결 해제  / 중요.
		sc.close();
		factory.close();
	}// main()

	
	
}
