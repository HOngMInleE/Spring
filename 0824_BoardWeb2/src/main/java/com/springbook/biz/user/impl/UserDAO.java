package com.springbook.biz.user.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.springbook.biz.common.JDBCUtil;
import com.springbook.biz.user.UserVO;

@Repository("userDAO")
public class UserDAO {
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
// 회원 정보 조회
	public UserVO getUser(UserVO vo) {
		System.out.println("DAO getUser() 기능 처리");
		UserVO user = null;
		
		String USER_GET = "select * from users where id = ? and password = ?";
		
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(USER_GET);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPassword());
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				user = new UserVO();
				user.setId(rs.getString("id"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setRole(rs.getString("role"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("getUser() 오류");
		}finally {
			JDBCUtil.close(pstmt, conn, rs);
		}
		return user;
	}// insertBoard()
	
	
	
	
	
	
	
	
	
	
}
