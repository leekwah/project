<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int b_id = Integer.parseInt(request.getParameter("b_id"));
	String pageNum = request.getParameter("pageNum");
%>
<!doctype html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="favicon.ico">
    <title>Tiny Dashboard - A Bootstrap Dashboard Template</title>
    <!-- 부트스트랩 CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    <!-- Simple bar CSS -->
    <link rel="stylesheet" href="css/simplebar.css">
    <!-- Fonts CSS -->
    <link href="https://fonts.googleapis.com/css2?family=Overpass:ital,wght@0,100;0,200;0,300;0,400;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">
    <!-- Icons CSS -->
    <link rel="stylesheet" href="css/feather.css">
    <!-- Date Range Picker CSS -->
    <link rel="stylesheet" href="css/daterangepicker.css">
    <!-- App CSS -->
    <link rel="stylesheet" href="css/app-light.css" id="lightTheme" disabled>
    <link rel="stylesheet" href="css/app-dark.css" id="darkTheme">
  </head>
  <body class="dark ">
    <div class="wrapper vh-100">
      <div class="row align-items-center h-100">
        <form method="post" action="qnaDelete_ok.jsp?b_id=<%= b_id %>&pageNum=<%= pageNum %>" name="del_frm" class="col-lg-3 col-md-4 col-10 mx-auto text-center" style="min-width:400px;">
          <div class="mx-auto text-center my-6">
            <h2 class="my-6">삭제하시겠습니까?</h2>
          </div>
          <p class="text-muted">글을 삭제하기 위해 비밀번호를 입력해 주세요.</p>
          <div class="form-group">
            <label for="password" class="sr-only"></label>
            <input type="password" name="b_pwd" id="password" class="form-control form-control-lg" placeholder="비밀번호를 입력하세요.">
          </div>
          <div style="text-align:center">
            <div class="btn"aria-label="Basic example">
                <input type="button" class="btn btn-primary" value="취소" onclick="history.go(-1)" />
	            <input type="button" class="btn btn-primary" value="삭제" onclick="delete_ok()" />
            </div>
       	  </div>
        </form>
      </div>
    </div>
    
    <script src="js/jquery.min.js"></script>
    <script type="text/javascript" src="../../js/board.js" charset="UTF-8"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/moment.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/simplebar.min.js"></script>
    <script src='js/daterangepicker.js'></script>
    <script src='js/jquery.stickOnScroll.js'></script>
    <script src="js/tinycolor-min.js"></script>
    <script src="js/config.js"></script>
    <script src="js/apps.js"></script>
    <!-- Global site tag (gtag.js) - Google Analytics -->
    <script async src="https://www.googletagmanager.com/gtag/js?id=UA-56159088-1"></script>

  </body>
</html>
</body>
</html>