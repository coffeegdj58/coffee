<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
<!-- Style -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/bootstrap/nav/css/style.css">
<script>
	  $(document).ready(function() {
	  	$('#btn').click(function(){
	  		if ($('#id').val().length < 1 || $('#pw').val().length< 1 || $('#name').val().length< 1 || $('#phone').val().length< 1){
	  			alert('내용을 채워주세요');
	  			$('#id').focus();
	  			return;
	  			}
	  		
	  			$('#addform').submit();
	  		
	  		
	  	})
	  })
  </script>
</head>
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
							<h3>Sign Up</h3>
							<form action="${pageContext.request.contextPath}/AddCustomer" id="addform" method="post">
								<div class="form-group first">
									<label for="username">아이디 </label>
									<input type="text" name="customerId" class="form-control" id="id">
									<c:if test="${msg eq 1 }">
										<span style="color:red">다른 아이디를 사용해주세요</span>
									</c:if>
								</div>
								
								
								<div class="form-group last mb-4">
									<label for="password">비밀번호 </label>
									<input type="password" name="customerPw" class="form-control" id="pw">
								</div>
								<div class="form-group last mb-4">
									<label for="password">이름 </label>
									<input type="text" name="customerName" class="form-control" id="name">
								</div>
								<div class="form-group last mb-4">
									<label for="password">핸드폰번호 </label>
									<input type="number" name="customerPhone" class="form-control" id="phone">
								</div>
								<div class="form-group last mb-4">
										<input type="radio" name="customerGender" id="gender" value="F" > 여
										<input type="radio" name="customerGender" id="gender" value="M" > 남
								</div>
								<div class="form-group last mb-4">
									<label for="password">생일 </label>
									<input type="date" name="customerBirth" class="form-control" id="brith">
								</div>
								<button type="button" id="btn" class="btn btn-block btn-dark">회원가입</button>
							</form>
						</div>
					</div>
					<span id="msgs" class="msgs"></span>

				</div>

			</div>
		</div>
	</div>
	</div>


	
	<!--footer -->
	<footer class="footer">
		<img alt="" src="${pageContext.request.contextPath}/image/footeer.png" style="width: 100%; height: auto; ">
	</footer>

	
	<script
		src="${pageContext.request.contextPath}/bootstrap/loginCss/js/popper.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/bootstrap/loginCss/js/bootstrap.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/bootstrap/loginCss/js/main.js"></script>

	</body>
</html>