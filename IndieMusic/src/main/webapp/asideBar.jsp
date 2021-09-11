<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="aside">
	<div class="subNavWrap">
		<div class="title">
			<img src="${pageContext.request.contextPath}/img/common/icon_chart.png" alt="인기">
			<span class="navName">인기차트</span>
		</div>
		<br>
		<ul>
			<li class="list">
				<a href="IndieServlet?command=AllPopular"> - 종합 </a>
			</li>
			<br>
			<li class="list">
				<a href="IndieServlet?command=KorPopular"> - 국내 </a>
			</li>
			<br>
			<li class="list">
				<a href="IndieServlet?command=ForPopular"> - 해외 </a>
			</li>
			<br>
		</ul>
	</div>
	<div class="subNavWrap">
		<div class="title">
			<img src="${pageContext.request.contextPath}/img/common/icon_music.png" alt="">
			<span class="navName">최신음악</span>
		</div>
		<br>
		<ul>
			<li class="list">
				<a href="IndieServlet?command=AllNewest">- 종합</a>
			</li>
			<br>
			<li class="list">
				<a href="IndieServlet?command=KorNewest">- 국내</a>
			</li>
			<br>
			<li class="list">
				<a href="IndieServlet?command=ForNewest">- 해외</a>
			</li>
			<br>
		</ul>
	</div>
	<div class="subNavWrap">
		<div class="title">
			<img src="${pageContext.request.contextPath}/img/common/icon_genre.png" alt="">
			<span class="navName">장르</span>
		</div>
		<br>
		<ul>
			<li class="list">
				<a href="IndieServlet?command=KorDance"> - 댄스/팝 </a>
			</li>
			<br>
			<li class="list">
				<a href="IndieServlet?command=KorBallad"> - 발라드 </a>
			</li>
			<br>
			<li class="list">
				<a href="IndieServlet?command=KorHiphop"> - 힙합 </a>
			</li>
			<br>
			<li class="list">
				<a href="IndieServlet?command=KorIndie"> - 인디 </a>
			</li>
			<br>
		</ul>
	</div>
	<div class="subNavWrap">
		<div class="title">
			<img src="${pageContext.request.contextPath}/img/common/icon_post.png" alt="게시판 아이콘">
			<span class="navName">포스트</span>
		</div>
		<br>
		<ul>
			<li class="list">
				<a href="IndieServlet?command=boardListAll_form">- 모든  소식 </a>
			</li>
			<br>
			<li class="list">
				<a href="IndieServlet?command=boardListCategory_form&b_category=News"> - 뮤직 이슈 </a>
			</li>
			<br>
			<li class="list">
				<a href="IndieServlet?command=boardListCategory_form&b_category=Magazine"> - 매거진 </a>
			</li>
			<br>
			<li class="list">
				<a href="IndieServlet?command=boardListCategory_form&b_category=Concert">- 공연 </a>
			</li>
			<br>
		</ul>
	</div>
	<div class="subNavWrap">
		<div class="title">
			<img src="${pageContext.request.contextPath}/img/common/icon_post.png" alt="게시판 아이콘">
			<span class="navName">마이 뮤직</span>
		</div>
		<br>
		<ul>
			<li class="list">
				<a href="IndieServlet?command=boardList_form">- 플레이리스트 </a>
			</li>
			<br>
			<!-- 			
			<li class="list">
				<a href="IndieServlet?command=boardList_form"> - 나의 문의 내역 </a>
			</li>
			<br>
			<li class="list">
				<a href="IndieServlet?command=boardList_form"> - FAQ </a>
			</li>
			<br>
			<li class="list">
				<a href="IndieServlet?command=boardList_form"> - Notice </a>
			</li>
			<br> 
			-->
		</ul>
	</div>
	<div class="hr"></div>
</div>