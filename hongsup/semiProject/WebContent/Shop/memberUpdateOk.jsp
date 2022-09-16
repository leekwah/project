<%@page import="magic.MemberDBBean"%>
<%@page import="magic.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
	
<jsp:useBean class="magic.MemberBean" id="mb"/>
<jsp:setProperty property="*" name="mb"/>

<%	
	String uid = (String)session.getAttribute("uid");
	mb.setUSER_ID(uid);

	MemberDBBean manager = MemberDBBean.getInstance();
	
	int re = manager.updateMember(mb);
	
	if(re == 1) {
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