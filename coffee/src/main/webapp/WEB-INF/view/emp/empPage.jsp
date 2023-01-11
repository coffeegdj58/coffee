<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>괸리자 페이지</title>
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
	
	<!--최고 관리자만 접근 가능하게 할 것  -->
	<table>
		<tr>
			<th>사원 이름</th>
			<th>사원 아이디</th>
			<th>계정 사용 가능</th>
			<th>관리자 등급</th>
			<th>입사일</th>
			<!-- 최고 관리자만 사용 가능하게 끔 -->
			<c:if test="${loginEmp.authCode==3}">
				<th>수정</th>
				<th>삭제</th>
			</c:if>
		</tr>
		<c:forEach var="e" items="${list}">
			<tr>
				<td>${e.empName}</td>
				<td>${e.empId}</td>
				<td>${e.active}</td>
				<td>${e.authCode}</td>
				<td>${e.createdate}</td>
				<!-- 최고 관리자만 사용 가능하게 끔 -->
				<c:if test="${loginEmp.authCode==3}">
					<td><a href="${pageContext.request.contextPath}/ModifyEmp?empCode=${e.empCode}">수정 </a></td>
					<td><a href="${pageContext.request.contextPath}/RemoveEmp?empCode=${e.empCode}">삭제 </a></td>
				</c:if>
			</tr>
		</c:forEach>
	</table>
</body>
</html>