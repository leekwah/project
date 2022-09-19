<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="semiProject.uploadProduct.ProductBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="semiProject.uploadProduct.ProductDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	String pageNum = request.getParameter("pageNum");//페이지 넘버 가져오기

	if(pageNum == null) {
		pageNum = "1";
	}
	ProductDBBean updb = ProductDBBean.getInstance();
	
	ArrayList<ProductBean> productList = updb.productList(pageNum);
	
	int product_number=0,product_price=0,product_stock=0;
	String product_name="",category_code="";
	Timestamp create_date = null;
	String stored_file_name="";//이미지 파일 호출을위한 변수
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link >
</head>
<body>
	<a href="main.jsp">메인페이지</a>
	<table border="1">
		<tr align="center">
			<td width="80">
				<input type="checkbox" name="all_select">No
			</td>
			<td>상품명</td>
			<td width="80">판매가</td>
			<td width="80">카테고리</td>
			<td width="80">재고</td>
			<td width="80">등록일</td>
		</tr>
		<%
			for(int i = 0; i < productList.size(); i++) {
				ProductBean upbd = productList.get(i);
				
				product_number = upbd.getProduct_number();
				product_name = upbd.getProduct_name();
				product_price = upbd.getProduct_price();
				category_code = upbd.getCategory_code();
				product_stock = upbd.getProduct_stock();
				stored_file_name = updb.getImg(product_number).getStored_file_name();
				create_date = updb.getImg(product_number).getCreate_date();
			}
		%>
		<tr>
			<td align="center">
				<input type="checkbox" name="productNum_select"><%= product_number %>
			</td>
			<td width="200" height="100">
				<img src="C:\jsp_project\semiProject\WebContent\img\<%=stored_file_name%>" style="padding-right: 30px;"><%=product_name %>
			</td>
			<td>
				<%=product_price %>원
			</td>
			<td>
				<%=category_code %>
			</td>
			<td>
				<%=product_stock %>개
			</td>
			<td>
				<%=sdf.format(create_date)%>
			</td>
			<td>
				<input type="button" value="수정" onclick="location.href='updateProduct.jsp?product_number=<%=product_number%>'">
			</td>
		</tr>
	</table>
</body>
</html>