<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.sql.*" %>
<%@ page import ="javax.sql.*" %>
<%@ page import="javax.naming.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DB 연동</title>
</head>
<body>
<%
	Connection conn = null;

	try{
		Context init = new InitialContext();
		
		// Context envContext = (Context) initContext.lookup("java:/comp/env");
		// DataSource ds = (DataSource) envContext.lookup("jdbc/OracleDB");
		
		DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/OracleDB");
		conn = ds.getConnection();
		
		out.print("연결성공");
	}catch(Exception e){
		out.print("연결실패");
		e.printStackTrace();
	}
	
%>
</body>
</html>