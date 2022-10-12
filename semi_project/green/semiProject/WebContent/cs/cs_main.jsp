<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tiny Dashboard - A Bootstrap Dashboard Template</title>
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
                      <a href="main.jsp?pages=../cs/qna/qnaList_u">
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
                      <a href="main.jsp?pages=../cs/faq/faq_main">
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
                      <a href="main.jsp?pages=../cs/notice/noticeList_u">
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
                      <a href="main.jsp?pages=../user_log/mypage" class="btn btn-lg bg-primary-light text-white">My Page<i class="fe fe-arrow-right fe-16 ml-2"></i></a>
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
                      <a href="main.jsp?pages=../product/cart" class="btn btn-lg bg-success-light text-white">Basket<i class="fe fe-arrow-right fe-16 ml-2"></i></a>
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
</body>
</html>