<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nonage Shop</title>
<link href="css/shopping.css" rel="stylesheet">
<script type="text/javascript" src = "member/member.js?ver=1"></script>
</head>
<body>
	<div id="wrap">
		<header>
			<div id="logo">
				<a href="NonageServlet?command=index">
					<img src="images/logo.gif" width="180" height="100" alt="NoneageShop">
				</a>
			</div>
			<!-- 카테고리 -->
			<nav id="catagory_menu"> 
		    	<ul>
		    		<c:choose>
		    			 <c:when test="${empty sessionScope.loginUser}">
		    			<!--로그인 전-->
		    				<li>
		    					<a href="NonageServlet?command=login_form" style="width:110px;">Login(Customer</a>   
					     		<a href="NonageServlet?command=admin_login_form" style="width:110px;">| Admin)</a>
				     		</li>
				     		<li> / </li>
				     		<li>
				     			<a href="NonageServlet?command=contract">Join</a>
				     		</li>
     					</c:when>
     					
			     		<c:otherwise>
			     		<!--로그인 후-->
				     		<li style="color:orange">
					        	${sessionScope.loginUser.name}(${sessionScope.loginUser.id})
					       	</li>
					       	<li>
					       		<a href="NonageServlet?command=logout">Log out</a>
					       	</li>
				       	</c:otherwise>       
		       		</c:choose>
			       	<li> / </li>
			       	<li>
			       		<a href="NonageServlet?command=cart_list">Cart</a>
			       	</li>
			       	<li> / </li>
			       	<li>
		       	 		<a href="NonageServlet?command=mypage">My Page</a>
			       	</li>
			       	<li> / </li>
			       	<li>
			        	<a href="NonageServlet?command=qna_list">Q&amp;A(1:1)</a>
			       	</li>
 				</ul>
		    </nav>
		
			 <!-- 상단 메뉴바 -->
		    <nav id="top_menu">
		    	<ul>
		    		<li>
		        		<a href="NonageServlet?command=category&kind=1">Heels</a>
			        </li>  
			        <li>
		          		<a href="NonageServlet?command=category&kind=2">Boots</a>
			        </li>  
			        <li>
	        		  	<a href="NonageServlet?command=category&kind=3">Sandals</a>
			        </li> 
			        <li>
		          		<a href="NonageServlet?command=category&kind=4">Sneakers</a>
			        </li> 
			        <li>
		          		<a href="NonageServlet?command=category&kind=5">On Sale</a>
		       	 	</li>  
	      		</ul>
		    </nav>
		    <div class="clear"></div>
		    <hr>
		 </header>