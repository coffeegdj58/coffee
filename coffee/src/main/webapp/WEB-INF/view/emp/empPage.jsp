<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지</title>
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
	<div class="container">
		<div style="margin-top: 40px;">
			<h1>Emp Home</h1>
		</div> 
		<hr style="height: 3px; background-color:black;">
		<div class="row">
		<!--최고 관리자만 접근 가능하게 할 것  -->
		<div class="col-8">
			<table class="table" width="100%">
			 	<thead style="text-align: center;" >
					<tr>
						<th>이름</th>
						<th>아이디</th>
						<th>계정 사용 가능</th>
						<th>등급</th>
						<th>입사일</th>
						<!-- 최고 관리자만 사용 가능하게 끔 -->
						<c:if test="${loginEmp.authCode==1}">
							<th>수정</th>
							<th>삭제</th>
						</c:if>
					</tr>
				</thead>
				<tbody style="text-align: center;">
					<c:forEach var="e" items="${list}">
						<tr>
							<td>${e.empName}</td>
							<td>${e.empId}</td>
							<td>${e.active}</td>
							<td>${e.authCode}</td>
							<td>${e.createdate}</td>
							<!-- 최고 관리자만 사용 가능하게 끔 -->
							<c:if test="${loginEmp.authCode==1}">
								<td><a href="${pageContext.request.contextPath}/ModifyEmp?empCode=${e.empCode}" style="color: black;">수정 </a></td>
								<td><a href="${pageContext.request.contextPath}/RemoveEmp?empCode=${e.empCode}" style="color: black;">삭제 </a></td>
							</c:if>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="col-4">
			<ul class="list-group list-group-flush">
				<li class="list-group-item" style="text-align: center;"><a href="${pageContext.request.contextPath}/AddGoods" style="color: black;">상품추가하기 </a> </li>
				<li class="list-group-item" style="text-align: center;"> <a href="${pageContext.request.contextPath}/OrderList" style="color: black;">고객주문목록</a> </<li>
				<li class="list-group-item" style="text-align: center;"> <a href="${pageContext.request.contextPath}/QuestionListByEmp" style="color: black;">고객문의사항</a> </li>
			</ul>
			<div style="background-color: #cccccc; margin-top: 30px; text-align: center;">
			현재 접속자 ${currentCount}명<br>
			오늘 접속자 ${todayCount}명<br>
			누적 접속자 ${totalCount}명<br>
			</div>
		</div>
	</div>
	</div>
	<!--footer -->
	<footer class="footer" style="margin-top: 30px">
		<img alt="" src="${pageContext.request.contextPath}/image/footeer.png" style="width: 100%; height: auto; ">
	</footer>
</body>
</html>