package com.nonage.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nonage.dao.ProductDAO;
import com.nonage.dto.ProductVO;

public class IndexAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "/index.jsp";
		
		ProductDAO productDAO = ProductDAO.getInstance();
		ArrayList<ProductVO> newProductList = productDAO.listNewProduct();
		ArrayList<ProductVO> bestProductList = productDAO.listBestProduct();
		
		request.setAttribute("newProductList", newProductList);
		request.setAttribute("bestProductList", bestProductList);
		
//		HttpSession session = request.getSession(false);
//		
//		if(session != null) {
//			session.invalidate();
//		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	    dispatcher.forward(request, response);
	}

}
