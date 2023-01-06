<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>	
		<jsp:include page="../nav.jsp"></jsp:include> 
		<!-- include의 주소에는 context를 사용하지 않는다 편한 액션 중하나 -->
	</div>
	<table border="1">
		<tr>
			<td>사진</td>
			<td>주문번호</td>
			<td>주문상태</td>
			<td>상품이름</td>
			<td>상품가격</td>
		</tr>
		<c:forEach var="o" items="${orderList}">
		<tr>
			<td><img src="${pageContext.request.contextPath}/image/${o.categoryKind}/${o.categoryName}/${o.goodsName}.jpg" width= "150px" height="150px"></td>
			<td>${o.orderCode}</td>
			<td>${o.orderState}</td>
			<td>${o.goodsName}</td>
			<td>${o.goodsPrice}</td>
		</tr>
		</c:forEach>
	</table>
	<a href="${pageContext.request.contextPath}/ModifyCustomerController">회원정보수정</a>
	<a href="${pageContext.request.contextPath}/PointPageController">포인트</a>
	<a href="${pageContext.request.contextPath}/AddressCustomerController">주소관리</a>
	<a href="${pageContext.request.contextPath}/customer/questionList">고객센터</a>
	
</body>
</html>