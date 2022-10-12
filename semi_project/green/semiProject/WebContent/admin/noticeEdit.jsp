<%@page import="cs.NoticeDBBean"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<jsp:useBean class="cs.NoticeBean" id="notice"></jsp:useBean>
<%
	int n_num=0;
	if(request.getParameter("n_num") == null){
		response.sendRedirect("adminIndex.jsp");
	} else{
		NoticeDBBean noticeDBBean = NoticeDBBean.getInstance();
		n_num = Integer.parseInt(request.getParameter("n_num"));
		notice = noticeDBBean.getNotice(n_num,false);				
	}
	String pageNum=request.getParameter("pageNum");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script src="../js/admin.js"></script>
</head>
<body>
  <div class="wrapper">
     <div class="container-fluid">
       <div class="row justify-content-center">
         <div class="col-12">
           <h2 class="page-title">공지 수정</h2>
           <br />
           <form method="post" action="noticeEdit_ok.jsp?n_num=<%= n_num %>&pageNum=<%= pageNum %>" name="wrt_frm">
        	<div class="card shadow mb-2">
            	<div class="card shadow">
             	 <div class="card-body">
               		 <div class="form-group mb-3">
                  		<label for="name">작성자</label>
		               <input type="text" id="name" class="form-control" value="<%= notice.getUser_id() %>" aria-label="Username" aria-describedby="basic-addon1" readonly />
	                </div>
	                <div class="form-group mb-3">
	                  <label for="title">제목</label>
		               <input type="text" name="n_title" id="title" class="form-control" value="<%= notice.getN_title() %>" aria-label="Username" aria-describedby="basic-addon1" />
		                </div>
		                <div class="form-group mb-3">
		             			<div id="editor" style="min-height:300px;" contenteditable="true">
		             				<%= notice.getN_content() %>
		             			</div>
		             		</div>
		            		<input type="hidden" value="" name="n_content" id="content">
		                <div class="form-group mb-3">
		                  <label for="example-password">비밀번호</label>
		                  <input type="password" name="n_pwd" class="form-control" aria-label="Username" aria-describedby="basic-addon1" />
		                </div>
		            	<div style="text-align:center">
		             <div class="btn-group" role="group" aria-label="Basic example">
		               <input type="button" class="btn btn-primary" value="목록" onclick="location.href='adminIndex.jsp?pages=noticeList&pageNum=<%= pageNum %>&n_num=<%=n_num%>'" />
		             <input type="reset" class="btn btn-primary" value="다시 작성" />
		             <input type="button" class="btn btn-primary" value="수정" onclick="onclick_ok()" />
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