<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	li{
		display: inline-block;
	}
</style>
</head>
<body>
	<h1>CS center</h1>
	<hr />
	<ul>
		<li><a href="qna/list.jsp"><span style="font-size:18px; font-weight:bold;">QnA</span> 문의하기</a></li>
		<li><a href="faq/faq_main.jsp"><span style="font-size:18px; font-weight:bold;">FAQ</span> 자주 묻는 질문</a></li>
		<li><a href="notice/listNotice.jsp"><span style="font-size:18px; font-weight:bold;">Notice</span> 공지사항</a></li>
	</ul>
	<hr />
	<jsp:include page="faq/faq.jsp"></jsp:include>
</body>
</html>