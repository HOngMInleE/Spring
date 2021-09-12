<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.indie.dto.BoardVO" %>
<%@ page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/header.jsp"%>
<% // 넘어온 category별로 vo객체에 다르게 대입. 
		// ex) if (category.equals("News") { : getBoardListByCategory(String category) { 
			// category = ? pstmt.setString(request.getParameter(category)) //category가 news인 컬럼들을 찾아 출력하는 메소드 
	List<BoardVO> boardList = (List<BoardVO>)request.getAttribute("boardList");
%>
<div id="mid" class="frame">
	<div id="grid1co">
		<%@ include file="/asideBar.jsp"%></div>
	<div id="grid2co">
	
		<style>
		
			a{
			    color: #1a1a1a;
			    text-decoration: none;
			}
      
			div {
			    display: block;
			}
			
			ol, ul, li {
			    list-style: none;
			    font-weight: normal;
			}
			
			.board_list{
		    	padding: 16px 0;
   				border-bottom: 1px solid #e6e6e6;
   				height: 135px;
   				
				position: relative;
			    width: 100%;
			    display: inline-block;
			    vertical-align: top;
			}
			
			.board_list .list_date {
			    float: left;
			    width: 96px;
			    text-align: center;
			    padding: 48px 0 0;
			}
			
			.board_list .image {
			    position: relative;
			    float: left;
			    width: 240px;
			    margin-right: 24px;
			}

			.board_list .image img {
			    vertical-align: top;
			}

			.board_list .thumb_frame {
			    display: block;
			    position: absolute;
			    left: 0;
			    top: 0;
			    width: 240px;
			    height: 133px;
			    border: 1px solid #000;
			    opacity: 0.2;
			    filter: alpha(opacity=20);
			}

			.board_list dl {
			    width: 360px;
			    float: left;
			    color: #666;
			}
			
			.board_list .list_title {
			    overflow: hidden;
			    color: #1a1a1a;
			    font-size: 18px;
			    font-weight: bold;
			    width: 100%;
			    min-height: 20px;
			    padding: 5px 5px 10px 0;
			    margin-left: -2px;
			    white-space: nowrap;
			    text-overflow: ellipsis;
			}


			.board_list .list_content {
			    color: #666;
			    line-height: 20px;
			    min-height: 50px;
			    margin: 0 15px 15px 0;
			    word-wrap: break-word;
			    word-break: break-all;
			}
			
			.board_list .list_detail {
			    text-align: right;
			    width: 100%;
			    margin-top: 5px;
			    display: inline-block;
			}
			
			.board_list .list_detail .left {
			    float: left;
			    padding: 0;
			    text-align: left;
			}
			
			.board_list .list_detail .left .list_category, .list_cnt {
			    vertical-align: middle;
			    color: #666;
			    margin-right: 50px;
			}
			
			
			/* musicView에서 퍼온 것 */
			.board_wrap{
			margin: 30px 0 0 30px;
			}
			
			.board_category{
			width:720px;
		    height: 140px;
			}
		
			.board_content{
			width:720px;
			
			}
		</style>

<!-- https://www.melon.com/musicstory/today/index.htm 참고
 	관리자로 로그인시 우측에   추가, 삭제, 수정 버튼 추가. -->
 
 <!-- category 별로 board_header 다르게 표시(이미지와 카테고리 명) -->
		<article class="board_wrap">
			<dl class="board_category">
				<dt style="font-size: 50px; padding-bottom: 30px;">인디 포스트</dt>
				<dt style="font-size: 30px; font-weight: bold;"> 전체 </dt>
				<hr color="blue" style="margin-left: 0px; margin-top: 15px; height:2px;">
			</dl>
			<table class="board_content">
				<c:forEach items="${boardList}" var="boardList" varStatus="status">
					<tr class="board_list">
						<td class="list_date">글 등록일 ${boardList.b_regDate}</td>
						<td class="image">
							<a href="IndieServlet?command=Board_Detail_form&b_num=${boardList.b_num}">
								<img alt="이미지 채워넣어야함" src="" width="240" height="135">
								 ${boardList.b_picture}
								<span class="thumb_frame"></span>
							</a>
						</td>
						<td>
							<dl style="height:135px;">
								<dt class="list_title">
									<a href="IndieServlet?command=Board_Detail_form&b_num=${boardList.b_num}">글 제목 ${boardList.b_title}</a>
								</dt>
								<dd class="list_content">
									<a href="IndieServlet?command=Board_Detail_form&b_num=${boardList.b_num}">글 내용 ${boardList.b_content}</a> <!-- 일정 간격만 표기 css작성해야함 -->
								</dd>
								<dd class="list_detail">
									<p class="left">
										<span class="list_category">
											<a href="IndieServlet?command=BoardList_Category_form&b_category=${boardList.b_category}">[글 종류 ${boardList.b_category}]</a>
										</span>
										<span class="list_cnt">
											<span>조회 횟수 :</span>
											<span>${boardList.b_readCnt}</span>
										</span>
									</p>
								</dd>
							</dl>
						</td>
					</tr>
				</c:forEach>
			</table>
		</article>	
	</div> <!-- grid2 div -->
</div> <!-- mid div -->
<%@ include file="/footer.jsp"%>