<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 회원가입</title>
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
	
	<form action="${pageContext.request.contextPath}/AddEmp" method="post">
		<table>
			<tr>
				<td>관리자 아이디</td>
				<td><input type="text" name="empId"> </td>
			</tr>
			<tr>
				<td>관리자 이름</td>
				<td><input type="text" name="empName"> </td>
			</tr>
			<tr>
				<td>관리자 비밀번호</td>
				<td><input type="password" name="empPwCk"> </td>
			</tr>
			<tr>
				<td>관리자 비밀번호 확인</td>
				<td><input type="password" name="empPw"> </td>
			</tr>
		</table>
		<button type="submit">회원가입</button>
	</form>
</body>
</html>