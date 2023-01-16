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
	<div class="container">
	<form action="${pageContext.request.contextPath}/AddQuestion" method="post" class=" form">
		<div class="mb-3">
				<label class="form-label">주문 번호</label>
					<select name="orderCode" class="form-control">
						<c:forEach var="Q" items="${Qlist}">
							<option value="${Q.orderCode}"> 
								${Q.orderState}
								${Q.goodsName}
								${Q.goodsPrice}
							</option>
						</c:forEach>
					</select>
			</div>
			<div class="mb-3">
				<label class="form-label">카테고리</label>
					<select name="category" class="form-control">
					    <option value="">선택</option>
					    <option value="배송">배송</option>
					    <option value="반품">반품</option>
					    <option value="교환">교환</option>
					    <option value="기타">기타</option>
					</select>
			</div>
			<div class="mb-3">
				<label class="form-label">내용</label>
				<textarea cols="30" rows="10" name="questionMemo" class="form-control"></textarea>
			</div>
			<div class="mb-3">
				<label class="form-label">작성자</label>
				<input type="text" name="customerId" value="${customerId}" readonly="readonly"  class="form-control-plaintext">
			</div>
		<button type="submit" class="btn btn-dark">추가</button>
	</form>
	</div>	
	<!--footer -->
	<footer class="footer">
		<img alt="" src="${pageContext.request.contextPath}/image/footeer.png" style="width: 100%; height: auto; text-align: center;">
	</footer>
</body>
</html>