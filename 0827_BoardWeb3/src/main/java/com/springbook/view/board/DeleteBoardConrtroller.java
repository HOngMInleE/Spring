package com.springbook.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;
import com.springbook.view.controller.Controller;

public class DeleteBoardConrtroller implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("글 삭제 처리");
		
		String seq = request.getParameter("seq");
		
		BoardVO boardVO = new BoardVO();
		BoardDAO boardDAO = new BoardDAO();
		
		boardVO.setSeq(Integer.parseInt(seq));
		boardDAO.deleteBoard(boardVO);
		
		return "getBoardList.do";
	}

}
