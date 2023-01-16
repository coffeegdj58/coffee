<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지 추가하기</title>
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
	<br><br><br><br>
	<div class="container">	
		<h1>공지사항 작성</h1>
		<hr style="height: 3px; background-color:black;">
		<form action="${pageContext.request.contextPath}/AddNotice" method="post">
			<table width="100%">
				<tr>
					<td>제목</td>
					<td><input type="text" name="noticeTitle"></td>
				</tr>
				<tr><td colspan="2"><hr></td></tr>
				<tr>
					<td>내용</td>
					<td><textarea cols="30" rows="10" name="noticeContent"></textarea></td>
				</tr>
				<tr><td colspan="2"><hr></td></tr>
				<tr>
					<td>작성자</td>
					<td><input type="text" name="empId" value="admind" readonly="readonly"></td>
				</tr>
				<tr><td colspan="2"><hr></td></tr>
			</table>
			<br><br>
			<button class="btn btn-outline-dark btn-lg" type="submit">추가</button>
		</form>
	</div>
	<br><br><br><br><br><br><br><br><br><br><br><br>
	<!--footer -->
	<footer class="footer">
		<img alt="" src="${pageContext.request.contextPath}/image/footeer.png" style="width: 100%; height: auto; ">
	</footer>
</body>
</html>