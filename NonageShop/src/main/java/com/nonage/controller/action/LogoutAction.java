package com.nonage.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "NonageServlet?command=index";
		System.out.println("LogoutAction 요청 ");
		
		HttpSession session = request.getSession();
		
		if (session != null) {
			try {
				session.invalidate();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
//		request.getRequestDispatcher(url).forward(request, response);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	    dispatcher.forward(request, response);
	}
	
}
