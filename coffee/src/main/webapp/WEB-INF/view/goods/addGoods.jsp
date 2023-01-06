<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>AddGoods</title>
	</head>
	<body>
		<h1>상품 추가</h1>
		<a href="${pageContext.request.contextPath}/goodsList">goodsList</a>
		<form action="${pageContext.request.contextPath}/addGoods" method="post" enctype="multipart/form-data">
			<div>goodsName : <input type="text" name="goodsName"></div>
			<div>goodsPrice : <input type="number" name="goodsName"></div>
			<div>soldout : Y<input type="radio" name="soldout" value="Y">N<input type="radio" name="soldout" value="N"></div>
			<div>hit : <input type="number" name="hit"></div>
			<div>file : <input type="file" name="filename" accept="image/jpeg, image/png"></div>
			<button type="submint">상품 추가</button>
		</form>
	</body>
</html>