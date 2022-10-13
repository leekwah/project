<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if(session.getAttribute("Member") == null){ 
	// member가 null(초기화)되면  main으로 들어갈 수 없게 
	// jsp:forward로 login으로 돌아감.
%>
		<jsp:forward page="../login/login.jsp" />
<%
	}
%>
<%
	String id = (String)session.getAttribute("id"); // 타입을 맞도록 해야함.
	String name = (String)session.getAttribute("name");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul class="navbar-nav flex-fill w-100 mb-2">
            <li class="nav-item dropdown">
              <a href="../user/user_index.jsp" data-toggle="collapse" aria-expanded="false" class="nav-link">
                <i class="fe fe-home fe-16"></i>
                <span class="ml-3 item-text">홈</span>
              </a>
            </li>
            <li class="nav-item dropdown">
              <a href="#contact" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle nav-link">
                <i class="fe fe-briefcase fe-16"></i>
                <span class="ml-3 item-text">상품</span>
              </a>
              <ul class="collapse list-unstyled pl-4 w-100" id="contact">
                <a class="nav-link pl-3" href="#"><span class="ml-1">주문 관리</span></a>
                <a class="nav-link pl-3" href="#"><span class="ml-1">환불 관리</span></a>
              </ul>
            </li>
            <li class="nav-item dropdown">
              <a href="#profile" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle nav-link">
                <i class="fe fe-smile fe-16"></i>
                <span class="ml-3 item-text">고객 센터</span>
              </a>
              <ul class="collapse list-unstyled pl-4 w-100" id="profile">
                <a class="nav-link pl-3" href="adminIndex.jsp?pages=qnaList"><span class="ml-1">문의 관리</span></a>
                <a class="nav-link pl-3" href="adminIndex.jsp?pages=listNotice"><span class="ml-1">공지사항 관리</span></a>
              </ul>
            </li>
            <li class="nav-item w-100">
              <a class="nav-link" href="adminIndex.jsp?pages=listMember">
                <i class="fe fe-calendar fe-16"></i>
                <span class="ml-3 item-text">회원관리</span>
              </a>
            </li>
            <div class="btn-box w-100 mt-1 mb-1">
            <a href="../login/login.jsp" target="_blank" class="btn mb-2 btn-primary btn-lg btn-block">
              <i class="fe fe-shopping-cart fe-12 mx-2"></i><span class="small">로그인</span>
            </a>
          </div>
          <div class="btn-box w-100 mb-1">
            <a href="../login/register.jsp" target="_blank" class="btn mb-2 btn-secondary btn-lg btn-block">
              <i class="fe fe-user-plus fe-12 mx-2"></i><span class="small">회원가입</span>
            </a>	
          </div>
          <div class="btn-box w-100 mb-1">
              <i class="fe fe-user-plus fe-12 mx-2"></i>
              <span class="small"> 안녕하세요. <%= name %> (<%= id %>)님
              </span>
          </div>
	</ul>
</body>
</html>