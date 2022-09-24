<%@page import="java.net.URLEncoder"%>
<%@page import="java.util.ArrayList"%>
<%@page import="cs.QnABoardBean"%>
<%@page import="cs.QnABoardDBBean"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<%
	int b_id,b_view, b_level, b_fsize;
	String b_category, u_id, b_title, b_content, b_pwd, b_secret, b_anschk;
	Timestamp b_date;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	QnABoardDBBean qdb = QnABoardDBBean.getInstance();
	String pageNum = request.getParameter("pageNum");
	if(pageNum == null){
		pageNum = "1";
	} 
	ArrayList<QnABoardBean> list = qdb.listBoard(pageNum);
	
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
              <div class="row">
                <!-- Small table -->
                <div class="col-md-12 my-4">
                  <h2 class="h4 mb-1">Q & A</h2>
                  <br />
                  <div class="col-md-12 my-4">
                  	<a href="../../main.jsp">스토어 홈</a>> <a href="../cs_main.jsp">고객센터</a>> QnA
                  </div>
                  <div class="card shadow">
                    <div class="card-body">
                      <!-- table -->
                      <div style="text-align:center">
                      <table class="table table-borderless table-hover">
                        <thead>
                          <tr>
                            <th>글번호</th>
							<th>분류</th>
							<th class="w-25">제목</th>
							<th>작성자</th>
							<th>작성일</th>
							<th>조회수</th>
							<th>첨부파일</th>
							<th>비공개</th>
                          </tr>
                        </thead>
                        <tbody>
   <%
		for(int i=0; i < list.size(); i++) {
			QnABoardBean board = list.get(i); // 배열에 넣은 역순으로 board 객체에 값을 넣어줌
			b_id=board.getB_id();
			u_id=board.getU_id();
			b_category=board.getB_category();
			b_pwd=board.getB_pwd();
			b_title= board.getB_title();
			b_date= board.getB_date();
			b_view= board.getB_view();
			b_level = board.getB_level();
			b_fsize = board.getB_fsize();
			b_secret = board.getB_secret();
			b_anschk = board.getB_anschk();
			
	%>
                          <tr>
							<td class="mb-0 text-muted"><%=b_id%></td>
							<td class="mb-0 text-muted"><%=b_category%></td>
							<td class="mb-0 text-muted">
								<%
									if(b_level > 0){
										for(int j=0; j<b_level; j++){
								%>
											&nbsp;
								<%
										}
								%>
									<img src="../../images/replyE.png" style="width:20px;" />
								<%
									}
								%>
								<a href="qnaShow.jsp?b_id=<%= b_id %>&pageNum=<%= pageNum %>"><%=b_title%></a>
							</td>
							<td class="mb-0 text-muted"><%= u_id %></td>
							<td class="mb-0 text-muted"><%=sdf.format(b_date)%></td>
							<td class="mb-0 text-muted"><%=b_view%></td>
							<td>
								<%
									if(b_fsize != 0) {
								%>
										<img src="../../images/image.png" style="width:30px;" />
								<%
									}
								%>
							</td>
							<td>
								<%
									if(b_secret.equals("Y")) {
								%>
										<img src="../../images/lock.png" style="width:30px;" />
								<%
									}
								%>
							</td>
						</tr>
                        </tbody>
	<%
					}
	%>
                      </table>
                      </div>
				<nav aria-label="Table Paging" class="mb-0 text-muted">
		        	<ul class="pagination justify-content-center mb-0">
						<%= QnABoardBean.pageNumber(5) %>
					</ul>
	<%
				 /* if(session.getAttribute("id") != null){ */
	%>
						<div style="text-align:right">
							<a href="qnaWrite.jsp?pageNum=<%= pageNum %>" class="btn mb-2 btn-outline-primary">글 쓰 기</a>
						</div>
			
	<% 
		/* } */
	%>
                      </nav>
                    </div>
                  </div>
                </div> <!-- customized table -->
              </div> <!-- end section -->
            </div> <!-- .col-12 -->
          </div> <!-- .row -->
        </div> <!-- .container-fluid -->
    </div> <!-- .wrapper -->
<!--     <script src="js/jquery.min.js"></script> -->
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