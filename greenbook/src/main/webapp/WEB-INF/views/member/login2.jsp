<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!doctype html>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>로그인</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="css/login.css" rel="stylesheet">
    <script src="js/login.js"></script>
</head>

<body class="text-center">

<main class="form-signin w-100 m-auto">
    <form method="post" action="login_yn">
        <img class="mb-4" src="img/logo.png" alt="" width="72" height="72">
        <h1 class="h3 mb-3 fw-normal">로그인</h1>

        <div class="form-floating">
            <input type="text" class="form-control" name="member_id" id="floatingInput" placeholder="아이디" autofocus>
            <label for="floatingInput">아이디</label>
        </div>
        <div class="form-floating">
            <input type="password" class="form-control" name="member_pwd" id="floatingPassword" placeholder="비밀번호">
            <label for="floatingPassword">비밀번호</label>
        </div>

        <div class="checkbox mb-3">
            <label>
                <input type="checkbox" value="remember-me"> Remember me
            </label>
        </div>
        <button class="w-100 btn btn-lg btn-success" type="submit" id="btnLogin">로그인</button>
        <p class="mt-5 mb-3 text-muted">&copy; GREENBOOK</p>
        <a href="register">가입</a>
        <c:if test="${message == 'error'}">
        <div style="color:red;"> 아이디 또는 비밀번호가 일치하지 않습니다.
        </div>
        </c:if>
        <c:if test="${message == 'logout'}">
            <div style="color:red;"> 로그아웃되었습니다.
            </div>
        </c:if>
    </form>
</main>
</body>
</html>