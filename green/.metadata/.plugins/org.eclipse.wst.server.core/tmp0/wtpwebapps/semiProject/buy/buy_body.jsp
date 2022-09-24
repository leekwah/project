<%@page import="member.MemberBean"%>
<%@page import="member.MemberDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if(session.getAttribute("Member") == null){ 
	// member가 null(초기화)되면  main으로 들어갈 수 없게 
	// jsp:forward로 login으로 돌아감.
%>
		<jsp:forward page="../login/login.jsp" />
<%
	}
%>
<%
	String id = (String)session.getAttribute("id"); // 타입을 맞도록 해야함.
	String name = (String)session.getAttribute("name");
	
	MemberDBBean member = MemberDBBean.getInstance();
	MemberBean mb = member.getMember(id);
	
	String phone1 = mb.getUser_phone1();
	String phone2 = mb.getUser_phone2();
	String phone3 = mb.getUser_phone3();
	String email = mb.getUser_email();
	String pcode = mb.getUser_pcode();
	String raddr = mb.getUser_raddr();
	String detailaddr = mb.getUser_detailaddr();
%>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="favicon.ico">
<title>결제</title>
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
	<div class="container-fluid">
	  <div class="row justify-content-center">
	    <div class="col-12">
	      <h2 class="page-title" style="text-align: center;">주문서</h2>
	      <div class="row">
	       <div class="col-md-6" style="margin: 0 auto;">
	         <div class="card shadow mb-4">
	           <div class="card-body">
				<table class="table table-bordered">
					<thead>
					  <tr role="row">
					    <th>상품정보</th>
					    <th>수량</th>
					    <th>배송비</th>
					    <th>주문금액</th>
					  </tr>
					</thead>
					<tbody>
					  <tr>
					    <td>상품명1</td>
					    <td>1개</td>
					    <td>무료</td>
					    <td>상품가격1</td>
					  </tr>
					</tbody>
					<tbody>
					  <tr>
					    <td colspan="3">총금액</td>
					    <td>999,999,999</td>
					  </tr>
					</tbody>
				 </table>
	             <form class="needs-validation" novalidate>
	               <div class="form-row">
	                 <div class="col-md-4 mb-3">
	                   <label for="validationCustom3">수령인</label>
	                   <input type="text" class="form-control" id="validationCustom3" placeholder="-" value="<%= name %>" required>
	                   <div class="invalid-feedback"> 수령인을 입력해주세요. </div>
	                 </div>
	               </div> <!-- /.form-row -->
	               <div class="form-row">
	                 <div class="col-md-2 mb-3">
	                   <label for="custom-phone">연락처</label>
	                   <input class="form-control input-phoneus" id="custom-phone" maxlength="14" placeholder="-" value="<%= phone1 %>" required>
	                   <div class="invalid-feedback"> 연락처를 입력해주세요. </div>
	                 </div>
	                 <div class="col-md-3 mb-3">
	                   <label for="custom-phone">&nbsp;</label>
	                   <input class="form-control input-phoneus" id="custom-phone" maxlength="14" placeholder="-" value="<%= phone2 %>" required>
	                   <div class="invalid-feedback"> 연락처를 입력해주세요. </div>
	                 </div>
	                 <div class="col-md-3 mb-3">
	                   <label for="custom-phone">&nbsp;</label>
	                   <input class="form-control input-phoneus" id="custom-phone" maxlength="14" placeholder="-" value="<%= phone3 %>" required>
	                   <div class="invalid-feedback"> 연락처를 입력해주세요. </div>
	                 </div>
                   </div>
	               <div class="form-row">
	                 <div class="col-md-8 mb-3">
	                   <label for="exampleInputEmail2">이메일</label>
	                   <input type="email" class="form-control" id="exampleInputEmail2" aria-describedby="emailHelp1" placeholder="-" value="<%= email %>" required>
	                   <div class="invalid-feedback"> 이메일주소를 입력해주세요. </div>
	                 </div>
	               </div> <!-- /.form-row -->
	               <div class="form-row">
	                 <div class="col-md-4 mb-3">
	                   <label for="address-wpalaceholder">우편번호</label>
	                   <input class="form-control input-address" id="address-wpalaceholder" maxlength="14" placeholder="-" value="<%= pcode %>" required>
	                   <div class="invalid-feedback"> 우편번호를 입력해주세요. </div>
	                 </div>
	                 <div class="col-md-8 mb-3">
	                   <label for="address-wpalaceholder">도로명 주소</label>
	                   <input class="form-control input-address" id="address-wpalaceholder" maxlength="14" placeholder="-" value="<%= raddr %>" required>
	                   <div class="invalid-feedback"> 도로명주소를 입력해주세요. </div>
	                 </div>
				   </div> <!-- /.form-row -->
	               <div class="form-group mb-3">
	                 <label for="address-wpalaceholder">상세 주소</label>
	                 <input type="text" id="address-wpalaceholder" class="form-control" placeholder="-" value="<%= detailaddr %>" required>
	                 <div class="invalid-feedback"> 상세주소를 입력해주세요. </div>
	               </div>
	               <div class="form-group mb-3">
	                 <label for="validationTextarea1">요청사항</label>
	                 <textarea class="form-control" id="validationTextarea1" placeholder="배송 시 요청사항을 적어주세요." rows="3"></textarea>
	               </div>
	               <button class="btn btn-primary" type="submit">결제하기</button>
	             </form>
	           </div> <!-- /.card-body -->
	         </div> <!-- /.card -->
	       </div> <!-- /.col -->
	     </div> <!-- end section -->
	   </div> <!-- /.col-12 col-lg-10 col-xl-10 -->
	 </div> <!-- .row -->
	</div> <!-- .container-fluid -->
    <script src="../js/jquery.min.js"></script>
    <script src="../js/popper.min.js"></script>
    <script src="../js/moment.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    <script src="../js/simplebar.min.js"></script>
    <script src='../js/daterangepicker.js'></script>
    <script src='../js/jquery.stickOnScroll.js'></script>
    <script src="../js/tinycolor-min.js"></script>
    <script src="../js/config.js"></script>
    <script src='../js/jquery.mask.min.js'></script>
    <script src='../js/select2.min.js'></script>
    <script src='../js/jquery.steps.min.js'></script>
    <script src='../js/jquery.validate.min.js'></script>
    <script src='../js/jquery.timepicker.js'></script>
    <script src='../js/dropzone.min.js'></script>
    <script src='../js/uppy.min.js'></script>
    <script src='../js/quill.min.js'></script>
    <script>
      $('.select2').select2(
      {
        theme: 'bootstrap4',
      });
      $('.select2-multi').select2(
      {
        multiple: true,
        theme: 'bootstrap4',
      });
      $('.drgpicker').daterangepicker(
      {
        singleDatePicker: true,
        timePicker: false,
        showDropdowns: true,
        locale:
        {
          format: 'MM/DD/YYYY'
        }
      });
      $('.time-input').timepicker(
      {
        'scrollDefault': 'now',
        'zindex': '9999' /* fix modal open */
      });
      /** date range picker */
      if ($('.datetimes').length)
      {
        $('.datetimes').daterangepicker(
        {
          timePicker: true,
          startDate: moment().startOf('hour'),
          endDate: moment().startOf('hour').add(32, 'hour'),
          locale:
          {
            format: 'M/DD hh:mm A'
          }
        });
      }
      var start = moment().subtract(29, 'days');
      var end = moment();

      function cb(start, end)
      {
        $('#reportrange span').html(start.format('MMMM D, YYYY') + ' - ' + end.format('MMMM D, YYYY'));
      }
      $('#reportrange').daterangepicker(
      {
        startDate: start,
        endDate: end,
        ranges:
        {
          'Today': [moment(), moment()],
          'Yesterday': [moment().subtract(1, 'days'), moment().subtract(1, 'days')],
          'Last 7 Days': [moment().subtract(6, 'days'), moment()],
          'Last 30 Days': [moment().subtract(29, 'days'), moment()],
          'This Month': [moment().startOf('month'), moment().endOf('month')],
          'Last Month': [moment().subtract(1, 'month').startOf('month'), moment().subtract(1, 'month').endOf('month')]
        }
      }, cb);
      cb(start, end);
      $('.input-placeholder').mask("00/00/0000",
      {
        placeholder: "__/__/____"
      });
      $('.input-zip').mask('00000-000',
      {
        placeholder: "____-___"
      });
      $('.input-money').mask("#.##0,00",
      {
        reverse: true
      });
      $('.input-mixed').mask('AAA 000-S0S');
      $('.input-ip').mask('0ZZ.0ZZ.0ZZ.0ZZ',
      {
        translation:
        {
          'Z':
          {
            pattern: /[0-9]/,
            optional: true
          }
        },
        placeholder: "___.___.___.___"
      });
      // editor
      var editor = document.getElementById('editor');
      if (editor)
      {
        var toolbarOptions = [
          [
          {
            'font': []
          }],
          [
          {
            'header': [1, 2, 3, 4, 5, 6, false]
          }],
          ['bold', 'italic', 'underline', 'strike'],
          ['blockquote', 'code-block'],
          [
          {
            'header': 1
          },
          {
            'header': 2
          }],
          [
          {
            'list': 'ordered'
          },
          {
            'list': 'bullet'
          }],
          [
          {
            'script': 'sub'
          },
          {
            'script': 'super'
          }],
          [
          {
            'indent': '-1'
          },
          {
            'indent': '+1'
          }], // outdent/indent
          [
          {
            'direction': 'rtl'
          }], // text direction
          [
          {
            'color': []
          },
          {
            'background': []
          }], // dropdown with defaults from theme
          [
          {
            'align': []
          }],
          ['clean'] // remove formatting button
        ];
        var quill = new Quill(editor,
        {
          modules:
          {
            toolbar: toolbarOptions
          },
          theme: 'snow'
        });
      }
      // Example starter JavaScript for disabling form submissions if there are invalid fields
      (function()
      {
        'use strict';
        window.addEventListener('load', function()
        {
          // Fetch all the forms we want to apply custom Bootstrap validation styles to
          var forms = document.getElementsByClassName('needs-validation');
          // Loop over them and prevent submission
          var validation = Array.prototype.filter.call(forms, function(form)
          {
            form.addEventListener('submit', function(event)
            {
              if (form.checkValidity() === false)
              {
                event.preventDefault();
                event.stopPropagation();
              }
              form.classList.add('was-validated');
            }, false);
          });
        }, false);
      })();
    </script>
    <script>
      var uptarg = document.getElementById('drag-drop-area');
      if (uptarg)
      {
        var uppy = Uppy.Core().use(Uppy.Dashboard,
        {
          inline: true,
          target: uptarg,
          proudlyDisplayPoweredByUppy: false,
          theme: 'dark',
          width: 770,
          height: 210,
          plugins: ['Webcam']
        }).use(Uppy.Tus,
        {
          endpoint: 'https://master.tus.io/files/'
        });
        uppy.on('complete', (result) =>
        {
          console.log('Upload complete! We’ve uploaded these files:', result.successful)
        });
      }
    </script>
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