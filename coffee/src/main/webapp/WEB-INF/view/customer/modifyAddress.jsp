<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
</head>
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
   
<body>

<div>	
		<jsp:include page="../nav.jsp"></jsp:include> 
		<!-- include의 주소에는 context를 사용하지 않는다 편한 액션 중하나 -->
	</div>
	<br><br><br>
	<div class="container">
		<h1>주소수정</h1>
		<hr style="height: 3px; background-color:black;" width="100%">
		<br>
		<form action="${pageContext.request.contextPath}/ModifyAddress" method="post" id="addressform">
			<input type="hidden" name="addressCode" value="${address.addressCode}">
			<table>
				<tr>
					<td>주소</td>
					<td><input type="text" name="address" value="${address.address}" id="address"></td>
				</tr>
				<tr>
					<td>기본 배송지로 등록</td>
					
					<td><input type="checkbox" name="flag" value="1"<c:if test="${address.flag==1}">checked="checked"</c:if>></td>
					
				</tr>	
			</table>
			<br><br>
			<button type="button"class="btn btn-outline-dark btn-lg" id="btn">수정하기</button>
			<button type="button" class="btn btn-outline-dark btn-lg" onclick="location.href='${pageContext.request.contextPath}/DeleteAddress?addressCode=${address.addressCode}'">삭제</button>
		</form>
	</div>
	<br><br><br><br><br><br><br><br><br><br><br><br>
	<footer class="footer">
		<img alt="" src="${pageContext.request.contextPath}/image/footeer.png" style="width: 100%; height: auto; ">
	</footer>
	<script>
			$(document).ready(function(){	
					$('#btn').click(function(){
						if($('#address').val().length < 5){
							alert('올바른 주소를 입력해주세요')
							$('#address').focus();
						}
						$('addressform').submit();
					})
				
			})
		</script>
</body>
</html>