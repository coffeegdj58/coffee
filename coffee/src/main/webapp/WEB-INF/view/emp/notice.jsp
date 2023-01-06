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
			<!-- 관리자만 수정 삭제가 보이게 할 것 -->
			<c:if test="">
				<th>수정 / 삭제</th>
			</c:if>
		</tr>
		<c:forEach var="n" items="${list}">
			<tr>
				<td>${n.noticeCode}</td>
				<td>${n.noticeTitle}</td>
				<td>
					<a href="${pageContext.request.contextPath}/notice/noticeOne?noticeCode=${n.noticeCode}">
					${n.noticeContent} </a>
				</td>
				<td>${n.createdate}</td>
			</tr>
			<!-- 관리자만 수정 삭제가 보이게 할 것 -->
			<c:if test="">
					<td>
						<a href="${pageContext.request.contextPath}/question/modifyQuestion?noticeCode=${n.noticeCode}">수정</a> /
						<a href="${pageContext.request.contextPath}/question/removeQuestion?noticeCode=${n.noticeCode}">삭제</a> 
					</td>
				</c:if>
		</c:forEach>
	</table>
	
	<a href="${pageContext.request.contextPath}/emp/questionList?currentPage=1">처음</a>
	<c:if test="${currentPage > 1}">
		<a href="${pageContext.request.contextPath}/emp/questionList?currentPage=${currentPage-1}&rowPerPage=${rowPerPage}">이전</a>
	</c:if>
	<c:if test="${currentPage < lastPage}">
		<a href="${pageContext.request.contextPath}/emp/questionList?currentPage=${currentPage+1}&rowPerPage=${rowPerPage}">이후</a>
	</c:if>
	<a href="${pageContext.request.contextPath}/emp/questionList?currentPage=${lastPage}">마지막</a>
</body>
</html>