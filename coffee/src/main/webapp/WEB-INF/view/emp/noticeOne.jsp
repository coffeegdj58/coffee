<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지 상세보기</title>
</head>
<body>
	<div>
		공지 번호: ${n.noticeCode}
	</div>
	<div>
		제목: ${n.noticeTitle}
	</div>
	<div>
		내용: ${n.noticeContent}
	</div>
	<div>
		작성자: ${n.empId}
	</div>
	<div>
		날짜: ${n.createdate}
	</div>
	<!-- 관리자만 수정 삭제가 보이게 할 것 -->
	<c:if test="${loginEmp!=null}">
		<td>
			<a href="${pageContext.request.contextPath}/ModifyNotice?noticeCode=${n.noticeCode}">수정</a> /
			<a href="${pageContext.request.contextPath}/RemoveNotice?noticeCode=${n.noticeCode}">삭제</a> 
		</td>
	</c:if>
</body>
</html>