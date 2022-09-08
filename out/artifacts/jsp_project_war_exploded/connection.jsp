<%--
  Created by IntelliJ IDEA.
  User: kwah
  Date: 2022/09/08
  Time: 10:25 PM
  To change this template use File | Settings | File Templates.
  MySQL연결 확인을 위한 JSP 코드 (Connection Pool)
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*" %>
<html>
<head>
    <title>Database Connection</title>
</head>
<body>
<%
    Connection conn = null;
    try {
        String url = "jdbc:mysql://localhost:3306/sys";
        /*
            현재 DB명을 sys로 해뒀습니다. 추후에 정해지고, 바뀌게 되면
            다르게 지정하겠습니다.
            user, password는 root와 1234로 저장해뒀습니다.

            확인 후, web/META-INF/context.xml 로 가세요. (Connection Pool)
        */
        String user = "root";
        String password = "1234";

        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(url, user, password);
        out.print("JDBC Success");
        System.out.println("JDBC Success");
    } catch (SQLException ex){
        out.print("JDBC Fail");
        System.out.println("JDBC Fail");
        System.out.println("SQLException : "+ex.getMessage());
    } finally {
        if(conn != null) conn.close();
    }
%>
</body>
</html>
