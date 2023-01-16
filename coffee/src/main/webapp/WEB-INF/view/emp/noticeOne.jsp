<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지 상세보기</title>
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
	<br><br><br>
	<div class="container">
		
		<br><br>
		<div>
			<h2>
				${n.noticeTitle}
			</h2>
			<span style="float:right">${n.createdate}</span>
			
		</div>
		<br>
		<hr style="height: 3px; background-color:black;">
		
			<img src="${pageContext.request.contextPath}/image/bg${n.noticeCode}.png" width="100%">		
			<h4 style=" text-align: center;">
				<br> ${n.noticeContent}
			</h4>
		
		<br><br>
		<!-- 관리자만 수정 삭제가 보이게 할 것 -->
		<div style="float:right">
			<c:if test="${loginEmp!=null}">
				<button type="button" class="btn btn-outline-dark" onclick="location.href='${pageContext.request.contextPath}/ModifyNotice?noticeCode=${n.noticeCode}'">수정</button>
				<button type="button" class="btn btn-outline-dark" onclick="location.href='${pageContext.request.contextPath}/RemoveNotice?noticeCode=${n.noticeCode}'">삭제</button>
				
			</c:if>
		</div>
	</div>
	<br><br><br><br><br><br><br><br><br><br><br><br>
	<!--footer -->
	<footer class="footer">
		<img alt="" src="${pageContext.request.contextPath}/image/footeer.png" style="width: 100%; height: auto; ">
	</footer>
</body>
</html>