<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="sub_img.html"%>
<%@ include file="sub_menu.jsp"%>

	<article>
		<h2>My Page(주문 상세 정보)</h2>
		<form name="formm" method="post">
			<table id="cartList">
				<h3> 주문 상품 정보 </h3>
				<tr>
					<th>주문일자</th>
					<th>주문번호</th>
					<th>주문자</th>
					<th>주문 총액</th>
				</tr>
				<tr>
					<td><fmt:formatDate value="${orderVO.indate}" type="date" /></td>
					<td>${orderVO.oseq}</td>
					<td>${orderVO.mname}</td>
					<td><fmt:formatNumber value="${totalPrice}" type="currency" /></td>
				</tr>
			</table>
	
			<table id="cartList">
				<h3> 주문 상품 정보 </h3>
				<tr>
					<th>상품명</th>
					<th>상품별주문번호</th>
					<th>수량</th>
					<th>가격</th>
					<th>처리 상태</th>
				</tr>
				<c:forEach items="${orderList}" var="orderVO">
					<tr>
						<td>${orderVO.pname}</td>
						<td>${orderVO.oseq}</td>
						<td>${orderVO.quantity}</td>
						<td><fmt:formatNumber value="${orderVO.price2*orderVO.quantity}" type="currency" /></td>
						<td>
							<c:choose>
								<c:when test="${orderVO.result == '1'}">진행 중</c:when>
								<c:otherwise><span style="color:red">처리 완료</span></c:otherwise>
							</c:choose>
						</td>
					</tr>
				</c:forEach>
			</table>
	
			<div class="clear"></div>
			<div id="buttons" style="float: right">
				<input type="button" value="쇼핑 계속하기" class="cancel"
					onclick="location.href='NonageServlet?command=index'">
			</div>
		</form>
	</article>


<%@ include file="../footer.jsp"%>
