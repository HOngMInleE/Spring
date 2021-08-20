package com.springbook.biz.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.user.UserService;
import com.springbook.biz.user.UserVO;

@Service("userService") // 객체 생성(등록)후에만 implements 가능.
public class UserServiceImple implements UserService {

	@Autowired //필요한 의존 객체의 “타입"에 해당하는 빈을 찾아 자동으로 주입
	private UserDAO userDAO;
	
	// 사용자 등록 메소드 실행
	@Override
	public void insertUser(UserVO vo) {
		// TODO Auto-generated method stub
		userDAO.insertUser(vo);
	}

	
	
	
}
