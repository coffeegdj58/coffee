<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
</body>
</html>