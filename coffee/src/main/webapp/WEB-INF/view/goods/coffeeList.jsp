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
	<table>
		<tr>
		
			<c:forEach var="b" items="${blended}" varStatus="s">
				<c:if test="${s.index != 0 && s.index % 3 == 0}">
					</tr><tr>
				</c:if>
				 
				<td>
					<div><img src="${pageContext.request.contextPath}/image/${b.goodsName}.jpg" width="200" height="200"></div>
					
				</td>
			</c:forEach>
		</tr>

	</table>
	<div> <a href="${pageContext.request.contextPath}/AddGoods">추가하기</a> </div>
</body>
</html>