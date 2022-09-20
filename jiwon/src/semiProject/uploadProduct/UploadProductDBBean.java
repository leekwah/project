package semiProject.uploadProduct;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
	
	public int insertUploadProduct(UploadProductBean product) throws Exception {
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
}
