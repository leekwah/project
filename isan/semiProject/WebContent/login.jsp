<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border = "1" align="center">
		<form action = "loginOk.jsp" method="post">
			<tr>
				<td align="center">사용자 ID</td>
				<td><input type="text" name= "user_id"></td>
			</tr>
			<tr>
				<td align="center">비밀번호</td>
				<td><input type="password" onKeyup = "addHypen(this);" name="user_pwd"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				<input type="submit" value="로그인" >
				<input type="button" value="회원가입"
                onclick="javascript:window.location='register.jsp'">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				<input type="button" value="id 찾기" onclick="javascript:window.location='findId.jsp'">
				<input type="button" value="pw 찾기" onclick="javascript:window.location='findPw.jsp'">
				</td>
			</tr>
		</form>
	</table>
	
</body>
</html>