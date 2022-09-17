<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
</head>
<body>
	<table border="1" align="center">
		<!-- loginOK로 post방식 -->
		<form method="post" action="loginOK.jsp">
			<tr>
				<td width="100">사용자 ID</td>
				<td width="100">
					<input type="text">
				</td>
			</tr>
			<tr>
				<td width="100">비밀번호</td>
				<td width="100">
					<input type="text">
				</td>
			</tr>
			<tr>
				<!-- colspan="2"을 통해서 열을 합친다.  -->
				<td colspan="2" align="center">
					<input type="submit" value="로그인" >
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<!-- 회원가입을 눌리면 register.jsp로 넘어간다. -->
					<input type="button" value="회원가입" onclick="javascript:window.location='register.jsp'">
				</td>
			</tr>
		</form>
	</table>
</body>
</html>