<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

	<form action="${pageContext.request.contextPath}/AddComment" method="post">
		<input type="hidden" value="${q.questionCode}" name="questionCode">
		<div>
			답변 내용:
			<textarea rows="10" cols="30" name="commentMemo"></textarea>
		</div>
		<button type="submit">답변 추가</button>
	</form>

</body>
</html>