<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>productList</title>
</head>
<body>
<div>	
		<jsp:include page="../nav.jsp"></jsp:include> 
		<!-- include의 주소에는 context를 사용하지 않는다 편한 액션 중하나 -->
	</div>
	<h3>머그</h3>
	<table>
		<tr>
			<c:forEach var="b" items="${mug}" varStatus="s">
				<c:if test="${s.index != 0 && s.index % 3 == 0}">
					</tr><tr>
				</c:if>
				 
				<td>
					<div><a href="${pageContext.request.contextPath}/GoodsOne?goodsCode=${b.goodsCode}"><img src="${pageContext.request.contextPath}/image/${b.goodsName}.jpg" width="200" height="200"></div></a><br>
					<div>${b.goodsName}</div>
				</td>
			</c:forEach>
		</tr>

	</table>	
	<h3>글라스</h3>
	<table>
		<tr>
			<c:forEach var="b" items="${glass}" varStatus="s">
				<c:if test="${s.index != 0 && s.index % 3 == 0}">
					</tr><tr>
				</c:if>
				 
				<td>
					<div><a href="${pageContext.request.contextPath}/GoodsOne?goodsCode=${b.goodsCode}"><img src="${pageContext.request.contextPath}/image/${b.goodsName}.jpg" width="200" height="200"></div></a><br>
					<div>${b.goodsName}</div>
				</td>
			</c:forEach>
		</tr>

	</table>
	
		<h3>텀블러</h3>
	<table>
		<tr>
			<c:forEach var="b" items="${tumbler}" varStatus="s">
				<c:if test="${s.index != 0 && s.index % 3 == 0}">
					</tr><tr>
				</c:if>
				 
				<td>
					<div><a href="${pageContext.request.contextPath}/GoodsOne?goodsCode=${b.goodsCode}"><img src="${pageContext.request.contextPath}/image/${b.goodsName}.jpg" width="200" height="200"></div></a><br>
					<div>${b.goodsName}</div>
				</td>
			</c:forEach>
		</tr>

	</table>

</body>
</html>