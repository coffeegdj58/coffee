<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지 수정하기</title>
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
	
<form action="${pageContext.request.contextPath}/ModifyNotice" method="post">
		<input type="hidden" name="noticeCode" value="${n.noticeCode}"> 
		<table>
			<tr>
				<td>제목</td>
				<td><input type="text" name="noticeTitle" value="${n.noticeTitle }"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea cols="30" rows="10" name="noticeContent">${n.noticeContent}</textarea></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><input type="text" name="empId" value="${n.empId}" readonly="readonly"></td>
			</tr>
		</table>
		<button type="submit">수정</button>
	</form>
</body>
</html>