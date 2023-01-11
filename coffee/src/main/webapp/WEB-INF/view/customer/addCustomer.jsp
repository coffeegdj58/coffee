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
	<h1>회원가입페이지</h1>
	<form action="${pageContext.request.contextPath}/AddCustomer" method="post">
		<table>
			<tr>
				<td>id</td>
				<td><input type="text" name="customerId"></td>
			</tr>
			<tr>
				<td>pw</td>
				<td><input type="password" name="customerPw"></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><input type="text" name="customerName"></td>
			</tr>
			<tr>
				<td>Phone</td>
				<td><input type="number" name="customerPhone"></td>
			</tr>
			<tr>
				<td>gender</td>
				<td><input type="radio" name="customerGender" id="gender" value="F">여
					<input type="radio" name="customerGender" id="gender" value="M">남</td>
			</tr>
			<tr>
				<td>birth</td>
				<td><input type="date" name="customerBirth"></td>
			</tr>
		</table>
		<button type="submit">회원가입</button>
	</form>
</body>
</html>