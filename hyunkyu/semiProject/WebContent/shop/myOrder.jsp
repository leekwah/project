<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String pageNum = request.getParameter("pageNum");
	if(pageNum == null){
		pageNum = "1";
	}
	
	GoodsDBBean db = GoodsDBBean.getInstance();
	ArrayList<GoodsBean> orderList = db.listOrder(pageNum);
	
	count포함하여 총 8가지 변수 선언
%>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table align="center" width="1250">
		<tr>
			<td>주문조회<hr></td>
		</tr>
		<tr>
			<td><a href="#">주문내역조회(0)</a> | <a href="#">취소/반품/교환 내역(0)</a><hr></td>
			<!-- 0 부분에 상품개수 (count?) 받아와야함 -->
		</tr>
		<tr>
			<td>주문 상품 정보</td>
		</tr>
	</table>
	<table border="1" align="center">
		<tr height="60" align="center">
			<td width="150">주문일자<br>[주문번호]</td>
			<td width="150">이미지</td>
			<td width="500">상품정보</td>
			<td width="50">수량</td>
			<td width="100">상품구매금액</td>
			<td width="100">주문처리상태</td>
			<td width="150">취소/교환/반품</td>
		</tr>
		<%
//			데이터베이스에 있는 데이터 가져오기
			for(int i=0; i<주문리스트.size(); i++){
//				예를들어서 진행---------------------------------------------------
				OrderBean order = orderList.get(i);
				order_number = order.getOrder_number();
				... 7가지 전부
		%>
				<tr height="150" align="center">
					<td><%= order_number %>변수불러오기</td>
					<td>변수불러오기</td>
					<td>변수불러오기</td>
					<td>변수불러오기</td>
					<td>변수불러오기</td>
					<td>변수불러오기</td>
					<td>변수불러오기</td>
				</tr>
		<%
			}
		%>
	</table>
</body>
</html>