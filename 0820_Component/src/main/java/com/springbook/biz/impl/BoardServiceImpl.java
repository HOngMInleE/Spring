package com.springbook.biz.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;

@Service("boardService") // @ : 역할에 따라 구분. 기능은 다 같음
// Spring Container에 등록할 때 , id 값 : ""
public class BoardServiceImpl implements BoardService{
	// BoardDAO를 사용
	
	@Autowired // boardDAO 타입 하나만 쓰기때문에 오류 발생 안함.
	private BoardDAO boardDAO;
	
	@Override
	public void insertBoard(BoardVO vo) {
		boardDAO.insertBoard(vo);
	}

	
	
	
}
