<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
     <%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
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
	<style type="text/css">
		a:link {
			  color : black;
			}
			a:visited {
			  color : black;
			}
			a:hover {
			  color : green;
			}
			a:active {
			  color : green
			}
		
	</style>
	
   
</head>
<body>
	<div>	
		<jsp:include page="../nav.jsp"></jsp:include> 
		<!-- include의 주소에는 context를 사용하지 않는다 편한 액션 중하나 -->
	</div>
	
	
	<br><br>
	<div><img src="${pageContext.request.contextPath}/image/myPage.png"></div>
	
	<br><br>
	
	<div class="container">
	<h1>Order</h1>
	<br>
	
	<div class="row">
	<div class="col-10">
	<c:set var="predate" value=""/>
   
	
	<c:forEach var="o" items="${orderList}">
		<c:set var ="num" value="${o.createdate}"/> 
		<c:set var="curdate" value="${fn:substring(num,0,10)}"/>
		
		<c:if test="${curdate != predate}">
			<c:set var="predate" target="predate" value="${fn:substring(num,0,10)}"/>
			<br>
		<h4>${predate} 주문</h4>
		</c:if>
		
		<table width="750px;">
			
			<tr>
				<td width="15%"><img src="${pageContext.request.contextPath}/image/${o.goodsName}.jpg" width= "200px" height="200px"></td>
				<td>
					<table width="100%" style="text-align: center;">
						<tr><td><h4><a href="${pageContext.request.contextPath}/GoodsOne?goodsCode=${o.goodsCode}">${o.goodsName}</a></h4></td> </tr>
						<tr><td>${o.orderState}</td></tr>
						
						<tr><td> ₩ ${o.orderPrice} &nbsp;&nbsp;&nbsp;${o.orderQuantity}개</td></tr>
					</table>
				</td>
				<td width="15%">
					<table width="100%" height="100%">
						<tr style="text-align: center;">
							<td>
								<button type="button" class="btn btn-outline-dark" onclick="location.href='${pageContext.request.contextPath}/AddReview?orderCode=${o.orderCode}&goodsCode=${o.goodsCode}'">리뷰작성</button>
							</td>
						</tr>
						<tr style="text-align: center;">
							<c:if test="${o.orderState.equals('결제')}">
								<td><button type="button" class="btn btn-outline-dark" onclick="location.href='${pageContext.request.contextPath}/ModifyOrder?orderCode=${o.orderCode}'">취소하기</button></td>
							</c:if>
							<c:if test="${o.orederState.equals('결제')==false}">
								<td><button type="button" class="btn btn-outline-dark" onclick="location.href='${pageContext.request.contextPath}/ModifyOrder?orderCode=${o.orderCode}'">반품,환불</button></td>
							</c:if>
						</tr>
						<tr style="text-align: center;">
							<td><button type="button" class="btn btn-outline-dark" onclick="location.href='${pageContext.request.contextPath}/OrderOne?orderCode=${o.orderCode}'">배송조회</button></td>
						</tr>
						
					</table>
				</td>
				
				
				
			</tr>
			
			
		</table>
		<c:if test="${curdate != predate}">
		<br>
		</c:if>
		</c:forEach>
		</div>
		
		<div class="col-2">
			<hr height="20px" background-color="black">
			<ul class="list-group list-group-flush">
			  <li class="list-group-item"><a href="${pageContext.request.contextPath}/CartList">장바구니</a>
			  <li class="list-group-item"><a href="${pageContext.request.contextPath}/ModifyCustomer">회원정보수정</a></li>
			  <li class="list-group-item"><a href="${pageContext.request.contextPath}/PointPage">포인트</a></li>
			  <li class="list-group-item"><a href="${pageContext.request.contextPath}/AddressCustomer">주소관리</a></li>
			  <li class="list-group-item"><a href="${pageContext.request.contextPath}/QuestionListByCustomer">고객센터</a></li>
			</ul>
		
			
		</div>	
	</div>
	<br><br><br>
	</div>
	<div><img src="${pageContext.request.contextPath}/image/footeer.png" ></div>
</body>
</html>