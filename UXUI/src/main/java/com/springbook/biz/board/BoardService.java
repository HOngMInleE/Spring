package com.springbook.biz.board;

import java.util.List;

public interface BoardService {
	
	//CRUD
	void insertBoard(BoardVO vo); // Create 추가 
	void updateBoard(BoardVO vo); // Update 수정
	void deleteBoard(BoardVO vo); // Delte 삭제
	BoardVO getBoard(BoardVO vo); // Read 특정 글 조회
	List<BoardVO> getBoardList(BoardVO vo); // Read 전체 글 조회 (List)
	
	
	
	
	
}
