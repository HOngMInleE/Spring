package com.springbook.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

public class InsertBoardController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("글 등록 처리");
		
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		BoardVO boardVO = new BoardVO();
		BoardDAO boardDAO = new BoardDAO();
		
		boardVO.setTitle(title);
		boardVO.setWriter(writer);
		boardVO.setContent(content);
		boardDAO.insertBoard(boardVO);
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("getBoardList");
		return mav;	
		
	}

}
