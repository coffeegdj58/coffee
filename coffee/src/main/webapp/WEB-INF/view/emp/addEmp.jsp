<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 회원가입</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/emp/addEmp" method="post">
		<table>
			<tr>
				<td>관리자 아이디</td>
				<td><input type="text" name="empId"> </td>
			</tr>
			<tr>
				<td>관리자 이름</td>
				<td><input type="text" name="empName"> </td>
			</tr>
			<tr>
				<td>관리자 비밀번호</td>
				<td><input type="password" name="empPwCk"> </td>
			</tr>
			<tr>
				<td>관리자 비밀번호 확인</td>
				<td><input type="password" name="empPw"> </td>
			</tr>
		</table>
		<button type="submit">회원가입</button>
	</form>
</body>
</html>