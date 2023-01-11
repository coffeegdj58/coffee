<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,700" rel="stylesheet">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/nav/fonts/icomoon/style.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/nav/css/owl.carousel.min.css">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/nav/css/bootstrap.min.css">
    
    <!-- Style -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/nav/css/style.css">
</head>
<body>
	<div>	
			<jsp:include page="../nav.jsp"></jsp:include> 
			<!-- include의 주소에는 context를 사용하지 않는다 편한 액션 중하나 -->
	</div>
	
	<div>
		문의 번호: ${q.questionCode}
	</div>
	<div>
		카테고리: ${q.category}
	</div>
	<div>
		주문 번호: ${q.orderCode}
	</div>
	<div>
		문의내용: ${q.questionMemo}
	</div>
	<div>
		주문자 아이디: ${q.customerId}
	</div>
	
	<!-- 답변이 달리기 전이고 관리자만 보이게 해야함 -->
	<c:if test="${q.flag eq 'N' && loginEmp!=null}">
		<a href="${pageContext.request.contextPath}/AddComment?questionCode=${q.questionCode}">답변 추가</a>
	</c:if>
	<!-- 관리자가 답변을 달면 보이게 -->
	<c:if test="${q.flag eq 'Y'}">
		<div>
		답변 내용: ${c.commentMemo}
		</div>
		<div>
		 날짜: ${c.createdate}
		</div>
	</c:if>
	<c:if test="${q.flag eq 'Y' && loginEmp!=null}">
		<a href="${pageContext.request.contextPath}/RemoveComment?commentCode=${c.commentCode}&questionCode=${q.questionCode}">답변 삭제</a>
	</c:if>
</body>
</html>