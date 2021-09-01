package com.springbook.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;
import com.springbook.view.controller.Controller;

public class LoginController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		UserVO userVO = new UserVO();
		UserDAO userDAO = new UserDAO();
		
		userVO.setId(id);
		userVO.setPassword(password);
		UserVO user = userDAO.getUser(userVO);
		
		if (user != null) {
			System.out.println("로그인 성공");
			return "getBoardList.do"; // 페이지 이동 바로하지않고 url값만 넘김(Spring의원리이해위해)
		} else {
			System.out.println("로그인 실패");
			return "login"; //.jsp 지움, ViewResolver가 확장자 생성해줌.
		}
		
	}

}
