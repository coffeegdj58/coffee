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
	<div class="container" style="margin-top: 40px;">
		<!-- 공지사항은 회원 비회원 모두가 볼 수있게  -->
		<div>
			<h1>공지사항</h1>
		</div> 
		<hr style="height: 3px; background-color:black;">
		
		<table class="table" width="100%">
		 	<thead style="text-align: center;" >
				<tr>
					<th scope="col"  width="80px">번호</th>
					<th scope="col" style="word-break:break-all">제목</th>
					<th scope="col">내용</th>
					<th scope="col" width="150px">날짜</th>
				</tr>
			</thead>
			<tbody style="text-align: center;">
				<c:forEach var="n" items="${list}">
					<tr>
						<td  scope="col" >${n.noticeCode}</td>
						<td scope="col"><a href="${pageContext.request.contextPath}/NoticeOne?noticeCode=${n.noticeCode}" style="color: black;">
							${n.noticeTitle} </a></td>
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
			<button type="button" class="btn btn-outline-dark" onclick="location.href='${pageContext.request.contextPath}/NoticeList?currentPage=1'">처음</button>
			<c:if test="${currentPage > 1}">
				<button type="button" class="btn btn-outline-dark" onclick="location.href='${pageContext.request.contextPath}/NoticeList?currentPage=${currentPage-1}&rowPerPage=${rowPerPage}'">이전</button>
			</c:if>
			<c:if test="${currentPage < lastPage}">
				<button type="button" class="btn btn-outline-dark" onclick="location.href='${pageContext.request.contextPath}/NoticeList?currentPage=${currentPage+1}&rowPerPage=${rowPerPage}'">다음</button>
			</c:if>
			<button type="button" class="btn btn-outline-dark" onclick="location.href='${pageContext.request.contextPath}/NoticeList?currentPage=${lastPage}'">마지막</button>
			<br>
			<c:if test="${loginEmp!=null}">
				<div style="float:left"><button type="button" class="btn btn-outline-dark btn-lg" onclick="location.href='${pageContext.request.contextPath}/AddNotice'">글쓰기</button></div>
			</c:if>
		</div>
	</div>
	<br><br><br><br><br><br><br><br><br><br><br><br>
	<!--footer -->
	<footer class="footer" style="margin-top: 30px;">
		<img alt="" src="${pageContext.request.contextPath}/image/footeer.png" style="width: 100%; height: auto; ">
	</footer>
</body>
</html>