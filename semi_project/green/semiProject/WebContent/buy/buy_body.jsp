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
	
	String p_name = (String)request.getParameter("p_name");
    int p_num = Integer.parseInt(request.getParameter("p_num"));
    int count = Integer.parseInt(request.getParameter("count"));
    int price = Integer.parseInt(request.getParameter("price"));
    int ship;
    if(price>=20000){
    	ship = 0;
    } else {
    	ship = 3000;
    }
    int totalPrice = price+ship;
    String phone = phone1+phone2+phone3;
    String address = raddr+detailaddr;
%>
<html>
<head>
<meta charset="UTF-8">
<title>결제</title>
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
	             <form class="needs-validation" method="post" action="kakao.jsp" novalidate>
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
					    <td>
	                   		<input type="text" class="form-control" value="<%= p_name %>" name="p_name" readonly>		
					    </td>
					    <td>
					    	<input type="number" class="form-control" id="count" value="<%= count %>" name="count">
					    	<input type="hidden" class="form-control" id="ori_count" value="<%= count %>" readonly>
					    </td>
					    <td>
					    	<input type="text" class="form-control" value="<%= ship %>" readonly>
					    </td>
					    <td>
					   		<input type="text" class="form-control" id="price" value="<%= price %>" name="price" readonly>
					   		<input type="hidden" class="form-control" id="ori_price" value="<%= price %>" readonly>
					    </td>
					  </tr>
					</tbody>
					<tbody>
					  <tr>
					    <td colspan="2">총 금액</td>
					    <td colspan="2">
					   		<input type="text" class="form-control" value="<%= totalPrice %>" name="totalPrice" readonly>
					    </td>
					  </tr>
					</tbody>
				 </table>
	               <div class="form-row">
	                 <div class="col-md-4 mb-3">
	                   <label for="validationCustom3">수령인</label>
	                   <input type="text" class="form-control" id="validationCustom3" value="<%= name %>" name="name" required>
	                   <div class="invalid-feedback"> 수령인을 입력해주세요. </div>
	                 </div>
	               </div> <!-- /.form-row -->
	               <div class="form-row">
	                 <div class="col-md-2 mb-3">
	                   <label for="custom-phone">연락처</label>
	                   <input class="form-control input-phoneus" id="custom-phone" value="<%= phone1 %>" name="phone1" required>
	                   <div class="invalid-feedback"> 연락처를 입력해주세요. </div>
	                 </div>
	                 <div class="col-md-3 mb-3">
	                   <label for="custom-phone">&nbsp;</label>
	                   <input class="form-control input-phoneus" id="custom-phone" value="<%= phone2 %>" name="phone2" required>
	                   <div class="invalid-feedback"> 연락처를 입력해주세요. </div>
	                 </div>
	                 <div class="col-md-3 mb-3">
	                   <label for="custom-phone">&nbsp;</label>
	                   <input class="form-control input-phoneus" id="custom-phone" value="<%= phone3 %>" name="phone3" required>
	                   <div class="invalid-feedback"> 연락처를 입력해주세요. </div>
	                 </div>
                   </div>
	               <div class="form-row">
	                 <div class="col-md-8 mb-3">
	                   <label for="exampleInputEmail2">이메일</label>
	                   <input type="email" class="form-control" id="exampleInputEmail2" aria-describedby="emailHelp1" value="<%= email %>" name="email" required>
	                   <div class="invalid-feedback"> 이메일주소를 입력해주세요. </div>
	                 </div>
	               </div> <!-- /.form-row -->
	               <div class="form-row">
	                 <div class="col-md-4 mb-3">
	                   <label for="address-wpalaceholder">우편번호</label>
	                   <input type="text"  class="form-control input-address" id="sample4_postcode" value="<%= pcode %>" name="pcode" required>
	                   <div class="invalid-feedback"> 우편번호를 입력해주세요. </div>
			           <input id="juso" type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기">
	                 </div>
	                 <div class="col-md-8 mb-3">
	                   <label for="address-wpalaceholder">도로명 주소</label>
	                   <input type="text" class="form-control input-address" id="sample4_roadAddress" value="<%= raddr %>" name="raddr" required>
			           <input type="hidden" name="jibun" id="sample4_jibunAddress" placeholder="지번주소">
	                   <div class="invalid-feedback"> 도로명주소를 입력해주세요. </div>
	                 </div>
				   </div> <!-- /.form-row -->
	               <div class="form-group mb-3">
			            <span id="guide" style="color:#999;display:none"></span>
	                 	<label for="address-wpalaceholder">상세 주소</label>
	                 	<input type="text" id="sample4_detailAddress" class="form-control" value="<%= detailaddr %>" name="detailaddr" required>
			            <input type="hidden" id="sample4_extraAddress" placeholder="참고항목">
	                 	<div class="invalid-feedback"> 상세주소를 입력해주세요. </div>
	               </div>
	               <div class="form-group mb-3">
	                 <label for="validationTextarea1">요청사항</label>
	                 <textarea class="form-control" id="validationTextarea1" placeholder="배송 시 요청사항을 적어주세요.(300자 제한)" rows="3" name="requested"></textarea>
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
<script type="text/javascript">
/*주문 수량을 변경하면 가격이 자동으로 설정되는 스크립트*/
function priceCal(){
	var ori_count = document.getElementById("ori_count").value;
	var count = document.getElementById("count").value;
	var one_price = document.getElementById("ori_price").value/ori_count;
	document.getElementById("price").value = (parseInt(count) * parseInt(one_price));
}
</script>
</body>
</html>