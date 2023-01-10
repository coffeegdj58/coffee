<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지 수정하기</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/ModifyNotice" method="post">
		<input type="hidden" name="noticeCode" value="${n.noticeCode}"> 
		<table>
			<tr>
				<td>제목</td>
				<td><input type="text" name="noticeTitle" value="${n.noticeTitle }"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea cols="30" rows="10" name="noticeContent">${n.noticeContent}</textarea></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><input type="text" name="empId" value="${n.empId}" readonly="readonly"></td>
			</tr>
		</table>
		<button type="submit">수정</button>
	</form>
</body>
</html>