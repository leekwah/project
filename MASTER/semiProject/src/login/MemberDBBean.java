package login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import myUtil.HanConv;

public class MemberDBBean {
	private static MemberDBBean instance = new MemberDBBean();

	public static MemberDBBean getInstance() {
		// 값을 입력받는 메소드
		return instance; // BoardDBBean의 객체를 입력받음.

	}

	public static Connection getConnection() throws Exception {
		// 쿼리작업 사용할 Connection객체 리턴하는 메소드
		// 따로만든 이유 -> 여러번 사용하기 위해서

		Context ctx = new InitialContext();
		DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle");
		return ds.getConnection();
	}
	
	// 유저 가입 메소드
	public static int register(MemberBean member) throws Exception {
        //값을 추가하는 메소드
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		String sql = "";
		int re = -1;
		
		try {
			con = getConnection();
			sql = "select max(b_id) from boardt"; 
			// max값에 1를 더하기 위해서 max(b_id)를 사용함. -> 게시판 번호로 나타낼 것임.
			pstmt=con.prepareStatement(sql);
			rs = pstmt.executeQuery();
				
			sql = "insert into user_table(user_id, user_pwd, user_name, user_phone1, user_phone2,\r\n" + 
					"					user_phone3, user_email, user_pcode, user_raddr, user_jibun,\r\n" + 
					"					 user_detailaddr, user_grade ,user_regdate)\r\n" + 
					"					 values(?,?,?,?,?,?,?,\r\n" + 
					"                     ?,?,?,?,?,sysdate)";
			pstmt = con.prepareStatement(sql);
			//pstmt를 연결
			pstmt.setString(1, member.getUser_id()); //추가 
			pstmt.setString(2, member.getUser_pwd()); //추가 
			pstmt.setString(3, member.getUser_name()); //추가 
			pstmt.setString(4, member.getUser_phone1()); //추가 
			pstmt.setString(5, member.getUser_phone2()); //추가 
			pstmt.setString(6, member.getUser_phone3()); //추가 
			pstmt.setString(7, member.getUser_email()); //추가 
			pstmt.setString(8, member.getUser_pcode()); //추가 
			pstmt.setString(9, member.getUser_raddr()); //추가 
			pstmt.setString(10, member.getUser_jibun()); //추가 
			pstmt.setString(11, member.getUser_detailaddr()); //추가 
			pstmt.setInt(12, member.getUser_grade()); //추가 
			pstmt.executeUpdate();
			System.out.println("회원가입 성공");
			re = 1;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("회원가입 실패");
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
		System.out.println("member.getUser_regdate()====>>" +member.getUser_regdate());
		return re;
	}
	public int confirmID(String id) throws Exception{
		//중복확인을 위한 메소드
		Connection con =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int re= -1;
		String sql = "select user_id from user_table where user_id =?";
		//파라미터값을 ?로 받음.
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery(); //sql의 결과값.
		
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
		//아이디가 일치하는 멤버의 정보를 얻어오는 메소드
		
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
			// 로그인할때 입력하는 아이디를 bean에 넣어줌 
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
	 
}
