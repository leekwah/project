<%@page import="member.MemberBean"%>
<%@page import="member.MemberDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% //로그인을 누르면  loginOk로 넘어옴.
 	String id =	request.getParameter("user_id");  
	String pwd = request.getParameter("user_pwd");
	MemberDBBean manager = MemberDBBean.getInstance(); 
	//instance객체를 manager로 받음
	
	int check = manager.userCheck(id, pwd);
	// 유저가 있는지 확인하는 메소드호출해서 check안에 넣음.
	MemberBean mb = manager.getMember(id);
		
	if(mb == null){ // id가 null이면,
%>		<script>	
			alert("존재하지 않는 회원");
			history.back(); //다시 로그인화면으로 돌아감.
		</script>
<%		
	}else{ // 회원이 존재할 시
		String name = mb.getUser_name(); //이름 출력-> name에 넣음.
	
		if(check == -1){ //아이디와 비밀번호가 입력값과 같을 때,
			session.setAttribute("id", id); //session으로 id를 저장
			session.setAttribute("name", name); // session으로 name을 저장
			session.setAttribute("Member", "yes"); //회원이 아니면 튕기도록 함.
			response.sendRedirect("main.jsp"); //메인화면으로 이동
			
		}
		else if(check == 0 ){ // 비밀번호가 틀릴때,
%>		
		<script>
			alert("비밀번호가 맞지 않습니다.")
			history.go(-1); // 이전페이지로 이동
		</script>
<%
		}else{ // 아이디가 없을 때, 
		/*실제테스트시에는 이 케이스는 제외됨.*/
%>		
		<script>
			alert("아이디가 없습니다.")
			history.go(-1); // 이전페이지로 이동
		</script>
<%
		}

	}
%>
