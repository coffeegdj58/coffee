<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
</head>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,700" rel="stylesheet">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/nav/fonts/icomoon/style.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/nav/css/owl.carousel.min.css">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/nav/css/bootstrap.min.css">
    
    <!-- Style -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/nav/css/style.css">

   
<body>

<div>	
		<jsp:include page="../nav.jsp"></jsp:include> 
		<!-- include의 주소에는 context를 사용하지 않는다 편한 액션 중하나 -->
	</div>
	<form action="${pageContext.request.contextPath}/ModifyAddress" method="post">
		<input type="hidden" name="addressCode" value="${address.addressCode}">
		<table>
			<tr>
				<td>주소</td>
				<td><input type="text" name="address" placeholder="${address.address}"></td>
			</tr>
			<tr>
				<td>기본 배송지로 등록</td>
				
				<td><input type="checkbox" name="flag" value="1"<c:if test="${address.flag==1}">checked="checked"</c:if>></td>
				
			</tr>	
		</table>
		<button type="submit">수정하기</button>
	</form>
</body>
</html>