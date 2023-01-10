<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<div>	
		<jsp:include page="../nav.jsp"></jsp:include> 
		<!-- include의 주소에는 context를 사용하지 않는다 편한 액션 중하나 -->
	</div>
	<h1>배송지 목록</h1>
	<c:forEach var="a" items="${list}">
		<table>
			<tr>
				<td>이름</td>
				<td>${loginMember.customerName}</td>	
			</tr>
			<tr>
				<td>주소</td>
				<td>${a.address}</td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td>${loginMember.customerPhone}</td>
			</tr>
			
		</table>
		<div><a href="${pageContext.request.contextPath}/ModifyAddress?addressCode=${a.addressCode}">수정하기</a></div>
		
		<c:if test="${a.flag==1}">
			<div>기본배송지</div>
		</c:if>
		<br><br>
	</c:forEach>
	<a href="#" data-bs-toggle="modal" data-bs-target="#exampleModal">배송지 추가하기</a>
	
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
						   <button type="button" data-bs-dismiss="modal">Close</button>
						   <button type="submit">추가하기</button>
					      
				</div>
			</div>
		</div>
	</div>
	</form> 
</body>
</html>