<%@page import="java.text.SimpleDateFormat"%>
<%@page import="order.OrderManageDBBean"%>
<%@page import="order.OrderManageBean"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	long o_dNum = Long.parseLong(request.getParameter("orderDNum"));

	OrderManageBean omb = new OrderManageBean();
	OrderManageDBBean omdb = OrderManageDBBean.getInstance();
	omb = omdb.getOrder(o_dNum);
	String p_name = omb.getProduct_name();
	int count = omb.getProduct_count();
	int price = omb.getProduct_price();
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
	String orderDate = sdf.format(omb.getOrder_date());
	
	String name = omb.getReceiver_name();
	String phone = omb.getReceiver_phone1()+"-"+omb.getReceiver_phone2()+"-"+omb.getReceiver_phone3();
	String detailaddr = omb.getReceiver_raddr()+" "+omb.getReceiver_detailaddr();
	String requested = omb.getRequested();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<div class="container-fluid">
	  <div class="row justify-content-center">
	    <div class="col-12">
	      <h2 class="page-title" style="text-align: center;">결제 완료</h2>
	      <div class="row">
	       <div class="col-md-6" style="margin: 0 auto;">
	         <div class="card shadow mb-4">
	           <div class="card-body">
				<table class="table table-bordered">
					<thead>
					  <tr role="row">
					    <th>상품정보</th>
					    <th>수량</th>
					    <th>주문금액</th>
					    <th>주문일자</th>
					  </tr>
					</thead>
					<tbody>
					  <tr>
					    <td>
	                   		<input type="text" class="form-control" value="<%= p_name %>" readonly>		
					    </td>
					    <td>
					    	<input type="text" class="form-control" value="<%= count %>" readonly>
					    </td>
					    <td>
					   		<input type="text" class="form-control" value="<%= price %>" readonly>
					    </td>
					    <td>
					   		<input type="text" class="form-control" value="<%= orderDate %>" readonly>
					    </td>
					  </tr>
					</tbody>
				 </table>
	               <div class="form-row">
	                 <div class="col-md-4 mb-3">
	                   <label for="validationCustom3">수령인</label>
	                   <input type="text" class="form-control" id="validationCustom3" value="<%= name %>" readonly>
	                 </div>
	               </div> <!-- /.form-row -->
	               <div class="form-row">
	                 <div class="col-md-2 mb-3">
	                   <label for="custom-phone">연락처</label>
	                   <input class="form-control input-phoneus" id="custom-phone" value="<%= phone %>" readonly>
	                 </div>
                   </div>
	               <div class="form-group mb-3">
	                 	<label for="address-wpalaceholder">상세 주소</label>
	                 	<input type="text" id="sample4_detailAddress" class="form-control" value="<%= detailaddr %>" readonly>
	               </div>
	               <div class="form-group mb-3">
	                 <label for="validationTextarea1">요청사항</label>
	                 <div><%= requested %></div>
	               </div>
	           </div> <!-- /.card-body -->
	         </div> <!-- /.card -->
	       </div> <!-- /.col -->
	     </div> <!-- end section -->
	   </div> <!-- /.col-12 col-lg-10 col-xl-10 -->
	 </div> <!-- .row -->
	</div> <!-- .container-fluid -->

</body>
</html>