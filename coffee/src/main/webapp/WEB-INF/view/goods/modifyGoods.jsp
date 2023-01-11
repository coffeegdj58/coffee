<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>ModifyGoods</title>
	</head>
	<body>
		<form action="${pageContext.request.contextPath}/ModifyGoods" method="post" enctype="multipart/form-data">
			<input type="hidden" name="goodsCode" value="${m.goodsCode}">
			<input type="text" name="goodsName" value='${m.goodsName}' readonly='readonly'>
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
			<button type="submit">수정</button>
		</form>
	</body>
</html>