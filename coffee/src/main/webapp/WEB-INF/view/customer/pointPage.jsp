<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
     <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>포인트페이지</title>
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
	<div><img src="${pageContext.request.contextPath}/image/myPage.png"></div>
	<br>
	
	<br><br>
	
	<div class="container">
	
		<br><br>
		<div class="row">
			<div class="col-12" style="text-align: center;" >
			<table width="90%">
				<tr>
					<td colspan="2" width="50%"><h3 style="text-align: center;"> 잔여포인트:&nbsp;&nbsp;&nbsp; <fmt:formatNumber value="${loginMember.point}" pattern="#,###"/>Pt</h3></td>	
				</tr>
				<tr><td>&nbsp;</td></tr>		
				<tr><td colspan="2"><img src="${pageContext.request.contextPath}/image/point.jpg" width="400px" heigth="400px"></td></tr>
				<tr><td>&nbsp;</td></tr>
				<tr><td>&nbsp;</td></tr>
				<c:forEach var="p" items="${list}">
							<tr>
								<td>${p.createdate}</td>
							</tr>
							<tr>
								
								<td><h4>포인트 ${p.pointKind}</h4></td>
								<c:if test="${p.pointKind.equals('사용')}">
									<td><h4>-<fmt:formatNumber value="${p.point}" pattern="#,###"/>Pt</h4></td>
								</c:if>
								<c:if test="${p.pointKind.equals('적립')}">
									<td><h4><fmt:formatNumber value="${p.point}" pattern="#,###"/>Pt</h4></td>
								</c:if>
							</tr>
							<tr><td colspan=2><hr></td></tr>
				</c:forEach>	
			</table>
			</div>
		</div>
	</div>
	<br><br><br><br>
	<footer class="footer">
		<img alt="" src="${pageContext.request.contextPath}/image/footeer.png" style="width: 100%; height: auto; ">
	</footer>
</body>
</html>