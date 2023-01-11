<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<form action="${pageContext.request.contextPath}/AddQuestion" method="post">
		<table>
			<tr>
				<td>주문 번호</td>
				<td>
					<select name="orderCode">
						<c:forEach var="Q" items="${Qlist}">
							<option value="${Q.orderCode}"> 
								${Q.orderState}
								${Q.goodsName}
								${Q.goodsPrice}
							</option>
						</c:forEach>
					</select>
				</td>
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
				<td><textarea cols="30" rows="10" name="questionMemo"></textarea></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><input type="text" name="customerId" value="${customerId}" readonly="readonly"></td>
			</tr>
		</table>
		<button type="submit">추가</button>
	</form>
</body>
</html>