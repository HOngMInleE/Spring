package com.springbook.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;
import com.springbook.view.controller.Controller;

public class GetBoardController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("글 상세 조회 처리");
		
		String seq = request.getParameter("seq");
		
		BoardVO boardVO = new BoardVO();
		BoardDAO boardDAO = new BoardDAO();
		
		boardVO.setSeq(Integer.parseInt(seq));
		BoardVO board = boardDAO.getBoard(boardVO);
		
		HttpSession session = request.getSession();
		session.setAttribute("board", board);
		
		return "getBoard";
	}

}
