<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.springbook.biz.board.BoardVO" %>
<%@ page import="com.springbook.biz.board.impl.BoardDAO" %>

<%
	request.setCharacterEncoding("UTF-8");

	String title = request.getParameter("title");
	String content = request.getParameter("content");
	String seq = request.getParameter("seq");
	
	BoardVO boardVO = new BoardVO();
	BoardDAO boardDAO = new BoardDAO();
	
	boardVO.setTitle(title);
	boardVO.setContent(content);
	boardVO.setSeq(Integer.parseInt(seq));
	
	boardDAO.updateBoard(boardVO);
	
	response.sendRedirect("getBoardList.jsp");
	
%>