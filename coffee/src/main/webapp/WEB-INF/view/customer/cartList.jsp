<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>	
		<jsp:include page="../nav.jsp"></jsp:include> 
		<!-- include의 주소에는 context를 사용하지 않는다 편한 액션 중하나 -->
	</div>
	<h1>장바구니</h1>
	<table border="1">
		<tr>
			<td>전체선택</td>
			<td>상품사진</td>
			<td>상품이름</td>
			<td>상품금액</td>
			<td>수량</td>	
		</tr>
		<c:forEach var= "c" items="${cartList}">
			<tr>
				<form action="${pageContext.request.contextPath}/CartListController" method="post">
					<c:if test="${c.selected==0}">
				 		<td><input type="checkBox" name="${c.goodsCode}" value= 1></td>
				 	</c:if>
				 	<c:if test="${c.selected==1}">
				 		<td><input type="checkBox" name="${c.goodsCode}" value= 1 checked></td>
				 	</c:if>
			 	</form>
			 	<td><img src="${pageContext.request.contextPath}/image/${c.goodsName}.jpg" width= "150px" height="150px"></td>
			 	<td>${c.goodsName}</td>
			 	<td>${c.goodsPrice}</td>
			 	<td>${c.cartQuantity}</td>
			</tr>
		</c:forEach>
	</table>
	
	<div>총 가격  ${sum}</div>
</body>
</html>