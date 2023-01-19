<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>커피이야기</title>
 <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,700" rel="stylesheet">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/nav/fonts/icomoon/style.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/nav/css/owl.carousel.min.css">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/nav/css/bootstrap.min.css">
    
    <!-- Style -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/nav/css/style.css">
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
		<jsp:include page="nav.jsp"></jsp:include> 
		<!-- include의 주소에는 context를 사용하지 않는다 편한 액션 중하나 -->
	</div>
	
	<div class="container" style="margin-top: 40px; ">
		<div style="font-weight: bold;">
			<h1>커피 이야기</h1>
		</div>
		<hr style="height: 3px; background-color:black;">
		<!-- 탭 메뉴 -->
		<ul class="nav nav-tabs" id="postTab" style="font-weight: bold; margin-top: 40px;" >
			<li class="nav-item"><a data-toggle="tab" href="#tab1" class="nav-link active"  style="color: black;" >농장에서 우리 손으로</a></li>
			<li class="nav-item"><a data-toggle="tab" href="#tab2" class="nav-link"  style="color: black;">최상의 아라비카 원두</a></li>
			<li class="nav-item"><a data-toggle="tab" href="#tab3" class="nav-link"  style="color: black;">스타벅스 로스트 스펙트럼</a></li>
			<li class="nav-item"><a data-toggle="tab" href="#tab4" class="nav-link"  style="color: black;">스타벅스 디카페인</a></li>
		</ul>
		<div class="tab-content" id="postTabContent" style="margin-top: 40px;">
			<div id="tab1" class="tab-pane fade show active"> 
			 	<img alt="1-1" src="${pageContext.request.contextPath}/image/1-1.png">
			 	<img alt="1-1" src="${pageContext.request.contextPath}/image/1-2.png">
			 	<img alt="1-1" src="${pageContext.request.contextPath}/image/1-3.png">
			 	<img alt="1-1" src="${pageContext.request.contextPath}/image/1-4.png">
			</div>
			<div id="tab2" class="tab-pane fade">
				<img alt="1-1" src="${pageContext.request.contextPath}/image/2-1.png"> 		
				<img alt="1-1" src="${pageContext.request.contextPath}/image/2-2.png"> 		
				<img alt="1-1" src="${pageContext.request.contextPath}/image/2-3.png"> 		
				<img alt="1-1" src="${pageContext.request.contextPath}/image/2-4.png"> 		
			</div>
			<div id="tab3" class="tab-pane fade">  
		  		<img alt="1-1" src="${pageContext.request.contextPath}/image/3-1.png"> 		
				<img alt="1-1" src="${pageContext.request.contextPath}/image/3-2.png"> 	
			</div>
			<div id="tab4" class="tab-pane fade">
				<img alt="1-1" src="${pageContext.request.contextPath}/image/4-1.png">
			 	<img alt="1-1" src="${pageContext.request.contextPath}/image/4-2.png">
			 	<img alt="1-1" src="${pageContext.request.contextPath}/image/4-3.png">
			</div>
		</div>
	</div>
	<!--footer -->
	<footer class="footer" style="margin-top: 100px;">
		<img id="footer" alt="" src="${pageContext.request.contextPath}/image/footeer.png" style="width: 100%; height: auto; ">
	</footer>
</body>
</html>