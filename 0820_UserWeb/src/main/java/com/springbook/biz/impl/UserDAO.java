package com.springbook.biz.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

import com.springbook.biz.common.JDBCUtil;
import com.springbook.biz.user.UserVO;

@Repository("userDAO")
public class UserDAO {
	private Connection conn = null;
	private ResultSet rs = null;
	private PreparedStatement pstmt = null;
	
	
	// 사용자 등록 메소드
	public void insertUser(UserVO vo) {
		conn = JDBCUtil.getConnection();
		String sql = "insert into users values(?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getRole());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("insertUser 오류 : " + e);
		}finally {
			JDBCUtil.close(pstmt, conn);
		}
	}// insertUser()
	
	
	
	
	
	
	
}
