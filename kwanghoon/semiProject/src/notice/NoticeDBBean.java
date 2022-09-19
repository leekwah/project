package notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class NoticeDBBean {
	// 09-19 광훈
	// 새로운 instance 객체 생성
	private static NoticeDBBean instance = new NoticeDBBean();
	// 09-19 광훈
	// instance 반환 메서드 
	public static NoticeDBBean getInstance() { return instance; }
	// 09-19 광훈
	// DBCP 메서드 
	public Connection getConnection() throws Exception {
		Context ctx = new InitialContext();
		DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/oracle");
		return ds.getConnection();
	}
	// insertBoard메서드
	public int insertboard(NoticeBean notice) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "";
		int re = -1;
		int number;
		
		try {
			conn = getConnection();
			query = "SELECT MAX(n_num) FROM notice";
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				number = rs.getInt(1) + 1;
			} else {
				number = 1;
			}
			
			query = "INSERT INTO notice VALUES (?, ?, ?, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, number);
			pstmt.setString(2, notice.getN_title());
			pstmt.setString(3, notice.getN_content());
			pstmt.setTimestamp(4, notice.getN_date());
			pstmt.setString(5, notice.getN_pwd());
			pstmt.setString(6, notice.getN_ip());
			pstmt.executeUpdate();
			
			re = 1;
			pstmt.close();
			conn.close();
			
			System.out.println("insertboard Success");
		} catch (Exception e) {
			System.out.println("insertboard Fail");
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return re;
	}
	
	
	public ArrayList<NoticeBean> listNotice(String pageNumber) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ResultSet pageSet = null;
		String query = "";
		
		int dbCount = 0;
		int absolutePage = 1;
		
		ArrayList<NoticeBean> noticeList = new ArrayList<NoticeBean>();
		
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(query);
			query = "SELECT COUNT(n_num) FORM notice";
			pageSet = stmt.executeQuery(query);
			
			if (pageSet.next()) {
				dbCount = pageSet.getInt(1);
				pageSet.close();
				stmt.close();
			}
			
			if (dbCount % NoticeBean.pageSize == 0) {
				NoticeBean.pageCount = dbCount / NoticeBean.pageSize;
			} else {	//84
				NoticeBean.pageCount = dbCount / NoticeBean.pageSize + 1;
			}
			
			if (pageNumber != null) {
				NoticeBean.pageNum = Integer.parseInt(pageNumber);
				// 1 : 0*10+1 = 1
				// 2 : 1*10+1 = 11
				absolutePage = (NoticeBean.pageNum - 1) * NoticeBean.pageSize + 1;
			}
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			// TYPE_SCROLL_SENSITIVE -> 양방향 이동도 가능하고, 데이터 변경이 바로 적용된다.
			// CONCUR_UPDATABLE -> 데이터를 수정할 수 있다.
			query="SELECT * FROM notice ORDER BY n_num DESC";
 			rs = stmt.executeQuery(query);
 			
 			if (rs.next()) {
				rs.absolute(absolutePage);
				int count = 0;
				
	 			while (count < NoticeBean.pageSize) {
	 				NoticeBean notice = new NoticeBean();
	 				
	 				notice.setN_num(rs.getInt(1));
	 				notice.setN_title(rs.getString(2));
	 				notice.setN_content(rs.getString(3));
	 				notice.setN_date(rs.getTimestamp(4));
	 				notice.setN_hit(rs.getInt(5));
	 				notice.setN_pwd(rs.getString(6));
	 				notice.setN_ip(rs.getString(7));
	 				
	 				noticeList.add(notice);
	 				
	 				if (rs.isLast()) {
	 					break;
					} else {
						rs.next();
					}
	 				
	 				count++;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return noticeList;
		
		
	}
}