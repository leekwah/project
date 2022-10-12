<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = (String)session.getAttribute("id");
	String name = (String)session.getAttribute("name");
	
	String pages = "";
	if(request.getParameter("pages")!=null){
		pages = request.getParameter("pages");		
	} else{
		pages = "main_body";
	}
%>
<!doctype html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Order progress</title>
    <link href="https://fonts.googleapis.com/css2?family=Overpass:ital,wght@0,100;0,200;0,300;0,400;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="../css/simplebar.css">
    <link rel="stylesheet" href="../css/feather.css">
    <link rel="stylesheet" href="../css/dataTables.bootstrap4.css">
    <link rel="stylesheet" href="../css/daterangepicker.css">
    <link rel="stylesheet" href="../css/app-light.css" id="lightTheme">
  </head>
  <body class="vertical  light  ">
    <div class="wrapper">
        <div class="container-fluid">
          <div class="row justify-content-center">
            <div class="col-12">
              <div class="row">
                <!-- Small table -->
                <div class="col-md-12 my-4">
                  <h2 class="h4 mb-1">배송상품 및 결제내역</h2>
                  <p class="mb-3">배송상태 및 결제내역을 확인하세요.</p>
                  <div class="card shadow">
                    <div class="card-body">
                      <!-- table -->
                      <table class="table table-borderless table-hover">
                        <thead>
                          <tr>
                            <th>제품사진</th>
                            <th>제품이름</th>
                            <th>카테고리</th>
                            <th>운송장번호</th>
                            <th class="w-25">전화번호</th>
                            <th class="w-25">제품 설명</th>
                            <th>주문날짜</th>
                          </tr>
                        </thead>
                        <tbody>
                          <tr>
                            <td>
                              <div class="avatar avatar-md">
                                <img src="./assets/avatars/face-3.jpg" alt="제품사진" class="avatar-img rounded-circle">
                                <!-- 사진 가져오기 -->
                              </div>
                            </td>
                            <td>
                              <p class="mb-0 text-muted"><strong>제품 이름 가져오기</strong></p>
                              <!-- 제품명 가져오기 -->
                            </td>
                            <td>
                              <p class="mb-0 text-muted">카테고리 가져오기</p>
                              <!-- 제품 카테고리 가져오기-->
                            </td><td>
                              <p class="mb-0 text-muted">운송장번호 가져오기</p>
                              <!-- 운송장번호 가져오기 -->
                            </td>
                            <td>
                              <p class="mb-0 text-muted"><a href="#" class="text-muted">고객 전화번호 가져오기</a></p>
                              <!-- 전화번호 가져오기 -->
                            </td>
                            <td class="w-25"><small class="text-muted">주소 가져오기</small></td>
                            <td class="text-muted">13/09/2020</td>
                            <td><button class="btn btn-sm dropdown-toggle more-horizontal" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <span class="text-muted sr-only">Action</span>
                              </button>
                              <div class="dropdown-menu dropdown-menu-right">
                                <a class="dropdown-item" href="main.jsp?pages=../buy/buy_body">배송지 변경</a>
                                <a class="dropdown-item" href="#">환불 및 교환</a>
                                <a class="dropdown-item" href="#">구매확정</a>
                              </div>
                            </td>
                          </tr>
                        </tbody>
                      </table>
                      <nav aria-label="Table Paging" class="mb-0 text-muted">
                        <ul class="pagination justify-content-center mb-0">
                          <li class="page-item"><a class="page-link" href="#">Previous</a></li>
                          <li class="page-item"><a class="page-link" href="#">1</a></li>
                          <li class="page-item"><a class="page-link" href="#">2</a></li>
                          <li class="page-item"><a class="page-link" href="#">3</a></li>
                          <li class="page-item"><a class="page-link" href="#">Next</a></li>
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
  </body>
</html>