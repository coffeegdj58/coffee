<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		문의 번호: ${q.question_code}
	</div>
	<div>
		카테고리: ${q.category}
	</div>
	<div>
		주문 번호: ${q.order_code}
	</div>
	<div>
		문의내용: ${q.question_memo}
	</div>
	<div>
		주문자 아이디: ${q.customer_id}
	</div>
	<!-- 답변이 달리기 전이고 관리자만 보이게 해야함 -->
	<c:if test="${q.flag eq 'N'}&&${loginMember.authCode > 1}">
		<a href="${pageContext.request.contextPath}/comment/addComment?questionCode=${q.question_code}">답변 추가</a>
	</c:if>
	<!-- 관리자가 답변을 달면 보이게 -->
	<c:if test="${q.flag eq 'Y'}">
		<div>
		답변 내용: ${c.commentMemo}
		</div>
		<div>
		 날찌: ${c.createdate }
		</div>
	</c:if>
	<c:if test="${loginMember.authCode > 1}">
		<a href="${pageContext.request.contextPath}/comment/removeComment?commentCode=${c.commentCode}">삭제</a>
	</c:if>
</body>
</html>