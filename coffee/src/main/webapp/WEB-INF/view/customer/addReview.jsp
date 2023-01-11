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
<body>
<div>	
		<jsp:include page="../nav.jsp"></jsp:include> 
		<!-- include의 주소에는 context를 사용하지 않는다 편한 액션 중하나 -->
</div>
	<form action="${pageContext.request.contextPath}/AddReview" method="post">
		<table>
			<tr>
				<td>주문번호</td>
				<td><input type="text" name="orderCode" value="${orderCode}" readonly="readonly"></td>
			</tr>
			<tr>
				<td>상품번호</td>
				<td><input type="text" name="goodsCode" value="${goodsCode}"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><input type="text" name="reviewMemo"></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><input type="text" name="customerId" value="${loginMember.customerId}" readonly="readonly"></td>
			</tr>
			<tr>
				<td>별점</td>
				<td>
					<select  name="rating">
						<option value="5">★★★★★</option>
						<option value="4">★★★★☆</option>
						<option value="3">★★★☆☆</option>
						<option value="2">★★☆☆☆</option>
						<option value="1">★☆☆☆☆</option>
						<option value="0">☆☆☆☆☆</option>
					</select>
				</td>
			</tr>
		</table>
		<button type="submit">리뷰작성</button>
	</form> 
</body>
</html>