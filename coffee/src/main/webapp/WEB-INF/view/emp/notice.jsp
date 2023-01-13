<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항</title>
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
			<jsp:include page="../nav.jsp"></jsp:include> 
			<!-- include의 주소에는 context를 사용하지 않는다 편한 액션 중하나 -->
	</div>
	<img alt="" src="${pageContext.request.contextPath}/image/starbucks.jpg"  style="width: 100%; height: auto;">
	
	<!-- 공지사항은 회원 비회원 모두가 볼 수있게  -->
	<div>
		<h3 style="margin-left: 230px; margin-top: 50px; font-weight: bold;">공지사항</h3>
	</div> 
	<div style="margin-left: 230px; margin-top: 30px;">
		<!-- 관리자만 공지사항 추가가 보이게 할 것 -->
		<c:if test="${loginEmp!=null}">
			<a href="${pageContext.request.contextPath}/AddNotice" style="color: black;">공지사항 추가</a>
		</c:if>
	</div>
	<table class="table w-75"  style="margin-left: auto; margin-right: auto;  margin-top: 20px;">
	 	<thead style="text-align: center;" >
			<tr>
				<th scope="col"  width="80px">번호</th>
				<th scope="col" width="200px" style="word-break:break-all">제목</th>
				<th scope="col">내용</th>
				<th scope="col" width="150px">날짜</th>
			</tr>
		</thead>
		<tbody style="text-align: center;">
			<c:forEach var="n" items="${list}">
				<tr>
					<td  scope="col" >${n.noticeCode}</td>
					<td scope="col">${n.noticeTitle}</td>
					<td scope="col">
						<a href="${pageContext.request.contextPath}/NoticeOne?noticeCode=${n.noticeCode}" style="color: black;">
						${n.noticeContent} </a>
					</td>
					<td scope="col">${n.createdate}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div style=" text-align: center;">
		<a href="${pageContext.request.contextPath}/NoticeList?currentPage=1" style="color: black;">처음</a>
		<c:if test="${currentPage > 1}">
			<a href="${pageContext.request.contextPath}/NoticeList?currentPage=${currentPage-1}&rowPerPage=${rowPerPage}" style="color: black;">이전</a>
		</c:if>
		<c:if test="${currentPage < lastPage}">
			<a href="${pageContext.request.contextPath}/NoticeList?currentPage=${currentPage+1}&rowPerPage=${rowPerPage}" style="color: black;">이후</a>
		</c:if>
		<a href="${pageContext.request.contextPath}/NoticeList?currentPage=${lastPage}" style="color: black;">마지막</a>
	</div>
	
	<!--footer -->
	<img alt="" src="${pageContext.request.contextPath}/image/footeer.png"  style="width: 100%; height: auto;">
</body>
</html>