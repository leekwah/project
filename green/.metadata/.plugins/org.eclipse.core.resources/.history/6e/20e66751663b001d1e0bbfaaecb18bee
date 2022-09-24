<%@page import="java.util.ArrayList"%>
<%@page import="order.OrderManageBean"%>
<%@page import="order.OrderManageDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String pageChange = request.getParameter("page");
	if(pageChange == null){
		pageChange = "admin_body.jsp";
	}

	OrderManageDBBean omdb = OrderManageDBBean.getInstance();
	
	int o_rank = 0;
	int o_dNum, p_num, p_count, p_price;
	String o_num, o_dStat, refund;
	
	// 페이징 처리
	int pageSize = 10; // 한페이지에 보여질 글 수
	int count = omdb.getCount(new OrderManageBean()); // 전체 글 수
	// 현재 페이지 정보 설정
	String pageNum = request.getParameter("pageNum");
	if(pageNum == null){
		pageNum = "1";
	} 
	// 첫 행번호 계산
	int currentPage = Integer.parseInt(pageNum);
	int startRow = (currentPage-1)*pageSize+ 1; // 2페이지면 11~20
	ArrayList<OrderManageBean> list = omdb.orderList(startRow,pageSize,"N");
	
	int pageCount=1, pageBlock=5, startPage=1, endPage=1; // pageBlock: 한 페이지에 보여줄 페이지 블럭
	if(count != 0) {
		pageCount = (int)Math.ceil((double)count / pageSize); // 전체 페이지 수
		startPage = ((currentPage-1)/pageBlock)*pageBlock+1; // 페이지 블럭 시작 번호
		endPage = startPage + pageBlock -1; // 페이지 블럭 끝 번호
		if(endPage > pageCount){
			endPage = pageCount;
		} // 전체 페이지가 10페이지인데 마지막 페이지가 11이면 안되므로 조건문 설정
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h1>주문 관리</h1>
		<form action="?page=orderEdit.jsp&pageNum=<%= pageNum %>" method="post">
		<table border="1">
			<tr>
				<td>주문 순서</td> <!-- 주문일자 순으로 Rank() -->
				<td>주문 번호</td>
				<td>제품 번호</td>
				<td>수량</td>
				<td>금액</td>
				<td>주문 상태</td>
				<td>주문 수정</td> <!-- 라디오 버튼  > 수정 버튼 > 정보 수정, 환불 처리 -->
			</tr>
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
			
	%>
			<tr height="25" bgcolor="#E8E8E8" onmouseover="this.style.backgroundColor='#AEBAB4'"
			onmouseout="this.style.backgroundColor='#E8E8E8'">
				<td align="center"><%=o_rank%></td>
				<td align="center"><%=o_num%></td>
				<td align="center">
					<a href="#"><%=p_num%></a>
				</td>
				<td align="center"><%= p_count %></td>
				<td align="center"><%=p_price%></td>
				<td align="center">
					<input type="text" name="o_dstat" value="<%=o_dStat%>" readonly />
				</td>
				<td>
					<input type="radio" name="o_dNum" value="<%= o_dNum %>" />
				</td> <!-- 라디오 버튼  > 수정 버튼 > 정보 수정, 환불 처리 -->
	<%			
		}
	%>
			</tr>
		</table>	
		<input type="submit" value="주문 수정">
		</form>
		<div>
		<%
			if(startPage > pageBlock) {
		%>
				<a href="?page=orderList.jsp&pageNum=<%= startPage-pageBlock %>">이전</a>
		<%
			}
		%>
		<%
			for(int i = startPage; i<= endPage; i++){
		%>
				<a href="?page=orderList.jsp&pageNum=<%= i %>"><%= i %></a>
		<%	
			}
		%>
		<%
			if(startPage+pageBlock <= pageCount) {
		%>
				<a href="?page=orderList.jsp&pageNum=<%= startPage+pageBlock %>">다음</a>
		<%
			}
		%>
		</div>
	</center>
</body>
</html>