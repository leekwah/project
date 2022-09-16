package magic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDBBean {
	private static MemberDBBean instance = new MemberDBBean();
	
	public static MemberDBBean getInstance() {
		return instance;
	}
	
	public Connection getConnection() throws Exception {
		Context ctx = new InitialContext(); 
		DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle");
		
		return ds.getConnection();  
	}
	public int insertMember(MemberBean member) throws Exception {
		int re=-1;
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql="INSERT INTO USER_TABLE VALUES(?,?,?,?,?,?,?)";

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql); 
			
			pstmt.setString(1, member.getUser_id());
			pstmt.setString(2, member.getUser_pwd());
			pstmt.setString(3, member.getUser_name());
			pstmt.setString(4, member.getUser_phone());
			pstmt.setString(5, member.getUser_email());
			pstmt.setString(7, member.getUser_addr());
			pstmt.setString(8, member.getUser_grade());
			pstmt.executeUpdate();
			
			re=1; 
			
		}catch(SQLException ex){
			System.out.println("등록실패");
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
	
	public int confirmID(String id) throws Exception {  
		int re=-1; 
		Connection conn=null; 
		PreparedStatement pstmt=null;  
		ResultSet rs=null;
		
		String sql="SELECT USER_ID FROM USER_TABLE WHERE USER_ID = ?"; 
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql); 
			pstmt.setString(1, id); 
			rs = pstmt.executeQuery(); 
									  
			if (rs.next()) { 
				re=1;
			}else { 
				re=-1;
			}
		}catch(SQLException ex){ 
			System.out.println("등록실패");
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
		
		return re;
	}
	
	public int userCheck(String id, String pwd) throws Exception{
		int re=-1;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String db_mem_pwd;
		String sql="SELECT USER_PWD FROM USER_TABLE WHERE USER_ID = ?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery(); 

			if (rs.next()) {
				db_mem_pwd = rs.getString("USER_PWD");
				if (db_mem_pwd.equals(pwd)) { 
					re=1;
				}else { 
					re=0;
				}
			}else { 
				re=-1;
			}
		}catch(SQLException ex){
			System.out.println("등록실패");
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
		
		return re;
	}
	
	public MemberBean getMember(String id) throws Exception{
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="SELECT USER_ID, USER_PWD, USER_NAME, USER_PHONE, USER_EMAIL, USER_ADDR, USER_GRADE\r\n" + 
				"FROM USER_TABLE WHERE USER_ID = ?";
		MemberBean member=null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery(); 

			if (rs.next()) { // ���̵� ��ġ�ϴ� �ο� ����
				member = new MemberBean();
				member.setUser_id(rs.getString("user_id"));
				member.setUser_pwd(rs.getString("user_pwd"));
				member.setUser_name(rs.getString("user_name"));
				member.setUser_phone(rs.getString("user_phone"));
				member.setUser_email(rs.getString("user_email"));
				member.setUser_addr(rs.getString("user_addr"));
				member.setUser_grade(rs.getString("user_grade"));
			}
		}catch(SQLException ex){
			System.out.println("등록실패");
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
		
		return member;
	}
	
	public int updateMember(MemberBean member) throws Exception {
		int re=-1;
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql="UPDATE USER_TABLE SET USER_PWD=?, USER_EMAIL=?, USER_ADDR=? "
				+ "WHERE USER_ID=?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, member.getUser_pwd());
			pstmt.setString(2, member.getUser_email());
			pstmt.setString(3, member.getUser_addr());
			pstmt.setString(4, member.getUser_id());
			re = pstmt.executeUpdate();
			
			System.out.println("@@@### re ===>"+re);
			
			System.out.println("등록실패");

		}catch(SQLException ex){
			System.out.println("등록실패");
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















