<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
	<a href="${pageContext.request.contextPath}/AddQuestion">문의하기</a>
	<table>
		<tr>
			<th>번호</th>
			<th>카테고리</th>
			<th>주문자 아이디</th>
			<th>주문번호</th>
			<!-- 답변이 안달렸으면 보이게 달리면 안보이게 -->
			<c:if test="${q.flag eq 'N'}">
				<th>수정 / 삭제</th>
			</c:if>
		</tr>
		<c:forEach var="q" items="${list}">
			<tr>
				<td>
					<a href="${pageContext.request.contextPath}/QuestionOne?questionCode=${q.questionCode}">
					${q.questionCode}</a>
				</td>
				<td>${q.category}</td>
				<td>${q.customerId}</td>
				<td>${q.orderCode}</td>
				<!-- 답변이 안달렸으면 보이게 달리면 안보이게 -->
				<c:if test="${q.flag eq 'N'}">
					<td>
						<a href="${pageContext.request.contextPath}/ModifyQuestion?questionCode=${q.questionCode}">수정</a> /
						<a href="${pageContext.request.contextPath}/RemoveQuestion?questionCode=${q.questionCode}">삭제</a> 
					</td>
				</c:if>
			</tr>
		</c:forEach>
	</table>
</body>
</html>