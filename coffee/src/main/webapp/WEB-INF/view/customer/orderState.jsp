<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,700" rel="stylesheet">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/nav/fonts/icomoon/style.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/nav/css/owl.carousel.min.css">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/nav/css/bootstrap.min.css">
    
    <!-- Style -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/nav/css/style.css">

</head>
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
<body>
<div>	
		<jsp:include page="../nav.jsp"></jsp:include> 
		<!-- include의 주소에는 context를 사용하지 않는다 편한 액션 중하나 -->
	</div>
	<br><br><br>
	<div class="container">
		<h1>배송조회</h1>
		
		<hr style="height: 3px; background-color:black;" width="100%">
		<br><br>
		<c:if test="${order.orderState=='결제'}">
			<img src="${pageContext.request.contextPath}/image/결제.png" width="100%" height="auto">
		</c:if>
		
		<c:if test="${order.orderState=='배송중'}">
			<img src="${pageContext.request.contextPath}/image/배송중.png">
		</c:if>
		
		<c:if test="${order.orderState=='배송완료'}">
			<img src="${pageContext.request.contextPath}/image/배송완료.png">
		</c:if>
		
		<c:if test="${order.orderState=='구매확정'}">
			<img src="${pageContext.request.contextPath}/image/구매확정.png">
		</c:if>

		<hr>
		<br><br>
		<h2>상품정보</h2>
		<hr style="height: 3px; background-color:black;" width="100%">
		
		<table width="100%">
			<tr>
				<td>상품명</td>
				<td>수량</td>
				<td>상품가격</td>
	
			</tr>
			<tr><td colspan="3"><hr></td></tr>
			<tr>
				<td><img src="${pageContext.request.contextPath}/image/${goods.goodsName}.jpg" width="200px" height="200px"> ${goods.goodsName}</td>
				<td>${order.orderQuantity}</td>
				<td>${order.orderPrice}</td>

			</tr>
		</table>
		<br><br>
		<h2>배송정보</h2>
		<hr style="height: 3px; background-color:black;" width="100%">
		
		<table width="100%">
				<tr>
					<td>구매자 이름</td>
					<td>${loginMember.customerName}</td>
				</tr>
				<tr>
					<td>배송지 주소</td>
					<td>${address.address}</td>
				</tr>
				<tr>
					<td>수취인 연락처</td>
					<td>${loginMember.customerPhone}</td>
				</tr>
			</table>
	
	</div>
	<br><br><br><br><br><br><br>
	<footer class="footer">
		<img alt="" src="${pageContext.request.contextPath}/image/footeer.png" style="width: 100%; height: auto; ">
	</footer>
</body>
</html>