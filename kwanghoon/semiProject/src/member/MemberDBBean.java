package member;

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

	public static Connection getConnection() throws Exception {

		Context ctx = new InitialContext();
		DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle");
		return ds.getConnection();
	}
	
	// �쑀�� 媛��엯 硫붿냼�뱶
	public static int register(MemberBean member) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "";
		int re = -1;
		
		try {
			sql = "insert into user_table1 values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getUser_id()); //異붽� 
			pstmt.setString(2, member.getUser_pwd()); //異붽� 
			pstmt.setString(3, member.getUser_name()); //異붽� 
			pstmt.setString(4, member.getUser_phone1()); //異붽� 
			pstmt.setString(5, member.getUser_phone2()); //異붽� 
			pstmt.setString(6, member.getUser_phone3()); //異붽� 
			pstmt.setString(7, member.getUser_email()); //異붽� 
			pstmt.setString(8, member.getUser_pcode()); //異붽� 
			pstmt.setString(9, member.getUser_raddr()); //異붽� 
			pstmt.setString(10, member.getUser_jibun()); //異붽� 
			pstmt.setString(11, member.getUser_detailaddr()); //異붽� 
			pstmt.setInt(12, member.getUser_grade()); //異붽� 
			pstmt.setTimestamp(13, member.getUser_regdate());
			pstmt.executeUpdate();
			re = 1;
		} catch (Exception e) {
			e.printStackTrace();
			re=-1;
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		System.out.println("member.getUser_id()====>>" +member.getUser_id());
		System.out.println("member.getUser_pwd()====>>" +member.getUser_pwd());
		System.out.println("member.getUser_name()====>>" +member.getUser_name());
		System.out.println("member.getUser_phone1()====>>" +member.getUser_phone1());
		System.out.println("member.getUser_phone2()====>>" +member.getUser_phone2());
		System.out.println("member.getUser_phone3()====>>" +member.getUser_phone3());
		System.out.println("member.getUser_email()====>>" +member.getUser_email());
		System.out.println("member.getUser_addr()====>>" +member.getUser_pcode());
		System.out.println("member.getUser_addr()====>>" +member.getUser_raddr());
		System.out.println("member.getUser_addr()====>>" +member.getUser_jibun());
		System.out.println("member.getUser_addr()====>>" +member.getUser_detailaddr());
		System.out.println("member.getUser_grade()====>>" +member.getUser_grade());
		return re;
	}
	public int confirmID(String id) throws Exception{
		Connection con =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int re= -1;
		String sql = "select user_id from user_table where user_id =?";
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery(); //sql�쓽 寃곌낵媛�.
		
			if(rs.next()) {
				re =1;
			}
			else {
				re = -1;
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
			return re;
	}
	
	public MemberBean getMember(String id) throws Exception{
		//�븘�씠�뵒媛� �씪移섑븯�뒗 硫ㅻ쾭�쓽 �젙蹂대�� �뼸�뼱�삤�뒗 硫붿냼�뱶
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from user_table where user_id=?";
		MemberBean member = null;
		
		try {	con = getConnection();
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		
		rs = pstmt.executeQuery();
		
		if(rs.next()) {
			member = new MemberBean();
			// 濡쒓렇�씤�븷�븣 �엯�젰�븯�뒗 �븘�씠�뵒瑜� bean�뿉 �꽔�뼱以� 
			member.setUser_id(rs.getString("user_id"));  
			member.setUser_pwd(rs.getString("user_pwd"));  
			member.setUser_name(rs.getString("user_name"));  
			member.setUser_phone1(rs.getString("user_phone1"));  
			member.setUser_phone2(rs.getString("user_phone2"));  
			member.setUser_phone3(rs.getString("user_phone3"));  
			member.setUser_email(rs.getString("user_email"));  
			member.setUser_pcode(rs.getString("user_pcode"));  
			member.setUser_raddr(rs.getString("user_raddr"));  
			member.setUser_jibun(rs.getString("user_jibun"));  
			member.setUser_detailaddr(rs.getString("user_detailaddr"));  
			member.setUser_grade(rs.getInt("user_grade"));  
			member.setUser_regdate(rs.getTimestamp("user_regdate"));
		}
		rs.close();
		pstmt.close();
		con.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return member;
	}
	
	 public int userCheck(String id, String pwd) throws Exception {
		  Connection con = null;
		  PreparedStatement pstmt = null;
		  ResultSet rs = null;
		  String sql = "select user_pwd from user_table where user_id = ?";
		  String db_user_pwd;
		  int re = -1;

		  try {
		   con = getConnection();
		   pstmt = con.prepareStatement(sql);
		   pstmt.setString(1, id);
		   rs = pstmt.executeQuery();

		   if(rs.next()) {
		    db_user_pwd = rs.getString("user_pwd");
		    
		    if (db_user_pwd.equals(pwd))
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
	 
	 public String findId(String user_name, String user_phone1, String user_phone2, String user_phone3)throws Exception {
					
				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				
				
				System.out.println("user_name ====>"+user_name);
				System.out.println("user_phone1 ====>"+user_phone1);
				System.out.println("user_phone2 ====>"+user_phone2);
				System.out.println("user_phone3 ====>"+user_phone3);
				String sql = "SELECT USER_ID FROM USER_TABLE \r\n" + 
						"WHERE USER_NAME = ? and user_phone1 =? and user_phone2 =? and user_phone3 =?";
				String re="";
				try {	
				con = getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, user_name);
				pstmt.setString(2, user_phone1);
				pstmt.setString(3, user_phone2);
				pstmt.setString(4, user_phone3);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					re = rs.getString("user_id");
				} else {
					re = null;
				}

			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				if (rs!=null) rs.close(); 		
				if (pstmt!=null) pstmt.close(); 		
				if (con!=null) con.close(); 		
				
			}
			return re;
	 }
	 
	 public int updateMember(MemberBean member) throws Exception {
			int re=-1;
			Connection conn=null;
			PreparedStatement pstmt=null;
			String sql="UPDATE USER_TABLE SET USER_PWD=?,\r\n" + 
					"                      USER_NAME=?, \r\n" + 
					"                      USER_PHONE1=?, USER_PHONE2=?, USER_PHONE3=?,\r\n" + 
					"                      USER_EMAIL=?,\r\n" + 
					"                      USER_PCODE=?, USER_RADDR=?, USER_JIBUN=?, USER_DETAILADDR=?\r\n" + 
					"                      WHERE USER_ID=?";
			
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				System.out.println("@@@### member.getMem_pwd() ===>"+member.getUser_pwd());
				System.out.println("@@@### member.getMem_name() ===>"+member.getUser_name());
				System.out.println("@@@### member.getMem_phone1() ===>"+member.getUser_phone1());
				System.out.println("@@@### member.getMem_phone2() ===>"+member.getUser_phone2());
				System.out.println("@@@### member.getMem_phone3() ===>"+member.getUser_phone3());
				System.out.println("@@@### member.getMem_email() ===>"+member.getUser_email());
				System.out.println("@@@### member.getMem_pcode() ===>"+member.getUser_pcode());
				System.out.println("@@@### member.getMem_raddr() ===>"+member.getUser_raddr());
				System.out.println("@@@### member.getMem_jibun() ===>"+member.getUser_jibun());
				System.out.println("@@@### member.getMem_detailaddr() ===>"+member.getUser_detailaddr());
				System.out.println("@@@### member.getMem_id() ===>"+member.getUser_id());
				
				pstmt.setString(1, member.getUser_pwd());
				pstmt.setString(2, member.getUser_name());
				pstmt.setString(3, member.getUser_phone1());
				pstmt.setString(4, member.getUser_phone2());
				pstmt.setString(5, member.getUser_phone3());
				pstmt.setString(6, member.getUser_email());
				pstmt.setString(7, member.getUser_pcode());
				pstmt.setString(8, member.getUser_raddr());
				pstmt.setString(9, member.getUser_jibun());
				pstmt.setString(10, member.getUser_detailaddr());
				pstmt.setString(11, member.getUser_id());
				
				re = pstmt.executeUpdate();
				System.out.println("@@@### re ===>"+re);
			}catch(SQLException ex){
				System.out.println("�닔�젙�떎�뙣");
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
	 
	 public MemberBean getMemberByNameAndEmail(String user_name, String user_email) throws Exception{
			
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = "select * from user_table where user_name=? and user_eamil=?";
			MemberBean member = null;
			
			try {	con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user_name);
			pstmt.setString(2, user_email);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member = new MemberBean();
				// 濡쒓렇�씤�븷�븣 �엯�젰�븯�뒗 �븘�씠�뵒瑜� bean�뿉 �꽔�뼱以� 
				member.setUser_id(rs.getString("user_id"));  
				member.setUser_pwd(rs.getString("user_pwd"));  
				member.setUser_name(rs.getString("user_name"));  
				member.setUser_phone1(rs.getString("user_phone1"));  
				member.setUser_phone2(rs.getString("user_phone2"));  
				member.setUser_phone3(rs.getString("user_phone3"));  
				member.setUser_email(rs.getString("user_email"));  
				member.setUser_pcode(rs.getString("user_pcode"));  
				member.setUser_raddr(rs.getString("user_raddr"));  
				member.setUser_jibun(rs.getString("user_jibun"));  
				member.setUser_detailaddr(rs.getString("user_detailaddr"));  
				member.setUser_grade(rs.getInt("user_grade"));  
				member.setUser_regdate(rs.getTimestamp("user_regdate"));
			}
			rs.close();
			pstmt.close();
			con.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
			return member;
		}
	 
}
