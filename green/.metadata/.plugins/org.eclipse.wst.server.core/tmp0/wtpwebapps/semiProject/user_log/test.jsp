<%@page import="member.MemberDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
	MemberDBBean manger = MemberDBBean.getInstance();
	String ran = manger.getRamdomPassword(4);
%>
랜덤 수 는 <%= ran %>
</body>
</html>