<%@page import="java.util.ArrayList"%>
<%@page import="cs.NoticeDBBean"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.sql.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<jsp:useBean class="cs.NoticeBean" id="notice"></jsp:useBean>
<%
	String pageNum=request.getParameter("pageNum");
	int n_num = 0,n_hit=0,n_before=0,n_after=0;
	String n_date="", user_id="", n_title="", n_content="";
	NoticeDBBean noticeDBBean = NoticeDBBean.getInstance();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	
	if(request.getParameter("n_num")==null){
		response.sendRedirect("adminIndex.jsp");
	} else {
		n_num = Integer.parseInt(request.getParameter("n_num"));
		notice = noticeDBBean.getNotice(n_num, true);
		n_date = sdf.format(notice.getN_date());
		user_id=notice.getUser_id();
		n_hit=notice.getN_hit();
		n_title=notice.getN_title();
		n_content = notice.getN_content();
		n_before = notice.getBefore();
		n_after = notice.getAfter();
	}
	String n_title2="";
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
    <!-- App CSS -->
    <link rel="stylesheet" href="css/app-light.css" id="lightTheme" disabled>
    <link rel="stylesheet" href="css/app-dark.css" id="darkTheme">
  </head>
<body class="vertical  dark  ">
    <div class="wrapper">
    <div class="container-fluid">
          <div class="row justify-content-center">
            <div class="col-12">
              <h2 class="page-title">공지 확인</h2>
               <br />
              <div class="row">
                <div class="col-md-12">
                  <div class="card shadow mb-4">
                    <div class="card-body">
                      <form class="needs-validation" novalidate>
                        <div class="form-row">
                          <div class="col-md-6 mb-3">
                            <span>글 번호</span>
                            <span class="form-control"><%= n_num %></span>
                          </div>
                          <div class="col-md-6 mb-3">
                            <span>조회수</span>
                            <span class="form-control"><%= n_hit %></span>
                          </div>
                        </div>
                        <div class="form-row">
                          <div class="col-md-6 mb-3">
                            <span>작성자</span>
                            <span class="form-control"><%= user_id %></span>
                          </div>
                          <div class="col-md-6 mb-3">
                            <span>작성일</span>
                            <span class="form-control"><%= n_date %></span>
                          </div>
                        </div>
                        <div class="form-group mb-3">
                        	<span>제목</span>
                            <span class="form-control"><%= n_title %></span>
                        </div>
                        <div class="form-group mb-3">
                          <span>내용</span>
                          <span class="form-control" style="height: 350px;"><%= n_content %></span>
                        </div>
                        <div style="text-align:center;">
                        <%	
						if(session.getAttribute("n_user_id") != null){
							if(!session.getAttribute("n_user_id").equals("")){
						%> 
							<input class="btn btn-primary" type="button" value="수정" onclick="location.href='adminIndex.jsp?pages=noticeEdit&n_num=<%= n_num %>&pageNum=<%=pageNum%>'">
							<input class="btn btn-primary" type="button" value="삭제" onclick="location.href='adminIndex.jsp?pages=noticeDelete&n_num=<%= n_num %>&pageNum=<%=pageNum%>'">
						<%
								}
							}
						%>
							<input class="btn btn-primary" type="button" value="목록" onclick="location.href='adminIndex.jsp?pages=noticeList&pageNum=<%=pageNum%>'">
						</div>
						<div style="margin: 20px 0; text-align:center;">
						<%
							if(n_num+1 >0 ){
								notice = noticeDBBean.getNotice(n_after, false);
								n_title2 = notice.getN_title();
								if(n_title2 != null){
						%>
										<a class="btn btn-primary" href="adminIndex.jsp?pages=noticeShow&n_num=<%= n_after %>&pageNum=<%= pageNum %>" id="upPage">
											이전글 [<%= n_title2 %>]
										</a>
						<%
								}		
							}
						%>
						<%
							if(n_num-1 >0 ){
								notice = noticeDBBean.getNotice(n_before, false);
								n_title2 = notice.getN_title();
						%>
									<a class="btn btn-primary" href="adminIndex.jsp?pages=noticeShow&n_num=<%= n_before %>&pageNum=<%= pageNum %>" id="upPage">
										다음글 [<%= n_title2 %>]
									</a>
						<%
							}
						%>
						</div>
                      </form>
                    </div> <!-- /.card-body -->
                  </div> <!-- /.card -->
                </div> <!-- /.col -->
              </div>
            </div>
          </div>
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
    <script src='js/jquery.dataTables.min.js'></script>
    <script src='js/dataTables.bootstrap4.min.js'></script>
    <script>
      $('#dataTable-1').DataTable(
      {
        autoWidth: true,
        "lengthMenu": [
          [16, 32, 64, -1],
          [16, 32, 64, "All"]
        ]
      });
    </script>
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