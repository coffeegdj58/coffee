<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>AddGoods</title>
			<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,700" rel="stylesheet">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/nav/fonts/icomoon/style.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/nav/css/owl.carousel.min.css">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/nav/css/bootstrap.min.css">
    
    <!-- Style -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/nav/css/style.css">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
	</head>
	<body>
		<div>	
		<jsp:include page="../nav.jsp"></jsp:include> 
		<!-- include의 주소에는 context를 사용하지 않는다 편한 액션 중하나 -->
		</div>	
		<h1>상품 추가</h1>
		<a href="${pageContext.request.contextPath}/goodsList">goodsList</a>
		<form action="${pageContext.request.contextPath}/AddGoods" method="post" enctype="multipart/form-data">
			<div>goodsName : <input type="text" name="goodsName"></div>
			<div>goodsPrice : <input type="number" name="goodsPrice"></div>
			<div>soldout : Y<input type="radio" name="soldout" value="Y">N<input type="radio" name="soldout" value="N"></div>
			<div>
			<select name="categoryCode">
				<c:forEach var="c" items="${categorylist}">
						<option value="${c.categoryCode}">${c.categoryKind}  ${c.categoryName}</option>
				</c:forEach>
			</select>
			</div>
			<div>goodsContent : <textarea rows="3" cols="50" name= "goodsContent"></textarea></div>
			<div>goodsInfo : <input type="text" name="goodsInfo"></div>		
			<div>file : <input type="file" name="filename" accept="image/jpeg, image/png"></div>
			<button type="submit">상품 추가</button>
		</form>
	</body>
</html>