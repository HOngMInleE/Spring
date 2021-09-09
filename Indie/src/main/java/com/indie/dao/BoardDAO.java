package com.indie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.indie.dto.BoardVO;

import util.DBManager;

public class BoardDAO {

	// SingleTornPattern
	private static BoardDAO instance = new BoardDAO();
	private BoardDAO() {
	}
	public static BoardDAO getInstance() {
		return instance;
	}

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	ResultSet rs = null;

	
	// Create (insert)
	// BoardVO 를 매개값으로 받아 DB에 저장.
	public void board_insert(BoardVO vo) {
		String sql = "insert into board (b_category, b_title, b_content)"
				+ "values(?,?,?)";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getB_category());
			pstmt.setString(1, vo.getB_title());
			pstmt.setString(1, vo.getB_content());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("게시판 등록 실패" + e);
		} finally {
			DBManager.close(conn, pstmt);
		}
	}// board_insert()
	
	// Read (Detail)
	public BoardVO board_get(BoardVO vo) {
		String sql = "select * from board where bn_num = ?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getBn_num());
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				vo.setB_category(rs.getString("b_category"));
				vo.setB_title(rs.getString("b_title"));
				vo.setB_content(rs.getString("b_content"));
				vo.setB_readCnt(Integer.parseInt(rs.getString("b_readCnt")));
				vo.setB_regDate(rs.getDate("b_regDate"));
				vo.setB_upDate(rs.getDate("b_upDate"));
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	// Read (List)
	public List<BoardVO> board_getList(BoardVO vo) {
		return null;
	}
	
	// Update (update)
	public void board_update(BoardVO vo) {
		
	}
	
	// Delete (delete)
	public void board_delete(BoardVO vo) {
		
	}
	
	
	
	
	
	
	
}
