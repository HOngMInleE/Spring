<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/header.jsp"%>

<div id="mid" class="frame">
<div id="grid1co">
		<%@ include file="/asideBar.jsp"%></div>
	<div id="grid2co">
		<style>
			.allchart{
			margin: 30px 0 0 30px;
			}
			
			.allchart a{
			text-decoration-line: none;
			}
			
			.topchart{
			width:720px;
			height:50px;
			}
		
			.chart{
			width:720px;
			
			}
			.chart td{
			height:71px;
			text-align:left;
			}
			.chart th{
			font-size:0.6em;
			color:blue;
			}
			
			.chart th:nth-of-type(n+6){
			text-align:center;
			}
			
			.chart td a{
			text-decoration-line: none;
			}
			
			.line{
			border-bottom:1px solid #DCDCDC;
			}
			.icon{
			width:5%;
			}
			
			.icon button{
			border: 0;
			outline: 0;
			padding: 0;
			color: white;
			}
			
			.icon button img{
			width:30px;
			height:30px;
			}
			
			.topchart button{
			  background:#fff;
			  color:#8C8C8C;
			  border:none;
			  position:relative;
			  height:40px;
			  font-size:1.2em;
			  font-weight:bold;
			  padding:0 15px;
			  cursor:pointer;
			  transition:800ms ease all;
			  outline:none;
			}
			.topchart button:hover{
			  background:#000000;
			  color:#fff;
			}
			.topchart button:before,button:after{
			  content:'';
			  position:absolute;
			  top:0;
			  right:0;
			  height:2px;
			  width:0;
			  background: #fff;
			  transition:400ms ease all;
			}
			.topchart button:after{
			  right:inherit;
			  top:inherit;
			  left:0;
			  bottom:0;
			}
			.topchart button:hover:before,button:hover:after{
			  width:100%;
			  transition:800ms ease all;
			}
		</style>

<article class="allchart">
	<div class="topchart">
	
		<span style="font-size:30px; font-weight:bold;">발라드</span><span style="font-size:25px; font-weight:bold; color:#4C4C4C;">(국내)</span>
		&nbsp;&nbsp;&nbsp;
		<button onclick="location.href='IndieServlet?command=AllBallad'">종합</button>
		<button onclick="location.href='IndieServlet?command=KorBallad'">국내</button>
		<button onclick="location.href='IndieServlet?command=ForBallad'">해외</button>
	</div>
	<table class="chart">
	<div class="hide" style="display: none;">
		<form name="onoff" class="formm" action="IndieServlet?command=AllPopular" method="post">
			<input type="button" value="음악켜기" name="B1" onClick="changeButton()">
			<audio id="audio">
				<source src="stay.mp3" >
			</audio>
		</form>
	</div>
			<tr>
				<th align="center">순위</th><th></th><th>곡</th><th>아티스트</th><th>앨범</th><th>듣기</th><th>담기</th><th>가사</th>
			</tr>
		<c:forEach items="${getKorBalladGenre}" var="chartList" varStatus="status">
			<tr class="line">
				<td width="5%" style="text-align:center"><span style="font-size:20px; color:#4C4C4C;">${status.count}</span></td>
				<td width="10%"><a href="#"><img src="${pageContext.request.contextPath}/img/music/${chartList.m_album_pic}" width="50" height="50"/></a></td>
				<td width="30%"><a href="IndieServlet?command=music_view&m_id=${chartList.m_id}"><span style="font-size:20px; color:#4C4C4C;">${chartList.m_name}</a></span></td>
				<td width="20%"><span style="font-size:20px; color:#BDBDBD;">${chartList.m_artist}</span></td>
				<td width="20%"><span style="font-size:20px; color:#BDBDBD;">${chartList.m_album}</span></td>
				<td class="icon"><button type="submit" onclick="changeButton()"><img src="./img/chart/icon_playBefore.png"/></button></td>
				<td class="icon"><a href="IndieServlet?command=addlist&m_id=${chartList.m_id}&list=allpop"><img width="30" height="30" src="img/chart/icon_listBefore.png"/></a></td>
				<td class="icon"><a href="#" onclick="golyrics(${chartList.m_id})"><img width="30" height="30" src="img/chart/icon_lyricsBefore.png"/></a></td>
			</tr>
		</c:forEach>
	</table>
</article>

	</div>
</div>

<script>

function golyrics(no) {
	var url = "IndieServlet?command=lyrics_detail&m_id=" 
	+no;
	 window.open( url, "_blank_1",
	"toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=570, height=800");
	}

function play() {
	var audio = document.getElementById("audio");
	audio.play();
}

function pause() {
	var audio = document.getElementById("audio");
	audio.pause();
}


function changeButton() {
  if (document.onoff.B1.value=='음악끄기') {
    document.onoff.B1.value='음악켜기';
    pause();
  } else {
    document.onoff.B1.value='음악끄기';
    play();
  }
}
</script>
<%@ include file="/footer.jsp"%>