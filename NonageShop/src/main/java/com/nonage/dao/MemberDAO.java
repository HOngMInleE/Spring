package com.nonage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.DBManager;

public class MemberDAO {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	private MemberDAO() {
	}

	private static MemberDAO instance = new MemberDAO();

	public static MemberDAO getInstance() {
		return instance;
	}

	public int confirmID(String userid) {
		String sql = "select * from member where id = ?";
		int result = -1;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				result = 1;
			}else {
				result = -1;
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("confirmID 오류" + e);
		}finally {
			DBManager.close(conn, pstmt, rs);;
		}
		return result;
	}// confirmID()
	
	
	
	

}// MemberDAO