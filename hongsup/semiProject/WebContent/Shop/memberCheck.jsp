<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<section class="mypage_content">
		<div class="my_main_title_box b_line mb35">
			<h2 class="tit">회원가입정보</h2>
		</div>
		<hr>
		<h3 class="mem_infor_title">필수 정보</h3>
		<section class="mem_table">
			<table cellpadding="0" cellspacing="0">
				<div>
					<tr>
						<th><strong>아이디</strong></th>
						<td colspan="2">출력</td>
					</tr>
					<tr>
						<th scope="row" class="top"><strong>비밀번호</strong></th>
						<td>******************</td>
						<td>
							<a href="registerUpdate.jsp">비밀번호 변경</a>
						</td>
					</tr>
					<tr>
						<th scope="row"><strong>이름(실명)</strong></th>
						<td colspan="2">출력</td>
					</tr>
					<tr>
						<th scope="row" class="top"><strong>이메일</strong></th>
						<td>출력</td>
						<td>
							<a href="registerUpdate.jsp" class="btn_ty5">이메일 변경</a>
						</td>
					</tr>
					<tr>
						<th scope="row" class="top"><strong>휴대전화</strong></th>
						<td>출력</td>
						<td>
							<a href="registerUpdate.jsp" class="btn_ty5">휴대전화 변경</a>
						</td>
					</tr>
					<tr>
						<th scope="row" class="top"><strong>배송지<br>(기본배송지)</strong></th>
						<td>
							우편번호출력<br>
							주소출력
						</td>
						<td>
							<a href="registerUpdate.jsp">기본배송지 변경</a>
						</td>
					</tr>
				</div>
			</table>
			<hr>
		</section>
		<div class="mem_commemt mb80">
			아이디, 이름은 수정이 불가능합니다.
		</div>
		<div class="withdrawal_box mb40">
			탈퇴를 원하시면 회원탈퇴 버튼을 눌러주세요
			<a href="delete.jsp">회원탈퇴</a>
		</div>
	</section>
</body>
</html>