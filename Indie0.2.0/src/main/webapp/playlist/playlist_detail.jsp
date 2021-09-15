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
			
			article.playlist_wrap{
			margin: 30px 0 0 30px;
			}
			
			dl.top_menu {
				width: 720px;
				height: 70px;
			}
			dt.sub_title {
				font-weight: bold;
				font-size: 40px;
			}
			
			dt.playlist_make {
				float: right;
			}

			dt button{
			  color:#8C8C8C;
			  background-color: #fff;
			  border:1px solid #8C8C8C;
			  font-size:1.2em;
			  font-weight:bold;
			  padding:0 15px;
			  cursor:pointer;
			}
			button:hover{
			  background:#000000;
			  color:#fff;
			}
			
			table.playlist_content{
				width:720px;
				border-bottom:1px solid #DCDCDC;
				text-align: center;
			}
			
			tr.list_title {
				text-align: center;
				border-bottom:5px solid #DCDCDC;
			}
			tr.list_title th{
				padding-bottom: 10px;
			}
			
			tr.list_content {
				height: 60px;
				border-bottom:1px solid #DCDCDC;
			}
			
			span.content_count {
			
			}
			
			span.content_title {
			
			}
			
			td.icon{
			width:5%;
			}
			td.icon img{
			
			}
			
		</style>
	<!-- <script type="text/javascript">
	function add_playlist() {
		var url = "IndieServlet?command=Playlist_Insert_FormAction";
		window.open(url, "_blank_1",
				"toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=550, height=300, top=300, left=300, ");
		}
	</script> -->
<article class="playlist_wrap">
	<dl class="top_menu">
		<dt class="sub_title"> 플레이리스트 정보 </dt>
		<dt class="playlist_make">
			<!-- <button onclick="my_playlist()">담기</button> -->
		</dt>
		<dt class="playlist_title">
			${my_playlist.pl_title}
		</dt>
	</dl>
	<hr color="grey" style="margin:10px 0 10px 0; height: 1px;">
	<table class="playlist_content">
		<tr class="list_title">
			<th>곡명</th><th>아티스트</th><th>앨범</th><th>듣기</th><th>삭제</th>
		</tr>
		<c:forEach items="${playlist_songs}" var="playlist_songs" varStatus="status">
			<tr class="list_content">
				<td width="5%" style="text-align:center">
					<span style="font-size:20px; color:#4C4C4C;">
						${status.count}
					</span>
				</td>
					<td width="10%">
					<a href="#">
						<img src="img/music/${playlist_songs.m_album_pic}" width="50" height="50"/>
					</a>
				</td>
				<td width="30%">
					<span style="font-size:20px; color:#4C4C4C;">
						<a href="IndieServlet?command=music_detail&m_id=${playlist_songs.m_id}">
							${playlist_songs.m_name}
						</a>
					</span>
				</td>
				<td width="20%">
					<span style="font-size:20px; color:#BDBDBD;">
						${playlist_songs.m_artist}
					</span>
				</td>
				<td width="20%">
					<span style="font-size:20px; color:#BDBDBD;">
						${playlist_songs.m_album}
					</span>
				</td>
				<td class="icon">
					<a>
						<img width="30" height="30" src="img/chart/icon_playBefore.png"/>
					</a>
				</td>
				<td class="icon">
					<a href="IndieServlet?command=addlist&m_id=${playlist_songs.m_id}" onClick="history.go(0)">
						<img width="30" height="30" src="img/chart/icon_listBefore.png"/>
					</a>
				</td>
				<td class="icon">
					<a>
						<img width="30" height="30" src="img/chart/icon_lyricsBefore.png"/>
					</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</article>
		
		
	</div>
</div>
<%@ include file="/footer.jsp"%>