<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.springbook.biz.board.BoardVO" %>
<%@ page import="com.springbook.biz.board.impl.BoardDAO" %>

<%! 
	BoardVO boardVO = new BoardVO();
	BoardDAO boardDAO = new BoardDAO();
	List<BoardVO> boardList = boardDAO.getBoardList(boardVO);
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>getBoardList</title>
</head>
<body>
	<center>
		<h1>글목록</h1>
		<h3>
			<a href="logout_proc.jsp">Log-out</a>
		</h3>
		
		<!-- 검색 시작 -->
		<form action="getBoardList.jsp" method="post">
			<table border="1" cellpadding="0" cellspacing="0" width="700">
				<tr>
					<td align="right">
						<select name="searchCondition">
							<option value="TITLE">제목
							<option value="CONTENT">내용
						</select>
						<input name="searchKeyword" type="text">
						<input type="submit" value="검색">
					</td>
				</tr>
			</table>
		</form>
		
		<table boarder="1" cellpadding="0" width="700">
			<tr>
				<th bgcolor="orange" width="100">번호</th>
				<th bgcolor="orange" width="100">제목</th>
				<th bgcolor="orange" width="100">작성자</th>
				<th bgcolor="orange" width="100">등록일</th>
				<th bgcolor="orange" width="100">조회수</th> 
			</tr>
			<%
			for(BoardVO board : boardList) {
			%>
			<tr>
				<td><%=board.getSeq()%></td>
				<td><%=board.getTitle() %></td>
				<td><%=board.getWriter()%></td>
				<td><%=board.getRegDate() %></td>
				<td><%=board.getCnt()%></td>
			</tr>
			<%
			}
			%>
		</table>
		<a href="insertBoard.jsp">새 글 등록</a>
	</center>
</body>
</html>