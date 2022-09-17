<%@ page import="login.UserDBBean" %>
<%@ page import="login.UserBean" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean class="login.UserBean" id="user" />
<jsp:setProperty property="*" name="user"/>

<%
	String user_id = (String)session.getAttribute("user_id");
	user.setUser_id(user_id);
	
	UserDBBean manager = UserDBBean.getInstance();
	
	int re = manager.updateUser(user);
	
	if (re == 1) {
%>
	<script>
		alert("입력하신대로 회원 정보가 수정되었습니다.");
		document.location.href="main.jsp";
	</script>
<%
	} else {
%>
	<script>
		alert("수정이 실패되었습니다.");
		history.go(-1);
	</script>
<%	
	}
%>