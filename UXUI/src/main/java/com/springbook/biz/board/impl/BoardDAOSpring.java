package com.springbook.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;

@Repository
public class BoardDAOSpring {

	// a라는 클래스가 b라는 클래스를 사용하기 위해서 관계설정, 주입을 받아야한다.
		// 생성자, setter메소드, 자동의존주입(xmlFile이용) 방식이 존재.
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private final String Board_insert = "insert into board1(seq, title, writer, content) "
			+ "values((select nvl(max(seq),0) + 1 from board1), ? ,? ,?)";
	private final String Board_update = "update board1 set title=?, content=? where seq=?";
	private final String Board_delete = "delete board1 where seq=?";
	private final String Board_get = "select * from board1 where seq=?";
	private final String Board_getList = "select * from board1 order by seq ASC";
	
// CRUD
	public void insertBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC로 insertBoard() 기능 처리");
		jdbcTemplate.update(Board_insert,vo.getTitle(),vo.getWriter(),vo.getContent());
	}// insertBoard()
	
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println();
		System.out.println("===> Spring JDBC로 getBoardList() 기능 처리");
		return jdbcTemplate.query(Board_getList, new BoardRowMapper());
	}// getBoardList()
	
	public void updateBoard(BoardVO vo) {
		System.out.println();
		System.out.println("===> Spring JDBC로 updateBoard() 기능 처리");
		jdbcTemplate.update(Board_update,vo.getTitle(),vo.getContent(),vo.getSeq());
	}// updateBoard()
	
	public void deleteBoard(BoardVO vo) {
		System.out.println();
		System.out.println("===> Spring JDBC로 deleteBoard() 기능 처리");
		jdbcTemplate.update(Board_delete,vo.getSeq());
	}// deleteBoard()
	
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC로 getBoard() 기능 처리");
		Object[] args = { vo.getSeq() };
		return jdbcTemplate.queryForObject(Board_get, args, new BoardRowMapper());
	}
	
	
}//DAOSpring
