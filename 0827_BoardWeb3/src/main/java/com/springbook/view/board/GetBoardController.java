package com.springbook.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

public class GetBoardController implements org.springframework.web.servlet.mvc.Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("글 상세 조회 처리");
		
		String seq = request.getParameter("seq");
		
		BoardVO boardVO = new BoardVO();
		BoardDAO boardDAO = new BoardDAO();
		
		boardVO.setSeq(Integer.parseInt(seq));
		BoardVO board = boardDAO.getBoard(boardVO);
		
//		HttpSession session = request.getSession();
//		session.setAttribute("board", board);
//		return "getBoard";
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("board",board);
		mav.setViewName("getBoard");
		return mav;	
	}

}
