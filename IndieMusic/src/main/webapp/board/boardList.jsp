<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/header.jsp"%>
<%! // 넘어온 category별로 vo객체에 다르게 대입. 
		// ex) if (category.equals("News") { : getBoardListByCategory(String category) { 
			// category = ? pstmt.setString(request.getParameter(category)) //category가 news인 컬럼들을 찾아 출력하는 메소드 %>
			
<div id="mid" class="frame">
	<div id="grid1co">
		<%@ include file="/asideBar.jsp"%></div>
	<div id="grid2co">
		<%-- 
		<link href="<%=request.getContextPath()%>/css/board.css" rel="stylesheet"> 
		--%>
	
	<style type="text/css">
			#content_wrap {
				width: 100%;
				text-align: left;
				margin: 0 auto;
			}
			#table {
				border: 1px solid black;
			}
			.board_list {
				    position: relative;
				    width: 100%;
				    display: inline-block;
				    vertical-align: top;
		    }
		</style>

<!-- board 리스트 (입력된 카테고리에 따라 리스트 출력) -->
<!-- 새로운 소식 최신날짜순정렬 -->
<!-- https://www.melon.com/musicstory/today/index.htm 참고
 	날짜 표시, 사진, 제목, 카테고리, 내용, 조회수,
 	관리자로 로그인시 우측에   추가, 삭제, 수정 버튼 추가. -->
 
 <!-- category 별로 board_header 다르게 표시(이미지와 카테고리 명) -->
	 <div id="content_wrap">
			<article>
				<ul>
					<c:forEach items="${boardList}" var="boardList">
						<li>
							<div class="board_list">
								<div class="list_date">
									<span>${boardList.b_regDate}</span>
								</div>
								<div class="image">
									<%-- <td height="40">${boardList.b_picture}</td> --%>
								</div>
								
								<dl>
									<dt>
										<a href="#">${boardList.b_title}</a>
									</dt>
									<dd>
										<a href="#">${boardList.b_content}</a> <!-- 일정 간격만 표기 css작성해야함 -->
									</dd>
									<dd>
										<p class="left">
											<span class="category_move">
												<a href="#">${boardList.b_category}</a>
											</span>
											<span class="cnt_view">
												<span>조회</span>
												<span>${boardList.b_readCnt}</span>
											</span>
										</p>
									</dd>
								</dl>
							</div>
						</li>
					</c:forEach>
				</ul>
			</article>	
		</div>
	</div> <!-- grid2 div -->
</div> <!-- mid div -->
<%@ include file="/footer.jsp"%>