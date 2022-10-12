<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int b_id = Integer.parseInt(request.getParameter("b_id"));
	String pageNum = request.getParameter("pageNum");
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
        <form method="post" action="qnaDelete_ok.jsp?b_id=<%= b_id %>&pageNum=<%= pageNum %>" name="del_frm" class="col-lg-3 col-md-4 col-10 mx-auto text-center" style="min-width:400px;">
          <div class="mx-auto text-center my-6">
            <h2 class="my-6">삭제하시겠습니까?</h2>
          </div>
          <p class="text-muted">글을 삭제하기 위해 비밀번호를 입력해 주세요.</p>
          <div class="form-group">
            <label for="password" class="sr-only"></label>
            <input type="password" name="b_pwd" id="password" class="form-control form-control-lg" placeholder="비밀번호를 입력하세요.">
          </div>
          <div style="text-align:center">
            <div class="btn"aria-label="Basic example">
                <input type="button" class="btn btn-primary" value="취소" onclick="history.go(-1)" />
	            <input type="button" class="btn btn-primary" value="삭제" onclick="delete_ok()" />
            </div>
       	  </div>
        </form>
      </div>
    </div>
    <script type="text/javascript" src="../../js/board.js" charset="UTF-8"></script>
  </body>
</html>
</body>
</html>