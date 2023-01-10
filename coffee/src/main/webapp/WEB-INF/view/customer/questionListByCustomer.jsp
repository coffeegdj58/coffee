<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="${pageContext.request.contextPath}/AddQuestion">문의하기</a>
	<table>
		<tr>
			<th>카테고리</th>
			<th>질문 코드</th>
			<th>주문자 아이디</th>
			<th>주문번호</th>
			<!-- 답변이 안달렸으면 보이게 달리면 안보이게 -->
			<c:if test="${q.flag eq 'N'}">
				<th>수정 / 삭제</th>
			</c:if>
		</tr>
		<c:forEach var="q" items="${list}">
			<tr>
				<td>${q.category}</td>
				<td>
					<a href="${pageContext.request.contextPath}/question/questionOne?questionCode=${question_code}">
					${q.question_code}</a>
				</td>
				<td>${q.customer_id}</td>
				<td>${q.order_code}</td>
				<!-- 답변이 안달렸으면 보이게 달리면 안보이게 -->
				<c:if test="${q.flag eq 'N'}">
					<td>
						<a href="${pageContext.request.contextPath}/ModifyQuestion?questionCode=${question_code}">수정</a> /
						<a href="${pageContext.request.contextPath}/RemoveQuestion?questionCode=${question_code}">삭제</a> 
					</td>
				</c:if>
			</tr>
		</c:forEach>
	</table>
</body>
</html>