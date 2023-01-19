<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
     <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
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

</style>
   
</head>
<body>
	<div>	
		<jsp:include page="../nav.jsp"></jsp:include> 
		<!-- include의 주소에는 context를 사용하지 않는다 편한 액션 중하나 -->
	</div>
	
	<br><br><br>
	<div class="container">
	<h1>MyCart</h1>
	<hr style="height: 3px; background-color:black;">
	<br><br>
	<c:if test="${empty cartList}">
				<h2 style="text-align: center;">장바구니가 비었습니다</h2>
	</c:if>
		<c:forEach var= "c" items="${cartList}">
		
			<table width="100%">
			<tr><td colspan="3"><hr></td></tr>
			<tr>
				<c:if test="${c.soldout=='N'}">
					<form action="${pageContext.request.contextPath}/CartList" method="post" id="checkForm${c.goodsCode}">
					<input type="hidden" name="goodsCode" value="${c.goodsCode}">
					 		<td width='5%' style="text-align: center;"><input type="checkBox" name="${c.goodsCode}" id="selected${c.goodsCode}" value= 1 <c:if test="${c.selected==1}">checked</c:if>></td>
				 	</form>
			 	</c:if>
			 	<c:if test="${c.soldout=='Y'}"><td width="5%" style="text-align: center;">품절</td></c:if>
			 	
			 	<td width="15%"><img src="${pageContext.request.contextPath}/image/${c.goodsName}.jpg" width= "200px" height="200px"></td>
			 	
			 	<td>
			 		<table width="100%" style="text-align: center;">
			 			<tr>
			 				<td><h4><a style="color:black" href="${pageContext.request.contextPath}/GoodsOne?goodsCode=${c.goodsCode}">${c.goodsName}</a></h4></td>
			 			</tr>
			 			<tr>
			 				<form action="${pageContext.request.contextPath}/UpdateQuantity" method="post" id="updateQunatity${c.goodsCode}">
			 				<td>
			 				₩ <fmt:formatNumber value="${c.cartPrice}" pattern="#,###"/>  &nbsp;&nbsp;&nbsp;
			 				<c:if test="${c.soldout=='N'}">	
						 	
						 	
							 	
							 		<input type="hidden" name="goodsCode" value="${c.goodsCode}">
							 		
							 		<c:if test="${c.cartQuantity==1}">
								 		<select name="cartQuantity" id="quantity${c.goodsCode}">
											<option value="1" selected="selected">1</option>
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
									</c:if>	
									<c:if test="${c.cartQuantity==2}">
								 		<select name="cartQuantity" id="quantity${c.goodsCode}">
											<option value="1">1</option>
											<option value="2" selected="selected">2</option>
											<option value="3">3</option>
											<option value="4">4</option>
											<option value="5">5</option>
											<option value="6">6</option>
											<option value="7">7</option>
											<option value="8">8</option>
											<option value="9">9</option>
											<option value="10">10</option>
										</select>	
									</c:if>	
									<c:if test="${c.cartQuantity==3}" >
								 		<select name="cartQuantity" id="quantity${c.goodsCode}">
											<option value="1">1</option>
											<option value="2">2</option>
											<option value="3" selected="selected">3</option>
											<option value="4">4</option>											
											<option value="5">5</option>
											<option value="6">6</option>
											<option value="7">7</option>
											<option value="8">8</option>
											<option value="9">9</option>
											<option value="10">10</option>
										</select>	
									</c:if>	
									<c:if test="${c.cartQuantity==4}">
								 		<select name="cartQuantity" id="quantity${c.goodsCode}">
											<option value="1" >1</option>
											<option value="2">2</option>
											<option value="3">3</option>
											<option value="4" selected="selected">4</option>
											<option value="5">5</option>
											<option value="6">6</option>
											<option value="7">7</option>
											<option value="8">8</option>
											<option value="9">9</option>
											<option value="10">10</option>
										</select>	
									</c:if>	
									<c:if test="${c.cartQuantity==5}">
								 		<select name="cartQuantity" id="quantity${c.goodsCode}">
											<option value="1" >1</option>
											<option value="2">2</option>
											<option value="3">3</option>
											<option value="4">4</option>
											<option value="5" selected="selected">5</option>
											<option value="6">6</option>
											<option value="7">7</option>
											<option value="8">8</option>
											<option value="9">9</option>
											<option value="10">10</option>
										</select>	
									</c:if>
									<c:if test="${c.cartQuantity==6}">
								 		<select name="cartQuantity" id="quantity${c.goodsCode}">
											<option value="1">1</option>
											<option value="2">2</option>
											<option value="3">3</option>
											<option value="4">4</option>
											<option value="5">5</option>
											<option value="6" selected="selected" >6</option>
											<option value="7">7</option>
											<option value="8">8</option>
											<option value="9">9</option>
											<option value="10">10</option>
										</select>	
									</c:if>	
									<c:if test="${c.cartQuantity==7}">
								 		<select name="cartQuantity" id="quantity${c.goodsCode}">
											<option value="1">1</option>
											<option value="2">2</option>
											<option value="3">3</option>
											<option value="4">4</option>
											<option value="5">5</option>
											<option value="6">6</option>
											<option value="7" selected="selected">7</option>
											<option value="8">8</option>
											<option value="9">9</option>
											<option value="10">10</option>
										</select>	
									</c:if>	
									<c:if test="${c.cartQuantity==8}" >
								 		<select name="cartQuantity" id="quantity${c.goodsCode}">
											<option value="1">1</option>
											<option value="2">2</option>
											<option value="3">3</option>
											<option value="4">4</option>											
											<option value="5">5</option>
											<option value="6">6</option>
											<option value="7">7</option>
											<option value="8" selected="selected">8</option>
											<option value="9">9</option>
											<option value="10">10</option>
										</select>	
									</c:if>	
									<c:if test="${c.cartQuantity==9}">
								 		<select name="cartQuantity" id="quantity${c.goodsCode}">
											<option value="1" >1</option>
											<option value="2">2</option>
											<option value="3">3</option>
											<option value="4" >4</option>
											<option value="5">5</option>
											<option value="6">6</option>
											<option value="7">7</option>
											<option value="8">8</option>
											<option value="9" selected="selected">9</option>
											<option value="10">10</option>
										</select>	
									</c:if>	
									<c:if test="${c.cartQuantity==10}">
								 		<select name="cartQuantity" id="quantity${c.goodsCode}">
											<option value="1" >1</option>
											<option value="2">2</option>
											<option value="3">3</option>
											<option value="4">4</option>
											<option value="5" >5</option>
											<option value="6">6</option>
											<option value="7">7</option>
											<option value="8">8</option>
											<option value="9">9</option>
											<option value="10"selected="selected">10</option>
										</select>	
									</c:if>		
									
							 	
							 	
							 </c:if>
							 <c:if test="${c.soldout=='Y'}">
					 			품절
					 			</c:if>
					 		</td></form>
			 			</tr>
			 			<tr><td>&nbsp;</td></tr>
			 			<tr>
			 			<td>
					 		<button type="button" class="btn btn-outline-dark" onclick="location.href='${pageContext.request.contextPath}/DeleteCartOne?goodsCode=${c.goodsCode}'">삭제</button>
					 	</td>
					 	</tr>
					 	
			 		</table>
			 	</td>
			</tr>
			<tr><td colspan="3"><hr></td></tr>
			</table>
			<br>
		</c:forEach>
		<br>
		<c:if test="${!empty cartList}">
		<fieldset style="text-align: center;">
			
			<h4>
				총 가격 : ₩ <fmt:formatNumber value="${sum}" pattern="###,###"/> 
			</h4>
		</fieldset>
		
			<br><br>
		<div style="text-align: center;"><button type="button" class="btn btn-outline-dark btn-lg" onclick="location.href='${pageContext.request.contextPath}/Payment'">결제하기</button></div>
		</c:if>
		<br><br><br><br>
			<div>
				<h3 style="font-weight: bold; text-align: center;">BestSeller</h3>
					<br>
				<table width="100%">
						<tr>
							<c:forEach var="g" items="${goodsList}">
							<td>
								<div style="text-align: center;"><a href="${pageContext.request.contextPath}/GoodsOne?goodsCode=${g.goodsCode}"><img src="${pageContext.request.contextPath}/image/${g.goodsName}.jpg" width="200" height="200"></a></div>
								<div style="text-align: center;">${g.goodsName}</div>
								<div style="text-align: center;">₩  <fmt:formatNumber value="${g.goodsPrice}" pattern="#,###"/></div>
							</td>	
							</c:forEach>
						</tr>
				</table>
			</div>
	
	</div>
	<br><br><br>
	
	<c:forEach var="c" items='${cartList}'>
		<script>
			$(document).ready(function(){	
					$('#selected${c.goodsCode}').change(function(){
						$('#checkForm${c.goodsCode}').submit();
					})
					
					$("#quantity${c.goodsCode}").change(function(){
						$('#updateQunatity${c.goodsCode}').submit();
					})
			})
		</script>
	</c:forEach>
	<br><br><br><br>
	<footer class="footer">
		<img alt="" src="${pageContext.request.contextPath}/image/footeer.png" style="width: 100%; height: auto; ">
	</footer>
</body>
</html>