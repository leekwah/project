<%@page import="semiProject.uploadProduct.ProductDBBean"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.net.InetAddress"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="product" class="semiProject.uploadProduct.ProductBean"></jsp:useBean>
<jsp:setProperty property="*" name="product"/>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>up load file</title>
</head>
<body>
	<%
		String path = request.getRealPath("upload");
			String realfolder = "C:\\jsp_project\\semiProject\\WebContent\\img";
			
			int size = 3000*3000;
			int fileSize = 0;
			String file = "";
			String oriFile = "";
			
			MultipartRequest multi = new MultipartRequest(request, realfolder, size, "UTF-8", new DefaultFileRenamePolicy());
			
			Enumeration files = multi.getFileNames();
			String str = (String) files.nextElement();
			file = multi.getFilesystemName(str);
			
			if(file != null) {
		oriFile = multi.getOriginalFileName(str);
		fileSize = file.getBytes().length;
			}
			
			InetAddress address = InetAddress.getLocalHost();
			String ip = address.getHostAddress();
			
			product.setCategory_code(multi.getParameter("category_code"));
			product.setProduct_name(multi.getParameter("product_name"));
			product.setProduct_price(Integer.parseInt(multi.getParameter("product_price")));
			product.setProduct_stock(Integer.parseInt(multi.getParameter("product_stock")));
			product.setProduct_desc(multi.getParameter("product_desc"));
			product.setProduct_date(new Timestamp(System.currentTimeMillis()));
			
			if(file != null) {
		product.setStored_file_name(file);
		product.setFile_size(fileSize);
		product.setOrgin_file_name(oriFile);
		product.setCreate_date(new Timestamp(System.currentTimeMillis()));
			}
			
			ProductDBBean updb = ProductDBBean.getInstance();
			int re = updb.insertUploadProduct(product);
			
			if(re == 1){
		response.sendRedirect("myUploadProduct_List.jsp");
			}else{
		response.sendRedirect("uploadProduct.html");
			}
	%>
</body>
</html>