<%@page import="semiProject.uploadProduct.ProductDBBean"%>
<%@page import="semiProject.uploadProduct.ProductBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	int product_number = 0;
	String pageNum = request.getParameter("pageNum");
	String product_name = "";
	
	if(request.getParameter("product_number") != null) {
		product_number = Integer.parseInt(request.getParameter("product_number"));
	}
	
	ProductDBBean updb = ProductDBBean.getInstance();
	ProductBean upbd = updb.getproduct(product_number, false);
	
	if(upbd != null) {
		product_name = upbd.getProduct_name();
	}
%>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script language="JavaScript" src="uploadProduct.js" charset="utf-8"></script>
<style type="text/css">
	header ul li{
		text-decoration: none;
	}
</style>
</head>
<body>
	<header>
		<ul class="headMenu">
			<li><a href="mainPage.jsp">Home</a></li>
			<li><a href="myPage.jsp">MY PAGE</a></li>
			<li><a href="cart.jsp">CART</a></li>
		</ul>
		<center>	
			<div class="pageTitle">
				<h1>상품 등록</h1>
			</div>
		<center>
	</header>
	<div class="container">
		<center>
			<table>
				<form name="up_prodc" action="uploadProduct_ok.jsp" method="post" enctype="multipart/form-data">
					<input type="hidden" name="product_number" value="<%= product_number %>">
					<tr class="product_img">
						<td>
							상품 이미지 등록
						</td>
						<td>
							<input type="file" name="product_img">
						</td>
					</tr>
					<tr class="product_category">
					<!--  	<label class="gender_label">성별 카테고리</label>&nbsp;
						<select name="category_code_gender" >
						    <option value="none">=== 선택 ===</option>
						    <option value="female">여성 의류</option>
						    <option value="male">남성 의류</option>
						    <option value="unisex">유니 섹스</option>
						    <option value="kids">아동복</option>
						 </select>&nbsp;-->
						<td>
							<label class="dress_label">옷 카테고리</label>
						</td>
						<td>
							<select name="category_code" >
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
							<input type="text" name="product_name">
						</td>
					</tr>
					<br>
					<tr class="product_price">
						<td>
							<label class="product_price_label">상품 가격</label>&nbsp;
						</td>
						<td>
							<input type="number" name="product_price"> 원
						</td>
					</tr>
					<br>
					<tr class="product_stock">
						<td>
							<label class="product_stock">재고 수량</label>&nbsp;
						</td>
						<td>
							<input type="number" name="product_stock"> 개 남았습니다.
						</td>
					</tr>
					<br>
					<tr class="product_desc">
						<td>
							<label class="product_desc_label">상품 설명</label>&nbsp;
						</td>
						<td>
						<textarea rows="2" cols="60" name="product_desc"></textarea>
						</td>
					</tr>
					<br>
					<tr>
						<td>
							<input type="button" value="상품 등록" onclick="check_ok()">&nbsp;
							<input type="reset" value="다시작성">
							<input type="button" value="등록한 상품 목록" 
							onclick="location.href='myUploadProduct_List.jsp'">
						</td>
					</tr>
				</form>
			</table>
		</center>
	</div>
</body>
</html>