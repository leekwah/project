package semiProject;

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
		
		try {
			con = getConnection();
			sql = "select max(b_id) from boardt"; 
			// max값에 1를 더하기 위해서 max(b_id)를 사용함. -> 게시판 번호로 나타낼 것임.
			pstmt=con.prepareStatement(sql);
			rs = pstmt.executeQuery();
				
			sql = "insert into user_table(user_id, user_pwd, user_name, user_phone ,user_email, user_regdate,"
					+ " user_addr)"
					+ " values(?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			//pstmt를 연결
			pstmt.setString(1, member.getUser_id()); //추가 
			pstmt.setString(2, member.getUser_pwd()); //추가 
			pstmt.setString(3, member.getUser_name()); //추가 
			pstmt.setString(4, member.getUser_phone()); //추가 
			pstmt.setString(5, member.getUser_email()); //추가 
			pstmt.setTimestamp(6, member.getUser_regdate()); //추가 
			pstmt.setString(7, member.getUser_addr()); //추가 
			pstmt.executeUpdate();

			System.out.println("회원가입 성공");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("회원가입 실패");
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
	public int confirmID(String id) throws Exception{
		//중복확인을 위한 메소드
		Connection con =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int re= -1;
		String sql = "select mem_id from memberT where mem_id =?";
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
			member.setUser_pwd(rs.getString("user_pw"));  
			member.setUser_name(rs.getString("user_name"));  
			member.setUser_name(rs.getString("user_phone"));  
			member.setUser_email(rs.getString("user_email"));  
			member.setUser_regdate(rs.getTimestamp("user_regdate"));
			//타입이 다르기 때문에  
			member.setUser_addr(rs.getString("user_address"));  
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
	 
	 public String findId(String user_name, String user_phone) {
			String re=null;
			
			try {			
				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				
				String sql = "select user_id from user_table where user_name=? and user_phone=? ";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, user_name);
				pstmt.setString(2, user_phone);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					re = rs.getString("user_id");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			return re;
		}
	 
}
