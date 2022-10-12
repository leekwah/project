<%@page import="product.ProductBean"%>
<%@page import="product.ProductDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	int product_number = 0;
	String pageNum = request.getParameter("pageNum");
	String product_name = "";
	
	if (request.getParameter("product_number") != null) {
		product_number = Integer.parseInt(request.getParameter("product_number"));
	}
	
	ProductDBBean updb = ProductDBBean.getInstance();
	ProductBean upbd = updb.getproduct(product_number, false);
	
	if (upbd != null) {
		product_name = upbd.getProduct_name();
	}
%>
<html lang="ko">
<head>
<meta charset="utf-8">
<title></title>
<script language="JavaScript" src="../js/uploadProduct.js?112" charset="utf-8"></script>
</head>
<body class="vertical  dark  ">
	<div class="wrapper">
		<form method="post" name="reg_frm" action="adminIndex.jsp?pages=productReg_ok" enctype="multipart/form-data">
	        <div class="container-fluid">
	          <div class="row justify-content-center">
	            <div class="col-12">
	              <h2 class="h3 mb-3 page-title">상품등록</h2>
	                <div class="card shadow">
	                	<div class="card-body">
	                  <div class="row">
	                      <div class="col-md-12">
	                        <div class="form-group mb-3">
	                            <label for="custom-select">상품 카테고리</label>
	                            <select class="custom-select" id="custom-select" name="category_code">
	                            <option selected value="none">카테고리를 선택하세요</option>
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
	                        <input type="text" id="productName" name="product_name" class="form-control" />
	                      </div>
	                      <div class="form-group mb-3">
	                        <label for="productPrice">상품 가격(원)</label>
	                        <input type="number" id="productPrice" name="product_price" class="form-control" />
	                      </div>
	                      <div class="form-group mb-3">
	                        <label for="productStock">재고 수량(개)</label>
	                        <input type="number" id="productStock" name="product_stock" class="form-control" />
	                      </div>
	                      <div class="form-group mb-3">
	                       <label for="content">상품 상세 설명</label>
	                 		<div id="editor" style="min-height:500px;" contenteditable="true">
	                 		</div>
	                  		<input type="hidden" value="" name="product_desc" id="content">
	                      </div>
	                      <div class="form-group mb-3">
	                      <label for="fileinput">이미지</label>
	                      <!-- <input type="file" id="example-fileinput" class="form-control-file" name="product_img" onchange="setThumbnail(event);" />
							<div id="image_container" style="width: 150px; height: 150px;"></div>
	                      </div> -->
	                        <!-- 첨부파일(이미지파일만 업로드가능) -->
							<input type="file" id="fileinput" name="product_img" accept="image/*">
							
							<!-- 이미지 미리보기 영역 -->
							<div id="imgViewArea" style="margin-top:10px; display:none;">
								<img id="imgArea" style="width:200px; height:200px;" onerror="imgAreaError()"/>
							</div>
	                      <div style="text-align:center;">
	                      <input type="button" class="btn mb-2 btn-primary" value="목록" onclick="location.href='adminIndex.jsp?pages=productList'" />
	                      <input type="reset" class="btn mb-2 btn-primary" value="다시 작성" />
	                      <input type="button" class="btn mb-2 btn-primary" value="등록" onclick="check_ok()" />
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