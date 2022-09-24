<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
	a {color: blue;}
	a:active {color: red;}
</style>
</head>
<body>
	<%
        String select = request.getParameter("page");
 
        if (select == null) {
            select = "notice.jsp";
        }
    %>

	<div style="border: 3px double; width: 100%">
		<div class="header" style="border-bottom: 3px double; padding: 30px;">
			<a href="?page=notice.jsp">공지사항</a>|
			<a href="?page=board.jsp">게시판</a>|
			<a href="?page=faq.jsp">FAQ</a>|
			<a href="?page=qna.jsp">QnA</a>
		</div>
		
		<div class="main" style="display: flex;">
			<div style="border-right: 3px double; padding: 30px; line-height: 50px">
				<a href="?page=java.jsp">Java</a><br>
				<a href="?page=jsp.jsp">JSP</a><br>
				<a href="?page=oracle.jsp">Oracle</a><br>
				<a href="?page=html.jsp">HTML</a><br>
				<a href="?page=css.jsp">CSS</a>
			</div>
			
			<div style="padding: 145px 20px;">
				<jsp:include page="<%= select %>" flush="false"></jsp:include>
			</div>
		</div>
		
		<div class="footer" style="border-top: 3px double; padding: 0 30px">
			<p>Since 2021</p>
		</div>
	</div>
</body>
</html>