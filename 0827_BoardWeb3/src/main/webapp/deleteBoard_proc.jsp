<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.springbook.biz.board.BoardVO" %>
<%@ page import="com.springbook.biz.board.impl.BoardDAO" %>

<%
	String seq = request.getParameter("seq");
	BoardVO boardVO = new BoardVO();
	boardVO.setSeq(Integer.parseInt(seq));
	
	BoardDAO boardDAO = new BoardDAO();
	boardDAO.deleteBoard(boardVO);
	
	response.sendRedirect("getBoardList.jsp");
%>