<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>GoodsOne</title>
	</head>
	<body>
		<div>	
		<jsp:include page="../nav.jsp"></jsp:include> 
		<!-- include의 주소에는 context를 사용하지 않는다 편한 액션 중하나 -->
		</div>
		<div>
			<img width="300px" height= "300px" src="${pageContext.request.contextPath}/image/${g.goodsName}.jpg"/>
		</div>
		<div>${g.goodsName}</div>
		<div>${g.goodsPrice}</div>
		<div>${g.goodsContent}</div>
		<div>${g.goodsInfo}</div>
		
		<form action="${pageContext.request.contextPath}/GoodsOne" method="post">
			<input type="hidden" name= "goodsCode" value="${g.goodsCode}">
			<select name="cartQuantity">
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
			</select>
			<button type="submit">장바구니에 담기</button>
		</form>
		<c:if test="${result==1}">
			<div>장바구니에 담았습니다</div>
		</c:if>
		<form action="${pageContext.request.contextPath}/PaymentOne" method="post">
			<input type="hidden" name= "goodsCode" value="${g.goodsCode}">
			<select name="cartQuantity">
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
			</select>
			<button type="submit">바로구매</button>
		</form>
		
		
		<c:if test = "${not empty loginEmp}">
			<a href="${pageContext.request.contextPath}/ModifyGoods?goodsCode=${g.goodsCode}">수정</a>
			<a href="${pageContext.request.contextPath}/RemoveGoods?goodsCode=${g.goodsCode}">삭제</a>
		</c:if>
	</body>
</html>