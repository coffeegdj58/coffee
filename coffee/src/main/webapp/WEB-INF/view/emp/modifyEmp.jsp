<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Emp 수정하기</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,700"
	rel="stylesheet">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/bootstrap/nav/fonts/icomoon/style.css">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/bootstrap/nav/css/owl.carousel.min.css">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/bootstrap/nav/css/bootstrap.min.css">

<!-- Style -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/bootstrap/nav/css/style.css">
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
<!--
하단
 
footer
 
고정--
>
</style>
</head>
<body>
	<div>
		<jsp:include page="../nav.jsp"></jsp:include>
		<!-- include의 주소에는 context를 사용하지 않는다 편한 액션 중하나 -->
	</div>
<div class="container" style="margin-top: 40px;">	
<h1>EMP 수정</h1>
<hr style="height: 3px; background-color:black;">
	<form action="${pageContext.request.contextPath}/ModifyEmp"
		method="post">
		<input type="hidden" name="empCode" value="${e.empCode}">
		<table  width="100%" >
			<tr>
				<td>사원 아이디 <input type="text" name="empId" value="${e.empId}" readonly="readonly" class="form-control"></td>
			</tr>
			<tr> <td><hr></td> </tr>
			<tr>
				<td>사원 이름  <input type="text" name="empName" value="${e.empName}" readonly="readonly" class="form-control"></td>
			</tr>
			<tr> <td><hr></td> </tr>
			<tr>
				<td>계정 사용 활성화 &nbsp;&nbsp;&nbsp;
					<c:if test="${e.active=='Y'}">
						<input type="radio" name="active" value="Y"checked="checked" >Y
						<input type="radio" name="active" value="N" >N
					</c:if>
					<c:if test="${e.active=='N'}">
						<input type="radio" name="active" value="Y">Y 
						<input type="radio" name="active" value="N" checked="checked" >N
					</c:if>
				</td>
			</tr>
			<tr> <td><hr></td> </tr>
			<tr>
				<td>관리자 등급 
					<c:if test="${e.authCode == 0 }">
						<select name="authCode" class="form-control">
							<option value="0" selected="selected">사원</option>
							<option value="1" >슈퍼바이져</option>
							<option value="2">매니저</option>
							<option value="3">바리스타</option>
						</select>
					</c:if>
					<c:if test="${e.authCode == 1 }">
						<select name="authCode" class="form-control">
							<option value="1" selected="selected" >슈퍼바이져</option>
							<option value="2">매니저</option>
							<option value="3">바리스타</option>
						</select>
					</c:if>
					<c:if test="${e.authCode == 2 }">
						<select name="authCode"class="form-control">
							<option value="1" >슈퍼바이져</option>
							<option value="2" selected="selected" >매니저</option>
							<option value="3">바리스타</option>
						</select>
					</c:if>
					<c:if test="${e.authCode == 3 }">
						<select name="authCode" class="form-control">
							<option value="1" >슈퍼바이져</option>
							<option value="2">매니저</option>
							<option value="3" selected="selected" >바리스타</option>
						</select>
					</c:if>
				</td>
			</tr>
			<tr> <td><hr></td> </tr>
			<tr>
				<td>입사일 <input type="text" name="createdate" value="${e.createdate}" class="form-control"></td>
			</tr>
			<tr> <td><hr></td> </tr>
		</table>
		<div style="text-align: center;">
			<button type="submit" class="btn btn-outline-dark btn-lg">수정</button>
		</div>
	</form>
</div>
	<!--footer -->
	<footer class="footer" style="margin-top: 40px;">
		<img alt="" src="${pageContext.request.contextPath}/image/footeer.png"
			style="width: 100%; height: auto;">
	</footer>
</body>
</html>