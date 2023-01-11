<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BakaryList</title>
</head>
<body>
<div>	
		<jsp:include page="../nav.jsp"></jsp:include> 
		<!-- include의 주소에는 context를 사용하지 않는다 편한 액션 중하나 -->
	</div>
	<h3>브레드</h3>
	<table>
		<tr>
			<c:forEach var="b" items="${bread}" varStatus="s">
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
	<h3>케이크</h3>
	<table>
		<tr>
			<c:forEach var="b" items="${cake}" varStatus="s">
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
	
	<h3>샌드위치</h3>
	<table>
		<tr>
			<c:forEach var="b" items="${sandwich}" varStatus="s">
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
	
	<h3>푸딩</h3>
	<table>
		<tr>
			<c:forEach var="b" items="${pudding}" varStatus="s">
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