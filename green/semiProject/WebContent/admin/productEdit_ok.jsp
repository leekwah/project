<%@page import="net.coobird.thumbnailator.Thumbnails"%>
<%@page import="javax.media.jai.JAI"%>
<%@page import="javax.media.jai.RenderedOp"%>
<%@page import="javax.imageio.ImageIO"%>
<%@page import="java.io.File"%>
<%@page import="java.awt.Graphics2D"%>
<%@page import="java.awt.image.BufferedImage"%>
<%@page import="java.awt.image.renderable.ParameterBlock"%>
<%@page import="product.ProductBean"%>
<%@page import="product.ProductDBBean"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			String pageNum = request.getParameter("pageNum");
			int productNumber = Integer.parseInt(request.getParameter("productNum"));
			
			ProductBean pBean = new ProductBean();
			//String imgFolder = "C:/study/space_jsp/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/img";
			String path = request.getRealPath("img");
			int size = 1024*1024*10; // 10MB로 크기 제한
			int fileSize = 0;
			String file = "";
			String oriFile = "";
			
			MultipartRequest multi = new MultipartRequest(request, path, size, "UTF-8", new DefaultFileRenamePolicy());
			
			Enumeration files = multi.getFileNames();
			String str = (String) files.nextElement();
			file = multi.getFilesystemName(str);
			
			if(file != null) {
				oriFile = multi.getOriginalFileName(str);
				fileSize = file.getBytes().length;
			}
			pBean.setProduct_number(productNumber);
			pBean.setCategory_code(multi.getParameter("category_code"));
			pBean.setProduct_name(multi.getParameter("product_name"));
			pBean.setProduct_price(Integer.parseInt(multi.getParameter("product_price")));
			pBean.setProduct_stock(Integer.parseInt(multi.getParameter("product_stock")));
			pBean.setProduct_desc(multi.getParameter("product_desc"));
			pBean.setProduct_date(new Timestamp(System.currentTimeMillis()));
			
			if(file != null) {
				File fileIO = new File(path,oriFile);
			    Thumbnails.of(new File(path,oriFile)).forceSize(100, 100).toFile(new File(path,"/sm_"+file));
				
				pBean.setStored_file_name(file);
				pBean.setFile_size(fileSize);
				pBean.setOrgin_file_name(oriFile);
				pBean.setStored_thumbnail("sm_"+file);
				pBean.setCreate_date(new Timestamp(System.currentTimeMillis()));
			}
			
			ProductDBBean updb = ProductDBBean.getInstance();
			int re = updb.updateProduct(pBean);
			
			if(re == 1){
		%>
				<script type="text/javascript">
					alert("상품이 수정되었습니다.");
					location.href="adminIndex.jsp?pages=productList&pageNum=<%= pageNum %>";
				</script>
		<%		
			}else{
		%>
				<script type="text/javascript">
					alert("상품 수정에 실패했습니다.");
					history.go(-1);
				</script>
		<%		
			}
	%>
</body>
</html>