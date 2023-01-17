<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
	<!--하단 footer 고정-->
	</style>
</head>
<body>
<div>	
		<jsp:include page="../nav.jsp"></jsp:include> 
		<!-- include의 주소에는 context를 사용하지 않는다 편한 액션 중하나 -->
</div>
	<br><br><br><br>
	<div class="container">
		<h1>주문결제</h1>
		<hr style="height: 5px; background-color:black;">
		<br><br>
		<form action="${pageContext.request.contextPath}/Payment2" method="post" id="payment">
			<fieldset>
				<legend>구매자정보</legend>
					<hr style="height: 3px; background-color:black;">
					<table width="100%">
						<tr>
							<td>이름</td>
							<td>${loginMember.customerName}</td>
						</tr>
						<tr><td colspan=2><hr></td></tr>
						<tr>
							<td>휴대폰 번호</td>
							<td>${loginMember.customerPhone}</td>
						</tr>
						<tr><td colspan=2><hr></td></tr>
						<tr>
						<td>주소</td>
						<td>
						<select name="addressCode" id="address">
							<c:forEach var="a" items='${addressList}'>
								<option value="${a.addressCode}">
									${a.address}<c:if test="${a.flag==1 }">(기본배송지)</c:if>
								</option>
							</c:forEach>
						</select>
						<span style="float:right"><a href="${pageContext.request.contextPath}/AddressCustomer">배송지관리</a></span>
						</td>
					</tr>
					<tr><td colspan=2><hr></td></tr>
					</table>
			</fieldset>
			<br><br>
			<fieldset>
				<legend>배송</legend>
				<hr style="height: 3px; background-color:black;">
					<table width="100%">
					<tr>
						<td>상품이름</td>
						<td>상품사진</td>
						<td>가격</td>
						<td>수량</td>
					</tr>
					<tr><td colspan=4><hr></td></tr>
					<tr>
						<td>${c.goodsName}</td>
						<td><img width='200px' height="200px" src="${pageContext.request.contextPath}/image/${c.goodsName}.jpg"></td>
						<td>₩ ${c.cartPrice}</td>
						<td>${c.cartQuantity}</td>
					</tr>
					<tr><td colspan=4><hr></td></tr>
					</table>
				
			</fieldset><br><br>
			<br><br>
			<fieldset>
				<legend>결제 정보</legend>
				<hr style="height: 3px; background-color:black;">
					<table width="100%">
						<tr>
							<td>총 상품가격</td>
							<td>₩ ${c.cartPrice}</td>
						</tr>
						<tr><td colspan=2><hr></td></tr>
						<tr>
							<td>배송비</td>
							<td>0</td>
						</tr>
						<tr><td colspan=2><hr></td></tr>
						<tr>
							<td>포인트</td>
							<td><input type="number" name="usePoint" id="usePoint">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;보유: ${loginMember.point}pt</td>
						</tr>
						<tr><td colspan=2><hr></td></tr>
						<tr>
							<td>결제방법</td>
							<td>신용카드</td>
						</tr>
						<tr><td colspan=2><hr></td></tr>
					</table>
			</fieldset>
			<input type="hidden" value="${c.goodsCode}" name="goodsCode">
			<input type="hidden" value="${c.cartQuantity}" name="cartQuantity">
			<input type="hidden" value="${c.cartPrice}" name="orderPrice">
			<button type="button" id="btn" class="btn btn-outline-dark btn-lg">결제하기</button>
		</form>
	</div>
	
	<br><br><br><br>
	<footer class="footer">
		<img alt="" src="${pageContext.request.contextPath}/image/footeer.png" style="width: 100%; height: auto; ">
	</footer>
	
	<script>
	$(document).ready(function(){	
	 	$('#usePoint').change(function(){
	 		if($('#usePoint').val()>${loginMember.point}){
	 			$('#usePoint').val(${loginMember.point})
	 		}
	 		
	 		if($('#usePoint').val()<0){
	 			$('#usePoint').val(0);
	 		}
	 	})
	 	$('#btn').click(function(){
	 		if($('#address').val.length<1){
	 			alert('주소 만들어주세요')
	 			$('#address').focus();
	 			return;
	 		}	
	 		$('#payment').submit();
	 	})
	})
	</script>
	
</body>
</html>