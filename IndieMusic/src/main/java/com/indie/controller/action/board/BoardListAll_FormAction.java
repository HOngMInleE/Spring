package com.indie.controller.action.board;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.indie.controller.action.Action;
import com.indie.dao.BoardDAO;
import com.indie.dto.BoardVO;

public class BoardListAll_FormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("BoardList_All_form 실행");
		BoardDAO boardDAO = BoardDAO.getInstance();
		
		String url = "board/boardList.jsp";
		
		BoardVO vo = new BoardVO();
		
		List<BoardVO> boardList = boardDAO.getBoardListByNewest(vo);
		
		request.setAttribute("boardList", boardList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
