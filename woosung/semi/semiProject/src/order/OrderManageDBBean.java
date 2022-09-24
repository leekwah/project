package order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.sql.DataSource;


public class OrderManageDBBean {
private static OrderManageDBBean OrderMangeDBBean = new OrderManageDBBean();
	
	public static OrderManageDBBean getInstance() {
		return OrderMangeDBBean;
	}
	
	public Connection getConnection() throws Exception{
		Connection conn = ((DataSource)(new InitialContext().lookup("java:comp/env/jdbc/oracle"))).getConnection();
		return conn;
	}
	
	public ArrayList<OrderManageBean> listBoard() throws Exception {
		String sql = "SELECT B_ID, U_ID, B_CATEGORY, B_VIEW, B_TITLE, B_CONTENT\r\n" + 
				"     , B_IP, B_PWD, B_DATE, B_SECRET, B_REF, B_STEP, B_LEVEL\r\n" + 
				"     , B_FNAME, B_FSIZE, B_RFNAME, B_ANSCHK\r\n" + 
				"  FROM (SELECT ROWNUM AS rnum, A.* \r\n" + 
				"          FROM (SELECT * FROM QNA_BOARD ORDER BY B_REF DESC, B_STEP) A)\r\n" + 
				" WHERE rnum >= ? AND rnum <= ?";
		// 쿼리문 여러개 써서 column 합치기 또는 쿼리문 여러개 써서 column 일부들 변수에 저장해서 add
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<OrderManageBean> list = new ArrayList<OrderManageBean>();
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				OrderManageBean omb = new OrderManageBean();
				list.add(omb);
			}
			
		} catch (SQLException ex) {
			System.out.print("조회 실패");
			ex.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public OrderManageBean getBoard(int b_id, boolean hitAdd) throws Exception {
		String sql = "";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		OrderManageBean omb = null;
		
		try {
			if (hitAdd == true) {
				sql = "UPDATE QNA_BOARD SET B_VIEW=B_VIEW+1 WHERE B_ID = ?";
				conn = getConnection();
				;
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, b_id);
				pstmt.executeUpdate(); // 쿼리 실행
			} else {
				conn = getConnection();
			}
			
			sql = "SELECT B_ID, U_ID, B_CATEGORY, B_VIEW, B_TITLE, B_CONTENT\r\n" + 
					",B_IP, B_PWD, B_DATE, B_SECRET, B_REF, B_STEP, B_LEVEL\r\n" + 
					",B_FNAME, B_FSIZE, B_RFNAME, B_ANSCHK\r\n" + 
					"  FROM QNA_BOARD WHERE B_ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, b_id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				omb = new OrderManageBean();
			}
		} catch (SQLException ex) {
			System.out.print("조회 실패");
			ex.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return omb;
	}
}
