<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항</title>
</head>
<body>
	<!-- 공지사항은 회원 비회원 모두가 볼 수있게  -->
	
	<!-- 관리자만 공지사항 추가가 보이게 할 것 -->
	<a href="${pageContext.request.contextPath}/notice/addNotice">공지사항 추가</a>
	<table>
		<tr>
			<th>공지번호</th>
			<th>제목</th>
			<th>내용</th>
			<th>날짜</th>
		</tr>
		<c:forEach var="n" items="${list}">
			<tr>
				<td>${n.noticeCode}</td>
				<td>${n.noticeTitle}</td>
				<td>${n.noticeContent}</td>
				<td>${n.createdate}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>