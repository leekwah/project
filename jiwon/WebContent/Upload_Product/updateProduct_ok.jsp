<%@page import="semiProject.uploadProduct.ProductDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="upbd" class="semiProject.uploadProduct.ProductBean"></jsp:useBean>
<jsp:setProperty property="*" name="upbd"/>
<%
	String pageNum = request.getParameter("pageNum");
	
	ProductDBBean updb = ProductDBBean.getInstance();
	int re = updb.updateProduct(upbd);
	
	if(re == 1) {
%>
	<script type="text/javascript">
		alert("수정됐습니다.");
	</script>
<%		
		response.sendRedirect("myUploadProduct_List.jsp?pageNum="+pageNum);
	}
%>