<%@page import="java.util.ArrayList"%>
<%@page import="order.OrderManageBean"%>
<%@page import="order.OrderManageDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int o_rank = 0;
	int p_num, p_count, p_price;
	long o_dNum;
	String o_num, o_dStat, refund, pageNum;
	
	if(request.getParameter("pageNum") == null){
		pageNum = "1";
	} else {
		pageNum = request.getParameter("pageNum");
	}
	OrderManageDBBean omdb = OrderManageDBBean.getInstance();
	ArrayList<OrderManageBean> list = omdb.orderList(pageNum,"Y");
%>
<!doctype html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <title>document</title>
    <script type="text/javascript" src="../js/admin.js"></script>
  </head>
  <body class="vertical  dark  ">
    <div class="wrapper">
        <div class="container-fluid">
          <div class="row justify-content-center">
            <div class="col-12">
              <h2 class="h3 mb-3 page-title">환불 관리</h2>
              <div class="card shadow">
                    <div class="card-body">
	              <div style="text-align: center;">
	              <table class="table table-borderless table-hover">
	                <thead>
	                  <tr role="row">
	                    <th>주문 번호</th>
	                    <th>상품 이름(번호)</th>
	                    <th>수량</th>
	                    <th>금액</th>
	                    <th>주문 상태</th>
	                    <th>환불 처리</th>
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
		%>
	                  <tr>
						<td><%=o_num%></td>
						<td>
						<a href="#"><%= p_name %>(<%=p_num%>)</a>
						</td>
						<td><%= p_count %></td>
						<td><%=p_price%></td>
						<td><%=o_dStat%></td>
						<td>
							<input class="btn mb-2" type="hidden" id="refund" value="refund_ok.jsp?pageNum=<%= pageNum %>&orderNum=<%= o_num%>" />
                       		<a class="btn mb-2" href="#" onclick="refundCheck()">승인</a>
						</td>
		<%			
			}
		%>
	                  </tr>
	                </tbody>
	              </table>
	               <nav aria-label="Table Paging" class="mb-0 text-muted">
		                 <ul class="pagination justify-content-center mb-0">
		                 	<%= OrderManageBean.pageNumber(5,"refund_list") %>
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