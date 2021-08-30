<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.springbook.biz.board.BoardVO" %>
<%@ page import="com.springbook.biz.board.impl.BoardDAO" %>

<%
	request.setCharacterEncoding("UTF-8");
	
	BoardVO boardVO = new BoardVO();
	BoardDAO boardDAO = new BoardDAO();
	
	String title = request.getParameter("title");
	String writer = request.getParameter("writer");
	String content = request.getParameter("content");
	
	boardVO.setTitle(title);
	boardVO.setWriter(writer);
	boardVO.setContent(content);
	
	boardDAO.insertBoard(boardVO);
	
	response.sendRedirect("getBoardList.jsp");
%>