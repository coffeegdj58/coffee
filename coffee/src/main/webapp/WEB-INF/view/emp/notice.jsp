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
	
	<!-- 공지사항은 회원 비회원 모두가 볼 수있게  -->
	
	<!-- 관리자만 공지사항 추가가 보이게 할 것 -->
	<c:if test="${loginEmp!=null}">
		<a href="${pageContext.request.contextPath}/AddNotice">공지사항 추가</a>
	</c:if>
	<table>
		<tr>
			<th>공지번호</th>
			<th>제목</th>
			<th>내용</th>
			<th>날짜</th>
		</tr>
		<c:forEach var="n" items="${list}">
			<tr>
				<td>${n.noticeCode}</td>
				<td>${n.noticeTitle}</td>
				<td>
					<a href="${pageContext.request.contextPath}/NoticeOne?noticeCode=${n.noticeCode}">
					${n.noticeContent} </a>
				</td>
				<td>${n.createdate}</td>
			</tr>
		</c:forEach>
	</table>
	
	<a href="${pageContext.request.contextPath}/NoticeList?currentPage=1">처음</a>
	<c:if test="${currentPage > 1}">
		<a href="${pageContext.request.contextPath}/NoticeList?currentPage=${currentPage-1}&rowPerPage=${rowPerPage}">이전</a>
	</c:if>
	<c:if test="${currentPage < lastPage}">
		<a href="${pageContext.request.contextPath}/NoticeList?currentPage=${currentPage+1}&rowPerPage=${rowPerPage}">이후</a>
	</c:if>
	<a href="${pageContext.request.contextPath}/NoticeList?currentPage=${lastPage}">마지막</a>
</body>
</html>