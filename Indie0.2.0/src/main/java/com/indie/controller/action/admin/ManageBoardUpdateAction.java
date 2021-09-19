package com.indie.controller.action.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.indie.controller.action.Action;
import com.indie.dao.BoardDAO;
import com.indie.dto.AdminVO;
import com.indie.dto.BoardVO;

public class ManageBoardUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("게시판 수정 컨트롤러 실행");
		String url = "/IndieServlet?command=manage_board";

		BoardVO boardVO = new BoardVO();

		HttpSession session = request.getSession();
		AdminVO loginAdmin = (AdminVO) session.getAttribute("loginAdmin");

		boardVO.setB_num(Integer.parseInt(request.getParameter("b_num")));
		boardVO.setAdm_num(loginAdmin.getAdm_num());
		boardVO.setB_category(request.getParameter("b_category"));
		boardVO.setB_title(request.getParameter("b_title"));
		boardVO.setB_content(request.getParameter("b_content"));
		boardVO.setB_picture(
				request.getParameter("b_picture") != null ? request.getParameter("b_picture") : "noimg.png");

		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.updateBoard(boardVO);

		request.getRequestDispatcher(url).forward(request, response);
	}

}
