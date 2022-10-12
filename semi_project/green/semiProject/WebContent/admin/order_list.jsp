<%@page import="java.net.URLEncoder"%>
<%@page import="java.util.ArrayList"%>
<%@page import="order.OrderManageBean"%>
<%@page import="order.OrderManageDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	OrderManageDBBean omdb = OrderManageDBBean.getInstance();
	
	long o_dNum;
	int p_num, p_count, p_price;
	String o_num, o_dStat, refund, stat, pageNum, shipment;
	
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
    <title>document</title>
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
                    <th>주문 상세 번호</th>
                    <th>주문 번호</th>
                    <th>상품 이름(번호)</th>
                    <th>수량</th>
                    <th>금액</th>
                    <th>주문 상태</th>
                    <th>운송장 번호</th>
                    <th>주문 수정</th>
                  </tr>
                </thead>
                <tbody>
    <%
		for(int i=0; i < list.size(); i++) {
			OrderManageBean omb = list.get(i); // 배열에 넣은 역순으로 board 객체에 값을 넣어줌
			o_dNum = omb.getOrder_detail_number();
			o_num = omb.getOrder_number();
			p_num = omb.getProduct_number();
			p_count = omb.getProduct_count();
			p_price = omb.getProduct_price();
			o_dStat = omb.getOrder_detail_status();
			refund = omb.getRefund_check();
			
			omb = omdb.getOrder(o_dNum);
			String p_name = omb.getProduct_name();
			
			if(omb.getShipment() == null){
				shipment = "-";
			} else{
				shipment = omb.getShipment();
			}
			
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
                    <td><%=o_dNum%></td>
					<td><%=o_num%></td>
					<td>
						<a href="#"><%= p_name %>(<%=p_num%>)</a>
					</td>
					<td><%= p_count %></td>
					<td><%=p_price%></td>
					<td><%=o_dStat%></td>
					<td><%=shipment%></td>
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