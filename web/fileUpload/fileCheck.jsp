<%--
  Created by IntelliJ IDEA.
  User: kwah
  Date: 2022/09/08
  Time: 11:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%
  request.setCharacterEncoding("UTF-8");
  String name = request.getParameter("name");
  String subject = request.getParameter("subject");
  String filename1 = request.getParameter("filename1");
  String filename2 = request.getParameter("filename2");

%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>파일 업로드 확인 및 다운로드</title>
</head>
<body>
올린사람 : <%=name %><br>
제목 : <%= subject %><br>
파일명1 : <a href="upload/<%= filename1 %>"><%= filename1 %></a><br>
파일명2 : <a href="upload/<%= filename2 %>"><%= filename2 %></a>
</body>
</html>