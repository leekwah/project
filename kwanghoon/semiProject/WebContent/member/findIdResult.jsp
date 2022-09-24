<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="member.MemberDBBean"%>
<script language="JavaScript" src="script.js" charset="utf-8"></script>
<%
 	request.setCharacterEncoding("UTF-8");
    String name = request.getParameter("user_name");
    String phone1 = request.getParameter("user_phone1");
    String phone2 = request.getParameter("user_phone2");
    String phone3 = request.getParameter("user_phone3");
     
	MemberDBBean find = new MemberDBBean();
 	String user_id = find.findId(name, phone1, phone2, phone3); //아이디를 디비에서 가져옴..실패시 널
 	
 	/* System.out.print("user_name==>"+name+"  ");
 	System.out.print("user_phone1==>"+phone1+"  ");
 	System.out.print("user_phone2==>"+phone2+"  ");
 	System.out.print("user_phone3==>"+phone3+"  "); */
 	System.out.print(user_id);
%>
  <form name="idsearch" method="post">
<%

       if (user_id != null) {
%>
      
      <div class = "container">
      	<div class = "found-success">
	      <h4>  회원님의 아이디는 </h4>  
	      <div class ="found-id"><%=user_id%></div>
	      <h4>  입니다 </h4>
	     </div>
	     <div class = "found-login">
 		    <input type="button" id="btnLogin" value="로그인" onClick = 'login()'/>
       	</div>
       </div>
<%
  } else {
%>
        <div class = "container">
      	<div class = "found-fail">
	      <h4>  등록된 정보가 없습니다 </h4>  
	     </div>
	     <div class = "found-login">
 		    <input type="button" id="btnback" value="다시 찾기" onClick="history.back()"/>
 		    <input type="button" id="btnjoin" value="회원가입" onClick="javascript:window.location='login.jsp'"/>
       	</div>
       </div>
<%
  }
%> 
      </form>