<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="product.ProductBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="product.ProductDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean class="product.ProductBean" id="product"></jsp:useBean>
<%
	String pageNumber="";

	if(request.getParameter("pageNum")!=null){
		pageNumber=request.getParameter("pageNum");
	}else{
		pageNumber="1";
		response.sendRedirect("adminIndex.jsp?pages=productList&pageNum=1");
	}
	ProductDBBean db = ProductDBBean.getInstance();
	
	ArrayList<ProductBean> productList = db.productList(pageNumber);
	
	SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <script type="text/javascript" src="../js/admin.js"></script>
</head>
<body class="vertical  dark  ">
    <div class="wrapper">
        <div class="container-fluid">
          <div class="row justify-content-center">
            <div class="col-12">
              <div class="row">
                <!-- Small table -->
                <div class="col-md-12 my-4">
                  <h2 class="h3 mb-3 page-title">상품 정보 조회</h2>
                  <div class="card shadow">
                    <div class="card-body">
                      <!-- table -->
                      <div style="text-align: center;">
                      <table class="table table-borderless table-hover">
                        <thead>
                          <tr>
                            <th>상품 번호</th>
							<th>분류</th>
							<th>상품명</th>
							<th>가격</th>
							<th>재고량</th>
							<th>제품 등록(수정)일</th>
                            <th>Action</th>
                          </tr>
                        </thead>
  <%
		for(int i=0;i<productList.size();i++){
			product = productList.get(i);
			
			int product_number = product.getProduct_number();
			String product_name = product.getProduct_name();
			int product_price = product.getProduct_price();
			String category_code = product.getCategory_code();
			int product_stock = product.getProduct_stock();
			Timestamp product_date = product.getProduct_date();
			int product_fileNumber;
			String thumbName ="";
			product = db.getImg(product_number);
			if(product.getStored_thumbnail() != ""){
				thumbName = product.getStored_thumbnail();
			}
	%>
                        <tbody>
                        <tr>
							<td class="mb-0 text-muted"><%= product_number %></td>
							<td class="mb-0 text-muted"><%= category_code %></td>
							<td class="mb-0 text-muted">
								<%
									if(thumbName==null){
								%>
										<div style="background-color: #777">이미지 없음</div>
								<%
									} else{
								%>
										<div>
											<!-- <img src="http://localhost:8181/semiProject/upload/test.jpg" width="100px"> -->
											<img src="../img/<%= thumbName %>" width="100px">
								<%
									}
								%>
											<%= product_name %>
										</div>
							</td>
							<td class="mb-0 text-muted"><%= product_price %></td>
							<td class="mb-0 text-muted"><%= product_stock %></td>
							<td class="mb-0 text-muted"><%= sdf.format(product_date) %></td>
							<td class="mb-0 text-muted">
                              <div class="dropdown">
                                <button class="btn btn-sm dropdown-toggle" type="button" id="dr1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                  <span class="text-muted sr-only">Action</span>
                                </button>
                                <div class="dropdown-menu dropdown-menu-right" aria-labelledby="dr1">
                                  <a class="dropdown-item" href="adminIndex.jsp?pages=productEdit&product_number=<%= product_number %>&pageNum=<%= pageNumber %>">수정</a>
                                  <a class="dropdown-item" href="#" onclick="delCheck()">삭제</a>
                                  <input class="btn mb-2" type="hidden" id="delete" value="product_delete_ok.jsp?product_number=<%= product_number %>&pageNum=<%= pageNumber %>" />
                                </div>
                              </div>
                            </td>
						</tr>
	<%	
		}
	%>
					</tbody>
	 			</table>
			    <nav aria-label="Table Paging" class="mb-0 text-muted">
			      	<ul class="pagination justify-content-center mb-0">
						<%= ProductBean.pageNumber(5, "adminIndex") %>
					</ul>
			    </nav>
        	</div>
      	</div>
    </div>
</body>
</html>