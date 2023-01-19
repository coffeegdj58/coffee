<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>홈</title>
 <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,700" rel="stylesheet">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/nav/fonts/icomoon/style.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/nav/css/owl.carousel.min.css">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/nav/css/bootstrap.min.css">
    
    <!-- Style -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/nav/css/style.css">
<style type="text/css">
.a,
.b,
.c {
    display:flex;
    justify-content: center;'
}
.A,
.B,
.C{
max-width: 100%;
width: 634px;
width: :auto !important;
height: auto !important;
}

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
		<jsp:include page="nav.jsp"></jsp:include> 
		<!-- include의 주소에는 context를 사용하지 않는다 편한 액션 중하나 -->
</div>
	<br>

		<div>
			
			<div class="a" >
				<a href="${pageContext.request.contextPath}/GoodsOne?goodsCode=29"><img src="${pageContext.request.contextPath}/image/bgTh1.jpg"  class="A" ></a>
				<a href="${pageContext.request.contextPath}/GoodsOne?goodsCode=53"><img src="${pageContext.request.contextPath}/image/bgTh2.jpg"  class="A" ></a>
				<a href="${pageContext.request.contextPath}/GoodsOne?goodsCode=65"><img src="${pageContext.request.contextPath}/image/bgTh3.jpg"class="A"  ></a>
			</div>
			
			<div class="b" >
				<a href="${pageContext.request.contextPath}/NoticeOne?noticeCode=1"><img src="${pageContext.request.contextPath}/image/bg2.png" class="B" ></a>
				<a href="${pageContext.request.contextPath}/NoticeOne?noticeCode=1"><img src="${pageContext.request.contextPath}/image/bg1.png" class="B"></a>
				<a href="${pageContext.request.contextPath}/NoticeOne?noticeCode=1"><img src="${pageContext.request.contextPath}/image/bg.png" class="B"></a>
			</div>
			
			<div class="c">
				<a href="${pageContext.request.contextPath}/NoticeOne?noticeCode=2"><img src="${pageContext.request.contextPath}/image/bgSe1.jpg" class="C" ></a>
				<a href="${pageContext.request.contextPath}/NoticeOne?noticeCode=2"><img src="${pageContext.request.contextPath}/image/bgSe2.jpg" class="C" ></a>
				<a href="${pageContext.request.contextPath}/NoticeOne?noticeCode=2"><img src="${pageContext.request.contextPath}/image/bgSe3.jpg" class="C"></a>
			</div>
		</div>
	<!--footer -->
	<footer class="footer">
		<img id="footer" alt="" src="${pageContext.request.contextPath}/image/footeer.png" style="width: 100%; height: auto; ">
	</footer>
</body>
</html>