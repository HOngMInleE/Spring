package com.springbook.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

public class DeleteBoardController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("글 삭제 처리");
		
		String seq = request.getParameter("seq");
		
		BoardVO boardVO = new BoardVO();
		BoardDAO boardDAO = new BoardDAO();
		
		boardVO.setSeq(Integer.parseInt(seq));
		boardDAO.deleteBoard(boardVO);
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("getBoardList.do");
		return mav;
	}

}
