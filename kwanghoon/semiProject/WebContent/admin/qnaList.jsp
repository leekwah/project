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
	// 페이징 처리
	int pageSize = 10; // 한페이지에 보여질 글 수
	int count = qdb.getReplyCount(new QnABoardBean()); // 전체 글 수
	// 현재 페이지 정보 설정
	String pageNum = request.getParameter("pageNum");
	if(pageNum == null){
		pageNum = "1";
	} 
	// 첫 행번호 계산
	int currentPage = Integer.parseInt(pageNum);
	int startRow = (currentPage-1)*pageSize+ 1; // 2페이지면 11~20
	ArrayList<QnABoardBean> adminList = qdb.adminListBoard(startRow,pageSize);
	
	int pageCount=1, pageBlock=5, startPage=1, endPage=1; // pageBlock: 한 페이지에 보여줄 페이지 블럭
	if(count != 0) {
		pageCount = (int)Math.ceil((double)count / pageSize); // 전체 페이지 수
		startPage = ((currentPage-1)/pageBlock)*pageBlock+1; // 페이지 블럭 시작 번호
		endPage = startPage + pageBlock -1; // 페이지 블럭 끝 번호
		if(endPage > pageCount){
			endPage = pageCount;
		} // 전체 페이지가 10페이지인데 마지막 페이지가 11이면 안되므로 조건문 설정
	}
%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="favicon.ico">
    <title>Tiny Dashboard - A Bootstrap Dashboard Template</title>
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
                  <h2 class="h4 mb-1">Q & A 관리</h2>
                  <div class="card shadow">
                    <div class="card-body">
                      <!-- table -->
                      <div style="text-align: center;">
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
                            <th>Action</th>
                          </tr>
                        </thead>
                        <tbody>
   <%
		for(int i=0; i < adminList.size(); i++) {
			QnABoardBean board = adminList.get(i); // 배열에 넣은 역순으로 board 객체에 값을 넣어줌
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
			if(b_anschk.equals("N")){
	%>
                          <tr>
							<td class="mb-0 text-muted"><%=b_id%></td>
							<td class="mb-0 text-muted"><%=b_category%></td>
							<td class="mb-0 text-muted"><%=b_title%></td>
							<td class="mb-0 text-muted"><%= u_id %></td>
							<td class="mb-0 text-muted"><%=sdf.format(b_date)%></td>
							<td class="mb-0 text-muted"><%=b_view%></td>
							<td>
								<%
									if(b_fsize != 0) {
								%>
										<img src="../images/image.png" style="width:10px;" />
								<%
									}
								%>
							</td>
							<td>
								<%
									if(b_secret.equals("Y")) {
								%>
										<img src="../images/lock.png" style="width:30px;" />
								<%
									}
								%>
							</td>
							<td><button class="btn btn-sm dropdown-toggle more-horizontal" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <span class="text-muted sr-only">Action</span>
                              </button>
                              <div class="dropdown-menu dropdown-menu-right">
                                <a class="dropdown-item" href="adminIndex.jsp?pages=../cs/qna/show&b_id=<%= b_id %>&pageNum=<%= pageNum %>">확인</a>
                                <a class="dropdown-item" href="adminIndex.jsp?pages=../cs/qna/reply&b_id=<%= b_id %>&pageNum=<%= pageNum %>">답변</a>
                                <a class="dropdown-item" href="adminIndex.jsp?pages=../cs/qna/delete&b_id=<%= b_id %>&pageNum=<%= pageNum %>">삭제</a>
                              </div>
                            </td>
						</tr>
					<%
						}
					%>
				<%
					}
				%>
                        </tbody>
                      </table>
                      </div>
                      <nav aria-label="Table Paging" class="mb-0 text-muted">
                        <ul class="pagination justify-content-center mb-0">
                        	<%
		if(startPage > pageBlock) {
	%>
                          <li class="page-item"><a class="page-link" href="adminIndex.jsp?pages=qnaList&pageNum=<%= startPage-pageBlock %>">이전</a></li>
    <%
		}
		for(int i = startPage; i<= endPage; i++){
	%>
                          <li class="page-item"><a class="page-link" href="adminIndex.jsp?pages=qnaList&pageNum=<%= i %>"><%= i %></a></li>
    <%	
		}
		if(startPage+pageBlock <= pageCount) {
	%>
                          <li class="page-item"><a class="page-link" href="adminIndex.jsp?pages=qnaList&pageNum=<%= startPage+pageBlock %>">다음</a></li>
    <%
		}
	%>
                        </ul>
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