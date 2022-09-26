<%@page import="product.ProductBean"%>
<%@page import="product.ProductDBBean"%>
<%@page import="member.LikeDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String id = (String)session.getAttribute("id");
	int product_number = Integer.parseInt(request.getParameter("product_number"));
	
	ProductDBBean product_db = ProductDBBean.getInstance();
	ProductBean product_bd = product_db.getproduct(product_number, false);
	
	String product_name = product_bd.getProduct_name();
	int product_price = product_bd.getProduct_price();
	int product_file_num = product_bd.getFile_number();
	LikeDBBean like = LikeDBBean.getInstance();
	
	
	if(id != null){
	int likecheck = like.likeCheck(id, product_number);
		if(likecheck == -1){
			like.deleteLike(id, product_number);
%>
		<script>
				alert("like를 삭제합니다.")
		</script>
<%
		}else{
			like.updateLike(id, product_number, product_name, product_price, product_file_num);
%>
		<script>
				alert("like를 등록합니다.")
		</script>
<%			
		}
	}else{
%>
		<script>
				alert("회원이 아닙니다.")
				response.sendRedirect("login.jsp")
		</script>
<%
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
</body>
</html>