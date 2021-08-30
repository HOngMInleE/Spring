package com.springbook.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;

@Service("boardService") // @ : 역할에 따라 구분. 기능은 다 같음
// Spring Container에 등록할 때 , id 값 : ""
public class BoardServiceImpl implements BoardService{
	// BoardDAO를 사용
	
		@Autowired // boardDAO 타입 하나만 쓰기때문에 오류 발생 안함.
		private BoardDAOSpring boardDAO;

		@Override
		public void insertBoard(BoardVO vo) {
			boardDAO.insertBoard(vo);
//			boardDAO.insertBoard(vo); // transaction / Context.xml파일 수정후 테스트위해 생성
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
			return boardDAO.getBoard(vo);
		}

		@Override
		public List<BoardVO> getBoardList(BoardVO vo) {
			return boardDAO.getBoardList(vo);
		}

	
	
	
}
