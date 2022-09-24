<%@page import="java.util.ArrayList"%>
<%@page import="cs.QnABoardBean"%>
<%@page import="cs.QnABoardDBBean"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	QnABoardDBBean qdb = QnABoardDBBean.getInstance();
	QnABoardBean qbb = qdb.getBoard(Integer.parseInt(request.getParameter("b_id")),true);
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	String pageNum = request.getParameter("pageNum");
	String b_category = qbb.getB_category();
	if(qbb.getB_secret().equals("Y")&&!qbb.getU_id().equals(session.getAttribute("id"))){
%>
		<script>
			alert("작성자만 읽을 수 있습니다.");
			history.back();
		</script>	
<%
	}
%>
<!doctype html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <link rel="icon" href="favicon.ico">
    <title></title>
  </head>
<body class="vertical  dark  ">
    <div class="wrapper">
    <div class="container-fluid">
          <div class="row justify-content-center">
            <div class="col-12">
              <h2 class="page-title">문의 확인</h2>
              <div class="row">
                <div class="col-md-12">
                  <div class="card shadow mb-4">
                    <div class="card-body">
                      <form class="needs-validation" novalidate>
                        <div class="form-row">
                          <div class="col-md-6 mb-3">
                            <span>글 번호</span>
                            <span class="form-control"><%= qbb.getB_id() %></span>
                          </div>
                          <div class="col-md-6 mb-3">
                            <span>문의 유형</span>
                            <span class="form-control"><%= b_category %></span>
                          </div>
                        </div>
                        <div class="form-row">
                          <div class="col-md-6 mb-3">
                            <span>작성자</span>
                            <span class="form-control"><%= qbb.getU_id() %></span>
                          </div>
                          <div class="col-md-6 mb-3">
                            <span>작성일</span>
                            <span class="form-control"><%= sdf.format(qbb.getB_date()) %></span>
                          </div>
                        </div>
                        <div class="form-row">
                          <div class="col-md-4 mb-3">
                            <span>조회수</span>
                            <span class="form-control"><%= qbb.getB_view() %></span>
                          </div>
                          <div class="col-md-8 mb-3">
                            <span>이미지</span>
                            <span class="form-control">
                            <%
								if(qbb.getB_fname() != null){
							%>
									<img src="../images/download.png" style="width:20px;" />
									<a href="FileDownload.jsp?fileNum=<%= qbb.getB_id() %>">(파일명 :<%= qbb.getB_rfname() %>)</a>
							<%
								}else{
							%>
									업로드한 사진이 없습니다.
							<%
								}
							%>
							</span>
                          </div>
                        </div>
                        <div class="form-group mb-3">
                        	<span>제목</span>
                            <span class="form-control"><%= qbb.getB_title() %></span>
                        </div>
                        <div class="form-group mb-3">
                          <span>문의 내용</span>
                          <span class="form-control" style="height: 350px;"><%= qbb.getB_content() %></span>
                        </div>
                        <div style="text-align:center;">
	                        <input class="btn btn-primary" type="button" value="목록" onclick="location.href='adminIndex.jsp?pages=qnaList&pageNum=<%= pageNum %>'" />
							
							<% 
								if(qbb.getU_id().equals(session.getAttribute("id"))||session.getAttribute("grade")=="관리자") {
							%>
							<input class="btn btn-primary" type="button" value="삭제" onclick="location.href='adminIndex.jsp?pages=../cs/qna/qnaDelete&b_id=<%= qbb.getB_id() %>&pageNum=<%= pageNum %>'" />
							<% 
								}
							%>
							<% 
								if(session.getAttribute("grade")=="admin" || session.getAttribute("id")=="admin" ) {
							%>
							<input class="btn btn-primary" type="button" value="답변" onclick="location.href='adminIndex.jsp?pages=qnaReply&b_id=<%= qbb.getB_id() %>&pageNum=<%= pageNum %>&b_category=<%=b_category %>'" />
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
	<script type="text/javascript" src="../js/board.js" charset="UTF-8"></script>
  </body>
</html>