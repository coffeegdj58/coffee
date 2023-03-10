<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 회원가입</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link
	href="https://fonts.googleapis.com/css?family=Roboto:300,400&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/bootstrap/loginCss/fonts/icomoon/style.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/bootstrap/loginCss/css/owl.carousel.min.css">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/bootstrap/loginCss/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<!-- Style -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/bootstrap/loginCss/css/style.css">
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
<!--하단 footer 고정-->
</style>
</head>
<body>
	<div>
		<jsp:include page="../nav.jsp"></jsp:include>
		<!-- include의 주소에는 context를 사용하지 않는다 편한 액션 중하나 -->
	</div>
	<div class="content">
		<div class="container">
			<div class="row">
				<div class="col-md-6">
					<img src="${pageContext.request.contextPath}/image/login.jpeg"
						alt="Image" class="img-fluid">
				</div>
				<div class="col-md-6 contents">
					<div class="row justify-content-center">
						<div class="col-md-8">
							<div class="mb-4">
								<h3>Manager Sign Up</h3>
							</div>
							<form action="${pageContext.request.contextPath}/AddEmp" method="post" id="signInForm">
								<div class="form-group first">
									<label for="username">관리자 아이디 </label> 
									<input type="text" name="empId" class="form-control" id="id">
								</div>
								<div class="form-group last mb-4">
									<label for="password">이름 </label>
									<input type="text" name="empName" class="form-control" id="name">
								</div>
								<div class="form-group last mb-4">
									<label for="password">비밀번호 </label>
									<input type="password" name="empPwCk" class="form-control" id="pwCk">
								</div>
								<div class="form-group last mb-4">
									<label for="password">비밀번호 확인</label> 
									<input type="password" name="empPw" class="form-control" id="pw">
								</div>
									<button type="button" class="btn btn-block btn-success" id="signinInBt">회원가입</button>
							</form>
						</div>
					</div>
					<span id="msgs" class="msgs"></span>
				</div>
			</div>
		</div>
	</div>
	<script>
		let signinInBt=document.querySelector('#signinInBt');
		signinInBt.addEventListener("click", function(e) {
			//폼 유효성 검사
			let id=document.querySelector('#id');
			if(id.value==''){
				alert('아이디를 입력하세요');
				id.focus();
				return;
			}
			let name=document.querySelector('#name');
			if(name.value==''){
				alert('이름을 입력하세요');
				name.focus();
				return;
			}
			let pwCk=document.querySelector('#pwCk');
			if(pwCk.value==''){
				alert('비밀번호를 입력하세요!');
				pwCk.focus();
				return;
			}
			let pw=document.querySelector('#pw');
			if(pw.value!=pwCk.value){
				alert('비밀번호를 확인하세요!');
				return false; //false 적어줘야 비밀번호가 다를 경우 회원가입 액션으로 안넘어감
			}
			let signInForm=document.querySelector('#signInForm');
			signInForm.submit();
		});
	</script>
	<!--footer -->
	<footer class="footer">
		<img alt="" src="${pageContext.request.contextPath}/image/footeer.png" style="width: 100%; height: auto; ">
	</footer>

	<script
		src="${pageContext.request.contextPath}/bootstrap/loginCss/js/jquery-3.3.1.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/bootstrap/loginCss/js/popper.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/bootstrap/loginCss/js/bootstrap.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/bootstrap/loginCss/js/main.js"></script>

</body>
</html>