<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>	
	<div>	
		<jsp:include page="../nav.jsp"></jsp:include> 
		<!-- include의 주소에는 context를 사용하지 않는다 편한 액션 중하나 -->
	</div>
	<h1>포인트사용내역</h1>
	<div>잔여포인트: ${loginMember.point }</div>
	<table>
		<tr>
			<td>포인트</td>
			<td>적립/사용</td>
			<td>일자</td>
		</tr>
		<c:forEach var="p" items="${list}">
			<tr>
				<c:if test="${p.pointKind.equals('사용')}">
					<td>-${p.point}</td>
				</c:if>
				<c:if test="${p.pointKind.equals('적립')}">
					<td>${p.point}</td>
				</c:if>
				<td>${p.pointKind}</td>
				<td>${p.createdate}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>