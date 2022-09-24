<%@page import="member.MemberBean"%>
<%@page import="member.MemberDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="favicon.ico">
<title>상품 상세페이지</title>
<!-- Simple bar CSS -->
<link rel="stylesheet" href="../css/simplebar.css">
<!-- Fonts CSS -->
<link href="https://fonts.googleapis.com/css2?family=Overpass:ital,wght@0,100;0,200;0,300;0,400;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">
<!-- Icons CSS -->
<link rel="stylesheet" href="../css/feather.css">
<link rel="stylesheet" href="../css/select2.css">
<link rel="stylesheet" href="../css/dropzone.css">
<link rel="stylesheet" href="../css/uppy.min.css">
<link rel="stylesheet" href="../css/jquery.steps.css">
<link rel="stylesheet" href="../css/jquery.timepicker.css">
<link rel="stylesheet" href="../css/quill.snow.css">
<!-- Date Range Picker CSS -->
<link rel="stylesheet" href="../css/daterangepicker.css">
<!-- App CSS -->
<link rel="stylesheet" href="../css/app-light.css" id="lightTheme">
<style type="text/css">
	*{
         list-style: none;
         padding: 0;
         margin: 0;
     }
     a{
         text-decoration: none;
         color: black;
         display: block;
     }
</style>
</head>
<body>
	<main role="main" class="main-content">
	       <div class="container-fluid">
	         <div class="row justify-content-center">
	           <div class="col-12 col-lg-10 col-xl-8">
	             <div class="my-4">
	               <form>
	                 <div class="row mt-5 align-items-center">
                       <img src="../assets/avatars/example.jpg" alt="..." class="col-md-8">
	                   <div class="col-md-4">
	                       <div class="col">
							 <h2 class="mb-2">상품명 1</h2>
							 <hr>
							 <div>
	                         	<h4 class="mb-3">총 상품금액 : total price원</h4>
	                         </div>
							 <hr>
	                         <div style="height: 200;">
		                         <p class="text-muted"> 상품설명1 상품설명1 상품설명1 상품설명1 상품설명1 상품설명1 상품설명1 상품설명1 상품설명1 상품설명1 상품설명1 상품설명1 상품설명1 상품설명1 상품설명1 상품설명1 상품설명1 상품설명1 상품설명1 상품설명1 </p>
	                         </div>
	                         <div style="text-align: center;">
	                         	수량&nbsp;&nbsp;&nbsp;&nbsp; 
	                         	<input type="number" step="1" min="1" max="10" value="1">
	                         </div>
							 <div class="btn-box w-100 mt-1 mb-1">
								<a href="#" target="_blank" class="btn mb-2 btn-primary btn-lg btn-block">
									<i class="fe fe-shopping-cart fe-12 mx-2"></i><span class="small">장바구니</span>
								</a>
							 </div>
							 <div class="btn-box w-100 mb-1">
								<a href="buy_body.jsp" target="_blank" class="btn mb-2 btn-secondary btn-lg btn-block">
									<i class="fe fe-credit-card fe-12 mx-2"></i><span class="small">구매</span>
								</a>	
							 </div>
	                       </div>
	                   </div>
	                 </div>
	                 <hr class="my-4">
	               </form>
	             </div> <!-- /.card-body -->
	     </div> <!-- /.col-12 -->
	   </div> <!-- .row -->
	 </div> <!-- .container-fluid -->
	 <div class="modal fade modal-notif modal-slide" tabindex="-1" role="dialog" aria-labelledby="defaultModalLabel" aria-hidden="true">
	   <div class="modal-dialog modal-sm" role="document">
	     <div class="modal-content">
	       <div class="modal-header">
	         <h5 class="modal-title" id="defaultModalLabel">Notifications</h5>
	         <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	           <span aria-hidden="true">&times;</span>
	         </button>
	       </div>
	       <div class="modal-body">
	         <div class="list-group list-group-flush my-n3">
	           <div class="list-group-item bg-transparent">
	             <div class="row align-items-center">
	               <div class="col-auto">
	                 <span class="fe fe-box fe-24"></span>
	               </div>
	               <div class="col">
	                 <small><strong>Package has uploaded successfull</strong></small>
	                 <div class="my-0 text-muted small">Package is zipped and uploaded</div>
	                 <small class="badge badge-pill badge-light text-muted">1m ago</small>
	               </div>
	             </div>
	           </div>
	           <div class="list-group-item bg-transparent">
	             <div class="row align-items-center">
	               <div class="col-auto">
	                 <span class="fe fe-download fe-24"></span>
	               </div>
	               <div class="col">
	                 <small><strong>Widgets are updated successfull</strong></small>
	                 <div class="my-0 text-muted small">Just create new layout Index, form, table</div>
	                 <small class="badge badge-pill badge-light text-muted">2m ago</small>
	               </div>
	             </div>
	           </div>
	           <div class="list-group-item bg-transparent">
	             <div class="row align-items-center">
	               <div class="col-auto">
	                 <span class="fe fe-inbox fe-24"></span>
	               </div>
	               <div class="col">
	                 <small><strong>Notifications have been sent</strong></small>
	                 <div class="my-0 text-muted small">Fusce dapibus, tellus ac cursus commodo</div>
	                 <small class="badge badge-pill badge-light text-muted">30m ago</small>
	               </div>
	             </div> <!-- / .row -->
	           </div>
	           <div class="list-group-item bg-transparent">
	             <div class="row align-items-center">
	               <div class="col-auto">
	                 <span class="fe fe-link fe-24"></span>
	               </div>
	               <div class="col">
	                 <small><strong>Link was attached to menu</strong></small>
	                 <div class="my-0 text-muted small">New layout has been attached to the menu</div>
	                 <small class="badge badge-pill badge-light text-muted">1h ago</small>
	               </div>
	             </div>
	           </div> <!-- / .row -->
	         </div> <!-- / .list-group -->
	        </div>
	        <div class="modal-footer">
	          <button type="button" class="btn btn-secondary btn-block" data-dismiss="modal">Clear All</button>
	        </div>
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
	</main> <!-- main -->
    <script src="../js/jquery.min.js"></script>
    <script src="../js/popper.min.js"></script>
    <script src="../js/moment.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    <script src="../js/simplebar.min.js"></script>
    <script src='../js/daterangepicker.js'></script>
    <script src='../js/jquery.stickOnScroll.js'></script>
    <script src="../js/tinycolor-min.js"></script>
    <script src="../js/config.js"></script>
    <script src="../js/apps.js"></script>
    <!-- Global site tag (gtag.js) - Google Analytics -->
    <script async src="https://www.googletagmanager.com/gtag/js?id=UA-56159088-1"></script>
    <script>
      window.dataLayer = window.dataLayer || [];

      function gtag()
      {
        dataLayer.push(arguments);
      }
      gtag('js', new Date());
      gtag('config', 'UA-56159088-1');
    </script>
</body>
</html>