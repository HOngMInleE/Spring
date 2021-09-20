<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/header.jsp"%>
<div id="mid" class="frame">
	<div id="grid1co">
		<%@ include file="/asideBar.jsp"%></div>
	<div id="grid2co">
		<style>
		.allchart{
		margin: 30px 0 0 30px;
		}
		
		.headerinfo{
		width: 720px;
		height: 70px;
		}
		.form{
		width:720px;
		height: 50px;
		margin-left: 150px;
		}
		#input1{
		vertical-align:top;
		width: 130px;
		height: 30px;
		margin-bottom : 15px;
		background-color:white;
		border: 2px solid black;
		border-radius: 50px; 
		text-align: center;
		}
		
		#input2{
		}
		
		</style>
		
<article class="allchart">
	<div class="headerinfo">
		<span style="font-size:30px; font-weight:bold;">추천곡 수를 입력하세요.</span>
	</div>
	<div class="form">
		<form method="post" name="formm" action="IndieServlet?command=random_action">
			<input id="input1" type="text" name="r_num" placeholder="숫자만 입력하세요">
			<input id="input2" type="image" src="./img/common/icon_search.png" value="확인" class="submit" style="width: 40px; height: 40px">
		</form>
	</div>
</article>
	
		
		
		
		
	</div>
</div>
<%@ include file="/footer.jsp"%>