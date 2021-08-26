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
		private BoardDAOSpring boardDAO;
//		private BoardDAO boardDAO;
		
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
//			if (vo.getSeq() == 0) {  // 데이터를 저장해주지않고, 자동으로 넘어온 값이 0이다 
//				throw new IllegalArgumentException("0번 글을 등록할 수 없습니다.");
//			}
			boardDAO.insertBoard(vo);
		}

		@Override
		public void updateBoard(BoardVO vo) {
			boardDAO.updateBoard(vo);
		}

		@Override
		public void deleteBoard(BoardVO vo) {
			boardDAO.deleteBoard(vo);
		}

		@Override
		public BoardVO getBoard(BoardVO vo) {
//			BoardVO board = null;
//			board = boardDAO.getBoard(vo);
			return boardDAO.getBoard(vo);
		}

		@Override
		public List<BoardVO> getBoardList(BoardVO vo) {
//			log.pringLog();
//			log.pringLogging();
//			List<BoardVO> boardList = boardDAO.getBoardList(vo);
			return boardDAO.getBoardList(vo);
		}

	
	
	
}
