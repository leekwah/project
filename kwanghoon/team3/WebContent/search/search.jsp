<%@page import="goods.GoodsBean"%>
<%@page import="goods.GoodsDBBean"%>
<%@page import="java.util.ArrayList"%>

<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%@include file= "../main/mainClass.jsp"%>
<jsp:include page="../main/mainHeader.jsp"></jsp:include> 	
<body>
<link rel="stylesheet" href="./../css/main.css" type = "text/css">



<nav class="nav2" style="max-width : 1280px; min-width : 1120px; margin: auto;" >
	
	<nav style="--bs-breadcrumb-divider: '>'; float: right;" aria-label="breadcrumb" class="nav2div">
	  <ul class="breadcrumb ">
	    <li class="breadcrumb-item"><a href="../main/main.jsp">home</a></li>
	    <li class="breadcrumb-item active" aria-current="page">전체</li>
	  </ul>
	</nav>
		
		<div style="clear: both; font-size: large; color: black;">
			전체
		</div>
		<div class="d-flex justify-content-between"  style="clear: both;  margin-top: 35px; padding-bottom: 10px; border-bottom: 1px rgba(0, 0, 0, 0.09) solid">
			<div class="nav navbox" >
				검색결과
			</div>
			<div class="nav justify-content-end ulbox">
				판매순
			</div>
		</div>
	</nav>


<%
	 path = request.getRealPath("upload");
	request.setCharacterEncoding("UTF-8");

	String  searchtext = request.getParameter("searchtext");
	GoodsDBBean productdb = GoodsDBBean.getInstance();
	//System.out.println("검색한내용"+searchtext);
	
	if(productdb.getsearch(searchtext).size()==0){
		
		%>
		<script>
			location.href ="../main/main.jsp?searchCheck=false";
		 	<%-- location.href ="../main/main.jsp?searchCheck=false&searchtext=<%=searchtext%>"; --%>
		</script>
		<%
		//response.sendRedirect("../main/main.jsp?searchCheck=true");
	}else{

  	ArrayList<GoodsBean> productSearchlistArr  =  productdb.getsearch(searchtext);
	ArrayList<GoodsBean> productlistArr  =  productdb.getProductimg(productSearchlistArr);
	
	int j = 0;
 	int size = 0;
 	if(productlistArr.size()%4 != 0){
 		size = productlistArr.size()/4+1 ;
 	}else{
 		size = productlistArr.size()/4;
 	}
 %>
 
	<div class="goods">
<%
     	
     	out.print("<table>");
     	//번for 문
     	for(int i=0; i<size; i++){
     		out.print("<tr>");
     		int num =i*4;
     		//2번 for 문
     
     		for(j=0+num; j<=3+num; j++){
     			if(productlistArr.size()==j) break;
     		
				
				
				
     			product_number= productSearchlistArr.get(j).getProduct_number();
     			category_code = productSearchlistArr.get(j).getCategory_code();
     			product_name = productSearchlistArr.get(j).getProduct_name();
     			product_price =productSearchlistArr.get(j).getProduct_price();
     			product_stock = productSearchlistArr.get(j).getProduct_stock();
     			product_desc = productSearchlistArr.get(j).getProduct_desc();
     			product_hits = productSearchlistArr.get(j).getProduct_hits();
     			//System.out.println("상품이름은???"+product_name);
				
     			
     			file_number =productlistArr.get(j).getFile_number();
     			orgin_file_name = productlistArr.get(j).getOrgin_file_name();
     			stored_file_name = productlistArr.get(j).getStored_file_name();
     			stored_thumbnail = productlistArr.get(j).getStored_thumbnail();
     			delegate_thumbnail =productlistArr.get(j).getDelegate_thumbnail();
     			file_size = productlistArr.get(j).getFile_size();
     			create_date = productlistArr.get(j).getCreate_date();
     			delete_check = productlistArr.get(j).getDelete_check();
				
				String orgin_file_namearr[] = orgin_file_name.split("/");
				String stored_file_namearr[] = stored_file_name.split("/");
				//파일존재확인
				File file = new File(path+"\\"+stored_file_namearr[0]);
				boolean isExists = file.exists();
			/* 	if(isExists) { System.out.println("I find the existFile.txt"); } 
				else { System.out.println("No, there is not a no file."); } */
%>
 				
				   <td>
						<table>
							<tr>
								<td class="mainalinkimg">
									<%if(isExists){%>
									 <a href="./../cart/goodsDisplay.jsp?product_number=<%=product_number%>">
										<img src="<%= request.getContextPath() %><%= File.separator %>upload<%= File.separator %><%=stored_file_namearr[0]%>"  alt="이미지없음">
									 </a>
									<%}else{%>
									  <a href="./../cart/goodsDisplay.jsp?product_number=<%=product_number%>">
										<img src="../images/products/noimg.png"  alt="이미지없음">
									  </a>
									<%}%>
								</td>
							</tr>
							<tr  style = "cursor:pointer;" onclick="location.href='../cart/goodsDisplay.jsp?product_number=<%=product_number%>'">
								 	<td style="border-bottom: 1px rgba(0, 0, 0, 0.09) solid; line-height: 30px;">	
								 			<%=product_name %>
								 	</td>
							</tr>
							<tr>
								<td style="color: rgb(0, 139, 204); line-height: 15px;">판매가 :<%=product_price%> won</td>
							</tr>
						</table>
					</td>
	 	   
	 	
<%

     		}
     		out.print("</tr>");
     	}
     	out.print("</table>");
%>
    </div>
 	


<% 
}
%>
<jsp:include page="../main/mainfooter.jsp"></jsp:include>
</body>
</html>