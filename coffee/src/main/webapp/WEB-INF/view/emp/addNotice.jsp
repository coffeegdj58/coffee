<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지 추가하기</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/notice/addNotice" method="post">
		<table>
			<tr>
				<td>제목</td>
				<td><input type="text" name="noticeTitle"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea cols="30" rows="10" name="noticeContent"></textarea></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><input type="text" name="empId" value="admind" readonly="readonly"></td>
			</tr>
		</table>
		<button type="submit">추가</button>
	</form>
</body>
</html>