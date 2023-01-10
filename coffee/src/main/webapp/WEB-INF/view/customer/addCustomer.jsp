<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
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