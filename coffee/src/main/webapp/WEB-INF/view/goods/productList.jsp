<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>productList</title>
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
	<br><br>
	<div class="container">
	<h1>상품</h1>
	<hr style="height: 3px; background-color:black;" width="100%">
	<br><br>
	<h3>카테고리</h3>
	<hr style="height: 3px; background-color:black;" width="100%">
	<br>
			<h5>
			<c:forEach var="c" items="${categoryList}">
				<c:if test="${c.categoryKind=='product'}"><label><span><a style="color:black" href="#${c.categoryName}">${c.categoryName}</a></span> &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label></c:if>
			</c:forEach>
			</h5>
	
	<span id="Tumbler"></span>
	<br><br>
	
	<h3>텀블러</h3>
	<hr style="height: 3px; background-color:black;" width="100%"><br>
	<table>
		<tr>
			<c:forEach var="b" items="${tumbler}" varStatus="s">
				<c:if test="${s.index != 0 && s.index % 3 == 0}">
					</tr><tr>
				</c:if>
				 
				<td>
					<div><a href="${pageContext.request.contextPath}/GoodsOne?goodsCode=${b.goodsCode}"><img src="${pageContext.request.contextPath}/image/${b.goodsName}.jpg" width="369" height="369"></div></a><br>
					<div style="text-align: center;">${b.goodsName}</div>
					<br>
				</td>
			</c:forEach>
		</tr>

	</table>
	
	
	<span id="Glass"></span>
	<br><br>
	
		<h3>글라스</h3>
		<hr style="height: 3px; background-color:black;" width="100%"><br>
	<table>
		<tr>
			<c:forEach var="b" items="${glass}" varStatus="s">
				<c:if test="${s.index != 0 && s.index % 3 == 0}">
					</tr><tr>
				</c:if>
				 
				<td>
					<div><a href="${pageContext.request.contextPath}/GoodsOne?goodsCode=${b.goodsCode}"><img src="${pageContext.request.contextPath}/image/${b.goodsName}.jpg" width="369" height="369"></div></a><br>
					<div style="text-align: center;" >${b.goodsName}</div>
					<br>
				</td>
			</c:forEach>
		</tr>

	</table>
		
	<span id="Mug"></span>
		
			<br><br>
	
	<h3>머그</h3>
	<hr style="height: 3px; background-color:black;" width="100%">
	<br>
	<table> 
		<tr>
			<c:forEach var="b" items="${mug}" varStatus="s">
				<c:if test="${s.index != 0 && s.index % 3 == 0}">
					</tr><tr>
				</c:if>
				 
				<td>
					<div><a href="${pageContext.request.contextPath}/GoodsOne?goodsCode=${b.goodsCode}"><img src="${pageContext.request.contextPath}/image/${b.goodsName}.jpg" width="369" height="369"></div></a><br>
					<div style="text-align: center;">${b.goodsName}</div>
					<br>
				</td>
			</c:forEach>
		</tr>

	</table>
	
	
	
	<c:if test="${loginEmp!=null}">
	<div> <a href="${pageContext.request.contextPath}/AddGoods">추가하기</a> </div>
	</c:if>
	<br><br>
	</div>
	<div><img src="${pageContext.request.contextPath}/image/footeer.png" ></div>
	
</body>
</html>