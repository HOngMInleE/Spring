<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% // 입력된 데이터를 받아 처리하는 역할  %>
<%@ page import="com.springbook.biz.user.UserVO" %>
<%@ page import="com.springbook.biz.user.impl.UserDAO" %>
<%

	String id = request.getParameter("id");
	String password = request.getParameter("password");

	UserVO userVO = new UserVO();
	userVO.setId(id);
	userVO.setPassword(password);
	
	UserDAO userDAO = new UserDAO();
	UserVO user_get = userDAO.getUser(userVO);
	
	if (user_get != null) {
		System.out.println("로그인 성공");
		response.sendRedirect("getBoardList.do");
	} else {
		System.out.println("로그인 실패");
		response.sendRedirect("login.do");
	}
	
	
%>		
	
