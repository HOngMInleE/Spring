package com.nonage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.nonage.dto.MemberVO;

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

	// id (회원) 존재 유무 확인
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

	// 회원 등록 
	public int insertMember(MemberVO memberVO) {
		String sql = "insert into member (id, pwd, name, email, zip_num, address, phone)"
				+ "values (?, ?, ?, ?, ?, ?, ?)";
		int result = 0;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, memberVO.getId());
			pstmt.setString(2, memberVO.getPwd());
			pstmt.setString(3, memberVO.getName());
			pstmt.setString(4, memberVO.getEmail());
			pstmt.setString(5, memberVO.getZipNum());
			pstmt.setString(6, memberVO.getAddress());
			pstmt.setString(7, memberVO.getPhone());
			
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("insertMember 오류" + e);
		}finally {
			DBManager.close(conn, pstmt);;
		}
		return result;
	}// insertMember()
	
	
	
	
	

}// MemberDAO