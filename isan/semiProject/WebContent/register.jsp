<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="script.js" charset="utf-8"></script>
</head>
<body>
	<table border="1" >
		<form name="reg_frm" action="registerOk.jsp" method="post">
			<tr>
				<td colspan="2" align="center">
				<h1 style= text-align:center>Green</h1>
				</td>
			</tr>
			<tr>
				<td width="80">UserID</td>
				<td><input type="text" name="user_id" size ="20" >*</td>
			</tr>
			<tr>
				<td width="80">비밀번호</td>
				<td><input type="password" name="user_pwd" size ="20">*</td>
			</tr>
			<tr>
				<td width="80">암호 확인</td>
				<td><input type="password" name="user_pwdch" size ="20">*</td>
			</tr>
			<tr>
				<td width="80">이 름</td>
				<td><input type="text" name="user_name" size ="20">*</td>
			</tr>
			<tr>
				<td width="80">E-mail</td>
				<td><input type="text" name="user_email" size ="30">*</td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type="text" name="user_addr" size ="40"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				<input type="button" value="회원가입" onclick="check_ok()">
				<input type="reset" value="다시입력">
				&nbsp;&nbsp;&nbsp;
				<input type="button" value="가입안함" 
                 onclick="javascript:window.location='login.jsp'">
				</td>
			</tr>
		</form>
	</table>
</body>
</html>
