package com.nonage.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nonage.dao.AddressDAO;
import com.nonage.dto.AddressVO;

public class FindZipNumAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "member/findZipNum.jsp";
		
		String dong = request.getParameter("dong");
		
			//trim : 공백제거
		if (dong != null && dong.trim().equals("") == false) {
			AddressDAO addressDAO = AddressDAO.getInstance();
			List<AddressVO> addressList = addressDAO.selectAddressByDong(dong.trim());
			request.setAttribute("addressList", addressList);
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
