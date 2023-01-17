<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
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
	<style type="text/css">
	html, main {
	    height: 100%
	}
	
	#wrap {
	    min-height: 100%;
	    position: relative;
	    padding-bottom: 60px;
	}
	
	footer {
	    bottom: 0;
	}
	
	<!--하단 footer 고정-->
	</style>	
	</head>
	<body>
		<div>	
		<jsp:include page="../nav.jsp"></jsp:include> 
		<!-- include의 주소에는 context를 사용하지 않는다 편한 액션 중하나 -->
		</div>
		<br><br>
		
		
		<div class="container">
		<c:if test = "${not empty loginEmp}">
			<div style="float:right">
					<button type="button" class="btn btn-outline-dark btn-lg" onclick="location.href='${pageContext.request.contextPath}/ModifyGoods?goodsCode=${g.goodsCode}'">수정</button>
					<button type="button" class="btn btn-outline-dark btn-lg" onclick="location.href='${pageContext.request.contextPath}/RemoveGoods?goodsCode=${g.goodsCode}'">삭제</button>
			</div>
		</c:if>
			<h1>${g.categoryName}</h1>
			<hr style="height: 3px; background-color:black;">
			<div class="row">
		
				<div class="col-5">
					<img width="100%" height= "auto" src="${pageContext.request.contextPath}/image/${g.goodsName}.jpg"/>
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
					
					<h5>₩ <fmt:formatNumber value="${g.goodsPrice}" pattern="#,###"/> </h5>
					<br>
					<c:if test="${g.soldout == 'N'}">
						<form name="form" method="post">
							<input type="hidden" name= "goodsCode" value="${g.goodsCode}">
							<select name="cartQuantity" class="form-select">
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
								<option value="6">6</option>
								<option value="7">7</option>
								<option value="8">8</option>
								<option value="9">9</option>
								<option value="10">10</option>
							</select>
							<button class="btn btn-outline-dark" type="submit" onclick="javascript: form.action='${pageContext.request.contextPath}/Payment3'">바로구매</button>
							<button class="btn btn-outline-dark" type="submit" onclick="javascript: form.action='${pageContext.request.contextPath}/GoodsOne'">장바구니에 담기</button>
							<br><br>
						</form>
						<c:if test="${result==1}">
							<div>장바구니에 담았습니다</div>
						</c:if>
						
						<c:if test="${result==0}">
							<div>이미 담겨있는 상품 입니다</div>
						</c:if>
						<br>
						
					</c:if>
					<c:if test="${g.soldout == 'Y'}">
						<h3>현재 상품은 준비중입니다.</h3>
					</c:if>
					</div>
				
			</div>
			<br><br><br><br>
			<div>
				<h3 style="font-weight: bold; text-align: center;"  >BestSeller</h3>
					<br>
				<table width="100%">
						<tr>
							<c:forEach var="g" items="${goodsList}">
							<td>
								<div style="text-align: center;"><a href="${pageContext.request.contextPath}/GoodsOne?goodsCode=${g.goodsCode}"><img src="${pageContext.request.contextPath}/image/${g.goodsName}.jpg" width="200" height="200"></a></div>
								<div style="text-align: center;">${g.goodsName}</div>
								<div style="text-align: center;">₩ <fmt:formatNumber value="${g.goodsPrice}" pattern="#,###"/> </div>
							</td>	
							</c:forEach>
						</tr>
				</table>
			</div>
			<hr>
		<!-- 리뷰보이게 -->
		<div>
			<div>
				<h5 style="font-weight: bold; text-align: center;">Review</h5>
			</div>
			<br>
			<table class="table"
				style="width: 100%">
				<thead style="text-align: center;">
					<tr>
						<td>작성자</td>
						<td>별점</td>
						<td>내용</td>
					</tr>
				</thead>
				<tbody style="text-align: center;">
						<c:forEach var="Rlist" items="${Rlist}">
							<tr>
								<td>${Rlist.customerId}</td>
								<td>${Rlist.rating}
									<c:if test="${Rlist.rating==1}">
									★
									</c:if> <c:if test="${Rlist.rating==2}">
									★★
									</c:if> <c:if test="${Rlist.rating==3}">
									★★★
									</c:if> <c:if test="${Rlist.rating==4}">
									★★★★
									</c:if> <c:if test="${Rlist.rating==5}">
									★★★★★
									</c:if>
								</td>
								<td>${Rlist.reviewMemo}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				</div>
				<div style="text-align: center;" >
					<a href="${pageContext.request.contextPath}/GoodsOne?currentPage=1&goodsCode=${g.goodsCode}" style="color: black;">처음</a>
					<c:if test="${currentPage > 1}">
						<a href="${pageContext.request.contextPath}/GoodsOne?currentPage=${currentPage-1}&rowPerPage=${rowPerPage}&goodsCode=${g.goodsCode}">이전</a>
					</c:if>
					<c:if test="${currentPage < lastPage}">
						<a href="${pageContext.request.contextPath}/GoodsOne?currentPage=${currentPage+1}&rowPerPage=${rowPerPage}&goodsCode=${g.goodsCode}">이후</a>
					</c:if>
				</div>
			</div>
			<br><br><br>
		<!--footer -->
		<footer class="footer">
			<img alt="" src="${pageContext.request.contextPath}/image/footeer.png" style="width: 100%; height: auto; ">
		</footer>
	</body>
</html>