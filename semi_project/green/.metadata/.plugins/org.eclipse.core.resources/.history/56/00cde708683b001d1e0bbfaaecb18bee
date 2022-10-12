<%@page import="cs.NoticeBean"%>
<%@page import="cs.NoticeDBBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="cs.QnABoardBean"%>
<%@page import="cs.QnABoardDBBean"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int  n_num = 0;
	String n_user_id;
	String n_title="";
	NoticeDBBean noticeDB = NoticeDBBean.getInstance();
	NoticeBean notice = null;

	String pageNum=null;
	if(request.getParameter("pageNum")==null){
		pageNum="1";
	}else{
		pageNum=request.getParameter("pageNum");		
	}
	if(request.getParameter("n_user_id")!=null){
		n_user_id=request.getParameter("n_user_id");
	} else{
		n_user_id="";
		response.sendRedirect("adminIndex.jsp?pages=noticeList&pageNum="+pageNum);
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
   	<script src="notice.js?a=b"></script>
  </head>
  <body class="vertical  dark  ">
    <div class="wrapper">
        <div class="container-fluid">
          <div class="row justify-content-center">
            <div class="col-12">
              <h2 class="page-title">공지 작성</h2>
              <br />
              <form method="post" action="noticeWrite_ok.jsp" name="wrt_frm">
              <div class="card shadow mb-2">
                  <div class="card shadow">
                    <div class="card-body">
                      <div class="form-group mb-3">
                        <label for="simpleinput">작성자</label>
                        <input type="text" name="n_user_id" id="simpleinput" class="form-control" value="<%=n_user_id%>" readonly />
                      </div>
                      <div class="form-group mb-3">
                        <label for="example-palaceholder">제목</label>
                        <input type="text" id="example-palaceholder" class="form-control" name="n_title" placeholder="제목을 입력해주세요." />
                      </div>
                      <div class="form-group mb-3">내용
                 		<div id="editor" style="min-height:300px;" contenteditable="true">
                 		</div>
                  		<input type="hidden" value="" name="n_content" id="content">
                      </div>
                      <div class="form-group mb-3">
                        <label for="example-password">비밀번호</label>
                        <input type="password" name="n_pwd" id="example-password" class="form-control" placeholder="비밀번호를 입력해주세요.">
                      </div>
                  	<div style="text-align:center">
	                  <div class="btn-group" role="group" aria-label="Basic example">
	                    <input type="button" class="btn btn-primary" value="목록" onclick="location.href='adminIndex.jsp?pages=noticeList&pageNum=<%=pageNum%>'" />
		                 <input type="reset" class="btn btn-primary" value="다시 작성" />
		                 <input type="button" class="btn btn-primary" value="작성" onclick="onclick_ok()" />
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
<!--     <script src="js/jquery.min.js"></script> -->
    <script src="js/popper.min.js"></script>
    <script src="js/moment.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/simplebar.min.js"></script>
    <script src='js/daterangepicker.js'></script>
    <script src='js/jquery.stickOnScroll.js'></script>
    <script src="js/tinycolor-min.js"></script>
    <script src="js/config.js"></script>
    <script src='js/jquery.mask.min.js'></script>
    <script src='js/select2.min.js'></script>
    <script src='js/jquery.steps.min.js'></script>
    <script src='js/jquery.validate.min.js'></script>
    <script src='js/jquery.timepicker.js'></script>
    <script src='js/dropzone.min.js'></script>
    <script src='js/uppy.min.js'></script>
	<!-- <script src='js/quill.min.js'></script> -->
    <script type="text/javascript">
    // editor
    var editor = document.getElementById('editor');
    if (editor)
    {
      var toolbarOptions = [
        [
        {
          'font': []
        }],
        [
        {
          'header': [1, 2, 3, 4, 5, 6, false]
        }],
        ['bold', 'italic', 'underline', 'strike'],
        ['blockquote', 'code-block'],
        [
        {
          'header': 1
        },
        {
          'header': 2
        }],
        [
        {
          'list': 'ordered'
        },
        {
          'list': 'bullet'
        }],
        [
        {
          'script': 'sub'
        },
        {
          'script': 'super'
        }],
        [
        {
          'indent': '-1'
        },
        {
          'indent': '+1'
        }], // outdent/indent
        [
        {
          'direction': 'rtl'
        }], // text direction
        [
        {
          'color': []
        },
        {
          'background': []
        }], // dropdown with defaults from theme
        [
        {
          'align': []
        }],
        ['clean'] // remove formatting button
      ];
      var quill = new Quill(editor,
      {
        modules:
        {
          toolbar: toolbarOptions
        },
        theme: 'snow'
      });
    }
    </script>
  </body>
</html>