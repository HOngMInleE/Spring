package com.springbook.biz.user.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springbook.biz.user.UserVO;

public class UserRowMappter implements RowMapper<UserVO> {

	@Override
	public UserVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		UserVO userVO = new UserVO();
		userVO.setId(rs.getString("id"));
		userVO.setPassword(rs.getString("password"));
		userVO.setName(rs.getString("name"));
		userVO.setRole(rs.getString("role"));
		return userVO;
	}

}
