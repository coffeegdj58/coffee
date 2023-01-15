<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 수정하기</title>
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
	
<form action="${pageContext.request.contextPath}/ModifyEmp" method="post">
		<input type="hidden" name="empCode" value="${e.empCode}"> 
		<table>
			<tr>
				<td>사원 아이디</td>
				<td><input type="text" name="empId" value="${e.empId}"></td>
			</tr>
			<tr>
				<td>사원 이름</td>
				<td><input type="text" name="empName" value="${e.empName}" readonly="readonly"></td>
			</tr>
			<tr>
				<td>계정 사용 유/무</td>
				<c:if test="${e.active=='Y'}">
					<td><input type="radio" name="active" value="Y" checked="checked">Y</td>
					<td><input type="radio" name="active" value="N">N</td>
				</c:if>
				<c:if test="${e.active=='N'}">
					<td><input type="radio" name="active" value="Y">Y</td>
					<td><input type="radio" name="active" value="N" checked="checked">N</td>
				</c:if>
			</tr>
			<tr>
				<td>관리자 등급</td>
				<td>
					<select name="authCode">
						<option value="1">바리스타</option>
						<option value="2">매니저</option>
						<option value="3">슈퍼바이저</option>
					</select>
				</td>
			<tr>
				<td>입사일</td>
				<td><input type="text" name="createdate" value="${e.createdate}"></td>
			</tr>
		</table>
		<button type="submit">수정</button>
	</form>
	
	<!--footer -->
	<footer class="footer">
		<img alt="" src="${pageContext.request.contextPath}/image/footeer.png" style="width: 100%; height: auto; ">
	</footer>
</body>
</html>