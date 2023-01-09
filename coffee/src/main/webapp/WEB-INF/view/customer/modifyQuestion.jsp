<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의 수정하기</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/question/modifyQuestion" method="post">
		<table>
			<tr>
				<td>주문 번호</td>
				<td><input type="text" name="orderCode" value="${q.order_code}"></td>
			</tr>
			<tr>
				<td>카테고리</td>
				<td>
					<select name="category">
					    <option value="">선택</option>
					    <option value="배송">배송</option>
					    <option value="반품">반품</option>
					    <option value="교환">교환</option>
					    <option value="기타">기타</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea cols="30" rows="10" name="questionMemo"><${q.question_memo}</textarea></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><input type="text" name="customerId" value="${q.customer_id}" readonly="readonly"></td>
			</tr>
		</table>
		<button type="submit">추가</button>
	</form>
</body>
</html>