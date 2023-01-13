<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
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
		<jsp:include page="../nav.jsp"></jsp:include> 
		<!-- include의 주소에는 context를 사용하지 않는다 편한 액션 중하나 -->
	</div>
	
	<br><br>
	<div><img src="${pageContext.request.contextPath}/image/myPage.png"></div>
	<br><br>
	
	<div class="container">
		<div class="row">
			<div class="col-12" style="text-align: center;" >
				<table width="90%">
					<tr><td colspan="4" width="50%"><h1>배송지목록</h1></td></tr>
					<tr><td>&nbsp;</td></tr>
					<tr><td colspan="4"><img src="${pageContext.request.contextPath}/image/myAddress.png" width="400px" height="400px"></td></tr>
					<tr><td>&nbsp;</td></tr>
					<tr><td>&nbsp;</td></tr>
					<tr><td>&nbsp;</td></tr>
					<tr>
						<td>이름</td>
						<td>주소</td>
						<td>전화번호</td>
						<td>수정</td>
					</tr>
					<tr><td colspan="4"><hr></td></tr>
					<c:forEach var="a" items="${list}">
						<tr>
							<td>${loginMember.customerName}</td>	
							<td>${a.address} <c:if test="${a.flag==1}">(기본배송지)</c:if>
							<td>${loginMember.customerPhone}</td>
							<td colspan="3"><button type="button" class="btn btn-outline-dark" data-bs-toggle="modal" data-bs-target="#exampleModal" onclick="location.href='${pageContext.request.contextPath}/ModifyAddress?addressCode=${a.addressCode}'">수정하기</button></td>
						</tr>
						<tr><td colspan="4"><hr></td></tr>
				</c:forEach>
				</table>
			</div>
		</div>
		<br><br>
		
			
		<div style="text-align: center;"><button type="button" class="btn btn-outline-dark btn-lg" data-bs-toggle="modal" data-bs-target="#exampleModal" onclick="location.href='#'">배송지추가하기</button></div>
	</div>		
	
	
	<form action="${pageContext.request.contextPath}/AddressCustomer" method="post">
	<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				 <div class="modal-header">
					    <h1 class="modal-title fs-5" id="exampleModalLabel">배송지 추가</h1>			     
				 </div>
			 	 <div class="modal-body">
			 	 	
			 	 		<table>
			 	 			<tr>
			 	 				<td>주소</td>
			 	 				<td><input type="text" name="address"></td>
			 	 			</tr>
			 	 			<tr>
			 	 				<td>기본배송지로 등록</td>
			 	 				<td><input type="checkbox" name="flag" value="1"></td>
			 	 			</tr>
			 	 		</table>
			 	 	
					 </div>
					 <div class="modal-footer">
						   <button type="button" data-bs-dismiss="modal" class="btn btn-outline-dark">Close</button>
						   <button type="submit" class="btn btn-outline-dark">추가하기</button>
					      
				</div>
			</div>
		</div>
	</div>
	</form>
	
	
	<br><br><br><br>
	<div><img src="${pageContext.request.contextPath}/image/footeer.png" ></div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script> 
</body>
</html>