<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/PaymentOne" method="post">
		<fieldset>
			<legend>구매자정보</legend>
				<table>
					<tr>
						<td>이름</td>
						<td>${loginMember.customerName}</td>
					</tr>
					<tr>
						<td>휴대폰 번호</td>
						<td>${loginMember.customerPhone}</td>
					</tr>
					<tr>
					<td>주소</td>
					<td>
					<select name="addressCode">
						<c:forEach var="a" items='${addressList}'>
							<option value="${a.addressCode}">
								${a.address}<c:if test="${a.flag==1 }">(기본배송지)</c:if>
							</option>
						</c:forEach>
					</select>
					</td>
				</tr>
				</table>
		</fieldset>
		
		<fieldset>
			<legend>배송</legend>
				<table>
				<tr>
					<td>상품이름</td>
					<td>상품사진</td>
					<td>가격</td>
					<td>수량</td>
				</tr>
				<tr>
					<td>${c.goodsName}</td>
					<td><img width='200px' height="200px" src="${pageContext.request.contextPath}/image/${c.goodsName}.jpg"></td>
					<td>${c.cartPrice}</td>
					<td>${c.cartQuantity}</td>
				</tr>
				</table>
			
		</fieldset>
		
		<fieldset>
			<legend>결제 정보</legend>
				<table>
					<tr>
						<td>총상품가겨</td>
						<td>${c.cartPrice*c.cartQuantity}</td>
					</tr>
					<tr>
						<td>배송비</td>
						<td>2500</td>
					</tr>
					<tr>
						<td>포인트</td>
						<td><input type="number" name="usePoint">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;보유: ${loginMember.point}</td>
					</tr>
					<tr>
						<td>결제방법</td>
						<td>신용카드</td>
					</tr>
					<input type="hidden" value="${c.cartPrice*c.cartQuantity}" name="orderPrice">
					<button type="submit">결제하기</button>
				</table>
		</fieldset>
		<button type="submit">결제하기</button>
	</form>
</body>
</html>