<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 로그인</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/LoginEmp" method="post">
		<table>
			<tr>
				<td>관리자 아이디</td>
				<td><input type="text" name="empId"> </td>
			</tr>
			<tr>
				<td>관리자 비밀번호</td>
				<td><input type="password" name="empPw"> </td>
			</tr>
		</table>
		<button type="submit">로그인</button>
	</form>
	<a href="${pageContext.request.contextPath}/AddEmp">관리자 회원가입</a>
</body>
</html>