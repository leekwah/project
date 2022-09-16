<%@page import="magic.MemberBean"%>
<%@page import="magic.MemberDBBean"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%
	String uid = (String)session.getAttribute("uid");
	
	MemberDBBean manager = MemberDBBean.getInstance();
	
	MemberBean mb = manager.getMember(uid);
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="member.js" charset="UTF-8"></script>
</head>
<body>
	<table>
		<form name="upd_frm" method="post" action="memberUpdateOk.jsp">
			<tr>
				<td>
					<h2>회원가입정보수정</h2>
				</td>
			</tr>
			<tr>
				<td>
					<h3>필수 정보</h3>
				</td>
			</tr>
			<hr>
			<table>
				<table>
					<div>
						<tr>
							<td><strong>아이디</strong></td>
							<td><%= uid %></td>
						</tr>
						<tr>
							<td>현재 비밀번호 <input type="password" name="" ></td>
						</tr>
						<tr>
							<td>신규 비밀번호<input type="password" name=""></td>
						</tr>
						<tr>
							<td>신규 비밀번호 재입력<input type="password" name=""></td>
						</tr>
						</td>
					</div>
				</table>
				<hr>
				<table>
					<div>
						<tr>
							<td><strong>이름(실명)</strong></td>
						</tr>
					</div>
					<div>
						<tr>
							<td>이메일주소 입력 <input type="text" name=""></td>
						</tr>
						<tr>
							<td>
							<strong>배송지<br>(기본배송지)</strong>
							<input type="text"><button>검색</button><br>
							<input type="text">
							</td>
						</tr>
					</div>
				</table>
				<hr>
		</form>
		</section>
			<td colspan="2" align="center">
				<input type="button" value=" 완료 " onclick="update_check_ok()">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="button" value=" 취소 "
				 onclick="javascript:window.location='main.jsp'">
			 </td>
</body>
</html>