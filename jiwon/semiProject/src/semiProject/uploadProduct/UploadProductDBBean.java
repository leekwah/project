package semiProject.uploadProduct;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class UploadProductDBBean {
	private static UploadProductDBBean instance = new UploadProductDBBean();
	
	// UploadProductDBBean 객체 생성
	public static UploadProductDBBean getInstance() {
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
	
	public int insertUploadProduct(UploadProductBean product, boolean stored_thumbnail) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		int product_number = 0;
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		int re = -1;
		int file_number = 0;
		
		try {
			conn = getConnection();
			sql = "select MAX(product_number) from product";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				product_number = rs.getInt(1);
			}else {
				product_number = 0;
			}
			
			if(stored_thumbnail == false) {
				sql = "INSERT IN TO PRODUCT VALUES(?,?,?,?,?,?,?,?,?)";
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, product_number);
				pstmt.setString(2, product.getCategory_code());
				pstmt.setString(3, product.getProduct_name());
				pstmt.setInt(4, product.getProduct_price());
				pstmt.setInt(5, product.getProduct_stock());
				pstmt.setString(6, product.getProduct_desc());
				pstmt.setTimestamp(7, timestamp);
				pstmt.setInt(8, 0);
				pstmt.setInt(9, 0);
				
				re = pstmt.executeUpdate(); 
				
				sql = "INSERT INTO PRODUCT_IMAGEFILE(file_number,product_number"
						+ ",orgin_file_name"
						+ ",stored_file_name"
						+ ",create_date) VALUES (?,?,?,?,?)";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, product_number) ;
				pstmt.setInt(2, product_number);
				pstmt.setString(3, product.getOrgin_file_name());
				pstmt.setString(4, product.getStored_file_name());
				pstmt.setTimestamp(5, timestamp);
				re = pstmt.executeUpdate(); 
				re = 1;
			}else {
				if(product_number == 0) {
					product_number = 1;
				}
				sql = "SELECT MAX(FILE_NUMBER) FROM PRODUCT_IMAGEFILE";
				
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					file_number = rs.getInt(sql);
				}else {
					file_number = 0;
				}
				file_number=file_number+1;
				
				sql = "INSERT INTO PRODUCT_IMAGEFILE(file_number,product_number"
						+ ",orgin_file_name"
						+ ",stored_file_name"
						+ ",create_date) VALUES (?,?,?,?,?)";
				
				pstmt = conn.prepareStatement(sql);
				  pstmt.setInt(1, product_number) ;
				  pstmt.setInt(2, product_number);
				  pstmt.setString(3, product.getOrgin_file_name());
				  pstmt.setString(4, product.getStored_file_name());
				  pstmt.setTimestamp(5, timestamp);
				  re = pstmt.executeUpdate(); 				
			}
			System.out.println("추가 성공"); 
		  } catch(Exception e) {
		  System.out.println("추가 실패");
		  	e.printStackTrace(); 
		  } finally {
			  if(pstmt!=null) pstmt.close(); 
			  if(conn!=null) conn.close(); 
		  }
		
		return re;
	}
}
