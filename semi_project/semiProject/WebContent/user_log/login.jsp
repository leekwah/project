<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>로그인</title>
    <link href="https://fonts.googleapis.com/css2?family=Overpass:ital,wght@0,100;0,200;0,300;0,400;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="../css/simplebar.css">
    <link rel="stylesheet" href="../css/feather.css">
    <link rel="stylesheet" href="../css/daterangepicker.css">
    <link rel="stylesheet" href="../css/app-light.css" id="lightTheme">
  </head>
  <style>
    *{list-style: none;}
    .info ul{display: flex; justify-content: center; width: 100%;}
    .info ul li{text-align: center; width: 33.33%; border-right: 1px solid gray;}
    .info ul li:last-child{border: none;}
  </style>
  <body class="light ">
    <div class="wrapper vh-100">
      <div class="row align-items-center h-100">
        <form class="col-lg-3 col-md-4 col-10 mx-auto text-center" action = "../user_log/login_ok.jsp" method="post">
          <a class="navbar-brand mx-auto mt-2 flex-fill text-center" href="../main/main.html">
            <svg version="1.1" id="logo" class="navbar-brand-img brand-md" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" viewBox="0 0 120 120" xml:space="preserve">
              <g>
                <polygon class="st0" points="78,105 15,105 24,87 87,87 	" />
                <polygon class="st0" points="96,69 33,69 42,51 105,51 	" />
                <polygon class="st0" points="78,33 15,33 24,15 87,15 	" />
              </g>
            </svg>
          </a>
          <h1 class="h6 mb-3">로그인</h1>
          <div class="form-group">
            <label for="inputEmail" class="sr-only">아이디</label>
            <input type="text" name= "user_id"  id="inputEmail" class="form-control form-control-lg" placeholder="ID" required="" autofocus="">
          </div>
          <div class="form-group">
            <label for="inputPassword" class="sr-only">비밀번호</label>
            <input type="password" name="user_pwd" id="inputPassword" class="form-control form-control-lg" placeholder="Password" required="">
          </div>
          <div class="checkbox mb-3">
            <label>
              <input type="checkbox" value="remember-me"> 로그인 유지 </label>
          </div>
          <button class="btn btn-lg btn-primary btn-block" type="submit">로그인 하기</button>
          <p class="mt-5 mb-3 text-muted">&nbsp;</p>
          <div class="info">
			<div class="btn-group" role="group" aria-label="Basic example">
				<a href="main.jsp?pages=../user_log/findId" role="button" class="btn mb-2 btn-outline-link btn-link" >아이디 찾기</a>
				<a href="main.jsp?pages=../user_log/findPw" role="button" class="btn mb-2 btn-outline-link btn-link" >비밀번호 찾기</a>
				<a href="main.jsp?pages=../user_log/register" role="button" class="btn mb-2 btn-outline-link btn-link" >회원 가입</a>
           </div>
          </div>
          <p class="mt-5 mb-3 text-muted">© 2022 GREENSHOP</p>
        </form>
      </div>
    </div>
    
    <script src="../js/jquery.min.js"></script>
    <script src="../js/popper.min.js"></script>
    <script src="../js/moment.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    <script src="../js/simplebar.min.js"></script>
    <script src='../js/daterangepicker.js'></script>
    <script src='../js/jquery.stickOnScroll.js'></script>
    <script src="../js/tinycolor-min.js"></script>
    <script src="../js/config.js"></script>
    <script src="../js/apps.js"></script>
    <script async src="https://www.googletagmanager.com/gtag/js?id=UA-56159088-1"></script>
    <script>
      window.dataLayer = window.dataLayer || [];

      function gtag()
      {
        dataLayer.push(arguments);
      }
      gtag('js', new Date());
      gtag('config', 'UA-56159088-1');
    </script>
  </body>
</html>
</body>
</html>