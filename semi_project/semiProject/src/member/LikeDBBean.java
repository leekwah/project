package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class LikeDBBean {
	private static LikeDBBean instance = new LikeDBBean();

	public static LikeDBBean getInstance() {
		// 媛믪쓣 �엯�젰諛쏅뒗 硫붿냼�뱶
		return instance; // BoardDBBean�쓽 媛앹껜瑜� �엯�젰諛쏆쓬.

	}

	public static Connection getConnection() throws Exception {
		// 荑쇰━�옉�뾽 �궗�슜�븷 Connection媛앹껜 由ы꽩�븯�뒗 硫붿냼�뱶
		// �뵲濡쒕쭔�뱺 �씠�쑀 -> �뿬�윭踰� �궗�슜�븯湲� �쐞�빐�꽌

		Context ctx = new InitialContext();
		DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle");
		return ds.getConnection();
	}
	
	public ArrayList<LikeBean> likeList(String id) throws Exception{
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<LikeBean> likeList = new ArrayList<LikeBean>();
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			String sql2 = "select * from user_like where user_id =";
			String sql3 = "and product_like = 1";
			String sql = sql2+"'"+id+"' "+sql3;
			System.out.println("sql==================="+sql);
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				
				LikeBean like = new LikeBean();
				
				like.setUser_id(rs.getString(1));
				like.setProduct_number(rs.getInt(2));
				like.setProduct_like(rs.getString(3));
				like.setProduct_name(rs.getString(4));
				like.setProduct_price(rs.getInt(5));
				like.setFile_number(rs.getInt(6));
				likeList.add(like);
				
			}

		}catch(SQLException ex){
			System.out.println("�뿰寃� �떎�뙣");
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
		
		return likeList;
	}
	
	public static int updateLike(String u_id, int p_number, String p_name, int p_price, int f_name) throws Exception {
        //媛믪쓣 異붽��븯�뒗 硫붿냼�뱶
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		String sql = "";
		
		try {
			con = getConnection();
			
			sql = "insert into user_table"
					+ " values(?,?,1,?,?,?)";
			pstmt = con.prepareStatement(sql);
			//pstmt瑜� �뿰寃�
			pstmt.setString(1, u_id);
			pstmt.setInt(2, p_number);
			pstmt.setString(3, p_name);
			pstmt.setInt(4, p_price);
			pstmt.setInt(5, f_name);
			
			pstmt.executeUpdate();

			System.out.println("like �벑濡�");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("like �떎�뙣");
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		return 1;
	}
	
	public int deleteLike(String user_id, int product_number) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;

		int re=-1;
		String sql;
		try {
			conn = getConnection();
			
			sql = "DELETE FROM PRODUCT_LIKE WHERE USER_ID = ? AND PRODUCT_NUMBER AND PRODUCT_LIKE = 1";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, user_id);
			pstmt.setInt(2, product_number);
			pstmt.executeUpdate();
			
			System.out.println("like �빐�젣");
			
		}catch(SQLException ex){
			System.out.println("蹂�寃� �떎�뙣");
			ex.printStackTrace();
		}finally{
			try{
				if(pstmt != null)pstmt.close();
				if(conn != null)conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return re;
	}
	
	public int likeCheck(String user_id, int product_number) throws Exception {
		  Connection con = null;
		  PreparedStatement pstmt = null;
		  ResultSet rs = null;
		  String sql = "select product_like from product_like where user_id and product_number = ?";
		  String db_user_like;
		  int re = -1;

		  try {
		   con = getConnection();
		   pstmt = con.prepareStatement(sql);
		   pstmt.setString(1, user_id);
		   pstmt.setInt(2, product_number);
		   rs = pstmt.executeQuery();

		   if(rs.next()) {
		    db_user_like = rs.getString("product_like");
		    
		    if (db_user_like.equals("1"))
		     re = -1;
		    else
		     re = 0;
		     
		   } else {
		    re = -1;
		   }
		  } catch(Exception e) {
		   System.out.println(e.getMessage()); 
		  }

		  rs.close();
		  pstmt.close();
		  con.close();

		  return re;
	 }
	 
}
