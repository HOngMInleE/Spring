package com.springbook.biz.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.user.UserService;
import com.springbook.biz.user.UserVO;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	// DAO를 실제로 사용
	@Autowired
	private UserDAO userDAO;
	
	// 객체 생성
		// setter를 통한 주입 방식 
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public UserVO getUser(UserVO vo) {
		// TODO Auto-generated method stub
		return userDAO.getUser(vo);
	}

}
