<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String pages = "";
	if(request.getParameter("pages")!=null){
		pages = request.getParameter("pages");		
	} else{
		pages = "faq.jsp";
	}
%>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <title>Tiny Dashboard - A Bootstrap Dashboard Template</title>
  </head>
<body class="vertical  dark  ">
     <div class="row">
       <div class="col-md-12 my-4">
         <h2 class="h4 mb-1">FAQ</h2>
         <br />
         <div class="col-md-12 my-4">
         	<a href="../main/main.jsp">스토어 홈</a>> <a href="../cs_main.jsp">고객센터</a>> FAQ
         </div>
       </div>
     </div>
   	<div class="form-group col-md-4">
		<form method="post" action="faq_main.jsp?pages=faq.jsp">
			<input type="text" name="b_titleS"  aria-label="Recipient's username" aria-describedby="button-addon2" />
			<input class="btn btn-primary" id="button-addon2" type="submit" value="FAQ검색">
		</form>
	</div>
	<jsp:include page="faq.jsp"></jsp:include>
  </body>
</html>