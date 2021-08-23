package com.springbook.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;

@Service("boardService") // @ : 역할에 따라 구분. 기능은 다 같음
public class BoardServiceImpl implements BoardService{
	// BoardDAO를 사용
	
	@Autowired // boardDAO 타입 하나만 쓰기때문에 오류 발생 안함.
	BoardDAO boardDAO;
	
	@Override
	public void insertBoard(BoardVO vo) {
		boardDAO.insertBoard(vo);
	}

	@Override
	public void updateBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		boardDAO.updateBoard(vo);
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		boardDAO.deleteBoard(vo);
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		BoardVO board = null;
		board = boardDAO.getBoard(vo);
		return board;
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		// TODO Auto-generated method stub
		List<BoardVO> boardList = boardDAO.getBoardList(vo);
		return boardList;
	}

	
}
