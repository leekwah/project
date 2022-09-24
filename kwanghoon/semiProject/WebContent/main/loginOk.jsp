<%@page import="login.UserDBBean"%>
<%@page import="login.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	// session 값을 체크한다. (URL로 찍으면, null로 되게 한다.)
	if(session.getAttribute("user") == null) { 
		// loginOk.jsp에서 setAttribute() 메서드를 통해 임의로 줬던 user 값이 null이면 첫 화면(login)으로 간다.
%>
	<jsp:forward page=".jsp"/>
<% 
	}
	// null이 아닌경우, getAttribute() 메서드를 통해서, session의 값을 얻어온다.
	String user_id = (String)session.getAttribute("user_id");
	String name = (String)session.getAttribute("user_name");
%>
	
<%
	String id = request.getParameter("user_id");
	String pwd = request.getParameter("user_pwd");
	// login.jsp 에서 input의 name값을 받아옴
	
	UserDBBean manager = UserDBBean.getInstance();
	// getInstance() 메서드를 통해서 manager 객체 생성

	int check = manager.userCheck(id, pwd);
	UserBean ur = manager.getUser(id);
	// 아이디가 일치하는 멤버의 정보를 mb객체에 저장
	
	if(ur == null) {
%>
	<script>
		alert("존재하지 않는 회원");
		history.go(-1);
	</script>
<%
	} else {
		// ur객체의 name을 받아서, String name으로 대입한다. 
		String name = ur.getUser_name();
		
		if(check == 1) {
			// session 을 넘겨서, main에서 출력한다.
			// main.jsp 로 이동하기 전에, session에 추가한다.
			session.setAttribute("user_id", id);
			session.setAttribute("user_name", name);
			session.setAttribute("user", "yes");
			// 임의로 user일 경우 "yes"값을 준다. URL로만 로그인하는 것을 막기 위해서이다.
			response.sendRedirect("main.jsp");			
		}else if(check == 0){
%>
		<script>
			alert("비밀번호가 맞지 않습니다.");
			history.go(-1);
		</script>
<%
		}else{
%>
		<script>
			alert("아이디가 맞지 않습니다.");
			history.go(-1);
		</script>	
<%
		}
	}
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginOK</title>
</head>
<body>
<table border="1" align="center"  cellspacing="0">
		<!-- 로그아웃 버튼 눌렸을 때, 이동 -->
		<form method="post" action="logOut.jsp">
			<tr>
				<td>
					안녕하세요. <%= name %>(<%= user_id %>)님
				</td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="로그아웃">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="button" value="회원정보 변경" onclick="javascript:window.location='userUpdate.jsp'">
				</td>
			</tr>
		</form>
	</table>
</table>
</body>
</html>