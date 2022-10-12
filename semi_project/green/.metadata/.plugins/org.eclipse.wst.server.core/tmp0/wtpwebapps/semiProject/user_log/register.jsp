<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>회원가입</title>
    <link href="https://fonts.googleapis.com/css2?family=Overpass:ital,wght@0,100;0,200;0,300;0,400;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="../css/simplebar.css">
    <link rel="stylesheet" href="../css/feather.css">
    <link rel="stylesheet" href="../css/daterangepicker.css">
    <link rel="stylesheet" href="../css/app-light.css" id="lightTheme">
  </head>
<style>
    .form-group1 {width: 50%; margin-bottom: 15px;}
    .form-row1 {margin-right: -5px;  }
    .form-row1 ul {list-style: none; display: flex; justify-content: flex;}
    .form-row1 ul li{margin-right: 3%;}
    .form-row1 ul li:first-child {list-style: none; width: 20%; }
    .row.mb-4{ margin-bottom: 5px;}
    input#sample4_postcode{width: 50%; display: inline-block; margin-right: 20px; margin-bottom: 10px;}
    input#sample4_roadAddress {margin-bottom: 10px;}
    #juso{height: 28px; font-size: 12px; background-color: #1B68FF; border-color: #1B68FF; border-radius: 3px; color: white;
    font-family: sans-serif;}
  </style>
  <script type="text/javascript" src="script.js" charset="utf-8"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
    function sample4_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var roadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 참고 항목 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample4_postcode').value = data.zonecode;
                document.getElementById("sample4_roadAddress").value = roadAddr;
                document.getElementById("sample4_jibunAddress").value = data.jibunAddress;
                
                // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
                if(roadAddr !== ''){
                    document.getElementById("sample4_extraAddress").value = extraRoadAddr;
                } else {
                    document.getElementById("sample4_extraAddress").value = '';
                }

                var guideTextBox = document.getElementById("guide");
                // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
                if(data.autoRoadAddress) {
                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                    guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
                    guideTextBox.style.display = 'block';

                } else if(data.autoJibunAddress) {
                    var expJibunAddr = data.autoJibunAddress;
                    guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
                    guideTextBox.style.display = 'block';
                } else {
                    guideTextBox.innerHTML = '';
                    guideTextBox.style.display = 'none';
                }
            }
        }).open();
    }
</script>
  <body class="light ">
    <div class="wrapper vh-100">
      <div class="row align-items-center h-100">
        <form class="col-lg-6 col-md-8 col-10 mx-auto" name="reg_frm" action="main.jsp?pages=../user_log/registerOk" method="post">
          <div class="mx-auto text-center my-4">
            <a class="navbar-brand mx-auto mt-2 flex-fill text-center" href="./index.html">
              <svg version="1.1" id="logo" class="navbar-brand-img brand-md" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" viewBox="0 0 120 120" xml:space="preserve">
                <g>
                  <polygon class="st0" points="78,105 15,105 24,87 87,87 	" />
                  <polygon class="st0" points="96,69 33,69 42,51 105,51 	" />
                  <polygon class="st0" points="78,33 15,33 24,15 87,15 	" />
                </g>
              </svg>
            </a>
            <h2 class="my-3">Register</h2>
          </div>
          <div class="form-group1">
            <label for="ID">ID</label>
            <input type="text" class="form-control" id="id" name="user_id">
            <span id="msg"></span>
          </div>
          <div class="row mb-4">
            <div class="col-md-6">
              <div class="form-group">
                <label for="inputPassword5">New Password</label>
                <input type="password" class="form-control" id="inputPassword5" name="user_pwd">
              </div>
              <div class="form-group">
                <label for="inputPassword6">Confirm Password</label>
                <input type="password" class="form-control" id="inputPassword6" name="user_pwdch">
              </div>
            </div>
            <div class="col-md-6">
              <p class="mb-2">Password requirements</p>
              <p class="small text-muted mb-2"> To create a new password, you have to meet all of the following requirements: </p>
              <ul class="small text-muted pl-4 mb-0">
                <li> Minimum 8 character </li>
                <li>At least one special character</li>
                <li>At least one number</li>
                <li>Can’t be the same as a previous password </li>
              </ul>
            </div>
          </div>
          
          <div class="form-row">
            <div class="form-group col-md-6">
              <label for="firstname">Name</label>
              <input type="text" id="firstname" class="form-control" name="user_name">
            </div>
          </div>
          <div class="form-row1">
            <label for="phone1">Phone</label>
            <label for="phone2"></label>
            <label for="phone3"></label>
              <ul>
                <li>
                  <input type="text" id="phone1" class="form-control" name ="user_phone1" maxlength="3">
                </li>
                <li>
                  <input type="text" id="phone2" class="form-control" name="user_phone2" maxlength="4">
                </li>
                <li>
                  <input type="text" id="phone3" class="form-control" name="user_phone3" maxlength="4">
                </li>
              </ul>
          </div>
          <div class="form-group">
            <label for="inputEmail4">Email</label>
            <input type="email" class="form-control" id="inputEmail4" name="user_email">
          </div>
          <div class="form-row1">
            <label for="sample4_postcode">Address</label>
            <br>
            <input type="text" class="form-control" name="user_pcode" id="sample4_postcode" placeholder="우편번호">
            <input id="juso" type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기">
            <input type="text" class="form-control" name="user_raddr" id="sample4_roadAddress" placeholder="도로명주소">
            <input type="hidden" name="user_jibun" id="sample4_jibunAddress" placeholder="지번주소">
            <span id="guide" style="color:#999;display:none"></span>
            <input type="text" class="form-control" name="user_detailaddr" id="sample4_detailAddress" placeholder="상세주소">
            <input type="hidden" id="sample4_extraAddress" placeholder="참고항목">
          </div>
          <hr class="my-4">
          <button class="btn btn-lg btn-primary btn-block" onclick="check_ok()">Sign up</button>
          <p class="mt-5 mb-3 text-muted text-center">© 2022</p>
        </form>
      </div>
    </div>
    
    <script src="js/jquery.min.js"></script>
    <script src="js/jquery-3.6.0.min.js"></script>
    <script>
    	$('#ID').on("keyup",(function(){
    		var $checkID = $("#id").val();
    		var params = "?user_id="+$checkID;
    		
    		var $msg = $("#msg");
    		
    		if($checkID == ""){
    			console.log("아이디 없음")
    			return;
    		}
    		
    		$.ajax({
    			type : "post",
    			url : "./checkid.jsp",
    			data : {"id": $checkID},
    			dataType : "html",
    			async : true,
    			success : function(data){
    				console.log("data : "+data)
    				if (data.trim() =="true") {
						$msg.html("<h4>아이디가 이미 존재합니다</h4>");
					}else{
						$msg.html("<h4>사용가능한 아이디 입니다</h4>")
					}
    			},
    			error : function(){
    				alert("서버요청 실패");
    			}
    		})
    	})
    </script>
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
</body>
</html>