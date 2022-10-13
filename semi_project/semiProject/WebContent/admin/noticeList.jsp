<%@page import="java.text.SimpleDateFormat"%>
<%@page import="cs.NoticeBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="cs.NoticeDBBean"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<jsp:useBean class="cs.NoticeBean" id="notice"></jsp:useBean>
<%

	String pageNum = request.getParameter("pageNum");//
	
	String n_user_id = "test";
	
	session.setAttribute("n_user_id", n_user_id);

	if(pageNum == null){
		pageNum = "1";
	}
	
	NoticeDBBean noticeDB = NoticeDBBean.getInstance();
	ArrayList<NoticeBean> noticeList = noticeDB.listNotice(pageNum);
	ArrayList<Integer> n_numbers = new ArrayList<>();
	
	int n_num, n_hit;
	String n_title, user_id;
	Timestamp n_date;
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <!-- Simple bar CSS -->
    <link rel="stylesheet" href="css/simplebar.css">
    <!-- Fonts CSS -->
    <link href="https://fonts.googleapis.com/css2?family=Overpass:ital,wght@0,100;0,200;0,300;0,400;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">
    <!-- Icons CSS -->
    <link rel="stylesheet" href="css/feather.css">
    <link rel="stylesheet" href="css/dataTables.bootstrap4.css">
    <!-- Date Range Picker CSS -->
    <link rel="stylesheet" href="css/daterangepicker.css">
    <!-- App CSS -->
    <link rel="stylesheet" href="css/app-dark.css?" id="darkTheme">
    <link rel="stylesheet" href="css/app-light.css?a=b" id="lightTheme" disabled>
</head>
<body>
 <div class="wrapper">
     <div class="container-fluid">
       <div class="row justify-content-center">
         <div class="col-12">
           <div class="row">
             <!-- Small table -->
             <div class="col-md-12 my-4">
               <h2 class="h3 mb-3 page-title">공지사항</h2>
               <div class="card shadow">
                 <div class="card-body">
					<div style="text-align: center;">
						<table class="table table-borderless table-hover">
						    <thead>
						      <tr>
						        <th>번호</th>
						        <th>글제목</th>
						        <th>작성자</th>
						        <th>작성일</th>
						        <th>조회수</th>
						      </tr>
						    </thead>
						    <tbody>
	    <%
			for(int i=0; i<noticeList.size();i++){
				notice = noticeList.get(i);
				
				n_num = notice.getN_num();
				n_title = notice.getN_title();
				user_id = notice.getUser_id();
				n_hit = notice.getN_hit();
				n_date = notice.getN_date();
				
				n_numbers.add(i, n_num);
		%>
								<tr>
								<td class="mb-0 text-muted"><%= n_num%></td>
								<td class="mb-0 text-muted">
									<a href="adminIndex.jsp?pages=noticeShow&n_num=<%= n_num %>&pageNum=<%= pageNum %>">
										<%= n_title %>
									</a>
								</td>
								<td class="mb-0 text-muted">
									<%= user_id %>
								</td>
								<td class="mb-0 text-muted">
									<%= sdf.format(n_date) %>
								</td>
								<td class="mb-0 text-muted">
									<%= n_hit %>
								</td>
							</tr>
						<%
							}
							noticeList.clear();
						%>
						<%
							if(session.getAttribute("n_user_id")!=null){
						%>
			<!-- 	    
			<td><span class="badge badge-pill badge-warning">Hold</span></td>
	        <td><span class="badge badge-pill badge-danger">Danger</span></td>
	        <td><span class="badge badge-pill badge-success">Success</span></td>
	         -->
	      
								    </tbody>
								</table>
							</div>
							<nav aria-label="Table Paging" class="mb-0 text-muted">
					        	<ul class="pagination justify-content-center mb-0">
									<%= NoticeBean.pageNumber(5) %>
								</ul>
								<div style="text-align: right;">
									<input class="btn btn-primary" type="button" value="글쓰기" 
										onclick="location.href='adminIndex.jsp?pages=noticeWrite&pageNum=<%= pageNum %>&n_user_id=<%= n_user_id %>'">		
								</div>
							</nav>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<%
		}
%>
	</div>
</body>
</html>