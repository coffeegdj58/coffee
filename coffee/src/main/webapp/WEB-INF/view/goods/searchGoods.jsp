<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,700" rel="stylesheet">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/nav/fonts/icomoon/style.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/nav/css/owl.carousel.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/nav/css/bootstrap.min.css">
    
    <!-- Style -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/nav/css/style.css">
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
html, main {
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
	<br><br>
	<div class="container">
		<h3>검색결과</h3>
		<br>
		<c:if test="${empty list}">
			<div>검색결과가 없습니다</div>
		</c:if>
		<table> 
			<tr>
				<c:forEach var="b" items="${list}" varStatus="s">
					<c:if test="${s.index != 0 && s.index % 3 == 0}">
						</tr><tr>
					</c:if>
					 
					<td>
						<div><a href="${pageContext.request.contextPath}/GoodsOne?goodsCode=${b.goodsCode}"><img src="${pageContext.request.contextPath}/image/${b.goodsName}.jpg" width="400" height="400"></div></a><br>
						<div style="text-align: center;">${b.goodsName}</div>
						<br>
					</td>
				</c:forEach>
			</tr>
	
		</table>
		
		<!--footer -->
		<footer class="footer">
			<img alt="" src="${pageContext.request.contextPath}/image/footeer.png" style="width: 100%; height: auto; ">
		</footer>
	</div>
</body>
</html>