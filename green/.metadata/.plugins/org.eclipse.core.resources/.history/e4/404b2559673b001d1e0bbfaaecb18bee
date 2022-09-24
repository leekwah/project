<%@page import="product.ProductDBBean"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean class="product.ProductBean" id="product"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		ProductDBBean db = ProductDBBean.getInstance();
		
		for(int i=0;i<100;i++){
			product.setProduct_number(i);
			product.setProduct_name("test"+i);
			product.setProduct_price((i%10)*1000);
			product.setCategory_code("testC"+(i%4));
			product.setProduct_stock((i%5)*10);
			product.setProduct_date(new Timestamp(System.currentTimeMillis()));
			
			db.insertUploadProduct(product);
		}
	%>
</body>
</html>