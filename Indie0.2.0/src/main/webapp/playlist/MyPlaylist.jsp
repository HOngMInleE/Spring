<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/header.jsp"%>
<div id="mid" class="frame">
	<div id="grid1co">
		<%@ include file="/asideBar.jsp"%></div>
	<div id="grid2co">
		<!-- 여기에 개인 메인 영역 작성 -->
		
		<!-- / 나의 플레이리스트 // mb_id값 이용, 
	// playlist없으면 플레이리스트 없고, 만들기 버튼만 보여줌.
	// 해당 id가 가진 playlist(보여줌 playList컬럼 정보)
	// 플레이리스트 순서 , 정보(제목, 총 수록곡 수), 듣기(전체듣기), 삭제, 플레이리스트 만들기
	// 첫 로그인시 : 플레이리스트 만들기만 보임 (검색창으로 이동, 모든 노래 최신순 정렬)  -->
		<style>
		
a {
	color: #1a1a1a;
	text-decoration: none;
}

div {
	display: block;
}
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
			
			button{
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
			button:hover{
			  background:#000000;
			  color:#fff;
			}
			button:before,button:after{
			  content:'';
			  position:absolute;
			  top:0;
			  right:0;
			  height:2px;
			  width:0;
			  background: #fff;
			  transition:400ms ease all;
			}
			button:after{
			  right:inherit;
			  top:inherit;
			  left:0;
			  bottom:0;
			}
			button:hover:before,button:hover:after{
			  width:100%;
			  transition:800ms ease all;
			}
		</style>

<article class="playlist_wrap">
	<div class="top_menu">
		<h2 class="sub_title">마이 뮤직</h2>
		<div>총 (count)개</div>			
		<button onclick="location.href='IndieServlet?command=AllPopular'">종합</button>
		<button onclick="location.href='IndieServlet?command=KorPopular'">국내</button>
		<button onclick="location.href='IndieServlet?command=ForPopular'">해외</button>
	</div>
	<table class="chart">
			<tr>
				<th align="center">순위</th><th>곡</th><th>아티스트</th><th>앨범</th><th>듣기</th>
			</tr>
		<c:forEach items="${getAllPopular}" var="chartList" varStatus="status">
			<tr class="line">
				<td width="5%" style="text-align:center"><span style="font-size:20px; color:#4C4C4C;">${status.count}</span></td>
				<td width="10%"><a href="#"><img src="img/music/${chartList.m_album_pic}" width="50" height="50"/></a></td>
				<td width="30%"><a href="IndieServlet?command=music_detail&m_id=${chartList.m_id}"><span style="font-size:20px; color:#4C4C4C;">${chartList.m_name}</a></span></td>
				<td width="20%"><span style="font-size:20px; color:#BDBDBD;">${chartList.m_artist}</span></td>
				<td width="20%"><span style="font-size:20px; color:#BDBDBD;">${chartList.m_album}</span></td>
				<td class="icon"><a><img width="30" height="30" src="img/chart/icon_playBefore.png"/></a></td>
				<td class="icon"><a href="IndieServlet?command=addlist&m_id=${chartList.m_id}" onClick="history.go(0)"><img width="30" height="30" src="img/chart/icon_listBefore.png"/></a></td>
				<td class="icon"><a><img width="30" height="30" src="img/chart/icon_lyricsBefore.png"/></a></td>
			</tr>
		</c:forEach>
	</table>
</article>
		
		
	</div>
</div>
<%@ include file="/footer.jsp"%>