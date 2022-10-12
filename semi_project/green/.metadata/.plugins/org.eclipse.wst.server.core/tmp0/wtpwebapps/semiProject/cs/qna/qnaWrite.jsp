<%@page import="java.util.ArrayList"%>
<%@page import="cs.QnABoardBean"%>
<%@page import="cs.QnABoardDBBean"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
		String id = "admin";
		String grade = "admin";
		session.setAttribute("id", id); 
		session.setAttribute("grade", grade); 
		String b_title="";
		/* if(session.getAttribute(id) == null){
			response.sendRedirect("login.jsp");
		} */
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null){
			pageNum = "1";
		} 
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
    <link rel="stylesheet" href="css/dataTables.bootstrap4.css">
    <!-- Date Range Picker CSS -->
    <link rel="stylesheet" href="css/daterangepicker.css">
    <!-- App CSS -->
    <link rel="stylesheet" href="css/app-light.css" id="lightTheme" disabled>
    <link rel="stylesheet" href="css/app-dark.css" id="darkTheme">
  </head>
  <body class="vertical  dark  ">
    <div class="wrapper">
        <div class="container-fluid">
          <div class="row justify-content-center">
            <div class="col-12">
              <h2 class="page-title">문의 작성</h2>
              <br />
              <form action="qna_write_ok.jsp" method="post" name="write_frm" enctype="multipart/form-data"">
              <div class="card shadow mb-2">
                  <div class="card shadow">
                    <div class="card-body">
                      <div class="form-group mb-3">
                        <label for="custom-select">문의 유형</label>
                        <select name="b_category" class="custom-select" id="custom-select category">
	                        <option value="nonSelect" selected>문의 유형을 선택해 주세요.</option>
	                        <option value="회원정보">회원정보</option>
	                        <option value="상품문의">상품문의</option>
	                        <option value="주문/결제">주문/결제</option>
	                        <option value="배송">배송</option>
	                        <option value="교환/취소">교환/취소</option>
	                        <option value="서비스">서비스</option>
                        </select>
                      </div>
                      <div class="form-group mb-3">
                        <label for="simpleinput">작성자</label>
                        <input type="text" id="simpleinput" class="form-control" readonly />
                      </div>
                      <div class="form-group mb-3">
                        <label for="example-palaceholder">휴대전화</label>
                        <input type="text" id="example-palaceholder" class="form-control" readonly />
                      </div>
                      <div class="form-group mb-3">
                        <label for="example-email">이메일</label>
                        <input type="email" id="example-email" name="example-email" class="form-control" readonly />
                      </div>
                      <div class="form-group mb-3">
                        <label for="example-palaceholder">제목</label>
                        <input type="text" id="example-palaceholder" class="form-control" name="b_title" placeholder="제목을 입력해주세요." />
                      </div>
                     <div class="form-group mb-3">
                        <label for="example-textarea">문의 내용</label>
                        <textarea class="form-control" name="b_content" id="example-textarea" rows="10"></textarea>
                      </div>
                      <div class="form-group mb-3">
                        <label for="customFile">이미지</label>
                        <div class="custom-file">
                          <input type="file" name="b_fname" id="customFile"/>
                          <label for="customFile"></label>
                        </div>
                      </div>
                      <div class="form-group mb-3">
                        <label for="example-password">비밀번호</label>
                        <input type="password" name="b_pwd" id="example-password" class="form-control" placeholder="비밀번호를 입력해주세요.">
                      </div>
                      <div class="form-check">
                        <input class="form-check-input" type="checkbox" name="b_secret" id="defaultCheck1">비밀글
                      </div>
                  	<div style="text-align:center">
	                  <div class="btn-group" role="group" aria-label="Basic example">
	                    <input type="button" class="btn btn-primary" value="목록" onclick="location.href='qnaList_u.jsp?pageNum=<%= pageNum %>'" />
		                 <input type="reset" class="btn btn-primary" value="다시 작성" />
		                 <input type="button" class="btn btn-primary" value="작성" onclick="check_ok()" />
	                  </div>
                	</div>
                    </div>
                  </div>
                  </div>
                	</div>
              	</div> <!-- end section -->
              </form>
            </div> <!-- .col-12 -->
          </div> <!-- .row -->
	<script src="../../js/jquery.min.js"></script>
	<script src="../../js/board.js" charset="UTF-8"></script>
  	<script src="../../js/popper.min.js"></script>
    <script src="../../js/moment.min.js"></script>
    <script src="../../js/bootstrap.min.js"></script>
    <script src="../../js/simplebar.min.js"></script>
    <script src='../../js/daterangepicker.js'></script>
    <script src='../../js/jquery.stickOnScroll.js'></script>
    <script src="../../js/tinycolor-min.js"></script>
    <script src="../../js/config.js"></script>
    <script src='../../js/jquery.mask.min.js'></script>
    <script src='../../js/select2.min.js'></script>
    <script src='../../js/jquery.steps.min.js'></script>
    <script src='../../js/jquery.validate.min.js'></script>
    <script src='../../js/jquery.timepicker.js'></script>
    <script src='../../js/dropzone.min.js'></script>
    <script src='../../js/uppy.min.js'></script>
  </body>
</html>