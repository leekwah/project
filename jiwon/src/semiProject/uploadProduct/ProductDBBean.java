package semiProject.uploadProduct;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/*
 * UploadProductBean의 매개변수는 upbd로 통일
 * UploadProudctDBBean의 매개변수는 updb로 통일
 * */

public class ProductDBBean {
	private static ProductDBBean instance = new ProductDBBean();
	
	// UploadProductDBBean 객체 생성
	public static ProductDBBean getInstance() {
		return instance;
	}
	
	//db연결
	public static Connection getConnection() throws Exception {
		// 쿼리작업 사용할 Connection객체 리턴하는 메소드
		// 따로만든 이유 -> 여러번 사용하기 위해서

		Context ctx = new InitialContext();
		DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle");
		return ds.getConnection();
	}
	
	public int insertUploadProduct(ProductBean product) throws Exception {
		int re=-1;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="";
		int number;
		
		try {
			conn = getConnection();
			sql = "select max(product_number) from product";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				number = rs.getInt(1)+1;
			} else {
				number = 1;
			}
			
			System.out.println("@@@### number ===>"+number);
			System.out.println("@@@### product.getProduct_name() ===>"+product.getProduct_name());
			System.out.println("@@@### product.getProduct_price() ===>"+product.getProduct_price());
			System.out.println("@@@### product.getProduct_stock() ===>"+product.getProduct_stock());
			System.out.println("@@@### board.getB_content() ===>"+product.getProduct_desc());
			System.out.println("@@@### board.getB_date() ===>"+product.getProduct_date());
			
			sql="INSERT INTO product VALUES(?,?,?,?,?,?,?,0)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, number);
			pstmt.setString(2, product.getCategory_code());
			pstmt.setString(3, product.getProduct_name());
			pstmt.setInt(4, product.getProduct_price());
			pstmt.setInt(5, product.getProduct_stock());
			pstmt.setString(6, product.getProduct_desc());
			pstmt.setTimestamp(7, product.getProduct_date());
			//pstmt.setInt(8, product.getProduct_ordered_count());
			pstmt.executeUpdate();
			
			sql="INSERT INTO product_imagefile VALUES(?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, number);
			pstmt.setInt(2, number);
			pstmt.setString(3, product.getOrgin_file_name());
			pstmt.setString(4, product.getStored_file_name());
			pstmt.setInt(5, product.getFile_size());
			pstmt.setTimestamp(6, product.getCreate_date());
			pstmt.executeUpdate();
			
			re=1;
			
		}catch(SQLException ex){
			System.out.println("추가 실패");
			ex.printStackTrace();
		}finally{
			try{
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		return re;
	}
	
	public ArrayList<ProductBean> productList(String pageNumber) throws Exception {
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		ResultSet pageSet=null;
		int dbCount = 0;
		int absolutePage = 1;
		
		String sql = "SELECT product_number \r \n"
				+ ",product_name \r \n"
				+ ",product_price \r \n"
				+ ",category_code \r \n"
				+ ",product_stock \r \n"
				+ ",product_date \r \n"
				+ "FROM PRODUCT \r \n"
				+ "ORDER BY product_number ASC";
		String sql2 = "SELECT COUNT(product_number) from product";

		ArrayList<ProductBean> productList = new ArrayList<ProductBean>();
		
		try {
			conn = getConnection();
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			
			pageSet = stmt.executeQuery(sql2);
			
			if(pageSet.next()) {
				dbCount = pageSet.getInt(1); // 총 글 갯수
				pageSet.close();
			}
			if (dbCount % ProductBean.pageSize == 0) {
				ProductBean.pageCount = dbCount / ProductBean.pageSize;
			}else {
				ProductBean.pageCount = dbCount / ProductBean.pageSize+1;
			}
			if(pageNumber != null) { 
				ProductBean.pageNum = Integer.parseInt(pageNumber);
				absolutePage = (ProductBean.pageNum - 1) * ProductBean.pageSize + 1;
			}
			
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				rs.absolute(absolutePage);
				int count = 0;
				
				while(count < ProductBean.pageSize) {
					ProductBean upbd = new ProductBean();
					
					upbd.setProduct_number(rs.getInt(1));
					upbd.setProduct_name(rs.getString(2));
					upbd.setProduct_price(rs.getInt(3));
					upbd.setCategory_code(rs.getString(4));
					upbd.setProduct_stock(rs.getInt(5));
					upbd.setProduct_date(rs.getTimestamp(6));
					
					productList.add(upbd);
					
					if(rs.isLast()) {
						break;
					}else {
						rs.next();
					}
					count++;
				}
			}
		} catch (SQLException ex) {
			System.out.println("조회 실패");
			ex.printStackTrace();
		}finally{
			try{
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return productList;
	}
	
	public ProductBean getImg(int product_number) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from product_imagefile where product_number=?";
		ProductBean upbd = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, product_number);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				upbd = new ProductBean();
				upbd.setFile_number(rs.getInt("file_number"));
				upbd.setProduct_number(rs.getInt("product_number"));
				upbd.setOrgin_file_name(rs.getString("orgin_file_name"));
				upbd.setStored_file_name(rs.getString("stored_file_name"));
				upbd.setFile_size(rs.getInt("file_size"));
				upbd.setCreate_date(rs.getTimestamp("create_date"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		}
		return upbd;
	}
	//                     pnumber = product_number odercount = product_ordered_count
	public ProductBean getproduct(int pnumber, boolean odercount) throws Exception {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ProductBean upbd = null;
		String sql="";
		

		try {
			conn = getConnection();
			
			if (odercount == true) {
				sql="UPDATE PRODUCT SET product_ordered_count=product_ordered_count+1 from WHERE product_number=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, pnumber);
				pstmt.executeUpdate();
			}
			
			sql = "SELECT product_number \r \n"
					+ ",product_name \r \n"
					+ ",product_price \r \n"
					+ ",category_code \r \n"
					+ ",product_stock \r \n"
					+ ",product_date \r \n"
					+ ",product_ordered_count \r \n"
					+ ",product_desc \r \n"
					+ "FROM PRODUCT  \r \n"
					+ "WHERE product_number=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pnumber);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				upbd = new ProductBean();
				
				upbd.setProduct_number(rs.getInt(1));
				upbd.setProduct_name(rs.getString(2));
				upbd.setProduct_price(rs.getInt(3));
				upbd.setCategory_code(rs.getString(4));
				upbd.setProduct_stock(rs.getInt(5));
				upbd.setProduct_date(rs.getTimestamp(6));
				upbd.setProduct_ordered_count(rs.getInt(7));
				upbd.setProduct_desc(rs.getString(8));
			}
		}catch(SQLException ex){
			System.out.println("조회 실패");
			ex.printStackTrace();
		}finally{
			try{
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		return upbd;
	}
}