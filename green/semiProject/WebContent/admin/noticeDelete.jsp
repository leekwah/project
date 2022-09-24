<%@page import="cs.NoticeDBBean"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<jsp:useBean class="cs.NoticeBean" id="notice"></jsp:useBean>
<%
	int n_num = 0;
	if(request.getParameter("n_num")==null){
		response.sendRedirect("adminIndex.jsp");
	} else{
		NoticeDBBean noticeDBBean = NoticeDBBean.getInstance();
		n_num = Integer.parseInt(request.getParameter("n_num"));
		noticeDBBean.getNotice(n_num,false);
		String bpwd = notice.getN_pwd();		
	}
	String pageNum=request.getParameter("pageNum");
%>
<!doctype html>
<html lang="ko">
<head>
  <meta charset="utf-8">
  <title></title>
</head>
<body class="dark ">
  <div class="wrapper vh-100">
    <div class="row align-items-center h-100">
      <form method="post" action="noticeDelete_ok.jsp?n_num=<%= n_num %>&pageNum=<%=pageNum %>" name="del_frm" class="col-lg-3 col-md-4 col-10 mx-auto text-center">
        <div class="mx-auto text-center my-4">
          <h2 class="my-3">정말로 글을 삭제하시겠습니까?</h2>
        </div>
        <p class="text-muted">글을 삭제하기 위해 비밀번호를 입력해 주세요.</p>
        <div class="form-group">
          <label for="inputEmail" class="sr-only"></label>
          <input type="password" name="b_pwd" id="inputEmail" class="form-control form-control-lg" placeholder="PassWord">
        </div>
        <div style="text-align:center">
          <div class="btn-group" role="group" aria-label="Basic example">
           <input type="button" class="btn mb-2 btn-secondary" value="삭제" onclick="delete_ok()" />
              <input type="button" class="btn mb-2 btn-secondary" value="취소" onclick="document.location.href='adminIndex.jsp?pages=noticeList&pageNum=<%= pageNum %>'" />
          </div>
     	  </div>
      </form>
    </div>
  </div>
  <script src="../js/jquery.min.js"></script>
  <script src="../js/admin.js"></script>
</body>
</html>
</body>
</html>