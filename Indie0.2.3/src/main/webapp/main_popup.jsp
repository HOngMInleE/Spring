<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>::알림::</title>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
<SCRIPT language="JavaScript">
function setCookie( name, value, expiredays ) {
	var todayDate = new Date();
	todayDate.setDate( todayDate.getDate() + expiredays );
	document.cookie = name + "=" + escape( value ) + "; path=/; expires=" + todayDate.toGMTString() + ";"
}

function closeWin() {
	if ( document.forms[0].Notice.checked )
		setCookie( "Notice", "done" , 1); //1이란 숫자는 1일간 안보임을 뜻합니다. 날짜는 자신에 맞게 수정하세요
	self.close();
}
</SCRIPT>
<style>
a {
	color: #1a1a1a;
	text-decoration: none;
}

div {
	display: block;
}
	body {
		height: 380px;
	}
	
	img.imgDetail {
		border: grey 0.5px solid;
		height: 300px;
		width: 430px;
	}
	
	div.popup_img {
		text-align: center;
		vertical-align: center;
	}
	
	div.content {
		font-size: 22px;
		font-weight: bold;
		padding-top: 15px;
		text-align: center;
	}
	
	div.fl_left {
		float: left;
	}
	
	div.fl_right {
		float: right;
	}
</style>
</head>

<body>
	<div id="wrap">
		<div class="popup_img">
			<a href="IndieServlet?command=Board_Detail_form&b_num=6" target="_blank">
				<img class="imgDetail" alt="팝업 이미지" src="${pageContext.request.contextPath}/img/board/concert_2.jpg">
			</a>
		</div>
		<div class="content">
			<strong>Billie Eilish</strong> 내한 공연 2020.08.23 20PM
		</div>
		<form style="margin-right: 0">
			<div style="margin-top: 20px">
				<div class="fl_left">
			        <input type="checkbox" name="Notice" value="">오늘 하루 이 창을 열지 않음  
				</div>
				<div class="fl_right">
		        	<button onClick="javascript:history.onclick=closeWin()">닫기</button>
	        	</div>
			</div>
		</form>
	</div>
</body>
</html>