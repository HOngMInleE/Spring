package com.nonage.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nonage.dao.CartDAO;

public class CartDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "NonageServlet?command=cart_list";
		
		CartDAO cartDAO = CartDAO.getInstance();
		String[] cseqDelete = request.getParameterValues("cseq");
		
		for (String cseq : cseqDelete) {
			System.out.println(cseq);
			cartDAO.deleteCart(Integer.parseInt(cseq));
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

	
}
