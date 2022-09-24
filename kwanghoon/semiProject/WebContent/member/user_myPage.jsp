<%@page import="member.MemberBean"%>
<%@page import="member.MemberDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = (String) session.getAttribute("id");

	MemberDBBean manager = MemberDBBean.getInstance();
	MemberBean mb = manager.getMember(id);
%> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
</head>
<body>
	
	<table border="1" align="center">
		<form name="upd_frm" method="post" action="userUpdateOk.jsp">
			<tr height="50">
				<td colspan="2">
					<h1>회원 정보 수정</h1>
					'*' 표시 항목은 필수 입력 항목입니다.
				</td>
			</tr>
			<tr height="30">
				<td width="80">User ID</td>
				<td><%= id %></td>
			</tr>
			<tr height="30">
				<td width="80">암호</td>
				<td><input type="password" name="user_pwd" size="20">*</td>
			</tr>
			<tr height="30">
				<td width="80">암호 확인</td>
				<td><input type="password" name="user_pwdcheck" size="20">*</td>
			</tr>
			<tr height="30">
				<td width="80">이    름</td>
				<td><input type="text" name="user_name" value="<%= mb.getUser_name() %>" size="20"></td>
			</tr>
			<tr>
				<td width="80">전화 번호</td>
				<td>
					<select name = "user_phone1">
						<option value = "010">010</option>
						<option value = "02">02</option>
						<option value = "031">031</option>
						<option value = "051">051</option>
					</select>
					<!-- <input type="text" name="user_phone1" size ="6" maxlength="4"> -->
					<input type="text" name="user_phone2" size ="10" maxlength="4">
					<input type="text" name="user_phone3" size ="10" maxlength="4">
				</td>
			</tr>
			<tr height="30">
				<td width="80">E-mail</td>
				<td><input type="text" name="user_email" value="<%= mb.getUser_email() %>" size="30">*</td>
			</tr>
			<tr>
				<td>주소</td>
				<td>
					<input type="text" name="user_pcode" id="sample4_postcode" placeholder="우편번호" value="<%= mb.getUser_pcode() %>" >
					<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br>
					<input type="text" name="user_raddr" id="sample4_roadAddress" placeholder="도로명주소" size="60" value="<%= mb.getUser_raddr()%>"><br>
					<input type="hidden" name="user_jibun" id="sample4_jibunAddress" placeholder="지번주소"  size="60" value="<%= mb.getUser_jibun() %>"> 
					<span id="guide" style="color:#999;display:none"></span>
					<input type="text" name="user_detailaddr" id="sample4_detailAddress" placeholder="상세주소"  size="60" value="<%= mb.getUser_detailaddr()%>"><br>
				</td>
			</tr>
			<tr height="30">
				<td colspan="2">
					<!-- <input type="button" value=" 수정 " onclick="update_check_ok()"> -->
					<input type="submit" value=" 수정 " >
					<input type="reset" value=" 다시입력 ">
					<input type="button" value=" 가입안함 " onclick="javascript:window.location='login.jsp'">
				</td>
			</tr>
		</form>
	</table> 
</body>
</html>