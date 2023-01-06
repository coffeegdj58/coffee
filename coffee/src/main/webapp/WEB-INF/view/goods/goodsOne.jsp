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
			<img src="${pageContext.request.contextPath}/}"/>
		</div>
		<div>${m.goodsName}</div>
		<div>${m.goodsPrice}</div>
		<c:if test = "${not empty loginEmp}">
			<a href="${pageContext.request.contextPath}/modifyGoods?goodsCode=${m.goodsCode}">수정</a>
			<a href="${pageContext.request.contextPath}/removeGoods?goodsCode=$filename=${m.filename}">삭제</a>
		</c:if>
	</body>
</html>