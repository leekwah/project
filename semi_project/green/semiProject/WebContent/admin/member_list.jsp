<%@page import="member.MemberDBBean"%>
<%@page import="member.MemberBean"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.util.ArrayList"%>
<%@page import="member.MemberDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean class="member.MemberBean" id="member"></jsp:useBean>

<%
	String pageNum = request.getParameter("pageNum");//
	String s_user_id="";
	
	if(pageNum == null){
		pageNum = "1";
	}
	
	if(request.getParameter("search_user_id")!=null){
		s_user_id = request.getParameter("search_user_id");
	} 
	MemberBean.s_user_id = s_user_id;
	
	MemberDBBean memberDB = MemberDBBean.getInstance();
	ArrayList<MemberBean> memberList = memberDB.listMember(pageNum,s_user_id);
	ArrayList<Integer> n_numbers = new ArrayList<>();
	
	String user_id, user_pwd, user_name, user_phone1, user_phone2, user_phone3, user_email
		, user_pcode, user_raddr, user_jibun, user_detailaddr;
	Timestamp user_regdate;
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../js/admin.js"></script>
</head>
 <body class="vertical  dark  ">
    <div class="wrapper">
        <div class="container-fluid">
          <div class="row justify-content-center">
            <div class="col-12">
              <div class="row">
                <!-- Small table -->
                <div class="col-md-12 my-4">
                  <h2 class="h3 mb-3 page-title">회원 관리</h2>
                  <div class="card shadow">
                    <div class="card-body">
                      <!-- table -->
                      <div style="text-align: center;">
                      <table class="table table-borderless table-hover">
                        <thead>
                          <tr>
                            <th>ID</th>
							<th>이름</th>
							<th>전화번호</th>
							<th>이메일</th>
							<th>가입일</th>
							<th>주소</th>
                            <th>Action</th>
                          </tr>
                        </thead>
                        <tbody>
		<%
			for(int i=0; i<memberList.size();i++){
				member = memberList.get(i);
				
				user_id = member.getUser_id();
				user_pwd=member.getUser_pwd();
				user_name=member.getUser_name();
				user_phone1=member.getUser_phone1();
				user_phone2=member.getUser_phone2();
				user_phone3=member.getUser_phone3();
				user_email=member.getUser_email();
				user_pcode=member.getUser_pcode();
				user_raddr=member.getUser_raddr();
				user_jibun=member.getUser_jibun();
				user_detailaddr=member.getUser_detailaddr();
				user_regdate=member.getUser_regdate();
		
		%>
				<tr>
					<td class="mb-0 text-muted"><%= user_id%></td>
					<td class="mb-0 text-muted">
						<a href="showMember.jsp?user_id=<%= user_id %>&pageNum=<%= pageNum %>">
							<%= user_name %>
						</a>
					</td>
					<td class="mb-0 text-muted">
						<%= user_phone1 %>-<%= user_phone2 %>-<%= user_phone3 %>
					</td>
					<td class="mb-0 text-muted">
						<%= user_email %>
					</td>
					<td class="mb-0 text-muted">
						<%= sdf.format(user_regdate) %>
					</td>
					<td class="mb-0 text-muted">
						우편번호 : <%= user_pcode %> <br>
						도 로 명 : <%= user_raddr %> <br>
						지     번 : <%= user_jibun %> <br>
						상세주소 : <%= user_detailaddr %>
					</td>
					<td class="mb-0 text-muted">
						<div class="dropdown">
                            <button class="btn btn-sm dropdown-toggle" type="button" id="dr1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                              <span class="text-muted sr-only">Action</span>
                            </button>
                            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="dr1">
								<input class="btn mb-2" type="hidden" id="delete" value="member_delete_ok.jsp?user_id=<%=user_id%>&pageNum=<%=pageNum%>" />
                           		<a class="dropdown-item" href="#" onclick="exitCheck()">탈퇴</a>
                            </div>
                        </div>
					</td>
				</tr>
		<%
			}
		%>
			</table>
			</div>
				<nav aria-label="Table Paging" class="mb-0 text-muted">
		        	<ul class="pagination justify-content-center mb-0">
		        		<%= MemberBean.pageNumber(5,"adminIndex") %>
					</ul>
				</nav>
			</div>
            </div>
          </div>
        </div> <!-- customized table -->
      </div> <!-- end section -->
    </div> <!-- .col-12 -->
  </div> <!-- .row -->
</div> <!-- .container-fluid -->
</body>
</html>