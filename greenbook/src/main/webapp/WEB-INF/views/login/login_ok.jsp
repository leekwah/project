<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>login Ok</title>
</head>
<body>
한다면 하는 이홍섭

<c:forEach items="${loginLog}" var="dto" >
    id = ${dto.mem_id}<br>
    pw = ${dto.mem_pwd}<br>
    id = ${dto.id}<br>
    pw = ${dto.pwd}<br>
</c:forEach>
<a href="login">로그인으로 돌아가기</a>
</body>
</html>
