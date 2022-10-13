<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="order.OrderManageBean"%>
<%@page import="order.OrderManageDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<%
	OrderManageDBBean omdb = OrderManageDBBean.getInstance();
	OrderManageBean omb = omdb.getOrder(Integer.parseInt(request.getParameter("o_dNum")));
	String pageNum = request.getParameter("pageNum");
	if(pageNum == null){
		pageNum = "1";
	}
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	String o_dStat = request.getParameter("o_dStat");
	int p_count = omb.getProduct_count();
	int p_price = omb.getProduct_price();
	String shipment;
	if(omb.getShipment() == null){
		shipment = "";
	} else{
		shipment = omb.getShipment();
	}
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
              <h2 class="page-title">주문서 수정</h2>
              <div class="row">
                <div class="col-md-12">
                  <div class="card shadow mb-4">
                    <div class="card-header">
                      <strong class="card-title">주문 내역</strong>
                    </div>
                    <div class="card-body">
                      <form action="order_edit_ok.jsp?pageNum=<%= pageNum %>" method="post" name="order_frm">
                        <div class="form-row">
                          <div class="form-group col-md-3">
                            <label for="date">주문 일자</label>
                            <input type="text" class="form-control" id="date" value="<%= sdf.format(omb.getOrder_date()) %>" readonly />
                          </div>
                          <div class="form-group col-md-3">
                            <label for="number">주문 번호</label>
                            <input type="text" class="form-control" name="order_number" id="number" value="<%= omb.getOrder_number() %>" readonly />
                          </div>
                          <div class="form-group col-md-3">
                            <label for="status">주문 상태</label>
                            <select id="status" class="form-control" name="order_detail_status">
	                            <option value="입금 완료">입금 완료</option>
		                        <option value="배송 준비">배송 준비</option>
		                        <option value="배송중">배송중</option>
		                        <option value="배송 완료">배송 완료</option>
		                        <option value="구매 확정">구매 확정</option>
                            </select>
                          </div>
                          <div class="form-group col-md-3">
                            <label for="shipment">운송장 번호</label>
                            <input type="text" class="form-control" name="shipment" id="shipment" value="<%= shipment %>" onchange="statusChange()" />
                          </div>
                        </div>
                        <div class="form-row">
                          <div class="form-group col-md-3">
                            <label for="userId">주문자 ID</label>
                            <input type="text" class="form-control" id="userId" value="<%= omb.getUser_id() %>" readonly />
                          </div>
                          <div class="form-group col-md-3">
                            <label for="productNumber">상품 번호</label>
                            <input type="text" class="form-control" id="productNumber" value="<%= omb.getProduct_number() %>" readonly />
                          </div>
                          <div class="form-group col-md-3">
                            <label for="count">수량(개)</label>
                            <input type="text" class="form-control" name="product_count" id="count" value="<%= p_count %>" readonly />
                          </div>
                          <div class="form-group col-md-3">
                            <label for="price">금액(원)</label>
                            <input type="text" class="form-control" name="product_price" id="price" value="<%= p_price %>" readonly />
                          </div>
                        </div>
                        <div class="form-row">
                          <div class="form-group col-md-3">
                            <label for="receivername">수령자</label>
                            <input type="text" class="form-control" name="receiver_name" id="receivername" value="<%= omb.getReceiver_name() %>" />
                          </div>
                        </div>
                        <div class="form-row">
                          <div class="form-group col-md-2">
                          	<label for="phone">전화번호</label>
                          </div>
                        </div>
                        <div class="form-row">
                          <div class="form-group col-md-2">
                            <select id="phone" class="form-control" name="receiver_phone1">
	                            <option value="010">010</option>
		                        <option value="02">02</option>
		                        <option value="031">031</option>
		                        <option value="051">051</option>
                            </select>
                          </div>
                          <div class="form-group col-md-2">
                            <input type="text" class="form-control" name="receiver_phone2" value="<%= omb.getReceiver_phone2() %>" maxlength="4" />
                          </div>
                          <div class="form-group col-md-2">
                            <input type="text" class="form-control" name="receiver_phone3" value="<%= omb.getReceiver_phone3() %>" maxlength="4" />
                          </div>
                        </div>
	                    <div class="form-row">
	                    	<div class="form-group col-md-3">
                          		<label for="address">수령 주소</label>
                          	</div>
                        </div>
                        <div class="form-row">
	                        <div class="form-group col-md-1">
	                        	<input type="text" class="form-control" name="receiver_pcode" id="sample4_postcode" value="<%= omb.getReceiver_pcode() %>">
	                        </div>
	                        <div class="form-group col-md-1">
							<input type="button" class="form-control" onclick="sample4_execDaumPostcode()" value="주소 변경"><br>
                        	</div>
                        </div>
                        <div class="form-row">
	                        <div class="form-group col-md-4">
								<input type="text" class="form-control" name="receiver_raddr" id="sample4_roadAddress" value="<%= omb.getReceiver_raddr() %>">
								<input type="hidden" class="form-control" name="receiver_jibun" id="sample4_jibunAddress" value="<%= omb.getReceiver_jibun() %>">
								<span id="guide" style="color:#999;display:none;"></span>
							</div>
							<div class="form-group col-md-4">
								<input type="text" class="form-control" name="receiver_detailaddr" id="sample4_detailAddress" value="<%= omb.getReceiver_detailaddr() %>">
								<input type="hidden" id="sample4_extraAddress" placeholder="참고항목">
							</div>
						</div>
						
                        <div style="text-align:center;">
	                        <input type="button" class="btn btn-primary" value="목록" onclick="history.go(-1)" />
	                        <input type="reset" class="btn btn-primary">
	                        <input type="button" class="btn btn-primary" value="수정" onclick="check()" />
                        </div>
                      </form>
                    </div> <!-- /. card-body -->
                  </div> <!-- /. card -->
                </div> <!-- /. col -->
              </div> <!-- /. end-section -->
            </div> <!-- .col-12 -->
          </div> <!-- .row -->
        </div> <!-- .container-fluid -->
    </div> <!-- .wrapper -->
	<script src="../js/jquery.min.js"></script>
	<script type="text/javascript" src="../js/admin.js" charset="UTF-8"></script>
    <script type="text/javascript">
		/*주문 수정 페이지에서 넘겨 받은 주문 상태가 기본으로 선택되게 하는 스크립트(Jquery 필요)*/
		$(function(){
			$("#status > option[value='<%= o_dStat %>']").prop("selected", true);
		});
		/* 변수를 받아야해서 스크립트 파일에 넣지 못함 */
	</script>
	<script type="text/javascript"> 
		$("#shipment").on("change keyup paste", function(){
			$(function(){
				$("#status > option[value='배송중']").prop("selected", true);
			});
		})
		//운송장 번호가 입력되면 주문 상태가 배송중으로 변경
	</script>
  </body>
</html>