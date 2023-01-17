<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 작성</title>
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
	<div class="container" style="margin-top: 40px;">	
		<h1>공지사항 작성</h1>
		<hr style="height: 3px; background-color:black;">
		<form action="${pageContext.request.contextPath}/AddNotice" method="post" id="addNotice">
			<table width="100%">
				<tr>
					<td>제목</td>
					<td><input type="text" name="noticeTitle" id="noticeTitle" class="form-control"></td>
				</tr>
				<tr><td colspan="2"><hr></td></tr>
				<tr>
					<td>내용</td>
					<td><textarea cols="30" rows="10" name="noticeContent" id="noticeContent" class="form-control"></textarea></td>
				</tr>
				<tr><td colspan="2"><hr></td></tr>
				<tr>
					<td>작성자</td>
					<td><input type="text" name="empId" value="admind" readonly="readonly" class="form-control"></td>
				</tr>
				<tr><td colspan="2"><hr></td></tr>
			</table>
			<div style="text-align: center;">
				<button class="btn btn-outline-dark btn-lg" type="button" id="NoticeBt">추가</button>
			</div>
		</form>
	</div>
	<br><br><br><br><br><br><br><br><br><br><br><br>
	<script>
		let NoticeBt=document.querySelector('#NoticeBt');
		NoticeBt.addEventListener("click", function(e) {
			//폼 유효성 검사
			let noticeTitle=document.querySelector('#noticeTitle');
			if(noticeTitle.value==''){
				alert('제목을 입력하세요');
				noticeTitle.focus();
				return;
			}
			let noticeContent=document.querySelector('#noticeContent');
			if(noticeContent.value==''){
				alert('내용을 입력하세요');
				noticeContent.focus();
				return;
			}
			let addNotice=document.querySelector('#addNotice');
			addNotice.submit();
		});
	</script>
	
	
	<!--footer -->
	<footer class="footer">
		<img alt="" src="${pageContext.request.contextPath}/image/footeer.png" style="width: 100%; height: auto; ">
	</footer>
</body>
</html>