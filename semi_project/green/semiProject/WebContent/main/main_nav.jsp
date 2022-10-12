<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = (String)session.getAttribute("id");
	String name = (String)session.getAttribute("name");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main_nav</title>
</head>
<body>
	<ul class="navbar-nav flex-fill w-100 mb-2">
		 <li class="nav-item w-100">
          <a class="nav-link" href="main.jsp">
            <i class="fe fe-home fe-16"></i>
            <span class="ml-3 item-text">홈</span>
          </a>
        </li>
        <li class="nav-item w-100">
          <a class="nav-link" href="main.jsp?pages=../buy/buy_body">
            <i class="fe fe-clipboard fe-16"></i>
            <span class="ml-3 item-text">구매폼</span>
          </a>
        </li>
        <li class="nav-item w-100">
          <a class="nav-link" href="main.jsp?pages=../order/order_body">
            <i class="fe fe-truck fe-16"></i>
            <span class="ml-3 item-text">주문 조회</span>
          </a>
        </li>
        <li class="nav-item dropdown">
          <a href="#ui-elements" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle nav-link">
            <i class="fe fe-box fe-16"></i>
            <span class="ml-3 item-text">상품</span>
          </a>
          <ul class="collapse list-unstyled pl-4 w-100" id="ui-elements">
            <li class="nav-item">
              <a class="nav-link pl-3" href="main.jsp?pages=../product/product_list"><span class="ml-1 item-text">티셔츠</span>
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link pl-3" href="main.jsp?pages=../product/product_list"><span class="ml-1 item-text">후드티</span>
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link pl-3" href="main.jsp?pages=../product/product_list"><span class="ml-1 item-text">니트/스웨터</span>
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link pl-3" href="main.jsp?pages=../product/product_list"><span class="ml-1 item-text">셔츠/남방</span>
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link pl-3" href="main.jsp?pages=../product/product_list"><span class="ml-1 item-text">바지</span>
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link pl-3" href="main.jsp?pages=../product/product_list"><span class="ml-1 item-text">청바지</span>
              </a>
            </li>
          </ul>
        </li>
        <li class="nav-item w-100">
          <a class="nav-link" href="main.jsp?pages=../order/order_body">
            <i class="fe fe-truck fe-16" style="color:red"></i>
            <span class="ml-3 item-text">장바구니</span>
          </a>
        </li>
        <li class="nav-item w-100">
          <a class="nav-link" href="main.jsp?pages=../product/likeList">
            <i class="fe fe-heart fe-16"></i>
            <span class="ml-3 item-text">나의 찜 목록</span>
          </a>
        </li>
        <li class="nav-item w-100">
          <a class="nav-link" href="main.jsp?pages=../cs/cs_main">
            <i class="fe fe-headphones fe-16"></i>
            <span class="ml-3 item-text">고객센터</span>
          </a>
        </li>
        
    </ul>
    
	<%
		if(session.getAttribute("Member") == null){ // 회원이 아닌 경우
	%>
		<a href="main.jsp?pages=../user_log/login" class="btn mb-2 btn-primary btn-lg btn-block" role="button"><i class="fe fe-log-in fe-16"></i> 로그인</a>
	    <a href="main.jsp?pages=../user_log/register" class="btn mb-2 btn-secondary btn-lg btn-block" role="button"><i class="fe fe-user-plus fe-16"></i> 회원가입</a>
	<%
    	} else if(id.equals("admin")) {
	%>
		<p><strong>안녕하세요 <%= id %> 님</strong></p>
		<a href="../admin/adminIndex.jsp" class="btn mb-2 btn-warning btn-lg btn-block" role="button"><i class="fe fe-log-in fe-16"></i> 관리페이지</a>
	    <a href="../user_log/logout.jsp" class="btn mb-2 btn-secondary btn-lg btn-block" role="button"><i class="fe fe-log-out fe-16"></i> 로그아웃</a>
	<%
		} else {
	%>
		<p><strong>안녕하세요 <%= id %>님</strong></p>
	    <a href="main.jsp?pages=../user_log/mypage" class="btn mb-2 btn-primary btn-lg btn-block" role="button"><i class="fe fe-log-in fe-16"></i> 마이페이지</a>
	    <a href="../user_log/logout.jsp" class="btn mb-2 btn-secondary btn-lg btn-block" role="button"><i class="fe fe-log-out fe-16"></i> 로그아웃</a>
    <%
    	}
    %>
</body>
</html>