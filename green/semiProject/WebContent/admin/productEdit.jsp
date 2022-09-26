<%@page import="java.sql.Timestamp"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="product.ProductBean"%>
<%@page import="product.ProductDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	int product_number = 0;
	String pageNum = request.getParameter("pageNum");
	
	SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm");
	product_number = Integer.parseInt(request.getParameter("product_number"));
	ProductDBBean db = ProductDBBean.getInstance();
	ProductBean product = db.getproduct(product_number, false);

	String product_name = product.getProduct_name();
	int product_price = product.getProduct_price();
	String category_code = product.getCategory_code();
	int product_stock = product.getProduct_stock();
	String product_desc = product.getProduct_desc();
	Timestamp product_date = product.getProduct_date();
	String date = sdf.format(product_date);
	ProductBean productImg = db.getImg(product_number);
	String product_img = productImg.getStored_thumbnail();
	
	System.out.println("==========>"+category_code);
%>
<html lang="ko">
<head>
<meta charset="utf-8">
<title></title>
<script language="JavaScript" src="../js/uploadProduct.js?123" charset="utf-8"></script>
</head>
<body class="vertical  dark  ">
	<div class="wrapper">
		<form method="post" name="reg_frm" action="productEdit_ok.jsp?productNum=<%= product_number %>&pageNum=<%= pageNum %>" enctype="multipart/form-data">
	        <div class="container-fluid">
	          <div class="row justify-content-center">
	            <div class="col-12">
	              <h2 class="h3 mb-3 page-title">상품 수정</h2>
	                <div class="card shadow">
	                	<div class="card-body">
	                  <div class="row">
	                      <div class="col-md-12">
	                        <div class="form-group mb-3">
	                            <label for="custom-select">상품 카테고리</label>
	                            <select class="custom-select" id="custom-select" name="category_code">
	                            <option value="t-shirt">티셔츠</option>
	                            <option value="hude-t">후드티</option>
	                            <option value="nite">니트/스웨터</option>
	                            <option value="shirt">셔츠/남방</option>
	                            <option value="pants">바지</option>
	                            <option value="blue-jeans">청바지</option>
	                            </select>
	                          </div>
	                      <div class="form-group mb-3">
	                        <label for="productName">상품명</label>
	                        <input type="text" id="productName" name="product_name" class="form-control" value="<%= product_name %>" />
	                      </div>
	                      <div class="form-group mb-3">
	                        <label for="productPrice">상품 가격(원)</label>
	                        <input type="number" id="productPrice" name="product_price" class="form-control" value="<%= product_price %>" />
	                      </div>
	                      <div class="form-group mb-3">
	                        <label for="productStock">재고 수량(개)</label>
	                        <input type="number" id="productStock" name="product_stock" class="form-control" value="<%= product_stock %>" />
	                      </div>
	                      <div class="form-group mb-3">
	                        <label for="productStock">상품 등록일</label>
	                        <input type="text" id="regDate" name="product_regDate" class="form-control" value="<%= date %>" />
	                      </div>
	                      <div class="form-group mb-3">
	                       <label for="content">상품 상세 설명</label>
	                 		<div id="editor" style="min-height:500px;" contenteditable="true">
	                 			<%= product_desc %>
	                 		</div>
	                  		<input type="hidden" value="" name="product_desc" id="content">
	                      </div>
	                      <div class="form-group mb-3">
	                      	<label for="fileinput">기존 이미지</label>
							<img src="../img/<%= product_img  %>" alt="이미지 없음" style="width:200px; height:200px;" />
	                      </div>
	                      <div class="form-group mb-3">
	                      	<label for="fileinput">이미지</label>
	                        <!-- 첨부파일(이미지파일만 업로드가능) -->
							<input type="file" id="fileinput" name="product_img" accept="image/*">
							
							<!-- 이미지 미리보기 영역 -->
							<div id="imgViewArea" style="margin-top:10px; display:none;">
								<img id="imgArea" style="width:200px; height:200px;" onerror="imgAreaError()"/>
							</div>
	                      <div style="text-align:center;">
	                      <input type="button" class="btn mb-2 btn-primary" value="목록" onclick="location.href='adminIndex.jsp?pages=productList'" />
	                      <input type="reset" class="btn mb-2 btn-primary" value="다시 작성" />
	                      <input type="button" class="btn mb-2 btn-primary" value="수정" onclick="check_ok()" />
	                      </div>
	                    </div> <!-- /.col -->
	               		 </div> <!-- row /.col -->
	               		 </div> <!-- card -->
	             	 </div> <!-- end section -->
	           	 </div> <!-- .col-12 -->
	          	</div> <!-- .row -->
	          </div> <!-- .row -->
		</form>
     </div> <!-- .container-fluid -->
    <script src="../js/jquery.min.js"></script>
   <script type="text/javascript">
		$(function(){
			$("#custom-select > option[value='<%= category_code %>']").prop("selected", true);
		});
	</script>
    <script type="text/javascript">
	// 콘텐츠 수정 :: 사진 수정 시 이미지 미리보기
	function readURL(input) {
		if (input.files && input.files[0]) {
			var reader = new FileReader();
			reader.onload = function(e) {
				$('#imgArea').attr('src', e.target.result); 
			}
			reader.readAsDataURL(input.files[0]);
		}
	}

	$(":input[name='product_img']").change(function() {
		if( $(":input[name='product_img']").val() == '' ) {
			$('#imgArea').attr('src' , '');  
		}
		$('#imgViewArea').css({ 'display' : '' });
		readURL(this);
	});

	// 이미지 에러 시 미리보기영역 미노출
	function imgAreaError(){
		$('#imgViewArea').css({ 'display' : 'none' });
	}
	</script>
</body>
</html>