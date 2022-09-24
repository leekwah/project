<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="cs.QnABoardBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="cs.FAQDBBean"%>
<%@page import="cs.QnABoardDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean class="cs.QnABoardBean" id="board"></jsp:useBean><!-- 객체 생성 -->
<jsp:useBean class="cs.QnABoardBean" id="board2"></jsp:useBean><!-- 객체 생성 -->
<%
	//아래에 사용할 변수들
	int b_id,b_view, b_level, b_fsize;
	String b_category, u_id, b_title, b_content, b_pwd, b_secret, b_anschk;
	Timestamp b_date;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	String b_titleSearch = "";
	int b_categorySearch = 0;
	String[] category = {"","회원정보", "상품문의", "주문/결제", "배송", "교환/취소", "서비스"};
	
	if(request.getParameter("b_titleS")!=null){
		b_titleSearch = request.getParameter("b_titleS");		
	} else{
		b_titleSearch = "회원정보";
	}
	if(request.getParameter("b_categoryS")!=null){
		b_categorySearch = Integer.parseInt(request.getParameter("b_categoryS"));
	} else {
		b_categorySearch = 1;
	}
	
	//객체생성 및 객체 배열
	FAQDBBean faqdbBean = FAQDBBean.getInstance();
	ArrayList<QnABoardBean> list = faqdbBean.listBoardFAQ(b_titleSearch,category[b_categorySearch]);
%>
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
    <!-- Date Range Picker CSS -->
    <link rel="stylesheet" href="css/daterangepicker.css">
    <!-- App CSS -->
    <link rel="stylesheet" href="css/app-light.css" id="lightTheme">
    <link rel="stylesheet" href="css/app-dark.css" id="darkTheme" disabled>
  </head>
