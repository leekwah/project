<%@page import="semiProject.MemberDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="mb" class="semiProject.MemberBean"></jsp:useBean>>
<jsp:setProperty property = "*" name="mb"/>

<% request.setCharacterEncoding("utf-8"); %>
<%
	MemberDBBean manager = MemberDBBean.getInstance();
	
	if(manager.confirmID(mb.getUser_id()) == 1){
		System.out.println("@@@###getMem_id ===>"+ manager.confirmID(mb.getUser_id()));
%>		
		<script>
		alert("중복되는 아이디가 존재합니다."); 
		history.back(); 
		</script>
<%
	}else{
		System.out.println("@@@###getMem_id ===>"+ manager.confirmID(mb.getUser_id()));
		int re = manager.register(mb);
	
		System.out.println("@@@###re ====>" +re);
		
		if(re == 1){
%>
		<script>
			alert("회원가입을 축하드립니다.\n 회원으로 로그인 해주세요.");
			document.location.href="login.jsp";
		</script>
<%
		}else{ 
%>
		<script>
			alert("회원가입을 실패했습니다.");
			document.location.href="login.jsp";
		</script>
<%
		}
	}
%>
