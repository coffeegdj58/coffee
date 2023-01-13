<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

</head>
<body>
<div>	
		<jsp:include page="nav.jsp"></jsp:include> 
		<!-- include의 주소에는 context를 사용하지 않는다 편한 액션 중하나 -->
</div>
	<br>

		<div class=row>
			
			<div class="col-4" width="100%">
				<img src="${pageContext.request.contextPath}/image/bgTh1.jpg" style="width:650px;"  >
			</div>
			<div class="col-4" width="100%">
				<img src="${pageContext.request.contextPath}/image/bgTh2.jpg" style="width:650px;"  >
			</div>
			<div class="col-4" width="100%">
				<img src="${pageContext.request.contextPath}/image/bgTh3.jpg" style="width:650px;" >
			</div>
			<div class="col-4" width="100%">
				<img src="${pageContext.request.contextPath}/image/bg2.png" style="width:650px;"  >
			</div>
			<div class="col-4" width="100%">
				<img src="${pageContext.request.contextPath}/image/bg1.png" style="width:650px;"  >
			</div>
			<div class="col-4" width="100%">
				<img src="${pageContext.request.contextPath}/image/bg.png" style="width:650px;" >
			</div>
			
			<div class="col-4" width="100%">
				<img src="${pageContext.request.contextPath}/image/bgSe1.jpg" style="width:650px;"  >
			</div>
			<div class="col-4" width="100%">
				<img src="${pageContext.request.contextPath}/image/bgSe2.jpg" style="width:650px;"  >
			</div>
			<div class="col-4" width="100%">
				<img src="${pageContext.request.contextPath}/image/bgSe3.jpg" style="width:650px;" >
			</div>
		</div>
	<div><img src="${pageContext.request.contextPath}/image/footeer.png" ></div>
</body>
</html>