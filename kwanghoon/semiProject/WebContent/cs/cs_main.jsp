<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
<link rel="stylesheet" href="css/app-light.css" id="lightTheme">
<link rel="stylesheet" href="css/app-dark.css" id="darkTheme" disabled>
<title>Insert title here</title>
<style type="text/css">
	li{
		display: inline-block;
	}
</style>
</head>
<body class="vertical  light  ">
	<div class="wrapper">
        <div class="container-fluid">
          <div class="row justify-content-center">
            <div class="col-12">
              <div class="w-50 mx-auto text-center justify-content-center py-5 my-5">
                <h2 class="page-title mb-0">How can we help?</h2>
                <p class="lead text-muted mb-4">궁금한점을 찾아보세요</p>
                <!-- <form class="searchform searchform-lg">
                  <input class="form-control form-control-lg bg-white rounded-pill pl-5" type="search" placeholder="Search" aria-label="Search">
                  <p class="help-text mt-2 text-muted">Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
                </form> -->
              </div>
              <div class="row my-4">
                <div class="col-6 col-md-4">
                  <div class="card shadow mb-4">
                    <div class="card-body">
                      <i class="fe fe-info fe-32 text-primary"></i>
                      <a href="qna/qnaList_u.jsp">
                        <h3 class="h5 mt-4 mb-1">QnA</h3>
                      </a>
                      <p class="text-muted">궁금한 점을 문의하세요</p>
                    </div> <!-- .card-body -->
                  </div> <!-- .card -->
                </div> <!-- .col-md-->
                <div class="col-6 col-md-4">
                  <div class="card shadow mb-4">
                    <div class="card-body">
                      <i class="fe fe-help-circle fe-32 text-success"></i>
                      <a href="faq/faq_main.jsp">
                        <h3 class="h5 mt-4 mb-1">FAQ</h3>
                      </a>
                      <p class="text-muted">자주 묻는 질문을 확인해주세요</p>
                    </div> <!-- .card-body -->
                  </div> <!-- .card -->
                </div> <!-- .col-md-->
                <div class="col-6 col-md-4">
                  <div class="card shadow mb-4">
                    <div class="card-body">
                      <i class="fe fe-globe fe-32 text-warning"></i>
                      <a href="notice/listNotice.jsp">
                        <h3 class="h5 mt-4 mb-1">Notice</h3>
                      </a>
                      <p class="text-muted">공지사항을 확인해주세요</p>
                    </div> <!-- .card-body -->
                  </div> <!-- .card -->
                </div> <!-- .col-md-->
              </div> <!-- .row -->
              
              <div class="row my-4">
                <div class="col-md-6">
                  <div class="card shadow bg-primary text-center mb-4">
                    <div class="card-body p-5">
                      <span class="circle circle-md bg-primary-light">
                        <i class="fe fe-navigation fe-24 text-white"></i>
                      </span>
                      <h3 class="h4 mt-4 mb-1 text-white">마이 페이지</h3>
                      <p class="text-white mb-4">마이 페이지에서 회원 정보를 확인하세요</p>
                      <a href="#" class="btn btn-lg bg-primary-light text-white">My Page<i class="fe fe-arrow-right fe-16 ml-2"></i></a>
                    </div> <!-- .card-body -->
                  </div> <!-- .card -->
                </div> <!-- .col-md-->
                <div class="col-md-6">
                  <div class="card shadow bg-success text-center mb-4">
                    <div class="card-body p-5">
                      <span class="circle circle-md bg-success-light">
                        <i class="fe fe-message-circle fe-24 text-white"></i>
                      </span>
                      <h3 class="h4 mt-4 mb-1 text-white">장바구니</h3>
                      <p class="text-white mb-4">장바구니에 담아둔 제품을 구매해 보세요</p>
                      <a href="#" class="btn btn-lg bg-success-light text-white">Basket<i class="fe fe-arrow-right fe-16 ml-2"></i></a>
                    </div> <!-- .card-body -->
                  </div> <!-- .card -->
                </div> <!-- .col-md-->
              </div> <!-- .row -->
            </div> <!-- .col-12 -->
          </div> <!-- .row -->
        </div> <!-- .container-fluid -->
        <jsp:include page="faq/faq.jsp"></jsp:include>
    </div> <!-- .wrapper -->
	    </div> <!-- .wrapper -->
    <script src="js/jquery.min.js"></script>
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