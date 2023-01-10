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
			<td>삭제</td>
		</tr>
		<c:forEach var= "c" items="${cartList}">
			<tr>
				<form action="${pageContext.request.contextPath}/CartList" method="post">
					<c:if test="${c.selected==0}">
				 		<td><input type="checkBox" name="${c.goodsCode}" value= 1></td>
				 	</c:if>
				 	<c:if test="${c.selected==1}">
				 		<td><input type="checkBox" name="${c.goodsCode}" value= 1 checked></td>
				 	</c:if>
			 	</form>
			 	<td><img src="${pageContext.request.contextPath}/image/${c.goodsName}.jpg" width= "150px" height="150px"></td>
			 	<td>${c.goodsName}</td>
			 	<td>${c.cartPrice}</td>
			 	<td>
			 	<form action="${pageContext.request.contextPath}/UpdateQuantity" method="post">
			 		<input type="hidden" name="goodsCode" value="${c.goodsCode}">
			 		
			 		<c:if test="${c.cartQuantity==1}">
				 		<select name="cartQuantity">
							<option value="1" selected="selected">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
						</select>	
					</c:if>	
					<c:if test="${c.cartQuantity==2}">
				 		<select name="cartQuantity">
							<option value="1">1</option>
							<option value="2" selected="selected">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
						</select>	
					</c:if>	
					<c:if test="${c.cartQuantity==3}">
				 		<select name="cartQuantity">
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3" selected="selected">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
						</select>	
					</c:if>	
					<c:if test="${c.cartQuantity==4}">
				 		<select name="cartQuantity">
							<option value="1" >1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4" selected="selected">4</option>
							<option value="5">5</option>
						</select>	
					</c:if>	
					<c:if test="${c.cartQuantity==5}">
				 		<select name="cartQuantity">
							<option value="1" >1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5" selected="selected">5</option>
						</select>	
					</c:if>	
			 	</form>
			 	</td>
			 	<td>
			 		<a href="${pageContext.request.contextPath}/DeletCartOne?goodsCode=${c.goodsCode}">삭제</a>
			 	</td>
			</tr>
		</c:forEach>
	</table>
	
	<div>총 가격  ${sum}</div>
	
	<script>
		
	</script>
</body>
</html>