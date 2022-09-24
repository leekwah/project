<<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<jsp:useBean class="cs.QnABoardBean" id="qBoard"></jsp:useBean>
<!DOCTYPE html>

<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>°í°´¼¾ÅÍ ¸ŞÀÎ ÆäÀÌÁö</h1>
=======
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
		<li><a href="qna/list.jsp"><span style="font-size:18px; font-weight:bold;">QnA</span> ë¬¸ì˜í•˜ê¸°</a></li>
		<li><a href="faq/faq_main.jsp"><span style="font-size:18px; font-weight:bold;">FAQ</span> ìì£¼ ë¬»ëŠ” ì§ˆë¬¸</a></li>
		<li><a href="notice/listNotice.jsp"><span style="font-size:18px; font-weight:bold;">Notice</span> ê³µì§€ì‚¬í•­</a></li>
	</ul>
	<hr />
	<jsp:include page="faq/faq.jsp"></jsp:include>
>>>>>>> a5a5679681f14cd843596c2c67a61d5d4b237f04
</body>
</html>