<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰 작성하기</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,700"
	rel="stylesheet">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/bootstrap/nav/fonts/icomoon/style.css">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/bootstrap/nav/css/owl.carousel.min.css">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/bootstrap/nav/css/bootstrap.min.css">

<!-- Style -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/bootstrap/nav/css/style.css">
<style type="text/css">
html, body {
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
	<div>
		<div>
			<h3 style="margin-left: 230px; margin-top: 50px; font-weight: bold;">리뷰 작성</h3>
		</div>
		<hr style="height: 50px;">
		<div style="margin-left: 230px; margin-top: 30px;">
			<form action="${pageContext.request.contextPath}/AddReview" method="post" id="AddReview">
				<input type="hidden" name="orderCode" value="${orderCode}" readonly="readonly" class="form-control"
					style="width: 30px; text-align: center;"> 
				<img src="${pageContext.request.contextPath}/image/${goodsOne.goodsName}.jpg" width="300px" height="300px">
				<br>
				<div>${goodsOne.goodsName}</div>
				<hr>
					별점
					<select name="rating" class="form-control" style="width: 140px;">
					<option value="5">★★★★★</option>
					<option value="4">★★★★☆</option>
					<option value="3">★★★☆☆</option>
					<option value="2">★★☆☆☆</option>
					<option value="1">★☆☆☆☆</option>
					<option value="0">☆☆☆☆☆</option>
				</select> 
				<input type="hidden" name="goodsCode" value="${goodsCode}"
					readonly="readonly" class="form-control" style="width: 50px;">

				<div>
					<label class="form-label">내용</label>
					<textarea cols="30" rows="10" name="reviewMemo" id="reviewMemo" placeholder="5글자 이상 입력해 주세요."
						class="form-control" style="width: 500px; background-color: #FBF8EF; "></textarea>
				</div>
				<label class="form-label">작성자</label> <input type="text"
					name="customerId" value="${loginMember.customerId}"
					readonly="readonly" class="form-control" style="width: 100px;">
				<br>
				<button type="button" class="btn btn-dark" id="reviewBt">리뷰작성</button>
			</form>
		</div>
		<script>
			let reviewBt = document.querySelector('#reviewBt');
			reviewBt.addEventListener("click", function(e) {
				console.log('리뷰 버튼 클릭');
				//폼 유효성 검사
				let reviewMemo = document.querySelector('#reviewMemo');
				if (reviewMemo.value == '') {
					alert('리뷰를 입력하세요');
					id.focus();
					return;
				}
				
				let AddReview = document.querySelector('#AddReview');
				AddReview.submit();
			});
		</script>
		
		<hr>
		<!-- 리뷰보이게 -->
		<div>
			<div>
				<h5 style="margin-left: 230px; margin-top: 50px; font-weight: bold;">My Review</h5>
			</div>
			<br>
			<table class="table w-75"
				style="margin-left: auto; margin-right: auto; margin-top: 20px;">
				<thead style="text-align: center;">
					<tr>
						<td>상품 이름</td>
						<td>작성자</td>
						<td>별점</td>
						<td>내용</td>
						<td>삭제</td>
					</tr>
				</thead>
				<tbody style="text-align: center;">
					<tr>
						<c:forEach var="Rlist" items="${Rlist}">
							<td>${Rlist.goodsName}</td>
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
							<td>
								<a href="${pageContext.request.contextPath}/RemoveReview?goodsCode=${Rlist.goodsCode}&orderCode=${Rlist.orderCode}" style="color: black;">삭제</a>
							</td>
						</c:forEach>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<!--footer -->
	<footer class="footer">
		<img alt="" src="${pageContext.request.contextPath}/image/footeer.png" style="width: 100%; height: auto; ">
	</footer>
</body>
</html>