<body class="vertical  light  ">
	<div class="form-group col-md-4">
		<form method="post" action="faq.jsp">
			<input type="text" name="b_titleS"  aria-label="Recipient's username" aria-describedby="button-addon2" />
			<input class="btn btn-primary" id="button-addon2" type="submit" value="FAQ검색">
		</form>
	</div>
    <div class="wrapper">
        <div class="container-fluid">
          <div class="row justify-content-center">
            <div class="col-12 col-lg-10 col-xl-12">
              <div class="row mt-4">
                <div class="col-md-4">
                  <div class="card shadow mb-4">
                    <div class="card-body">
                      <div class="row align-items-center">
                        <div class="col-3 text-center">
                          <span class="circle circle-md bg-primary">
                            <span class="fe fe-briefcase fe-24 text-white"></span>
                          </span>
                        </div>
                        <div class="col">
                        <label for="001" class="h6 mb-0 text-uppercase">회원 정보</label>
                          <p class="small text-muted mb-0">Member Information</p>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
                <div class="col-md-4">
                  <div class="card shadow mb-4">
                    <div class="card-body">
                      <div class="row align-items-center">
                        <div class="col-3 text-center">
                          <span class="circle circle-md bg-success">
                            <span class="fe fe-shopping-bag fe-24 text-white"></span>
                          </span>
                        </div>
                        <div class="col">
                        <label for="002" class="h6 mb-0 text-uppercase">상품 확인</label>
                          <p class="small text-muted mb-0">Product Confirmation</p>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
                <div class="col-md-4">
                  <div class="card shadow mb-4">
                    <div class="card-body">
                      <div class="row align-items-center">
                        <div class="col-3 text-center">
                          <span class="circle circle-md bg-warning">
                            <span class="fe fe-truck fe-24 text-white"></span>
                          </span>
                        </div>
                        <div class="col">
                        <label for="003" class="h6 mb-0 text-uppercase">주문 / 결제</label>	
                          <p class="small text-muted mb-0">Order / Payment</p>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
                <div class="col-md-4">
                  <div class="card shadow mb-4">
                    <div class="card-body">
                      <div class="row align-items-center">
                        <div class="col-3 text-center">
                          <span class="circle circle-md bg-secondary">
                            <span class="fe fe-package fe-24 text-white"></span>
                          </span>
                        </div>
                        <div class="col">
                        	<label for="004" class="h6 mb-0 text-uppercase">배송</label>	
	                          <p class="small text-muted mb-0">Shipment</p>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
                <div class="col-md-4">
                  <div class="card shadow mb-4">
                    <div class="card-body">
                      <div class="row align-items-center">
                        <div class="col-3 text-center">
                          <span class="circle circle-md bg-secondary">
                            <span class="fe fe-package fe-24 text-white"></span>
                          </span>
                        </div>
                        <div class="col">
                          <label for="005" class="h6 mb-0 text-uppercase">교환/취소</label>
                          <p class="small text-muted mb-0">Exchange / Cancellation</p>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
                <div class="col-md-4">
                  <div class="card shadow mb-4">
                    <div class="card-body">
                      <div class="row align-items-center">
                        <div class="col-3 text-center">
                          <span class="circle circle-md bg-secondary">
                            <span class="fe fe-package fe-24 text-white"></span>
                          </span>
                        </div>
                        <div class="col">
                        	<label for="006" class="h6 mb-0 text-uppercase">서비스</label>
	                        <p class="small text-muted mb-0">Service</p>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div> <!-- end section -->
              <input type="radio" name="category" id="001" onclick="location.href='?b_categoryS=1'" style="display: none;">
			  <input type="radio" name="category" id="002" onclick="location.href='?b_categoryS=2'" style="display: none;">
			  <input type="radio" name="category" id="003" onclick="location.href='?b_categoryS=3'" style="display: none;">
			  <input type="radio" name="category" id="004" onclick="location.href='?b_categoryS=4'" style="display: none;">
			  <input type="radio" name="category" id="005" onclick="location.href='?b_categoryS=5'" style="display: none;">
			  <input type="radio" name="category" id="006" onclick="location.href='?b_categoryS=6'" style="display: none;">
              <div class="row my-4">
                <div class="col-md-12">
                  <div class="accordion w-100" id="accordion1">
                    <div class="card shadow">
                      <div class="card-header" id="heading1">
                        <a role="button" href="#collapse1" data-toggle="collapse" data-target="#collapse1" aria-expanded="false" aria-controls="collapse1">
                          <strong>
      	<%
			for(int i=0;i<list.size();i++){
				board = list.get(i);
				
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
				
		%>
			<tr><!-- 조회순 20개의 질문글 -->
				<td>[<%= b_category %>]<%= b_title %></td>
			</tr>
                          </strong>
                        </a>
                      </div>
                      <div id="collapse1" class="collapse show" aria-labelledby="heading1" data-parent="#accordion1">
                        <div class="card-body">
            <tr><!-- 위의 질문글에 대한 답변 -->
		<%
				board2 = faqdbBean.getBoardFAQ(b_id, false);
		
				b_id=board2.getB_id();
				u_id=board2.getU_id();
				b_category=board2.getB_category();
				b_pwd=board2.getB_pwd();
				b_title= board2.getB_title();
				b_date= board2.getB_date();
				b_view= board2.getB_view();
				b_level = board2.getB_level();
				b_fsize = board2.getB_fsize();
				b_secret = board2.getB_secret();
		
		%>
				<td>[<%= b_category %>]<%= b_title %></td>
			</tr>
		<% 
			}
		%>
					</div>
					</div>
                	</div> 
				</div>
                </div> <!-- /.col -->
              </div> <!-- end section -->
            </div> <!-- /.col -->
          </div> <!-- .row -->
        </div> <!-- .container-fluid -->
    </div> <!-- .wrapper -->
    <script src="js/jquery.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/moment.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/simplebar.min.js"></script>
    <script src='js/daterangepicker.js'></script>
    <script src='js/jquery.stickOnScroll.js'></script>
    <script src="js/tinycolor-min.js"></script>
    <script src="js/config.js"></script>
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