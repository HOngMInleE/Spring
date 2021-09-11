package com.springbook.biz.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springbook.biz.user.UserVO;

@Repository
public class UserDAOSpring {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	private final String user_Get = "select * from users where id = ? and password = ?";
	
	public UserVO getUser(UserVO vo) {
		System.out.println("===> Spring jdbc로 getuser() 기능 처리");
		Object[] args = {vo.getId(), vo.getPassword() };
		return jdbcTemplate.queryForObject(user_Get, args, new UserRowMappter());
	}
}