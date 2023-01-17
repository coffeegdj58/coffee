
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>

	    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/loginCss/fonts/icomoon/style.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/loginCss/css/owl.carousel.min.css">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/loginCss/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
    <!-- Style -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/loginCss/css/style.css">
     <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,700" rel="stylesheet">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/nav/fonts/icomoon/style.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/nav/css/owl.carousel.min.css">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/nav/css/bootstrap.min.css">
    
    <!-- Style -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/nav/css/style.css">
    <script>
	  $(document).ready(function() {
	  	$('#pw').blur(function(){
	  		if ($('#id').val().length<1||$('#pw').val().length<1){
	  			$('#msgs').text("올바르게 채워주세요");
	  			$('#id').focus();
	  		}
	  		
	  	})
	  })
	  	
  </script>
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
	<div class="content">
    <div class="container">
      <div class="row">
        <div class="col-md-6">
          <img src="${pageContext.request.contextPath}/image/login.jpeg" alt="Image" class="img-fluid">
        </div>
        <div class="col-md-6 contents">
          <div class="row justify-content-center">
            <div class="col-md-8">
              <div class="mb-4">
              <h3>로그인</h3>
 
            </div>
            <form action="${pageContext.request.contextPath}/CustomerLogin" method="post">
              <div class="form-group first">
                <label for="username">아이디 </label>
                <input type="text" class="form-control" id="id" name="customerId" value="goodee">
              </div>
             
              <div class="form-group last mb-4">
                <label for="password">비밀번호 </label>
                <input type="password" class="form-control" id="pw" name="customerPw" value="1234">
                 <span style="color:red"id = "msgs" class="msgs"></span>
              </div>
                <a href="${pageContext.request.contextPath}/AddCustomer">회원가입 </a> <span style="float:right"><a href="${pageContext.request.contextPath}/LoginEmp">관리자 로그인 </a></span>
              <input type="submit" value="로그인" class="btn btn-block btn-dark">
            </form>
            </div>
           
          </div>
          
          
        </div>
        
      </div>
    </div>
  </div>
  <c:if test="${msg==1}">
  	<script>
  		alert("아이디 비밀번호를 확인해주세요")
  	</script>
  </c:if>
<br><br><br><br>
	<footer class="footer">
		<img alt="" src="${pageContext.request.contextPath}/image/footeer.png" style="width: 100%; height: auto; ">
	</footer>
	
	<script src="${pageContext.request.contextPath}/bootstrap/loginCss/js/jquery-3.3.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/bootstrap/loginCss/js/popper.min.js"></script>
    <script src="${pageContext.request.contextPath}/bootstrap/loginCss/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/bootstrap/loginCss/js/main.js"></script>
	
	
</body>
</html>


  
   