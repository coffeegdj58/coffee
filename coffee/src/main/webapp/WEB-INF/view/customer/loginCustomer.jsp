<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginCustomer</title>
</head>
<body>
	<h1>login</h1>
	<form method="post" action="${pageContext.request.contextPath}/CustomerLoginController">
		<table>
			<tr>
				<td>id</td>
				<td><input type="text" name="customerId"></td>
			</tr>
			<tr>
				<td>pw</td>
				<td><input type="password" name="customerPw"></td>
			</tr>
		</table>
		<button type="submit">login</button>
	</form>
	<a href="${pageContext.request.contextPath}/AddCustomerController">회원가입</a>
</body>
</html>