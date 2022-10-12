<%--
  Created by IntelliJ IDEA.
  User: kwah
  Date: 2022/10/13
  Time: 12:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>

    <table border="1" cellpadding="0" cellspacing="0">
        <form action="login_yn" method="post">

        <tr>
            <td>아이디</td>
            <td><input type="text" name="mem_uid"></td>
        </tr>
        <tr>
            <td>비밀번호</td>
            <td><input type="password" name="mem_pwd"></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="로그인"> <input type="button" value="회원가입"> </td>
        </tr>
        </form>
    </table>

</body>
</html>
