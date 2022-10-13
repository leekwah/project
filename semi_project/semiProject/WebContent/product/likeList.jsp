<%@page import="product.ProductDBBean"%>
<%@page import="member.LikeBean"%>
<%@page import="member.LikeDBBean"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	
	request.setCharacterEncoding("utf-8");

	String id = "aaaa";
	LikeDBBean db = LikeDBBean.getInstance();
	ArrayList<LikeBean> likeList = db.likeList(id);
	ProductDBBean productdb = ProductDBBean.getInstance();
	
	int i, product_price, product_number, file_number;
	String user_id, product_like, product_name;
%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Tiny Dashboard - A Bootstrap Dashboard Template</title>
  </head>
  <body class="vertical  light  ">
      <div class="container-fluid">
        <div class="row justify-content-center">
          <div class="col-12 col-lg-10">
            <div class="row align-items-center my-4">
            </div>
            <h6 class="mb-3">좋아요</h6>
            <div class="card-deck mb-4">
	      <%
			String stored_file_name;
			System.out.print(likeList.size());
				for(i=0; i<likeList.size(); i++){
					LikeBean like = likeList.get(i);
					
					user_id = like.getUser_id();
					product_number = like.getProduct_number();
					product_like = like.getProduct_like();
					product_name = like.getProduct_name();
					product_price = like.getProduct_price();
					file_number = like.getFile_number();
					
					stored_file_name = productdb.getImg(file_number).getStored_file_name();
			%>
              <div class="card border-0 bg-transparent">
                <img src="${pageContext.request.contextPath}/img/<%= stored_file_name %>" alt="..." class="card-img-top img-fluid rounded"  style="width: 100px" height="100px" >
                <div class="card-body">
                  <h5 class="h6 card-title mb-1">Fusion Backpack</h5>
                  <p class="card-text">
                    <span class="badge badge-light text-muted mr-2">제품명 : </span> <span><%= product_name %></span><br>
                    <span class="badge badge-pill badge-light text-muted">가격 : </span><span><%= product_price %></span><br>
                  </p>
                </div>
              </div> <!-- .card -->
              <%} %>
            </div> <!-- .card-deck -->
          </div>
        </div> <!-- .row -->
      </div> <!-- .container-fluid -->
  </body>
</html>