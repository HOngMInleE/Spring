<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.springbook.biz.board.BoardVO" %>
<%@ page import="com.springbook.biz.board.impl.BoardDAO" %>

<%
	// BoardVO boardVO = (BoardVO)session.getAttribute/("board");
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
			<input type="hidden" name="seq" value="${board.seq }">
			<table border="1" cellpadding="0" cellspacing="0">
				<tr>
					<td bgcolor="orange">제목</td>
					<td>
						<input name="title" type="text" value="${board.title }">
					</td>
				</tr>
				<tr>
					<td bgcolor="orange">작성자</td>
					<td>${board.writer }</td>
				</tr>
				<tr>
					<td bgcolor="orange">내용</td>
					<td>
						<textarea name="content" rows="10" cols="40">
							${board.content }
						</textarea>
					</td>
				</tr>
				<tr>
					<td bgcolor="orange">등록일</td>
					<td>${board.regDate }</td>
				</tr>
				<tr>
					<td bgcolor="orange">조회수</td>
					<td>${board.cnt }</td>
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
		<a href="deleteBoard.do?seq=${board.seq }">삭제</a>&nbsp;&nbsp;&nbsp;
		<a href="getBoardList.do">목록</a>
	</center>
</body>
</html>