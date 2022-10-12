<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="product.ProductBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="product.ProductDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String pageNum = request.getParameter("pageNum");//페이지 넘버 가져오기

	if (pageNum == null) {
		pageNum = "1";
	}
	ProductDBBean updb = ProductDBBean.getInstance();
	
	ArrayList<ProductBean> productList = updb.productList(pageNum);
	
	int product_number = 0, product_price = 0, product_stock = 0;
	String product_name = "", category_code = "";
	Timestamp create_date = null;
	String stored_file_name = "";//이미지 파일 호출을위한 변수
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	String path = request.getSession().getServletContext().getRealPath("\\img");
%>
<!doctype html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>Product</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<link href="https://fonts.googleapis.com/css2?family=Overpass:ital,wght@0,100;0,200;0,300;0,400;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">
<link rel="stylesheet" href="../css/simplebar.css">
<link rel="stylesheet" href="../css/feather.css">
<link rel="stylesheet" href="../css/select2.css">
<link rel="stylesheet" href="../css/dropzone.css">
<link rel="stylesheet" href="../css/uppy.min.css">
<link rel="stylesheet" href="../css/jquery.steps.css">
<link rel="stylesheet" href="../css/jquery.timepicker.css">
<link rel="stylesheet" href="../css/quill.snow.css">
<link rel="stylesheet" href="../css/daterangepicker.css">
<link rel="stylesheet" href="../css/app-light.css" id="lightTheme">
<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
<script>
        function show_product(){
            if($('.product_sub').css('display') == 'none'){
            $('.product_sub').show();
            } else {
                $('.product_sub').hide();
            }
        }
        
        //최상단 체크박스 클릭시 상품목록 전체클릭.
        $(document).ready(function() {
        	$(".cbx_chkAll").click(function() {
        		if($(".cbx_chkAll").is(":checked")) $("input[name=chk]").prop("checked", true);
        		else $("input[name=chk]").prop("checked", false);
        	});

        	$("input[name=chk]").click(function() {
        		var total = $("input[name=chk]").length;
        		var checked = $("input[name=chk]:checked").length;

        		if(total != checked) $(".cbx_chkAll").prop("checked", false);
        		else $(".cbx_chkAll").prop("checked", true); 
        	});
        });
</script>
    
