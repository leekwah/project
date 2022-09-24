<%@page import="java.net.URLEncoder"%>
<%@page import="java.util.ArrayList"%>
<%@page import="order.OrderManageBean"%>
<%@page import="order.OrderManageDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	OrderManageDBBean omdb = OrderManageDBBean.getInstance();
	
	int o_rank = 0;
	int o_dNum, p_num, p_count, p_price;
	String o_num, o_dStat, refund, stat, pageNum;
	
	if(request.getParameter("pageNum") == null){
		pageNum = "1";
	} else {
		pageNum = request.getParameter("pageNum");
	}
	ArrayList<OrderManageBean> list = omdb.orderList(pageNum,"N");
%>
<!doctype html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>document</title>
    <!-- 부트스트랩 CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    <!-- Simple bar CSS -->
    <link rel="stylesheet" href="css/simplebar.css">
    <!-- Fonts CSS -->
    <link href="https://fonts.googleapis.com/css2?family=Overpass:ital,wght@0,100;0,200;0,300;0,400;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">
    <!-- Icons CSS -->
    <link rel="stylesheet" href="css/feather.css">
    <link rel="stylesheet" href="css/select2.css">
    <link rel="stylesheet" href="css/dropzone.css">
    <link rel="stylesheet" href="css/uppy.min.css">
    <link rel="stylesheet" href="css/jquery.steps.css">
    <link rel="stylesheet" href="css/jquery.timepicker.css">
    <link rel="stylesheet" href="css/quill.snow.css">
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
              <h2 class="h3 mb-3 page-title">주문 관리</h2>
              <div class="card shadow">
                <div class="card-body">
              <div style="text-align: center;">
              <table class="table table-borderless table-hover">
                <thead>
                  <tr role="row">
                    <!-- <th>
                      <div class="custom-control custom-checkbox">
                        <input type="checkbox" class="custom-control-input" id="all">
                        <label class="custom-control-label" for="all"></label>
                      </div>
                    </th> -->
                    <th>주문 순서</th>
                    <th>주문 번호</th>
                    <th>제품 번호</th>
                    <th>수량</th>
                    <th>금액</th>
                    <th>주문 상태</th>
                    <th>주문 수정</th>
                  </tr>
                </thead>
                <tbody>
    <%
		for(int i=0; i < list.size(); i++) {
			OrderManageBean omb = list.get(i); // 배열에 넣은 역순으로 board 객체에 값을 넣어줌
			o_rank++;
			o_dNum = omb.getOrder_detail_number();
			o_num = omb.getOrder_number();
			p_num = omb.getProduct_number();
			p_count = omb.getProduct_count();
			p_price = omb.getProduct_price();
			o_dStat = omb.getOrder_detail_status();
			refund = omb.getRefund_check();
			
			if(o_dStat.equals("입금 완료")){
				stat = URLEncoder.encode("입금 완료","UTF-8");
			} else if(o_dStat.equals("배송 준비")){
				stat = URLEncoder.encode("배송 준비","UTF-8");
			} else if(o_dStat.equals("배송중")){
				stat = URLEncoder.encode("배송중","UTF-8");
			} else if(o_dStat.equals("배송 완료")){
				stat = URLEncoder.encode("배송 완료","UTF-8");
			} else if(o_dStat.equals("구매 확정")){
				stat = URLEncoder.encode("구매 확정","UTF-8");
			}
	%>
                  <tr>
                    <!-- <td class="align-center">
                      <div class="custom-control custom-checkbox">
                        <input type="checkbox" class="custom-control-input">
                        <label class="custom-control-label"></label>
                      </div>
                    </td> -->
                    <td><%=o_rank%></td>
					<td><%=o_num%></td>
					<td>
						<a href="#"><%=p_num%></a>
					</td>
					<td><%= p_count %></td>
					<td><%=p_price%></td>
					<td><%=o_dStat%></td>
					<td>
                      <div class="dropdown">
                        <button class="btn btn-sm dropdown-toggle more-vertical" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                          <span class="text-muted sr-only">Action</span>
                        </button>
                        <div class="dropdown-menu dropdown-menu-right">
                          <a class="dropdown-item" href="adminIndex.jsp?pages=order_edit&o_dNum=<%= o_dNum%>&o_dStat=<%=o_dStat%>&pageNum=<%= pageNum %>">수정</a>
                        </div>
                      </div>
                      
                    </td>
					<%-- <td>
						<input type="radio" name="o_dNum" value="<%= o_dNum %>" />
					</td> <!-- 라디오 버튼  > 수정 버튼 > 정보 수정, 환불 처리 --> --%>
	<%			
		}
	%>
                  </tr>
                </tbody>
              </table>
               <nav aria-label="Table Paging" class="mb-0 text-muted">
	                 <ul class="pagination justify-content-center mb-0">
	                 	<%= OrderManageBean.pageNumber(5,"order_list") %>
	                 </ul>
               </nav>
	              </div>
	            </div>
              </div>
            </div>
          </div> <!-- .row -->
        </div> <!-- .container-fluid -->
    </div> <!-- .wrapper -->
  </body>
</html>