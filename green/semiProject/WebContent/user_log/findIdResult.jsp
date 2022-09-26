<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>    
<%@ page import="member.MemberDBBean"%>
 <%
	request.setCharacterEncoding("UTF-8");
	String name = request.getParameter("user_name");
	String phone1 = request.getParameter("user_phone1");
	String phone2 = request.getParameter("user_phone2");
	String phone3 = request.getParameter("user_phone3");
	
    MemberDBBean find = new MemberDBBean();
 	String user_id = find.findId(name, phone1, phone2, phone3); //아이디를 디비에서 가져옴..실패시 널
%>
<!doctype html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="favicon.ico">
    <title>findidResult</title>
    <link href="https://fonts.googleapis.com/css2?family=Overpass:ital,wght@0,100;0,200;0,300;0,400;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="../css/simplebar.css">
    <link rel="stylesheet" href="../css/feather.css">
    <link rel="stylesheet" href="../css/daterangepicker.css">
    <link rel="stylesheet" href="../css/app-light.css" id="lightTheme">
  </head>
  <style>
   .login{font-size: 25px;}
   .found-id{font-weight: bold; font-size: 35px;}
   input#btnLogin{background-color: #1B68FF; border-color: #1B68FF; border-radius: 3px; width: 30%; height: 40px; font-size: 20px; color: white;}
   input#btnback{background-color: #1B68FF; border-color: #1B68FF; border-radius: 3px; width: 25%; height: 40px; font-size: 15px; color: white;}
   input#btnjoin{background-color: #1B68FF; border-color: #1B68FF; border-radius: 3px; width: 25%; height: 40px; font-size: 15px; color: white;}
  </style>
 
  <body class="light ">
    <div class="wrapper vh-100">
      <div class="row align-items-center h-100">
        <form class="col-lg-3 col-md-4 col-10 mx-auto text-center" name="idsearch" method="post">
<%
 		if (user_id != null) {
%>
          <a class="navbar-brand mx-auto mt-2 flex-fill text-center" href="./index.html">
            <svg version="1.1" id="logo" class="navbar-brand-img brand-md" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" viewBox="0 0 120 120" xml:space="preserve">
              <g>
                <polygon class="st0" points="78,105 15,105 24,87 87,87 	" />
                <polygon class="st0" points="96,69 33,69 42,51 105,51 	" />
                <polygon class="st0" points="78,33 15,33 24,15 87,15 	" />
              </g>
            </svg>
          </a>
          <h1 class="h6 mb-3">Find ID</h1>
          <div class="form-group">
            <a class="login">회원님의 ID는</a>
            <div class ="found-id"><mark><strong><%= user_id%></strong></mark></div>
            <a class="login">입니다.</a>
          </div>        
          <input type="button" id="btnLogin" value="Login" onClick ="javascript:window.location='main.jsp?pages=../user_log/login'"/>
<%
 		 } else {
%>
		<div class = "container">
   	  	<div class = "found-fail">
	    <h4>  등록된 정보가 없습니다 </h4>  
	    </div>
	    <div class = "found-login">
 		    <input type="button" id="btnback" value="다시 찾기" onClick="history.back()"/>
 		    <input type="button" id="btnjoin" value="회원가입" onClick="javascript:window.location='register.jsp'"/>
       	</div>
       </div>
<%
  }
%> 
          <p class="mt-5 mb-3 text-muted">© 2022</p>
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
    <script language="JavaScript" src="javascript.js" charset="utf-8"></script>
    <!-- Global site tag (gtag.js) - Google Analytics -->
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