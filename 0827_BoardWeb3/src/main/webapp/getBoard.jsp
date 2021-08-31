<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.springbook.biz.board.BoardVO" %>
<%@ page import="com.springbook.biz.board.impl.BoardDAO" %>

<%
	BoardVO boardVO = (BoardVO)session.getAttribute("board");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>getBoard</title>
</head>
<body>
	<center>
		<h1>글 상세</h1>
		<a href="logout.do">Log out</a>
		<hr>
		<form action="updateBoard.do" method="post">
			<input type="hidden" name="seq" value="<%=boardVO.getSeq() %>">
			<table border="1" cellpadding="0" cellspacing="0">
				<tr>
					<td bgcolor="orange">제목</td>
					<td>
						<input name="title" type="text" value="<%=boardVO.getTitle()%>">
					</td>
				</tr>
				<tr>
					<td bgcolor="orange">작성자</td>
					<td><%=boardVO.getWriter()%></td>
				</tr>
				<tr>
					<td bgcolor="orange">내용</td>
					<td>
						<textarea name="content" rows="10" cols="40">
							<%=boardVO.getContent()%>
						</textarea>
					</td>
				</tr>
				<tr>
					<td bgcolor="orange">등록일</td>
					<td><%=boardVO.getRegDate()%></td>
				</tr>
				<tr>
					<td bgcolor="orange">조회수</td>
					<td><%=boardVO.getCnt() %></td>
				</tr>		
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="글 수정">
					</td>
				</tr>
			</table>
		</form>
		<hr>
		<a href="insertBoard.jsp">등록</a>&nbsp;&nbsp;&nbsp;
		<a href="deleteBoard.do?seq=<%=boardVO.getSeq()%>">삭제</a>&nbsp;&nbsp;&nbsp;
		<a href="getBoardList.do">목록</a>
	</center>
</body>
</html>