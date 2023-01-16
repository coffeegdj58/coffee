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

		<style type="text/css">
	html, body {
	    height: 100%
	}
	
	#wrap {
	    min-height: 100%;
	    position: relative;
	    padding-bottom: 60px;
	}
	
	footer {
	    bottom: 0;
	}
	<!--하단 footer 고정-->
	</style>
</head>
<body>
<div>	
		<jsp:include page="../nav.jsp"></jsp:include> 
		<!-- include의 주소에는 context를 사용하지 않는다 편한 액션 중하나 -->
	</div>
	<div>
		<h3 style="margin-left: 230px; margin-top: 50px; font-weight: bold;">문의하기</h3>
	</div>
	<div class="container">
		<div align="right" >
			<a href="${pageContext.request.contextPath}/AddQuestion" style="color: black;">글쓰기</a>
		</div>
	<table class="table"
			style="margin-left: auto; margin-right: auto; margin-top: 20px; width: 100%">
			<thead style="text-align: center;">
				<tr>
					<th>번호</th>
					<th>카테고리</th>
					<th>주문자 아이디</th>
					<th>주문번호</th>
					<th>수정 / 삭제</th>
				</tr>
			</thead>
			<tbody style="text-align: center;">
				<c:forEach var="q" items="${list}">
					<tr>
						<td>
							<a href="${pageContext.request.contextPath}/QuestionOne?questionCode=${q.questionCode}" style="color: black;">
							${q.questionCode}</a>
						</td>
						<td>${q.category}</td>
						<td>${q.customerId}</td>
						<td>${q.orderCode}</td>
						<!-- 답변이 안달렸으면 보이게 달리면 안보이게 -->
					<c:if test="${q.flag eq 'N'}">
						<td>
							<a href="${pageContext.request.contextPath}/ModifyQuestion?questionCode=${q.questionCode}" style="color: black;">수정</a> /
							<a href="${pageContext.request.contextPath}/RemoveQuestion?questionCode=${q.questionCode}" style="color: black;">삭제</a> 
						</td>
					</c:if>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
	<br><br><br><br>
	<footer class="footer">
		<img alt="" src="${pageContext.request.contextPath}/image/footeer.png" style="width: 100%; height: auto; ">
	</footer>
</body>
</html>