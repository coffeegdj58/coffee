<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결제페이지</title>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,700" rel="stylesheet">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/nav/fonts/icomoon/style.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/nav/css/owl.carousel.min.css">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/nav/css/bootstrap.min.css">
    
    <!-- Style -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/nav/css/style.css">

   
</head>

<body>
<div>	
		<jsp:include page="../nav.jsp"></jsp:include> 
		<!-- include의 주소에는 context를 사용하지 않는다 편한 액션 중하나 -->
</div>
<form action = "${pageContext.request.contextPath}/Payment" method="post">

	<h1>주문/결제</h1>
	<br>
	<h2>구매자정보</h2>
		<table border='1'>
				<tr>
					<td>이름</td>
					<td>${loginMember.customerName}</td>
				</tr>
				<tr>
					<td>휴대폰 번호</td>
					<td>${loginMember.customerPhone}</td>
				</tr>
				<tr>
					<td>주소</td>
					<td>
					<select name="addressCode">
						<c:forEach var="a" items='${addressList}'>
							<option value="${a.addressCode}">
								${a.address}<c:if test="${a.flag==1 }">(기본배송지)</c:if>
							</option>
						</c:forEach>
					</select>
					</td>
				</tr>
		</table>
		<br>
	<h2>배송</h2>
		<table border='1'>
			<tr>
				<td>상품이름</td>
				<td>상품사진</td>
				<td>가격</td>
				<td>수량</td>
			</tr>
			<c:forEach var="c" items="${cartList}">
				<tr>
					<td>${c.goodsName}</td>
					<td><img width='200px' height="200px" src="${pageContext.request.contextPath}/image/${c.goodsName}.jpg"></td>
					<td>${c.cartPrice}</td>
					<td>${c.cartQuantity }</td>
				</tr>
			</c:forEach>
		</table>	
		<br>
	<h2>결제정보</h2>	
		<table border='1'>
			<tr>
				<td>총상품가격</td>
				<td>${sum}</td>
			</tr>
			<tr>
				<td>배송비</td>
				<td>0</td>
			</tr>
			<tr>
				<td>포인트</td>
				<td><input type="number" name="usePoint">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;보유: ${loginMember.point}</td>
			</tr>
			
			<tr>
				<td>결제방법</td>
				<td>신용카드</td>
			</tr>
		</table>
		<input type="hidden" value="${sum}" name="orderPrice">
		<button type="submit">결제하기</button>
</form>	
</body>
</html>