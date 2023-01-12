<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
	
  
		<meta charset="UTF-8">
			<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,700" rel="stylesheet">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/nav/fonts/icomoon/style.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/nav/css/owl.carousel.min.css">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/nav/css/bootstrap.min.css">
    
    <!-- Style -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/nav/css/style.css">

		<title>GoodsOne</title>
	</head>
	<body>
		<div>	
		<jsp:include page="../nav.jsp"></jsp:include> 
		<!-- include의 주소에는 context를 사용하지 않는다 편한 액션 중하나 -->
		</div>
		<br><br>
		
		<div class="container">
			<h1>${g.categoryName}</h1>
			<div class="row">
		
				<div class="col-5">
					<img width="450px" height= "450px" src="${pageContext.request.contextPath}/image/${g.goodsName}.jpg"/>
				</div>
				
				<div class="col-7">
					<h2>${g.goodsName}</h2>
					<hr>
					<br><br>
					<h5>${g.goodsContent}</h5>
					<br>
					<hr>
					<h5>${g.goodsInfo}</h5>
					
					<hr>
					<h5>₩ ${g.goodsPrice}</h5>
					<br>
					<c:if test="${g.soldout == 'N'}">
						<form action="${pageContext.request.contextPath}/GoodsOne" method="post">
							<input type="hidden" name= "goodsCode" value="${g.goodsCode}">
							<select name="cartQuantity" class="form-select">
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
							</select>
							<button class="btn btn-outline-dark" type="submit">장바구니에 담기</button>
							<br><br>
						</form>
						<c:if test="${result==1}">
							<div>장바구니에 담았습니다</div>
						</c:if>
						<form action="${pageContext.request.contextPath}/Payment2" method="get">
							<input type="hidden" name= "goodsCode" value="${g.goodsCode}">
							<select name="cartQuantity" class="form-select">
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
							</select>
							<button class="btn btn-outline-dark" type="submit">바로구매</button>
						</form>
					</c:if>
					<c:if test="${g.soldout == 'Y'}">
						<span>현재 상품은 준비중입니다.</span>
					</c:if>
					</div>
				<c:if test = "${not empty loginEmp}">
					<button type="button" class="btn btn-outline-dark" onclick="location.href='${pageContext.request.contextPath}/ModifyGoods?goodsCode=${g.goodsCode}'">수정</button>
					<button type="button" class="btn btn-outline-dark" onclick="location.href='${pageContext.request.contextPath}/RemoveGoods?goodsCode=${g.goodsCode}'">삭제</button>
				</c:if>
			</div>
		</div>
		
		<div>
			<div>
				<table>
					<tr>
						<th>아이디</th>
						<th>별점</th>
						<th>내용</th>
					</tr>
					<c:forEach var="Rlist" items="${Rlist}">
						<tr>
							<th>${Rlist.customerId}</th>
							<th>${Rlist.rating}</th>
							<th>${Rlist.reviewMemo}</th>
							<th>별점</th>
							<th>내용</th>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div>
				<a href="${pageContext.request.contextPath}/GoodsOne?currentPage=1&goodsCode=${g.goodsCode}">처음</a>
				<c:if test="${currentPage > 1}">
					<a href="${pageContext.request.contextPath}/GoodsOne?currentPage=${currentPage-1}&rowPerPage=${rowPerPage}&goodsCode=${g.goodsCode}">이전</a>
				</c:if>
				<c:if test="${currentPage < lastPage}">
					<a href="${pageContext.request.contextPath}/GoodsOne?currentPage=${currentPage+1}&rowPerPage=${rowPerPage}&goodsCode=${g.goodsCode}">이후</a>
				</c:if>
			</div>
		</div>
		
						<br><br><br><br><br>				<br><br><br><br><br>
		<div><img src="${pageContext.request.contextPath}/image/footeer.png" ></div>
	</body>
</html>