<%@page import="java.util.ArrayList"%>
<%@page import="cs.QnABoardBean"%>
<%@page import="cs.QnABoardDBBean"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	int b_id = 0,b_ref = 1,b_level = 0,b_step = 0;
	String b_title="",b_category="";
	/* if(session.getAttribute(id) == null){
		response.sendRedirect("login.jsp");
	} */
	b_id = Integer.parseInt(request.getParameter("b_id"));
	b_category = request.getParameter("b_category");
	QnABoardDBBean qdb = QnABoardDBBean.getInstance();
	QnABoardBean qbb = qdb.getBoard(b_id,false);
	if(qbb != null) {
		b_ref = qbb.getB_ref();
		b_step = qbb.getB_step();
		b_level = qbb.getB_level();
		b_title = qbb.getB_title();
	}
	String pageNum = request.getParameter("pageNum");
%>
<!doctype html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <title></title>
  </head>
  <body class="vertical  dark  ">
    <div class="wrapper">
        <div class="container-fluid">
          <div class="row justify-content-center">
            <div class="col-12">
              <h2 class="page-title">문의 답변</h2>
              <br />
              <form action="qnaReply_ok.jsp?pageNum=<%= pageNum %>" method="post" name="write_frm" enctype="multipart/form-data"">
              <div class="card shadow mb-2">
                  <div class="card shadow">
                    <div class="card-body">
                      <div class="form-group mb-3">
                        <label for="custom-select">문의 유형</label>
                        <select name="b_category" class="custom-select" id="b_category">
	                        <option value="회원정보">회원정보</option>
	                        <option value="상품문의">상품문의</option>
	                        <option value="주문/결제">주문/결제</option>
	                        <option value="배송">배송</option>
	                        <option value="교환/취소">교환/취소</option>
	                        <option value="서비스">서비스</option>
                        </select>
                      </div>
                      <div class="form-group mb-3">
                        <label for="simpleinput">글번호</label>
                        <input type="text" id="simpleinput" name="b_id" class="form-control" value="<%= b_id %>" readonly />
                      </div>
                      <div class="form-group mb-3">
                        <label for="example-palaceholder">제목</label>
                        <input type="text" id="example-palaceholder" class="form-control" name="b_title" value="[답변]<%= b_title %>" />
                      </div>
                      <div class="form-group mb-3">
                      	<label for="example-textarea">답변 내용</label>
                        <textarea class="form-control" name="b_content" id="example-textarea" rows="10"></textarea>
                      </div>
                      <div class="form-group mb-3">
                        <label for="customFile">사진 업로드</label>
                        <div class="custom-file">
                          <input type="file" name="b_fname" id="customFile qnaImg" />
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
                    </div>
                  </div>
                <div>
	                <input type="hidden" name="b_ref" value="<%= b_ref %>">
	                <input type="hidden" name="b_step" value="<%= b_step %>">
	                <input type="hidden" name="b_level" value="<%= b_level %>">
            	</div>
                  </div>
                  	<div style="text-align:center">
	                  <div aria-label="Basic example">
	                    <input type="button" class="btn btn-primary" value="목록" onclick="location.href='adminIndex.jsp?pages=qnaList&pageNum=<%= pageNum %>'" />
		                 <input type="reset" class="btn btn-primary" value="다시 작성" />
		                 <input type="button" class="btn btn-primary" value="작성" onclick="check_ok()" />
	                  </div>
                	</div>
                	</div>
              	</div> <!-- end section -->
              </form>
            </div> <!-- .col-12 -->
          </div> <!-- .row -->
        </div> <!-- .container-fluid -->
    </div> <!-- .wrapper -->
	<script src="../js/jquery.min.js">
	<script src="../js/board.js"></script>
    <script type="text/javascript">
		$(function(){
			$("#b_category > option[value='<%= b_category %>']").prop("selected", true);
		});
	</script>
  </body>
</html>