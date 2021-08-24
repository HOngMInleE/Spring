package com.springbook.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;
import com.springbook.biz.common.Log4jAdvice;
import com.springbook.biz.common.LogAdvice;

@Service("boardService") // @ : 역할에 따라 구분. 기능은 다 같음
// Spring Container에 등록할 때 , id 값 : ""
public class BoardServiceImpl implements BoardService{
	// BoardDAO를 사용
	
		@Autowired // boardDAO 타입 하나만 쓰기때문에 오류 발생 안함.
		private BoardDAO boardDAO;
//		private LogAdvice log; // 공통관심사
//		private Log4jAdvice log;
		
//		public BoardServiceImpl() {
//			log = new LogAdvice(); // 생성자를 통해 생성 / 자동의존주입방식도 생성가능
//			log = new Log4jAdvice();
//		}

		@Override
		public void insertBoard(BoardVO vo) {
//			log.pringLog();
//			log.pringLogging();
			boardDAO.insertBoard(vo);
		}

		@Override
		public void updateBoard(BoardVO vo) {
//			log.pringLog();
//			log.pringLogging();
			boardDAO.updateBoard(vo);
		}

		@Override
		public void deleteBoard(BoardVO vo) {
//			log.pringLog();
//			log.pringLogging();
			boardDAO.deleteBoard(vo);
		}

		@Override
		public BoardVO getBoard(BoardVO vo) {
//			log.pringLog();
//			log.pringLogging();
			BoardVO board = null;
			board = boardDAO.getBoard(vo);
			return board;
		}

		@Override
		public List<BoardVO> getBoardList(BoardVO vo) {
//			log.pringLog();
//			log.pringLogging();
			List<BoardVO> boardList = boardDAO.getBoardList(vo);
			return boardList;
		}

	
	
	
}
