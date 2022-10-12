<%@page import="member.MemberDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String id = request.getParameter("id");
	String result = "";	

	if(id != null){
		MemberDBBean dao = new MemberDBBean();
		int re = dao.confirmID(id);
		if(re == 1){
			result = "생성가능한 아이디입니다.";
		}else{
			result = "생성 불가능한 아이디입니다.";
		}
	}
%>
<%= result %>
