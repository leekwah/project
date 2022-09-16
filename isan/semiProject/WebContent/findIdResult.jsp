<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="semiProject.MemberDBBean"%>
<%
 	request.setCharacterEncoding("UTF-8");
    String name = request.getParameter("user_name");
    String phone = request.getParameter("user_phone");
     
	MemberDBBean find = new MemberDBBean();
 	String user_id = find.findId(name, phone); //아이디를 디비에서 가져옴..실패시 널
 
%>
	<div><a>
	</a></div>
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
 		    <input type="button" id="btnjoin" value="회원가입" onClick="joinin()"/>
       	</div>
       </div>
       
<%
  }
%> 
      </form>