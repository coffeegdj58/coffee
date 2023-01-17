<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객문의목록</title>
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
	<div class="container" style="margin-top: 40px;">
		<div>
			<h1>고객문의목록</h1>
		</div>
		<!--  검색창 -->
		<div align="right" >
			<form action="${pageContext.request.contextPath}/QuestionListByEmp" method="post">
				<input type="text" name="searchWord" id="searchWord" placeholder="검색어를 입력하세요.">
				<button type="submit" class="btn btn-dark">검색</button>
			</form>
		</div>	
		<table class="table"
			style="margin-left: auto; margin-right: auto; margin-top: 20px; width: 100%">
			<thead style="text-align: center;">
				<tr>
					<th>카테고리</th>
					<th>질문 코드</th>
					<th>주문자 아이디</th>
					<th>주문번호</th>
					<th>답변 상황</th>
					
				</tr>
			</thead>
			<tbody style="text-align: center;">
				<c:forEach var="q" items="${list}">
					<tr>
						<td>${q.category}</td>
						<td>
							<a href="${pageContext.request.contextPath}/QuestionOne?questionCode=${q.questionCode}" style="color: black;">
							${q.questionCode}</a>
						</td>
						<td>${q.customerId}</td>
						<td>${q.orderCode}</td>
						<!-- 답변 달기 전이면 빨간색으로 글씨 표시.. -->
						<c:if test="${q.flag eq 'N'}">
							<td style="color: red;">${q.flag}</td>
						</c:if>
						<c:if test="${q.flag eq 'Y'}">
							<td>${q.flag}</td>
						</c:if>
						
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div style="text-align: center;" >
		<button type="button" class="btn btn-outline-dark" onclick="location.href='${pageContext.request.contextPath}/QuestionListByEmp?currentPage=1'">처음</button>
		<c:if test="${currentPage > 1}">
			<button type="button" class="btn btn-outline-dark" onclick="location.href='${pageContext.request.contextPath}/QuestionListByEmp?currentPage=${currentPage-1}&rowPerPage=${rowPerPage}'">이전</button>
		</c:if>
		<c:if test="${currentPage < lastPage}">
			<button type="button" class="btn btn-outline-dark" onclick="location.href='${pageContext.request.contextPath}/QuestionListByEmp?currentPage=${currentPage+1}&rowPerPage=${rowPerPage}'">이전</button>
		</c:if>
		<button type="button" class="btn btn-outline-dark" onclick="location.href='${pageContext.request.contextPath}/QuestionListByEmp?currentPage=${lastPage}'">마지막</button>
	</div>
	
	<!--footer -->	
	<footer class="footer">
		<img src="${pageContext.request.contextPath}/image/footeer.png" style="width: 100%; height: auto;">
	</footer>
</body>
</html>