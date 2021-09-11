<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Indie Music</title>
<link href="<%=request.getContextPath()%>/css/common.css" rel="stylesheet">
</head>
<body>
	<div id="wrap">
		<header id="header">
			<div class="frame">
				<div class="topBtns">
					<a class="btns" name=login href="IndieServlet?command=admin_login_form" style="color: white;">관리자</a>
					<a class="btns" name=login href="IndieServlet?command=login">로그인</a>
					<a class="btns" name=join href="IndieServlet?command=join">회원가입</a>
				</div>
			</div>
			<div class="mainHeader">
				<div class="frame">
					<a href="IndieServlet?command=index">
						<img class="logo" alt="로고이미지" src="${pageContext.request.contextPath}/img/common/logo_01.png">
					</a>
					<div class="search">
						<form action="">
							<input class="searchKeyword" type="text" name="searchKeyword" size="50">
							<a class="searchIcon" href="IndieServlet" onclick="search()">
								<img src="${pageContext.request.contextPath}/img/common/icon_search.png"
									onclick="go_search()">
							</a>
						</form>
					</div>
				</div>
			</div>
		</header>