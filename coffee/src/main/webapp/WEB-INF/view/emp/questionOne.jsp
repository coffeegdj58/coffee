<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		문의 번호: ${q.question_code}
	</div>
	<div>
		카테고리: ${q.category}
	</div>
	<div>
		주문 번호: ${q.order_code}
	</div>
	<div>
		문의내용: ${q.question_memo}
	</div>
	<div>
		주문자 아이디: ${q.customer_id}
	</div>
</body>
</html>