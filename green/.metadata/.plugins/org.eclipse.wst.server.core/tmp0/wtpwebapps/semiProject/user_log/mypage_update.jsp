<%@page import="member.MemberBean"%>
<%@page import="member.MemberDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<jsp:useBean class="member.MemberBean" id="mb"/>
<jsp:setProperty property="*" name="mb"/>
<%
	String user_pwd = request.getParameter("user_pwd");
	String id = (String) session.getAttribute("id");
	mb.setUser_id(id);

	MemberDBBean manager = MemberDBBean.getInstance();
	MemberBean check = manager.getMember(id);
	
	int re=0;
	if(check.getUser_pwd().equals(user_pwd)){
		re = manager.updateMember(mb);
	}
	System.out.println("rerere======="+re);
		if(re == 1){
%>
	<script>
		alert("회원 정보가 수정되었습니다.");
		document.location.href="../main/main_user.jsp";
	</script>
<%
	} else {
%>
	<script>
		alert("수정이 실패되었습니다.");
		document.location.href="mypage_user.jsp";
	</script>
<%
	}
%>