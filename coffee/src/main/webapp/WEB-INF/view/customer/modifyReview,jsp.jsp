<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,700" rel="stylesheet">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/nav/fonts/icomoon/style.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/nav/css/owl.carousel.min.css">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/nav/css/bootstrap.min.css">
    
    <!-- Style -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/nav/css/style.css">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
<body>
<div>	
		<jsp:include page="../nav.jsp"></jsp:include> 
		<!-- include의 주소에는 context를 사용하지 않는다 편한 액션 중하나 -->
	</div>
	<form action="${pageContext.request.contextPath}/ModifyReview" method="post">
		<table>
			<tr>
				<td>주문번호</td>
				<td><input type="text" name="orderCode" value="${orderCode}" readonly="readonly"></td>
			</tr>
			<tr>
				<td>상품번호</td>
				<td><input type="text" name="goodsCode" value="" readonly="readonly"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><input type="text" name="reviewMemo"></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><input type="text" name="customerId" value="" readonly="readonly"></td>
			</tr>
			<tr>
				<td>별점</td>
				<td><input type="text" name="rating"></td>
			</tr>
		</table>
		<button type="submit">수정하기</button>
	</form>
</body>
</html>