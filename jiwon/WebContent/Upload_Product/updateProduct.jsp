<%@page import="semiProject.uploadProduct.ProductDBBean"%>
<%@page import="semiProject.uploadProduct.ProductBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	String pageNum = request.getParameter("pageNum");
	int product_number = Integer.parseInt(request.getParameter("product_number"));
	ProductDBBean updb = ProductDBBean.getInstance();
	ProductBean upbd = updb.getproduct(product_number, false);
	
	System.out.println("넘버어어어어어어어어어어어어"+product_number);
	
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script language="JavaScript" src="uploadProduct.js" charset="utf-8"></script>
</head>
<body>
	<center>
		<form name="up_prodc" method="post"
			 action="updateProduct_ok.jsp?product_number=<%=product_number %>&pageNum=<%=pageNum%>">
			<table>
				<tr class="product_img">
					<td>상품 이미지 등록</td>
					<td>
						<input type="file" name="product_img">
					</td>
				</tr>
				<tr class="product_category">
					<td>
						<label class="dress_label">옷 카테고리</label>
					</td>
					<td>
						<select name="category_code">
						    <option value="none">=== 선택 ===</option>
						    <option value="t-shirt">티셔츠</option>
						    <option value="hude-t">후드티</option>
						    <option value="nite">니트/스웨터</option>
						    <option value="shirt">셔츠/남방</option>
						    <option value="pants">바지</option>
						    <option value="blue-jeans">청바지</option>
						 </select>
					 </td>
				</tr>
				<br>
				<tr class="product_name">
					<td>
						<label class="product_name_label">상품 이름 </label>&nbsp;
					</td>
					<td>
						<input type="text" name="product_name" value="<%=upbd.getProduct_name()%>">
					</td>
				</tr>
				<br>
				<tr class="product_price">
					<td>
						<label class="product_price_label">상품 가격</label>&nbsp;
					</td>
					<td>
						<input type="number" name="product_price" value="<%=upbd.getProduct_price() %>"> 원
					</td>
				</tr>
				<br>
				<tr class="product_stock">
					<td>
						<label class="product_stock">재고 수량</label>&nbsp;
					</td>
					<td>
						<input type="number" name="product_stock" value="<%=upbd.getProduct_stock() %>"> 개 남았습니다.
					</td>
				</tr>
				<br>
				<tr class="product_desc">
					<td>
						<label class="product_desc_label">상품 설명</label>&nbsp;
					</td>
					<td>
					<textarea rows="2" cols="60" name="product_desc" value="<%=upbd.getProduct_desc() %>"></textarea>
					</td>
				</tr>
				<br>
				<tr>
					<td>
						<input type="button" value="상품 등록" onclick="check_ok()">&nbsp;
						<input type="reset" value="다시작성">
						<input type="button" value="등록한 상품 목록" 
						onclick="location.href='myUploadProduct_List.jsp?pageNum=<%= pageNum %>">
					</td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>