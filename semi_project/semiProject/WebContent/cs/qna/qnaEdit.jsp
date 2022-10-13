<%@page import="java.net.URLDecoder"%>
<%@page import="cs.QnABoardBean"%>
<%@page import="cs.QnABoardDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	QnABoardDBBean qdb = QnABoardDBBean.getInstance();
	QnABoardBean qbb = qdb.getBoard(Integer.parseInt(request.getParameter("b_id")),false);
	String content = qbb.getB_content();
	content = content.replace("<br>","\r\n");
	String pageNum = request.getParameter("pageNum");
	String b_category = request.getParameter("b_category");

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
              <h2 class="page-title">글 수정</h2>
              <br />
              <form action="qnaEdit_ok.jsp?b_id=<%= qbb.getB_id() %>&pageNum=<%= pageNum %>" method="post" name="write_frm" enctype="multipart/form-data"">
              <div class="card shadow mb-2">
                  <div class="card shadow">
                    <div class="card-body">
                      <div class="form-group mb-3">
                        <label for="custom-select">문의 유형</label>
                        <select name="b_category" class="custom-select" id="b_category">
	                        <option value="nonSelect" selected>문의 유형을 선택해 주세요.</option>
	                        <option value="회원정보">회원정보</option>	
	                        <option value="상품문의">상품문의</option>
	                        <option value="주문/결제">주문/결제</option>
	                        <option value="배송">배송</option>
	                        <option value="교환/취소">교환/취소</option>
	                        <option value="서비스">서비스</option>
                        </select>
                      </div>
                      <div class="form-group mb-3">
                        <label for="example-palaceholder">제목</label>
                        <input type="text" id="example-palaceholder" class="form-control" name="b_title" value="<%= qbb.getB_title() %>" />
                      </div>
                      <div class="form-group mb-3">
                        <label for="example-textarea">문의 내용</label>
                        <textarea class="form-control" name="b_content" id="example-textarea" rows="10"><%= content %></textarea>
                      </div>
                      <div class="form-group mb-3">
                        <label for="customFile">사진 업로드</label>
                        <div class="custom-file">
                          <input type="file" name="b_fname" id="customFile" />
                          <label for="customFile"></label>
                          	기존 업로드 파일 :<span id="showFiles"><%= qbb.getB_rfname() %></span>
                        </div>
                      </div>
                      <div class="form-group mb-3">
                        <label for="example-password">비밀번호</label>
                        <input type="password" name="b_pwd" id="example-password" class="form-control" placeholder="비밀번호를 입력해주세요.">
                      </div>
                      <div class="form-check">
                        <input class="form-check-input" type="checkbox" name="b_secret" id="defaultCheck1">비밀글
                      </div>
                  	<div style="text-align:center">
	                  <div class="btn-group" role="group" aria-label="Basic example">
	                    <input type="button" class="btn btn-primary" value="목록" onclick="location.href='main.jsp?pages=../cs/qna/qnaList_u&pageNum=<%= pageNum %>'" />
		                 <input type="reset" class="btn btn-primary" value="다시 작성" />
		                 <input type="button" class="btn btn-primary" value="작성" onclick="check_ok()" />
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
	<script type="text/javascript" src="../../js/board.js" charset="UTF-8"></script>
	<script src="../../js/jquery.min.js"></script>
  </body>
</html>