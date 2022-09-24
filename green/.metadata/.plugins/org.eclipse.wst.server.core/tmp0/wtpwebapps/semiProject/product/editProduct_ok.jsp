<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%@page import="product.ProductDBBean"%>
<!DOCTYPE html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<jsp:useBean id="upbd" class="product.ProductBean"></jsp:useBean>
<jsp:setProperty property="*" name="upbd"/>
<%
	String pageNum = request.getParameter("pageNum");
	
	String pdna = request.getParameter("product_name");
	System.out.println("name=================>>>>>>>>>>>>>>>>>+>+>++>"+pdna);

	ProductDBBean updb = ProductDBBean.getInstance();
	int re = updb.updateProduct(upbd);
	System.out.println("실행시출력");
	System.out.println("re==="+re);
	if(re == 1) {
%>
	<script type="text/javascript">
		alert("수정됐습니다.");
		location.href="adminIndex.jsp?pages=../product/productList&pageNum=<%= pageNum %>";
	</script>
<%		
	}
%>