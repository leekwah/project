<%@page import="java.io.File"%>
<%@page import="goods.GoodsBean"%>
<%@page import="goods.GoodsDBBean"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file= "../main/main.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
    Path = request.getRealPath("upload");
%>
<%


	String pageNum = request.getParameter("pageNum");

	if(pageNum == null){
		pageNum = "1";
	}
  	category_code = request.getParameter("category");

	String goods = null;
	
	if(category_code.equals("1") || category_code.equals("상의")){
		goods = "상의";
		category_code = "상의";
	}else if(category_code.equals("2")  || category_code.equals("하의")){
		goods = "하의";
		category_code = "하의";
	}else if(category_code.equals("3")  || category_code.equals("신발")){
		goods = "신발";
		category_code = "신발";
	}
	GoodsDBBean productdb = new GoodsDBBean();
	ArrayList<GoodsBean> CategoryProductList = productdb.getCategoryProductList(category_code,"1");
	
//필요없어서 주석처리-0502근지 	ArrayList<GoodsBean> productlistArr  =  productdb.getProductimg(CategoryProductList);
 	int j = 0;
 	int size = 0;
 	if(CategoryProductList.size()%4 != 0){
 		size = CategoryProductList.size()/4+1 ;
 	}else{
 		size = CategoryProductList.size()/4;
 	} 
 	
 	// 베스트상품 4개를 얻어오기 위해	-0429근지
	ArrayList<GoodsBean> CategoryProductList_best = productdb.getCategoryProductList_best(category_code,"1");
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>