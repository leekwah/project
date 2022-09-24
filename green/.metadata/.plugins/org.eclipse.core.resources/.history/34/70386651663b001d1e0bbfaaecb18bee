<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="order.OrderManageBean"%>
<%@page import="order.OrderManageDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.1.min.js" charset="UTF-8"></script>
<script type="text/javascript" src="admin.js" charset="UTF-8"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>
<body>
<%
	OrderManageDBBean omdb = OrderManageDBBean.getInstance();
	OrderManageBean omb = omdb.getBoard(Integer.parseInt(request.getParameter("o_dNum")));
	String pageNum = request.getParameter("pageNum");
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	String o_dStat = omb.getOrder_detail_status();
	int ori_count = omb.getProduct_count();
	int p_price = omb.getProduct_price();
	int ori_price = (p_price/ori_count);
%>
<script type="text/javascript">
/*주문 수정 페이지에서 넘겨 받은 주문 상태가 기본으로 선택되게 하는 스크립트(Jquery 필요)*/
$(function(){
	$("#status > option[value='<%= o_dStat %>']").prop("selected", true);
});
/* 변수를 받아야해서 스크립트 파일에 넣지 못함 */
</script>
	<center>
		<h1>주 문 서 수 정</h1>
		<form action="orderEdit_ok.jsp?pageNum=<%= pageNum %>" method="post" name="order_frm">
		<table border="1" cellspacing="0">
			<tr>
				<td>주문 일자</td>
				<td><%= sdf.format(omb.getOrder_date()) %></td>
				<td>주문 번호</td>
				<td><input type="text" name="order_number" value="<%= omb.getOrder_number() %>" readonly /></td>
				<td>주문 상태</td>
				<td>
					<select id="status" name="order_detail_status">
                        <option value="입금 완료">입금 완료</option>
                        <option value="배송 준비">배송 준비</option>
                        <option value="배송중">배송중</option>
                        <option value="배송 완료">배송 완료</option>
                        <option value="구매 확정">구매 확정</option>
                    </select>
                </td>
			</tr>
			<tr>
				<td>주문자 아이디</td>
				<td><%= omb.getUser_id() %></td>
				<td>수령자명</td>
				<td>
					<input type="text" name="receiver_name" value="<%= omb.getReceiver_name() %>" /> 
				</td>
				<td>수령자 전화번호</td>
				<td>
					 <select id="phone" name="receiver_phone1">
                        <option value="010">010</option>
                        <option value="011">011</option>
                        <option value="016">016</option>
                        <option value="017">017</option>
                        <option value="019">019</option>
                        <option value="019">02</option>
                        <option value="031">031</option>
                        <option value="051">051</option>
                    </select>-
					<input type="number" name="receiver_phone2" value="<%= omb.getReceiver_phone2() %>" maxlength="4" /> -
					<input type="number" name="receiver_phone3" value="<%= omb.getReceiver_phone3() %>" maxlength="4" /> 
				</td>
			<tr>
				<td>수령자 주소</td>
				<td colspan="5">
					<input type="text" name="receiver_pcode" id="sample4_postcode" value="<%= omb.getReceiver_pcode() %>">
					<input type="button" onclick="sample4_execDaumPostcode()" value="주소 변경"><br>
					<input type="text" type="text" name="receiver_raddr" id="sample4_roadAddress" value="<%= omb.getReceiver_raddr() %>">
					<input type="hidden" name="receiver_jibun" id="sample4_jibunAddress" value="<%= omb.getReceiver_jibun() %>">
					<span id="guide" style="color:#999;display:none"></span>
					<input type="text" name="receiver_detailaddr" id="sample4_detailAddress" value="<%= omb.getReceiver_detailaddr() %>">
					<input type="hidden" id="sample4_extraAddress" placeholder="참고항목">
				</td>
			</tr>
			<tr>
				<td>상품 번호</td>
				<td><%= omb.getProduct_number() %></td>
				<td>상품 수량</td>
				<td>
					<input type="number" id="count" name="product_count" min="1" max="10" value="<%= ori_count %>" onkeyup="priceCal()" />
				</td>
				<td>상품 가격</td>
				<td>
					<input type="text" id="price" name="product_price" value="<%= p_price %>" readonly />
				</td>
			</tr>
			<tr>
				<input type="hidden" id="ori_count" name="ori_count" value="<%= ori_count %>" />
				<input type="hidden" id="p_price" name="p_price" value="<%= p_price %>" />
			</tr>
			<tr>
				<td colspan="6">
					<input type="button" value="주문 수정" onclick="check()" />
					&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="reset" value="다시 작성" />
					&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="button" value="주문 목록" onclick="history.go(-1)" />
				</td>
			</tr>
		</table>
		</form>
	</center>
	
</body>
</html>