<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의사항 답변</title>
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
		<h1>문의사항 답변</h1>
		<hr style="height: 3px; background-color: black;">
		<table width="50%">
			<tr>
				<td>문의번호</td>
				<td>${q.questionCode}</td>
			</tr>
			<tr><td colspan="2"><hr></td></tr>
			<tr>
				<td>카테고리</td>
				<td>${q.category}</td>
			</tr>
			<tr><td colspan="2"><hr></td></tr>
			<tr>
				<td>주문 번호</td>
				<td>${q.orderCode}</td>
			</tr>
			<tr><td colspan="2"><hr></td></tr>
			<tr>
				<td>문의내용</td>
				<td>${q.questionMemo}</td>
			</tr>
			<tr><td colspan="2"><hr></td></tr>
			<tr>
				<td>주문자 아이디</td>
				<td>${q.customerId}</td>
			</tr>
			<tr><td colspan="2"><hr></td></tr>
		</table>
		<form action="${pageContext.request.contextPath}/AddComment" method="post" id="addComment">
			<input type="hidden" value="${q.questionCode}" name="questionCode">
			<div>
				답변 내용:
				<textarea rows="10" cols="30" name="commentMemo" id="commentMemo" class="form-control"></textarea>
			</div>
			<div style="text-align: center;">
				<button type="button" class="btn btn-outline-dark btn-lg" id="commentBt">답변 추가</button>
			</div>
		</form>
	</div>
	<script>
		let commentBt=document.querySelector('#commentBt');
		commentBt.addEventListener("click", function(e) {
			//폼 유효성 검사
			let commentMemo=document.querySelector('#commentMemo');
			if(commentMemo.value==''){
				alert('내용을 입력하세요');
				commentMemo.focus();
				return;
			}
			let addComment=document.querySelector('#addComment');
			addComment.submit();
		});
	</script>
	
	
	
	<!--footer -->
	<footer class="footer">
		<img alt="" src="${pageContext.request.contextPath}/image/footeer.png" style="width: 100%; height: auto; ">
	</footer>
</body>
</html>