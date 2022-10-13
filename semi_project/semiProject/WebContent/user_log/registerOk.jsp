<%@page import="java.sql.Timestamp"%>
<%@page import="member.MemberDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="mb" class="member.MemberBean"></jsp:useBean>>
<jsp:setProperty property = "*" name="mb"/>

<%
	MemberDBBean manager = MemberDBBean.getInstance();
	
	if(manager.confirmID(mb.getUser_id()) == 0){
		System.out.println("@@@###getMem_id ===>"+ manager.confirmID(mb.getUser_id()));
%>		
		<script>
		alert("중복되는 아이디가 존재합니다."); 
		history.back(); 
		</script>
<%
	}else{
		System.out.println("@@@###getMem_id ===>"+ manager.confirmID(mb.getUser_id()));
	
		mb.setUser_regdate(new Timestamp(System.currentTimeMillis()));
		int re = manager.register(mb);
		System.out.println("@@@###re ====>" +re);
		
		
		if(re == 1){
%>
		<script>
			alert("회원가입을 축하드립니다.\n 회원으로 로그인 해주세요.");
			document.location.href="../main/main.jsp";
		</script>
<%
		}else{ 
%>
		<script>
			alert("회원가입을 실패했습니다.");
			history.go(-1);
		</script>
<%
		}
	}
%>
