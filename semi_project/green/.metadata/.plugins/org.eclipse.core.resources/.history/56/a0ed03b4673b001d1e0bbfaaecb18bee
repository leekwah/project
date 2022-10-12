<%@page import="cs.NoticeDBBean"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<jsp:useBean class="cs.NoticeBean" id="notice"></jsp:useBean>
<%
	int n_num = 0;
	if(request.getParameter("n_num")==null){
		response.sendRedirect("adminIndex.jsp");
	} else{
		NoticeDBBean noticeDBBean = NoticeDBBean.getInstance();
		n_num = Integer.parseInt(request.getParameter("n_num"));
		noticeDBBean.getNotice(n_num,false);
		String bpwd = notice.getN_pwd();		
	}
	String pageNum=request.getParameter("pageNum");
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
        <form method="post" action="noticeDelete_ok.jsp?n_num=<%= n_num %>&pageNum=<%=pageNum %>" name="del_frm" class="col-lg-3 col-md-4 col-10 mx-auto text-center">
          <div class="mx-auto text-center my-4">
            <h2 class="my-3">정말로 글을 삭제하시겠습니까?</h2>
          </div>
          <p class="text-muted">글을 삭제하기 위해 비밀번호를 입력해 주세요.</p>
          <div class="form-group">
            <label for="inputEmail" class="sr-only"></label>
            <input type="password" name="b_pwd" id="inputEmail" class="form-control form-control-lg" placeholder="PassWord">
          </div>
          <div style="text-align:center">
            <div class="btn-group" role="group" aria-label="Basic example">
	            <input type="button" class="btn mb-2 btn-secondary" value="삭제" onclick="delete_ok()" />
                <input type="button" class="btn mb-2 btn-secondary" value="취소" onclick="document.location.href='adminIndex.jsp?pages=noticeList&pageNum=<%= pageNum %>'" />
            </div>
       	  </div>
        </form>
      </div>
    </div>
    
    <script src="js/jquery.min.js"></script>
    <script src="notice.js?a=d"></script>
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