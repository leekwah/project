<%@page import="member.MemberBean"%>
<%@page import="member.MemberDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if(session.getAttribute("Member") == null){ 
		// member가 null(초기화)되면  main으로 들어갈 수 없게 
		// jsp:forward로 login으로 돌아감.
%>
		<jsp:forward page="login.jsp"></jsp:forward>
<%
	}
%>
<%
	String id = (String)session.getAttribute("id"); // 타입을 맞도록 해야함.
	MemberDBBean manager = MemberDBBean.getInstance();
	MemberBean mb = manager.getMember(id);
%>
<table border="1" align="center">
	<form method="post" action ="logOut.jsp">
		<tr>
			<td>
				안녕하세요.
				<%= mb.getUser_name() %>
				(<%= id %>)님
			</td>
		</tr>
		<tr>
			<td>
				<input type="submit" value="로그아웃">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="button" value="회원정보변경"
				 onclick="javascript:window.location='mypage_user.jsp'">
			</td>
		</tr>
<%
	if(id.equals("admin")){
%>
	<tr>
		<td>
			<input type="button" value="관리자 페이지"
			 onclick="javascript:window.location='../adminPage.jsp'">
		</td>
	</tr>
<%
	}
%>
	</form>
</table>

