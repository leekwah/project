<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="cs.QnABoardBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="cs.FAQDBBean"%>
<%@page import="cs.QnABoardDBBean"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<jsp:useBean class="cs.QnABoardBean" id="board"></jsp:useBean><!-- 객체 생성 -->
<jsp:useBean class="cs.QnABoardBean" id="board2"></jsp:useBean><!-- 객체 생성 -->
<%
	//아래에 사용할 변수들
	int b_id,b_view, b_level, b_fsize;
	String b_category, u_id, b_title, b_content, b_pwd, b_secret, b_anschk;
	Timestamp b_date;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	String b_titleSearch = "";
	int b_categorySearch = 0;
	String[] category = {"","회원정보", "상품문의", "주문/결제", "배송", "교환/취소", "서비스"};
	
	if(request.getParameter("b_titleS")!=null){
		b_titleSearch = request.getParameter("b_titleS");		
	}
	if(request.getParameter("b_categoryS")!=null){
		b_categorySearch = Integer.parseInt(request.getParameter("b_categoryS"));
	}
	
	//객체생성 및 객체 배열
	FAQDBBean faqdbBean = FAQDBBean.getInstance();
	ArrayList<QnABoardBean> list = faqdbBean.listBoardFAQ(b_titleSearch,category[b_categorySearch]);
%>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
		<h3>자주 묻는 질문 FAQ</h3>
		<form method="post" action="FAQ.jsp">
			<input type="text" name="b_titleS">
			<input type="submit" value="FAQ검색">
		</form>
		<input type="radio" name="category" id="001" onclick="location.href='?page=FAQ.jsp&b_categoryS=1'" style="display: none;">
		<input type="radio" name="category" id="002" onclick="location.href='?page=FAQ.jsp&b_categoryS=2'" style="display: none;">
		<input type="radio" name="category" id="003" onclick="location.href='?page=FAQ.jsp&b_categoryS=3'" style="display: none;">
		<input type="radio" name="category" id="004" onclick="location.href='?page=FAQ.jsp&b_categoryS=4'" style="display: none;">
		<input type="radio" name="category" id="005" onclick="location.href='?page=FAQ.jsp&b_categoryS=5'" style="display: none;">
		<input type="radio" name="category" id="006" onclick="location.href='?page=FAQ.jsp&b_categoryS=6'" style="display: none;">
		<label for="001">회원정보</label>
		<label for="002">상품확인</label>
		<label for="003">주문/결제</label>
		<label for="004">배송</label>
		<label for="005">교환/취소</label>
		<label for="006">서비스</label>
		<table border="1">
			<tr>
				<!-- <td>글번호</td> -->
				<td>분류</td>
				<td>제목</td>
				<!-- <td>작성자</td>
				<td>작성일</td> -->
			</tr>
		<%
			for(int i=0;i<list.size();i++){
				board = list.get(i);
				
				b_id=board.getB_id();
				
				u_id=board.getU_id();
				b_category=board.getB_category();
				b_pwd=board.getB_pwd();
				b_title= board.getB_title();
				b_date= board.getB_date();
				b_view= board.getB_view();
				b_level = board.getB_level();
				b_fsize = board.getB_fsize();
				b_secret = board.getB_secret();
				
		%>
			<tr><!-- 조회순 20개의 질문글 -->
				<%-- <td><%= b_id %></td> --%>
				<td><%= b_category %></td>
				<td><%= b_title %></td>
				<%-- <td><%= u_id %></td>
				<td><%= sdf.format(b_date) %></td> --%>
			</tr>
			<tr><!-- 위의 질문글에 대한 답변 -->
		<%
				
				board2 = faqdbBean.getBoardFAQ(b_id, false);
		
				b_id=board2.getB_id();
				u_id=board2.getU_id();
				b_category=board2.getB_category();
				b_pwd=board2.getB_pwd();
				b_title= board2.getB_title();
				b_date= board2.getB_date();
				b_view= board2.getB_view();
				b_level = board2.getB_level();
				b_fsize = board2.getB_fsize();
				b_secret = board2.getB_secret();
		
		%>
				<%-- <td><%= b_id %></td> --%>
				<td><%= b_category %></td>
				<td><%= b_title %></td>
				<%-- <td><%= u_id %></td>
				<td><%= sdf.format(b_date) %></td> --%>
			</tr>
		<% 
			}
		%>
		</table>
</body>
</html>