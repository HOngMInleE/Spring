package com.springbook.biz.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
		
		String board_insert = "insert into board1(seq, title, writer, content) "
				+ "values((select nvl(max(seq),0) + 1 from board1), ? ,? ,?)";
		
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
	
	// 글 정보 수정
	public void updateBoard(BoardVO vo) {
		System.out.println("===> JDBC로 updateBoard() 기능 처리");
		String board_update = "update board1 set title=?, content=? where seq=?";
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(board_update);
			
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setInt(3, vo.getSeq());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("updateBoard 오류");
		}finally {
			JDBCUtil.close(pstmt, conn);
		}
	}//updateBoard()

	// 글 삭제
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> JDBC로 deleteBoard() 기능 처리");
		String board_delete = "delete board1 where seq=?";
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(board_delete);

			pstmt.setInt(1, vo.getSeq());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("deleteBoard 오류");
		}finally {
			JDBCUtil.close(pstmt, conn);
		}
	}//deleteBoard()

	// 특정 글 조회
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> JDBC로 getBoard() 기능 처리");
		String board_get = "select * from board1 where seq=?";
		BoardVO board = null;
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(board_get);
			pstmt.setInt(1, vo.getSeq());
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				board = new BoardVO();
				board.setSeq(rs.getInt("seq"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				board.setRegDate(rs.getDate("regdate"));
				board.setCnt(rs.getInt("cnt"));
			}
//				System.out.println("---> " + vo.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("getBoard 오류");
		}finally {
			JDBCUtil.close(pstmt, conn, rs);
		}
		return board;
	}//getBoard()

	// 전체 글 조회
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> JDBC로 getBoardList() 기능 처리");
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		String board_getList = "select * from board1 order by seq asc";
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(board_getList);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardVO board = new BoardVO();
				board.setSeq(rs.getInt("SEQ"));
				board.setTitle(rs.getString("TITLE"));
				board.setWriter(rs.getString("WRITER"));
				board.setContent(rs.getString("CONTENT"));
				board.setRegDate(rs.getDate("REGDATE"));
				board.setCnt(rs.getInt("CNT"));
				boardList.add(board);
//					System.out.println("---> " + vo.toString());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("getBoardList() 오류");
		}finally {
			JDBCUtil.close(pstmt, conn, rs);
		}
		return boardList;
	}//getBoardList()

	
	
}
