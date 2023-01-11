<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의 목록</title>
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
	
	<!--  검색창 -->
	<form action="${pageContext.request.contextPath}/QuestionListByEmp" method="post">
		<label for="searchWord">검색 : </label>
		<input type="text" name="searchWord" id="searchWord">
		<button type="submit">검색</button>
	</form>
	<table>
		<tr>
			<th>카테고리</th>
			<th>질문 코드</th>
			<th>주문자 아이디</th>
			<th>주문번호</th>
			<th>답변 유/무 </th>
			
		</tr>
		<c:forEach var="q" items="${list}">
			<tr>
				<td>${q.category}</td>
				<td>
					<a href="${pageContext.request.contextPath}/QuestionOne?questionCode=${q.questionCode}">
					${q.questionCode}</a>
				</td>
				<td>${q.customerId}</td>
				<td>${q.orderCode}</td>
				<!-- 답변 달기 전이면 빨간색으로 글씨 표시.. -->
				<td>${q.flag}</td>
			</tr>
		</c:forEach>
	</table>
	
	<a href="${pageContext.request.contextPath}/QuestionListByEmp?currentPage=1">처음</a>
	<c:if test="${currentPage > 1}">
		<a href="${pageContext.request.contextPath}/QuestionListByEmp?currentPage=${currentPage-1}&rowPerPage=${rowPerPage}">이전</a>
	</c:if>
	<c:if test="${currentPage < lastPage}">
		<a href="${pageContext.request.contextPath}/QuestionListByEmp?currentPage=${currentPage+1}&rowPerPage=${rowPerPage}">이후</a>
	</c:if>
	<a href="${pageContext.request.contextPath}/QuestionListByEmp?currentPage=${lastPage}">마지막</a>
</body>
</html>