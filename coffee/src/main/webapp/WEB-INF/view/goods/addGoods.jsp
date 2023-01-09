<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>AddGoods</title>
	</head>
	<body>
		<h1>상품 추가</h1>
		<a href="${pageContext.request.contextPath}/goodsList">goodsList</a>
		<form action="${pageContext.request.contextPath}/AddGoodsController" method="post" enctype="multipart/form-data">
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
			<div>goodsContent : <input type="text" name="goodsContent"></div>
			<div>goodsInfo : <input type="text" name="goodsInfo"></div>		
			<div>file : <input type="file" name="filename" accept="image/jpeg, image/png"></div>
			<button type="submit">상품 추가</button>
		</form>
	</body>
</html>