<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

</head>
<body>	
	<div>	
		<jsp:include page="../nav.jsp"></jsp:include> 
		<!-- include의 주소에는 context를 사용하지 않는다 편한 액션 중하나 -->
	</div>
	<br>
	<br>
	
	<div class="container">
	<h1>Point</h1>
		<div class="row">
			
			<br><br>
			<div style="text-align: center;" class="col-3">
				<h3>사용 가능 포인트</h3>
				<h3>${loginMember.point}</h3>
			</div>
			<div class="col-9">
				<table>
					<tr>
						<td>포인트</td>
						<td>적립/사용</td>
						<td>일자</td>
					</tr>
					<c:forEach var="p" items="${list}">
						<tr>
							<c:if test="${p.pointKind.equals('사용')}">
								<td>-${p.point}</td>
							</c:if>
							<c:if test="${p.pointKind.equals('적립')}">
								<td>${p.point}</td>
							</c:if>
							<td>${p.pointKind}</td>
							<td>${p.createdate}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>