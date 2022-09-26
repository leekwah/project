package product;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/*
 * UploadProductBean占쏙옙 占신곤옙占쏙옙占쏙옙占쏙옙 upbd占쏙옙 占쏙옙占쏙옙
 * UploadProudctDBBean占쏙옙 占신곤옙占쏙옙占쏙옙占쏙옙 updb占쏙옙 占쏙옙占쏙옙
 * */

public class ProductDBBean {
	private static ProductDBBean instance = new ProductDBBean();
	
	// UploadProductDBBean 占쏙옙체 占쏙옙占쏙옙
	public static ProductDBBean getInstance() {
		return instance;
	}
	
	//db占쏙옙占쏙옙
	public static Connection getConnection() throws Exception {
		// 占쏙옙占쏙옙占쌜억옙 占쏙옙占쏙옙占� Connection占쏙옙체 占쏙옙占쏙옙占싹댐옙 占쌨소듸옙
		// 占쏙옙占싸몌옙占쏙옙 占쏙옙占쏙옙 -> 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙歐占� 占쏙옙占쌔쇽옙

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
		int fileNumber;
		int productNumber;
		try {
			conn = getConnection();
			sql = "select max(product_number) from product";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				productNumber = rs.getInt(1)+1;
			} else {
				productNumber = 1;
			}
			sql="INSERT INTO product VALUES(?,?,?,?,?,?,?,0)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, productNumber);
			pstmt.setString(2, product.getCategory_code());
			pstmt.setString(3, product.getProduct_name());
			pstmt.setInt(4, product.getProduct_price());
			pstmt.setInt(5, product.getProduct_stock());
			pstmt.setString(6, product.getProduct_desc());
			pstmt.setTimestamp(7, product.getProduct_date());
			//pstmt.setInt(8, product.getProduct_ordered_count());
			pstmt.executeUpdate();
			
			if(product.getOrgin_file_name() !=null) {
				
				sql = "select max(FILE_NUMBER) from product_imagefile";
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				if (rs.next()) {
					fileNumber = rs.getInt(1)+1;
				} else {
					fileNumber = 1;
				}
				sql="INSERT INTO product_imagefile VALUES(?,?,?,?,?,?,sysdate)";
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, fileNumber);
				pstmt.setInt(2, productNumber);
				pstmt.setString(3, product.getOrgin_file_name());
				pstmt.setString(4, product.getStored_file_name());
				pstmt.setString(5, product.getStored_thumbnail());
				pstmt.setInt(6, product.getFile_size());
				/* pstmt.setTimestamp(7, product.getCreate_date()); */
				pstmt.executeUpdate();
			} else {
				sql="INSERT INTO product_imagefile VALUES(0,?,null,null,null,0,sysdate)";
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, productNumber);
				pstmt.executeUpdate();
			}
			
			re=1;
			
		}catch(SQLException ex){
			System.out.println("占쌩곤옙 占쏙옙占쏙옙");
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
				dbCount = pageSet.getInt(1); // 占쏙옙 占쏙옙 占쏙옙占쏙옙
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
			System.out.println("占쏙옙회 占쏙옙占쏙옙");
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
				upbd.setStored_thumbnail(rs.getString("stored_thumbnail"));
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
			System.out.println("占쏙옙회 占쏙옙占쏙옙");
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

	public int updateProduct(ProductBean upbd) throws Exception{
		int re=-1;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="";
		
		try {
			conn = getConnection();
			
			sql = "UPDATE product SET CATEGORY_CODE=?, PRODUCT_NAME=?\r\n" + 
					"     , PRODUCT_PRICE=?, PRODUCT_STOCK=?, PRODUCT_DESC=?\r\n" + 
					"     , PRODUCT_DATE=SYSDATE\r\n" + 
					"  WHERE PRODUCT_NUMBER=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, upbd.getCategory_code());
			pstmt.setString(2, upbd.getProduct_name());
			pstmt.setInt(3, upbd.getProduct_price());
			pstmt.setInt(4, upbd.getProduct_stock());
			pstmt.setString(5, upbd.getProduct_desc());
			pstmt.setInt(6, upbd.getProduct_number());
			pstmt.executeUpdate();
			// 占쏙옙품 占쏙옙占쏙옙 占쏙옙 占쏙옙占쏙옙占쏙옙 占쌕뀐옙 占쏙옙 占쌍억옙 占쏙옙占쏙옙占쏙옙 占쌩곤옙
			sql = "UPDATE product_imagefile SET ORGIN_FILE_NAME=?,STORED_FILE_NAME=?\r\n" + 
					"     , STORED_THUMBNAIL=?, FILE_SIZE=?, CREATE_DATE=SYSDATE\r\n" + 
					"  WHERE PRODUCT_NUMBER=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, upbd.getOrgin_file_name());
			pstmt.setString(2, upbd.getStored_file_name());
			pstmt.setString(3, upbd.getStored_thumbnail());
			pstmt.setInt(4, upbd.getFile_size());
			pstmt.setInt(5, upbd.getProduct_number());
			pstmt.executeUpdate();
			
			re=1;
			
		}catch(SQLException ex){
			System.out.println("占쏙옙占쏙옙 占쏙옙占쏙옙");
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
	
	public int deleteProduct(int product_number) throws Exception {
		int re=-1;
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql="";
		
		try {
			conn = getConnection();
			
			sql = "DELETE PRODUCT WHERE product_number=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, product_number);
			pstmt.executeUpdate();
			
			sql = "DELETE PRODUCT_IMAGEFILE WHERE product_number=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, product_number);
			pstmt.executeUpdate();
			re=1;
			System.out.println("占쏙옙占쏙옙 占쏙옙占쏙옙");
		}catch(SQLException ex){
			System.out.println("占쏙옙占쏙옙 占쏙옙占쏙옙");
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
	public ProductBean getCount(int product_number) throws Exception{
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
				upbd.setStored_thumbnail(rs.getString("stored_thumbnail"));
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
	public ProductBean productCount() throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT COUNT(*) FROM product";
		ProductBean upbd = new ProductBean();
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				upbd.setCount(rs.getInt(1));
			}
			
			sql = "SELECT COUNT(*) FROM product WHERE PRODUCT_STOCK=0";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				upbd.setNoStock(rs.getInt(1));
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
	
}