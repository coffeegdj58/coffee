
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>ModifyGoods</title>
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
		
		<br><br><br>
		<div class="container">
			<h1>상품수정</h1>
			<hr style="height: 3px; background-color:black;">
			
			<form action="${pageContext.request.contextPath}/ModifyGoods" method="post" enctype="multipart/form-data">
				<input type="hidden" name="goodsCode" value="${m.goodsCode}">
				
				<div>GoodsName : <input type="text" name="goodsName" value='${m.goodsName}' readonly='readonly'></div>
				<hr>
				<div>GoodsPrice : <input type="number" name="goodsPrice" value="${m.goodsPrice }"></div>
				<hr>
				<div>Soldout : Y<input type="radio" name="soldout" value="Y">&nbsp;N<input type="radio" name="soldout" value="N"></div>
				<hr>
				<div>
				 Category : &nbsp;&nbsp;<select name="categoryCode">
					<c:forEach var="c" items="${categorylist}">
							<option value="${c.categoryCode}">${c.categoryKind}  ${c.categoryName}</option>
					</c:forEach>
				</select>
				</div>
				<hr>
				<div>GoodsContent : <textarea rows="3" cols="50" name= "goodsContent" >${m.goodsContent }</textarea></div>
				<hr>
				<div>GoodsInfo : <input type="text" name="goodsInfo" value="${m.goodsInfo}"></div>		
				<hr>
				<div>File : <input type="file" name="filename" accept="image/jpeg, image/png"></div>
				<hr>
				<button class="btn btn-outline-dark btn-lg" type="submit">상품 추가</button>
			</form>
		
		</div>
		
		<br><br><br><br>
		<!--footer -->
		<footer class="footer">
			<img alt="" src="${pageContext.request.contextPath}/image/footeer.png" style="width: 100%; height: auto; ">
		</footer>
	</body>
</html>