</head>
<body class="vertical  light  ">
	<div class="wrapper">
			<div class="container-fluid">
				<div class="row justify-content-center">
					<div class="col-12">
						<!-- table -->
						<div class="card shadow">
							<div class="card-body">
								<table class="table table-borderless table-hover">
									<thead>
										<tr>
											<th>
												<div class="custom-control custom-checkbox">
													<input type="checkbox" class="custom-control-input cbx_chkAll" id="all2"> <label class="custom-control-label" for="all2">NO</label>
												</div>
											</th>
											<th>상품명</th>
											<th>판매가</th>
											<th>카테고리</th>
											<th>재고</th>
											<th>등록일</th>
											<th>수정</th>
											<th>삭제</th>
										</tr>
									</thead>
									<tbody>
										<%
											for (int i = 0; i < productList.size(); i++) {
											ProductBean upbd = productList.get(i);

											product_number = upbd.getProduct_number();
											product_name = upbd.getProduct_name();
											product_price = upbd.getProduct_price();
											category_code = upbd.getCategory_code();
											product_stock = upbd.getProduct_stock();
											stored_file_name = updb.getImg(product_number).getStored_file_name();
											create_date = updb.getImg(product_number).getCreate_date();
										%>
										<tr>
											<td><input type="checkbox" class="check" name="chk">NO.<%=product_number%></td>
											<td><img style="width: 100px" height="100px" src="${pageContext.request.contextPath}/img/<%=stored_file_name%>"><br>상품명:<%=product_name%></td>
											<td><%=product_price%>원</td>
											<td><%=category_code%></td>
											<td><%=product_stock%>개</td>
											<td><%=sdf.format(create_date)%></td>
											<td><input type="button" value="수정" onclick="location.href='adminIndex.jsp?pages=../product/editProduct&product_number=<%=product_number%>&pageNum=<%=pageNum%>'"></td>
											<td><input type="button" value="삭제" onclick="location.href='adminIndex.jsp?pages=../product/deleteProduct_ok&product_number=<%=product_number%>&pageNum=<%=pageNum%>'"></td>
										</tr>
										<%
											}
										%>
									</tbody>
								</table>
							</div>
						</div>
						<nav aria-label="Table Paging" class="my-3">
							<ul class="pagination justify-content-end mb-0">
								<li class="page-item"><a class="page-link" href="#">Previous</a></li>
								<li class="page-item active"><a class="page-link" href="#">1</a></li>
								<li class="page-item"><a class="page-link" href="#">2</a></li>
								<li class="page-item"><a class="page-link" href="#">3</a></li>
								<li class="page-item"><a class="page-link" href="#">Next</a></li>
							</ul>
						</nav>
					</div>
					<!-- .col-12 -->
				</div>
				<!-- .row -->
			</div>
			<!-- .container-fluid -->
					</div>
				</div>
			</div>
			<div class="modal fade modal-shortcut modal-slide" tabindex="-1" role="dialog" aria-labelledby="defaultModalLabel" aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="defaultModalLabel">Shortcuts</h5>
							<button type="button" class="close" data-dismiss="modal" aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body px-5">
							<div class="row align-items-center">
								<div class="col-6 text-center">
									<div class="squircle bg-success justify-content-center">
										<i class="fe fe-cpu fe-32 align-self-center text-white"></i>
									</div>
									<p>Control area</p>
								</div>
								<div class="col-6 text-center">
									<div class="squircle bg-primary justify-content-center">
										<i class="fe fe-activity fe-32 align-self-center text-white"></i>
									</div>
									<p>Activity</p>
								</div>
							</div>
							<div class="row align-items-center">
								<div class="col-6 text-center">
									<div class="squircle bg-primary justify-content-center">
										<i class="fe fe-droplet fe-32 align-self-center text-white"></i>
									</div>
									<p>Droplet</p>
								</div>
								<div class="col-6 text-center">
									<div class="squircle bg-primary justify-content-center">
										<i class="fe fe-upload-cloud fe-32 align-self-center text-white"></i>
									</div>
									<p>Upload</p>
								</div>
							</div>
							<div class="row align-items-center">
								<div class="col-6 text-center">
									<div class="squircle bg-primary justify-content-center">
										<i class="fe fe-users fe-32 align-self-center text-white"></i>
									</div>
									<p>Users</p>
								</div>
								<div class="col-6 text-center">
									<div class="squircle bg-primary justify-content-center">
										<i class="fe fe-settings fe-32 align-self-center text-white"></i>
									</div>
									<p>Settings</p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		<!-- main -->
	</div>
	<!-- .wrapper -->
	<script src="../js/popper.min.js"></script>
    <script src="../js/moment.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    <script src="../js/simplebar.min.js"></script>
    <script src='../js/daterangepicker.js'></script>
    <script src='../js/jquery.stickOnScroll.js'></script>
    <script src="../js/tinycolor-min.js"></script>
    <script src="../js/config.js"></script>
    <script src="../js/d3.min.js"></script>
    <script src="../js/topojson.min.js"></script>
    <script src="../js/datamaps.all.min.js"></script>
    <script src="../js/datamaps-zoomto.js"></script>
    <script src="../js/datamaps.custom.js"></script>
    <script src="../js/Chart.min.js"></script>
    <script>
      /* defind global options */
      Chart.defaults.global.defaultFontFamily = base.defaultFontFamily;
      Chart.defaults.global.defaultFontColor = colors.mutedColor;
    </script>
    <script src="../js/gauge.min.js"></script>
    <script src="../js/jquery.sparkline.min.js"></script>
    <script src="../js/apexcharts.min.js"></script>
    <script src="../js/apexcharts.custom.js"></script>
    <script src='../js/jquery.mask.min.js'></script>
    <script src='../js/select2.min.js'></script>
    <script src='../js/jquery.steps.min.js'></script>
    <script src='../js/jquery.validate.min.js'></script>
    <script src='../js/jquery.timepicker.js'></script>
    <script src='../js/dropzone.min.js'></script>
    <script src='../js/uppy.min.js'></script>
    <script src='../js/quill.min.js'></script>
	<!-- Global site tag (gtag.js) - Google Analytics -->
	<script async src="https://www.googletagmanager.com/gtag/js?id=UA-56159088-1"></script>
	<script>
		window.dataLayer = window.dataLayer || [];

		function gtag() {
			dataLayer.push(arguments);
		}
		gtag('js', new Date());
		gtag('config', 'UA-56159088-1');
		
	</script>
</body>
</html>