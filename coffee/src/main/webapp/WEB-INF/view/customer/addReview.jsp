<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/AddReview" method="post">
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
				<td><input type="text" name="customerId"></td>
			</tr>
			<tr>
				<td>별점</td>
				<td><input type="text" name="rating"></td>
			</tr>
		</table>
		<button type="submit">리뷰작성</button>
	</form> 
</body>
</html>