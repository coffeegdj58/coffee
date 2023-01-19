<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문완료</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
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

</style>
   
</head>
<body>
	<div>	
		<jsp:include page="../nav.jsp"></jsp:include> 
		<!-- include의 주소에는 context를 사용하지 않는다 편한 액션 중하나 -->
	</div>
	<br><br>
	<div class="container">
		<h2>주문 완료</h2>
		<hr style="height: 3px; background-color:black;">
		
		<h2 style="text-align: center;">주문해주셔서 감사합니다 빠르게 배달해드리겠습니다</h2>
		<br>	

		<h3 style="text-align: center;">결제 금액 : <fmt:formatNumber value="${sum}" pattern="#,###"/></h3>
		<hr>
		<br><br>
		<h4>Order Info</h4>
		<hr style="height: 3px; background-color:black;">
		<table width="100%">
			<tr>
				<td>상품명</td>
				<td>수량</td>
				<td>상품가격</td>
				<td>합계</td>

			</tr>
			<tr><td colspan="4"><hr></td></tr>	
			<c:forEach var="c" items="${list}">
				<tr>
					<td><img src="${pageContext.request.contextPath}/image/${c.goodsName}.jpg" width="200px" height="200px"> ${c.goodsName}</td>
					<td>${c.cartQuantity}</td>
					<td><fmt:formatNumber value="${c.cartPrice/c.cartQuantity}" pattern="#,###"/></td>
					<td><fmt:formatNumber value="${c.cartPrice}" pattern="#,###"/></td>
				</tr>
			</c:forEach>
		</table>
		
		<br><br>
		<hr>
		<h4>배송정보내역</h4>
		<hr style="height: 3px; background-color:black;">
		<table width="100%">
			<tr>
				<td>구매자 이름</td>
				<td>${loginMember.customerName}</td>
			</tr>
			<tr><td colspan="2"><hr></td></tr>
			<tr>
				<td>배송지 주소</td>
				<td>${address.address}</td>
			</tr>
			<tr><td colspan="2"><hr></td></tr>
			<tr>
				<td>수취인 연락처</td>
				<td>${loginMember.customerPhone}</td>
			</tr>
		</table>
		<hr>
	</div>
	<br><br><br><br>
		<div style="text-align: center;">
			<button type="button" class="btn btn-outline-dark btn-lg" onclick="location.href='${pageContext.request.contextPath}/CoffeeList'">계속 쇼핑하기</button>
			<button type="button" class="btn btn-outline-dark btn-lg" onclick="location.href='${pageContext.request.contextPath}/CustomerPage'">마이페이지로 가기</button>
		</div>
		
	<br><br>	
	<footer class="footer">
		<img alt="" src="${pageContext.request.contextPath}/image/footeer.png" style="width: 100%; height: auto; ">
	</footer>
</body>
</html>