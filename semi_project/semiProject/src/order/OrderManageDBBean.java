package order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
	public ArrayList<OrderManageBean> orderList(String pageNumber, String refundCheck) throws Exception {
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		ResultSet pageSet=null;
		int dbCount = 0;
		int absolutePage = 1;
		
		String sql = "SELECT ORDER_DETAIL_NUMBER, ORDER_NUMBER, PRODUCT_NUMBER, PRODUCT_COUNT\r\n" + 
				"     , PRODUCT_PRICE, ORDER_DETAIL_STATUS, REFUND_CHECK, SHIPMENT\r\n" + 
				"  FROM USERORDER_DETAIL\r\n" + 
				" WHERE REFUND_CHECK='"+refundCheck+"' AND ORDER_DETAIL_STATUS != 'ȯ�� �Ϸ�'\r\n" + 
				" ORDER BY ORDER_DETAIL_NUMBER";
		String sql2 = "SELECT COUNT(ORDER_NUMBER) from USERORDER_DETAIL WHERE REFUND_CHECK='"+refundCheck+"' AND ORDER_DETAIL_STATUS != 'ȯ�� �Ϸ�'";

		ArrayList<OrderManageBean> list = new ArrayList<OrderManageBean>();
		
		try {
			conn = getConnection();
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			
			pageSet = stmt.executeQuery(sql2);
			
			if(pageSet.next()) {
				dbCount = pageSet.getInt(1); // �� �� ����
				pageSet.close();
			}
			if (dbCount % OrderManageBean.pageSize == 0) {
				OrderManageBean.pageCount = dbCount / OrderManageBean.pageSize;
			}else {
				OrderManageBean.pageCount = dbCount / OrderManageBean.pageSize+1;
			}
			if(pageNumber != null) { 
				OrderManageBean.pageNum = Integer.parseInt(pageNumber);
				absolutePage = (OrderManageBean.pageNum - 1) * OrderManageBean.pageSize + 1;
			}
			
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				rs.absolute(absolutePage);
				int count = 0;
				
				while(count < OrderManageBean.pageSize) {
					OrderManageBean omb = new OrderManageBean();
					omb.setOrder_detail_number(rs.getLong("ORDER_DETAIL_NUMBER"));
					omb.setOrder_number(rs.getString("ORDER_NUMBER"));
					omb.setProduct_number(rs.getInt("PRODUCT_NUMBER"));
					omb.setProduct_count(rs.getInt("PRODUCT_COUNT"));
					omb.setProduct_price(rs.getInt("PRODUCT_PRICE"));
					omb.setOrder_detail_status(rs.getString("ORDER_DETAIL_STATUS"));
					omb.setRefund_check(rs.getString("REFUND_CHECK"));
					omb.setShipment(rs.getString("SHIPMENT"));
					list.add(omb);
					
					if(rs.isLast()) {
						break;
					}else {
						rs.next();
					}
					
					count++;
				}
			}
		} catch (SQLException ex) {
			System.out.println("��ȸ ����");
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
		return list;
	}
	
	public OrderManageBean getOrder(long o_dNum) throws Exception {
		String sql = "SELECT ORDER_NUMBER, PRODUCT_NUMBER, PRODUCT_COUNT\r\n" + 
				"     , PRODUCT_PRICE, ORDER_DETAIL_STATUS, SHIPMENT\r\n" + 
				"  FROM USERORDER_DETAIL\r\n" + 
				" WHERE order_detail_number = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		OrderManageBean omb = null;
		String o_num="";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, o_dNum);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				omb = new OrderManageBean();
				omb.setOrder_number(rs.getString(1));
				omb.setProduct_number(rs.getInt(2));
				omb.setProduct_count(rs.getInt(3));
				omb.setProduct_price(rs.getInt(4));
				omb.setOrder_detail_status(rs.getString(5));
				omb.setShipment(rs.getString(6));
				o_num = rs.getString(1);
			}
			
			sql = "SELECT USER_ID, ORDER_DATE, RECEIVER_NAME, RECEIVER_PCODE\r\n" + 
					"     , RECEIVER_PHONE1, RECEIVER_PHONE2, RECEIVER_PHONE3\r\n" + 
					"     , RECEIVER_RADDR, RECEIVER_JIBUN, RECEIVER_DETAILADDR\r\n" + 
					"  FROM USER_ORDER\r\n" + 
					" WHERE ORDER_NUMBER = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, o_num);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				omb.setUser_id(rs.getString(1));
				omb.setOrder_date(rs.getTimestamp(2));
				omb.setReceiver_name(rs.getString(3));
				omb.setReceiver_pcode(rs.getString(4));
				omb.setReceiver_phone1(rs.getString(5));
				omb.setReceiver_phone2(rs.getString(6));
				omb.setReceiver_phone3(rs.getString(7));
				omb.setReceiver_raddr(rs.getString(8));
				omb.setReceiver_jibun(rs.getString(9));
				omb.setReceiver_detailaddr(rs.getString(10));
			}
			
			sql = "SELECT PRODUCT_NAME FROM PRODUCT WHERE PRODUCT_NUMBER = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, omb.getProduct_number());
			rs = pstmt.executeQuery();

			if (rs.next()) {
				omb.setProduct_name(rs.getString(1));
			}
		} catch (SQLException ex) {
			System.out.print("��ȸ ����");
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
	public int editOrder(OrderManageBean omb) throws Exception {
		String sql = "UPDATE userorder_detail SET PRODUCT_COUNT=?, PRODUCT_PRICE=?, ORDER_DETAIL_STATUS=?, SHIPMENT = ? WHERE ORDER_NUMBER=?"; 
		int re = -1; // ���� ����
		Connection conn = null;
		PreparedStatement first_pstmt = null;
		PreparedStatement second_pstmt = null;
		try {
			conn = getConnection();
			first_pstmt = conn.prepareStatement(sql);
			first_pstmt.setInt(1, omb.getProduct_count());
			first_pstmt.setInt(2, omb.getProduct_price());
			first_pstmt.setString(3,omb.getOrder_detail_status());
			first_pstmt.setString(4,omb.getShipment());
			first_pstmt.setString(5,omb.getOrder_number());
			first_pstmt.executeUpdate();
			
			sql = "UPDATE user_order SET RECEIVER_NAME=?, RECEIVER_PCODE=?\r\n" + 
					"     , RECEIVER_PHONE1=?, RECEIVER_PHONE2=?, RECEIVER_PHONE3=?\r\n" + 
					"     , RECEIVER_RADDR=?, RECEIVER_JIBUN=?, RECEIVER_DETAILADDR=? \r\n" + 
					" WHERE ORDER_NUMBER=?";
			
			second_pstmt = conn.prepareStatement(sql);
			second_pstmt.setString(1,omb.getReceiver_name());
			second_pstmt.setString(2,omb.getReceiver_pcode());
			second_pstmt.setString(3,omb.getReceiver_phone1());
			second_pstmt.setString(4,omb.getReceiver_phone2());
			second_pstmt.setString(5,omb.getReceiver_phone3());
			second_pstmt.setString(6,omb.getReceiver_raddr());
			second_pstmt.setString(7,omb.getReceiver_jibun());
			second_pstmt.setString(8,omb.getReceiver_detailaddr());
			second_pstmt.setString(9,omb.getOrder_number());
			second_pstmt.executeUpdate();
			
			re = 1; // ���� ����
		}catch (SQLException ex) {
			System.out.print("���� ����");
			ex.printStackTrace();
		} finally {
			try {
				if (first_pstmt != null) {
					first_pstmt.close();
				}
				if (second_pstmt != null) {
					second_pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return re;
	}
	public int refundOrder(String orderNum) throws Exception {
		String sql = "UPDATE userorder_detail SET ORDER_DETAIL_STATUS='ȯ�� �Ϸ�' WHERE ORDER_NUMBER=?"; 
		Connection conn = null;
		PreparedStatement pstmt = null;
		OrderManageBean omb = null;
		ResultSet rs = null;
		
		int re=-1; // ȯ�� ����
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,orderNum);
			pstmt.executeUpdate();
			
			sql="SELECT PRODUCT_NUMBER, PRODUCT_COUNT FROM userorder_detail WHERE ORDER_NUMBER=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,orderNum);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				omb = new OrderManageBean();
				omb.setProduct_number(rs.getInt(1));
				omb.setProduct_count(rs.getInt(2));
			}
			
			sql = "UPDATE PRODUCT SET PRODUCT_STOCK = PRODUCT_STOCK +"+omb.getProduct_count()
					+"WHERE PRODUCT_NUMBER ="+omb.getProduct_number();
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
			
			re = 1; // ȯ�� ����
		}catch (SQLException ex) {
			re = -1; // ȯ�� ����
			ex.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (rs != null) {
					rs.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return re;
	}

	/*
	 * public int insertOrder(OrderManageBean omb) throws Exception { int re=-1;
	 * Connection conn=null; PreparedStatement pstmt=null; ResultSet rs=null; String
	 * sql=""; int p_num = omb.getProduct_number(); Date nowDate = new Date();
	 * SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss"); SimpleDateFormat
	 * sdf2 = new SimpleDateFormat("yyMMddHHmmssSSS"); String today =
	 * sdf.format(nowDate); String orderDNum = p_num+today; String orderNum =
	 * sdf2.format(nowDate); long o_dNum = Long.parseLong(orderDNum); try { conn =
	 * getConnection();
	 * sql="INSERT INTO user_order VALUES(?,?,sysdate,?,?,?,?,?,?,?,?)"; pstmt =
	 * conn.prepareStatement(sql);
	 * 
	 * pstmt.setString(1, orderNum); pstmt.setString(2, omb.getUser_id());
	 * pstmt.setString(3, omb.getReceiver_name()); pstmt.setString(4,
	 * omb.getReceiver_phone1()); pstmt.setString(5, omb.getReceiver_phone2());
	 * pstmt.setString(6, omb.getReceiver_phone3()); pstmt.setString(7,
	 * omb.getReceiver_pcode()); pstmt.setString(8, omb.getReceiver_raddr());
	 * pstmt.setString(9, omb.getReceiver_jibun()); pstmt.setString(10,
	 * omb.getReceiver_detailaddr()); pstmt.executeUpdate();
	 * 
	 * sql="INSERT INTO userorder_detail VALUES(?,?,?,?,?,'입금 완료','N',null)"; pstmt
	 * = conn.prepareStatement(sql);
	 * 
	 * pstmt.setLong(1, o_dNum); pstmt.setString(2, orderNum); pstmt.setInt(3,
	 * omb.getProduct_number()); pstmt.setInt(4, omb.getProduct_count());
	 * pstmt.setInt(5, omb.getProduct_price()); pstmt.executeUpdate();
	 * 
	 * re=1; }catch(SQLException ex){ ex.printStackTrace(); }finally{ try{ if(pstmt
	 * != null) pstmt.close(); if (rs != null) rs.close(); if(conn != null)
	 * conn.close(); }catch(Exception e){ e.printStackTrace(); } }
	 * 
	 * return re; }
	 */
	public int insertOrder(OrderManageBean omb) throws Exception {
		String sql;
		
		int re = -1;
		int product_stock;
		int p_num = omb.getProduct_number();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			sql = "select product_stock from product where product_number = ?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, omb.getProduct_number());
			rs = pstmt.executeQuery();
			if(rs.next()) {				 //제품이 존재하는지 판단
				product_stock = rs.getInt("product_stock");
				if(product_stock >= omb.getProduct_count()) { 			//제품 재고량 확인
					pstmt.clearParameters();
					
					sql="update product\r\n" + 
							"   set product_stock = product_stock - ?\r\n" + 
							" where product_number = ?";
					pstmt=conn.prepareStatement(sql);
					pstmt.setInt(1, omb.getProduct_count());
					pstmt.setInt(2, p_num);
					pstmt.executeUpdate();
					
					pstmt.clearParameters();
					
					sql="INSERT INTO user_order VALUES(?,?,sysdate,?,?,?,?,?,?,?,?)"; 
					pstmt =	conn.prepareStatement(sql);
					pstmt.setString(1, omb.getOrder_number()); 
					pstmt.setString(2, omb.getUser_id());
					pstmt.setString(3, omb.getReceiver_name()); 
					pstmt.setString(4, omb.getReceiver_phone1()); 
					pstmt.setString(5, omb.getReceiver_phone2());
					pstmt.setString(6, omb.getReceiver_phone3()); 
					pstmt.setString(7, omb.getReceiver_pcode()); 
					pstmt.setString(8, omb.getReceiver_raddr());
					pstmt.setString(9, omb.getReceiver_jibun()); 
					pstmt.setString(10, omb.getReceiver_detailaddr()); 
					
					pstmt.executeUpdate();
					
					pstmt.clearParameters();
					
					sql = "INSERT INTO userorder_detail VALUES(?,?,?,?,?,'입금 완료','N',null,?)";
					pstmt = conn.prepareStatement(sql);
					
					pstmt.setLong(1, omb.getOrder_detail_number());
					pstmt.setString(2, omb.getOrder_number());
					pstmt.setInt(3, p_num);
					pstmt.setInt(4, omb.getProduct_count());
					pstmt.setInt(5, omb.getProduct_price()); // 배송비 때문에 가격 차이 있을 수 있음
					pstmt.setString(6, omb.getRequested()); // 배송 요청사항 추가
					pstmt.executeUpdate();
					
					re=1;
				}else {
					re=2;
					System.out.println("재고 부족");
				}
			} else {
				System.out.println("제품이 존재하지 않습니다.");
				re=-1;
			}
			//스크립트 작성
		} catch (SQLException ex) {
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
		return re;
	}
}