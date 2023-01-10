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
	<h1>${loginMember.point}</h1>
	<table border="1">
		<tr>
			<td>사진</td>
			<td>주문번호</td>
			<td>주문상태</td>
			<td>상품이름</td>
			<td>상품가격</td>
			<td>리뷰작성</td>
			<td>취소하기</td>
			<td>배송조회</td>
		</tr>
		<c:forEach var="o" items="${orderList}">
		<tr>
			<td><img src="${pageContext.request.contextPath}/image/${o.categoryKind}/${o.categoryName}/${o.goodsName}.jpg" width= "150px" height="150px"></td>
			<td>${o.orderCode}</td>
			<td>${o.orderState}</td>
			<td>${o.goodsName}</td>
			<td>${o.goodsPrice}</td>
			<td><a href="${pageContext.request.contextPath}/AddReview?orderCode=${o.orderCode}">리뷰작성하기</a></td>
			<c:if test="${o.orderState.equals('결제')}">
				<td><a href="${pageContext.request.contextPath}/ModifyOrder?orderCode=${o.orderCode}">취소하기</a></td>
			</c:if>
			<c:if test="${o.orederState.equals('결제')==false}">
				<td><a href="${pageContext.request.contextPath}/ModifyOrder?orderCode=${o.orderCode}">반품,환불하기</a></td>
			</c:if>
			
			<td><a href="${pageContext.request.contextPath}/OrderOne?orderCode=${o.orderCode}">배송조회하기</a></td>
		
		</tr>
		
		</c:forEach>
	</table>
	<a href="${pageContext.request.contextPath}/CartList">장바구니</a>
	<a href="${pageContext.request.contextPath}/ModifyCustomer">회원정보수정</a><!-- check -->
	<a href="${pageContext.request.contextPath}/PointPage">포인트</a><!--check -->
	<a href="${pageContext.request.contextPath}/AddressCustomer">주소관리</a>  
	<a href="${pageContext.request.contextPath}/QuestionList">고객센터</a>
	
</body>
</html>