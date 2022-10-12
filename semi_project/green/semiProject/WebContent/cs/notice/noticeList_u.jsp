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
</head>
 <body class="vertical  dark  ">
    <div class="wrapper">
        <div class="container-fluid">
          <div class="row justify-content-center">
            <div class="col-12">
              <div class="row">
                <!-- Small table -->
                <div class="col-md-12 my-4">
                  <h2 class="h4 mb-1">공지 사항</h2>
                  <br />
                  <div class="col-md-12 my-4">
                  	<a href="../../main.jsp">스토어 홈</a>> <a href="../cs_main.jsp">고객센터</a>> 공지사항
                  </div>
                  <div class="card shadow">
                    <div class="card-body">
                      <!-- table -->
                      <table class="table table-borderless table-hover">
                      <thead>
					      <tr>
					        <th style="text-align: center;">번호</th>
					        <th style="text-align: center;">글제목</th>
					        <th style="text-align: center;">작성자</th>
					        <th style="text-align: center;">작성일</th>
					        <th style="text-align: center;">조회수</th>
					      </tr>
                        <tr>
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
					<td  align="center"><%= n_num%></td>
					<td  align="center" style="text-align: left">
						<a href="noticeShow.jsp?n_num=<%= n_num %>&pageNum=<%= pageNum %>">
							<%= n_title %>
						</a>
					</td>
					<td  align="center">
						<%= user_id %>
					</td>
					<td  align="center">
						<%= sdf.format(n_date) %>
					</td>
					<td  align="center">
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
				<nav aria-label="Table Paging" class="mb-0 text-muted">
        			<ul class="pagination justify-content-center mb-0">
						<%= NoticeBean.userPageNumber(5) %>
					</ul>
				</nav>
		<%
				}
		%>
						</div>
                  </div>
                </div> <!-- customized table -->
              </div> <!-- end section -->
            </div> <!-- .col-12 -->
          </div> <!-- .row -->
        </div> <!-- .container-fluid -->
    </div> <!-- .wrapper -->
</body>
</html>
</body>
</html>