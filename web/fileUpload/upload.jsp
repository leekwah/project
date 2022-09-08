<%--
  Created by IntelliJ IDEA.
  User: kwah
  Date: 2022/09/08
  Time: 4:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.io.InputStream" %>
<%@ page import="java.io.BufferedReader" %>
<%@ page import="java.io.InputStreamReader" %>
<%
  InputStream is = request.getInputStream();

  BufferedReader br = new BufferedReader(new InputStreamReader(is));
  String str = null;

  while((str = br.readLine())!=null) {
%>
    <%= str %>
<%
  }
%>