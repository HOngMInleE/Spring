package com.nonage.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nonage.dao.CartDAO;
import com.nonage.dto.CartVO;
import com.nonage.dto.MemberVO;

public class CartListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "mypage/cartList.jsp";
		
		HttpSession session = request.getSession();
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		
		if (loginUser == null) {
			url = "NonageServlet?command=login_form";
		}else {
			CartDAO cartDAO = CartDAO.getInstance();
			ArrayList<CartVO> cartList = cartDAO.cartList(loginUser.getId());
			
			int totalPrice = 0;
			for (CartVO cartVO : cartList) {
				// 상품 총 가격 : 상품 가격 * 개수
				totalPrice += cartVO.getPrice2() * cartVO.getQuantity();
			}
			request.setAttribute("cartList", cartList);
			request.setAttribute("totalPrice", totalPrice);
		}//else
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
		
	}// execute()

}
