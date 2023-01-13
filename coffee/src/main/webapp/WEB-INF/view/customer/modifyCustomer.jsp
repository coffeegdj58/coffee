<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	
	<br><br>
	<div><img src="${pageContext.request.contextPath}/image/myPage.png"></div>
	
	<br><br>
	<div class="container">
		<div class="row">
			<div class="col-12" style="text-align: center;">
				<h1>내정보관리</h1>
			</div>
			<br>
			<br>
			<br>
			<br>
			<div class="col-3">&nbsp;</div>
			<div class="col-6" style="text-align: center;">
				<div>
					<img src="${pageContext.request.contextPath}/image/page2.jpg" style="width:300px; height:300px;">
				</div>
				<br><br>
				<table border="1" width="100%">
					<tr>
						<td>아이디</td>
						<td>${loginMember.customerId}</td>
					</tr>
					<tr>
						<td>이름</td>
						<td>${loginMember.customerName}</td>
					</tr>
					<tr>
						<td>휴대폰번호</td>
						<td>${loginMember.customerPhone}</td>
					</tr>
					<tr>
						<td>배송지</td>
						<td>배송지는 <a href="${pageContext.request.contextPath}/AddressCustomer">배송지관리</a>에서 수정, 등록합니다 </td>
					</tr>
					<tr>
						<td>비밀번호 변경</td>
						<td>
							<form action="${pageContext.request.contextPath}/ModifyCustomer" method="post">
									<table>
										<tr>
											<td>현재비밀번호</td>
											<td><div><input type="password" name="beforePassword"></div></td>
										</tr>
										<tr>
											<td>새 비밀번호</td>
											<td><div><input type="password" name="afterPassword"></div></td>
										</tr>
										<tr>
											<td>비밀번호 다시 입력</td>
											<td><div><input type="password" name="afterPasswordCk"></div></td>
										</tr>
										<tr>
											<td>&nbsp;</td>
											<td><button type="submit" class="btn btn-outline-dark">비밀번호 변경</button><td>
										</tr>
									</table>
							</form>
						</td>
					</tr>
				</table>
				<br><br>
				<button type="button" class="btn btn-outline-dark btn-lg" onclick="location.href='href=${pageContext.request.contextPath}/DeleteCustomer'">회원탈퇴</button>
			</div>
			<div class="col-3">&nbsp;</div>
		</div>
	</div>
	
	<br><br><br>	<br><br><br>	<br><br><br>	<br><br><br>	<br><br><br>	<br><br><br>	<br><br><br>	<br><br><br>
	
	<div><img src="${pageContext.request.contextPath}/image/footeer.png" ></div>
</body>
</html>