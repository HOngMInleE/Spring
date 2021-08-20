package com.springbook.biz.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.common.JDBCUtil;

@Repository("BoardDAO") // 데이터를 저장, 처리 역할  / @component와 같음
public class BoardDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
// 글 등록 기능
	public void insertBoard(BoardVO vo) {
		System.out.println("DAO insertBoard() 기능 처리");
		
		String board_insert = "insert into board1(seq, title, writer, content, regdate) "
				+ "values((select nvl(max(seq),0) + 1 from board1), ? ,? ,?, sysdate)";
		
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(board_insert);
			
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getWriter());
			pstmt.setString(3, vo.getContent());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("insertBoard 오류");
		}finally {
			JDBCUtil.close(pstmt, conn);
		}
	}// insertBoard()
	
	
	
	
	
}
