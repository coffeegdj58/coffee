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
		<table class="table"
			style="margin-left: auto; margin-right: auto; margin-top: 20px; width: 100%">
			<thead style="text-align: center;">
				<tr>
					<td>문의 번호</td>
					<td>문의내용</td>
					<td>카테고리</td>
					<td>주문 번호</td>
					<td>주문자 아이디</td>
				</tr>
				</thead>
				<tbody style="text-align: center;">
					<tr>
						<td>${q.questionCode}</td>
						<td>${q.questionMemo}</td>
						<td>${q.category}</td>
						<td>${q.orderCode}</td>
						<td>${q.customerId}</td>
					</tr>
				</tbody>
			</table>
			
		
		<!-- 답변이 달리기 전이고 관리자만 보이게 해야함 -->
		<c:if test="${q.flag eq 'N' && loginEmp!=null}">
			<a href="${pageContext.request.contextPath}/AddComment?questionCode=${q.questionCode}">답변 추가</a>
		</c:if>
		<!-- 관리자가 답변을 달면 보이게 -->
		<c:if test="${q.flag eq 'Y'}">
		<hr>
				<div>
				답변 내용: ${c.commentMemo}
				</div>
				<div>
				 날짜: ${c.createdate}
				</div>
		</c:if>
		<c:if test="${q.flag eq 'Y' && loginEmp!=null}">
			<a href="${pageContext.request.contextPath}/RemoveComment?commentCode=${c.commentCode}&questionCode=${q.questionCode}">답변 삭제</a>
		</c:if>
	</div>
	
	<!--footer -->
	<footer class="footer" style="margin-top: 30px;">
		<img alt="" src="${pageContext.request.contextPath}/image/footeer.png" style="width: 100%; height: auto; ">
	</footer>	
</body>
</html>