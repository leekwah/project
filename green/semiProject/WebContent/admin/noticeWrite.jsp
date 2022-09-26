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
		n_user_id=(String)session.getAttribute("name");
	} else{
		n_user_id="";
		response.sendRedirect("adminIndex.jsp?pages=noticeList&pageNum="+pageNum);
	}
	
%>
<!doctype html>
<html lang="ko">
<head>
  <meta charset="utf-8">
  <title></title>
  <script src="../js/admin.js"></script>
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
                 <div aria-label="Basic example">
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
</body>
</html>