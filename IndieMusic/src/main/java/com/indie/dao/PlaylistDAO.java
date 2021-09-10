package com.indie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.indie.dto.BoardVO;

import util.DBManager;

public class PlaylistDAO {

	// SingleTornPattern
	private static PlaylistDAO instance = new PlaylistDAO();
	private PlaylistDAO() {
	}
	public static PlaylistDAO getInstance() {
		return instance;
	}

	// DBCP 객체 초기화
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	ResultSet rs = null;

// CRUD
	// Create (insert)
	public void insertBoard(BoardVO vo) {
		
		try {
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	// Read (Detail)
	public BoardVO getBoard(BoardVO vo) {
		
		try {
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	// Read (List)
	public ArrayList<BoardVO> getBoardList(BoardVO vo) {
		return null;
	}
	
	// Update (update)
	public void updateBoard(BoardVO vo) {
		
	}
	
	// Delete (delete)
	public void board_delete(BoardVO vo) {
		
	}
	
	
	
	
	
	
	
}
