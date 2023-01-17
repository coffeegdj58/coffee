<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객 목록</title>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,700" rel="stylesheet">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/nav/fonts/icomoon/style.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/nav/css/owl.carousel.min.css">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/nav/css/bootstrap.min.css">
    
    <!-- Style -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/nav/css/style.css">
<style type="text/css">
html, body {
    height: 100%
}

#wrap {
    min-height: 100%;
    position: relative;
    padding-bottom: 60px;
}

footer {
    bottom: 0;
}
<!--하단 footer 고정-->
</style>
</head>
<body>
	<div>	
			<jsp:include page="../nav.jsp"></jsp:include> 
			<!-- include의 주소에는 context를 사용하지 않는다 편한 액션 중하나 -->
	</div>
	<div class="container" style="margin-top: 40px;">
		<!-- 공지사항은 회원 비회원 모두가 볼 수있게  -->
		<div>
			<h1>고객 목록</h1>
		</div> 
		<hr style="height: 3px; background-color:black;">

	<table class="table" width="100%">
		<thead style="text-align: center;" >
			<tr>
				<td>주문번호</td>
				<td>상품번호</td>
				<td>주문자 아이디</td>
				<td>주문 수량</td>
				<td>주문 상태</td>
				<td>주문 상태</td>
				<td>주문 일자</td>
			</tr>
		</thead> 
		<tbody style="text-align: center;">
			<c:forEach var="O" items="${Olist}">
			<form action="${pageContext.request.contextPath}/OrderList" method="post" id="modifyForm${O.orderCode}">
				<input type="hidden" name="orderCode" value="${O.orderCode}">
				<input type="hidden" name="customerId" value="${O.customerId}">
				<tr>
					<td>${O.orderCode}</td>
					<td>${O.goodsCode}</td>
					<td>${O.customerId}</td>
					<td>${O.orderQuantity}</td>
					<td>
						<c:if test="${O.orderState eq '결제' }">
							<select name="orderState" id="orderState${O.orderCode}">
								<option value="결제" selected="selected" >결제</option>
								<option value="취소">취소</option>
								<option value="배송중">배송중</option>
								<option value="구매완료">구매완료</option>
								<option value="구매확정">구매확정</option>
							</select>
						</c:if>
						<c:if test="${O.orderState eq '취소' }">
							<select name="orderState" id="orderState${O.orderCode}">
								<option value="결제">결제</option>
								<option value="취소" selected="selected" >취소</option>
								<option value="배송중">배송중</option>
								<option value="구매완료">구매완료</option>
								<option value="구매확정">구매확정</option>
							</select>
						</c:if>
						<c:if test="${O.orderState eq '배송중' }">
							<select name="orderState" id="orderState${O.orderCode}">
								<option value="결제">결제</option>
								<option value="취소">취소</option>
								<option value="배송중" selected="selected">배송중</option>
								<option value="구매완료">구매완료</option>
								<option value="구매확정">구매확정</option>
							</select>
						</c:if>
						<c:if test="${O.orderState eq '구매완료' }">
							<select name="orderState" id="orderState${O.orderCode}">
								<option value="결제">결제</option>
								<option value="취소">취소</option>
								<option value="배송중">배송중</option>
								<option value="구매완료" selected="selected">구매완료</option>
								<option value="구매확정">구매확정</option>
							</select>
						</c:if>
						<c:if test="${O.orderState eq '구매확정' }">
							<select name="orderState" id="orderState${O.orderCode}">
								<option value="결제">결제</option>
								<option value="취소">취소</option>
								<option value="배송중">배송중</option>
								<option value="구매완료">구매완료</option>
								<option value="구매확정" selected="selected">구매확정</option>
							</select>
						</c:if>
					</td>
					<td>${O.createdate}</td>
				</tr>
			</form>
			</c:forEach>
		</tbody>
	</table>
	</div>
	<c:forEach var="O" items="${Olist}">
	<script>
		$(document).ready(function(){	
				$('#orderState${O.orderCode}').change(function(){
					$('#modifyForm${O.orderCode}').submit();
					
				})
		})		
	</script>
	</c:forEach>
	<!--footer -->
	<footer class="footer" style="margin-top: 30px;">
		<img alt="" src="${pageContext.request.contextPath}/image/footeer.png" style="width: 100%; height: auto; ">
	</footer>		
</body>
</html>