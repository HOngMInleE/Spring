package com.springbook.biz.board;

import java.util.List;

import org.springframework.stereotype.Service;

public interface BoardService {

	void insertBoard(BoardVO vo); // 추가
	void updateBoard(BoardVO vo); // 수정
	void deleteBoard(BoardVO vo); // 삭제
	BoardVO getBoard(BoardVO vo); // 특정 글 조회
	List<BoardVO> getBoardList(BoardVO vo); // 전체 글 조회 (List)
	
	
	
}
