<%@page import="product.ProductBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="product.ProductDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	ProductDBBean updb = ProductDBBean.getInstance();

	ArrayList<ProductBean> productList = updb.productList("1");
	int product_number[] = new int[productList.size()];
	String product_name[] = new String[productList.size()];
	int product_price[] = new int[productList.size()];
	String stored_file_name[] = new String[productList.size()];
	String product_desc[] = new String[productList.size()];
	for (int i = 0; i < productList.size(); i++) {
		ProductBean upbd = productList.get(i);

	product_number[i] = upbd.getProduct_number();
	product_name[i] = upbd.getProduct_name().toString();
	product_price[i] = upbd.getProduct_price();
	product_desc[i] = updb.getproduct(product_number[i], false).getProduct_desc();
	stored_file_name[i] = updb.getImg(product_number[i]).getStored_file_name();

}
%>
<html>
<head>
<meta charset="UTF-8">
<title>index_body</title>
</head>
<body>
	<div class="container-fluid">
	  <div class="row justify-content-center">
	      <div class="row">
	      	<div class="container-fluid">
          <div class="row justify-content-center">
            <div class="col-12">
            	<div class="products-catagories-area clearfix">
		<div class="amado-pro-catagory clearfix">
			<!-- Single Catagory -->
		<%
			for(int i=0; i < productList.size(); i++) {
		%>
			<div class="single-products-catagory clearfix">
				<a href="main.jsp?pages=../product/product_detail&product_number=<%=product_number[i]%>"><img src="${pageContext.request.contextPath}/img/<%=stored_file_name[i]%>" style="width: 583px; height: 633px"> <!-- Hover Content -->
					<div class="hover-content">
						<div class="line"></div>
						<!-- &#8361; 원 특수문자 표시 -->
						<p>
							&#8361;
							<%=product_price[i]%></p>
						<h4><%=product_name[i]%></h4>
					</div>
				</a>
			</div>
		<%
			}
		%>
		</div>
	</div>
	</div>
	</div>
	        <!-- Striped rows -->
	      </div> <!-- .row-->
	    </div> <!-- .col-12 -->
	  </div> <!-- .row -->
	</div> <!-- .container-fluid -->
</body>
</html>