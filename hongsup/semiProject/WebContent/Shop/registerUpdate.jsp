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
			<h2 class="tit">회원가입정보 수정</h2>
			<p>아이디출력 님의 개인정보를 안전하게 보호하기 위해 비밀번호를 다시 한번 확인해주세요.</p>
		</div>
		<section class="mem_table">
			<table cellpadding="0" cellspacing="0">
				<div>
					<tr>
						<th><strong>아이디</strong></th>
						<td colspan="2">출력</td>
					</tr>
					<tr>
						<th scope="row" class="top"><strong>비밀번호</strong></th>
						<td><input type="password" name="" ></td>
					</tr>
				</div>
				<hr>
			</table>
			<hr>
				<tr height="50">
					<td>
						<input type="button" value="확인" href="registerUpdate.jsp"">
					</td>
				</tr>
				<tr height="50">
					<td>
						<input type="button" value="취소" href="memberCheck.jsp"">
					</td>
				</tr>
		</section>
	</section>
</body>
</html>