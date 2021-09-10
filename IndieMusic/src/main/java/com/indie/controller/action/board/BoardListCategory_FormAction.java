package com.indie.controller.action.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.indie.controller.action.Action;
import com.indie.dao.BoardDAO;
import com.indie.dto.BoardVO;

public class BoardListCategory_FormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("boardListCategory_form 실행");
		BoardDAO boardDAO = BoardDAO.getInstance();
		
		String url = "board/boardList.jsp";
		
		// 넘어온 category별로 vo객체에 다르게 대입. 
		// ex) if (category.equals("News") { : getBoardListByCategory(String category) { 
		// category = ? pstmt.setString(request.getParameter(category)) //category가 news인 컬럼들을 찾아 출력하는 메소드
		
		String category = request.getParameter("category");
		
		ArrayList<BoardVO> boardList = boardDAO.getBoardListByCategory(category);
		
		request.setAttribute("boardList", boardList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
