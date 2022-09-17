<%
	session.invalidate(); // session 제거
	response.sendRedirect("login.jsp");
%>