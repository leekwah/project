<<<<<<< HEAD
package cart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class CartDBBean {
	private static CartDBBean instance = new CartDBBean();
	
	// CartDBBean 객체 생성 메서드
	public static CartDBBean getinstance() {
		return instance;
	}
	
	// db와 연결하는 메서드
	public Connection getConnection() throws Exception {
		Context ctx = new InitialContext();
		DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/oracle");
		
		return ds.getConnection();
	}
	
	// 장바구니를 db에 저장하는 메서드
	public int insertCart(String user_id, int product_number, int product_count) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		
		int re = -1;
		int number = 0;
		int count = 0;
		
		try {
			conn = getConnection();

			// cart_number(장바구니 번호)를 세팅하기 위한 쿼리
			sql = "SELECT MAX(CART_NUMBER) FROM cart";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if (rs.next()) { // 장바구니에 상품이 있을 경우
				number = rs.getInt(1) + 1;
			}else {
				number = 1; // 장바구니가 비어있을 경우
			}
			
			// product_count를 세팅하기 위한 쿼리
			sql = "SELECT PRODUCT_COUNT FROM cart WHERE USER_ID = ? AND PRODUCT_NUMBER = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);
			pstmt.setInt(2, product_number);
			rs = pstmt.executeQuery();
			
			if (rs.next()) { // 장바구니에 상품이 있을 경우
				count = rs.getInt(1) + product_count;
				
				sql = "UPDATE cart SET PRODUCT_COUNT = ? WHER USER_ID = ? AND PRODUCT_NUMBER = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, count);
				pstmt.setString(2, user_id);
				pstmt.setInt(3, product_number);
				
				re = pstmt.executeUpdate();
				re = 1;
			}else { // 장바구니가 비어있을 경우
				sql = "INSERT INTO cart(CART_NUMBER, USER_ID, PRODUCT_NUMBER, PRODUCT_COUNT) VALUES(?,?,?,?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, number);
				pstmt.setString(2, user_id);
				pstmt.setInt(3, product_number);
				pstmt.setInt(4, product_count);
				
				re = pstmt.executeUpdate();
				re = 1;
			}
			
			System.out.println("추가 성공");
		} catch (SQLException ex) {
			System.out.println("추가 실패");
			ex.printStackTrace();
		} finally {
			try {
				if (rs != null) {rs.close();}
				if (pstmt != null) {pstmt.close();}
				if (conn != null) {conn.close();}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return re;
	}
	
	// user_id와 일치하는 cart의 정보를 가져오는 메서드
	public ArrayList<CartBean> listCart(String user_id) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT CART_NUMBER, PRODUCT_NUMBER, PRODUCT_COUNT FROM cart WHERE USER_ID = ?";
		
		ArrayList<CartBean> cartArr = new ArrayList<CartBean>();
		CartBean cart = new CartBean();
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				cart.setCart_number(rs.getInt("cart_number"));
				cart.setProduct_number(rs.getInt("product_number"));
				cart.setProduct_count(rs.getInt("product_count"));
				
				cartArr.add(cart);
			}
			
			System.out.println("조회 성공");
		} catch (SQLException ex) {
			System.out.println("조회 실패");
			ex.printStackTrace();
		} finally {
			try {
				if (rs != null) {rs.close();}
				if (pstmt != null) {pstmt.close();}
				if (conn != null) {conn.close();}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return cartArr;
	}
	
	// cart_number에 해당되는 열을 삭제하는 메서드
	public int deleteCart(int cart_number) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM cart WHERE CART_NUMBER = ?";
		int re = -1;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cart_number);
			re = pstmt.executeUpdate();
			re = 1;
			
			System.out.println("삭제 성공");
		} catch (SQLException ex) {
			System.out.println("삭제 실패");
			ex.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {pstmt.close();}
				if (conn != null) {conn.close();}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return re;
	}
	
	// 구매수량을 수정하는 메서드
	public int editCart(int product_count, int cart_number) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE cart SET PRODUCT_COUNT = ? WHERE CART_NUMBER = ?";
		int re = -1;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, product_count);
			pstmt.setInt(2, cart_number);
			re = pstmt.executeUpdate();
			re = 1;
			
			System.out.println("수정 성공");
		} catch (SQLException ex) {
			System.out.println("수정 실패");
			ex.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {pstmt.close();}
				if (conn != null) {conn.close();}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return re;
	}
	
	// 재고수량을 확인해 장바구니에 추가 가능 여부를 확인하는 메서드 (장바구니에 추가 할 때)
	public int checkStock(int product_number, int product_count, String user_id) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		int cnt = 0;
		int stock = 0;
		int re = -1;
		
		try {
			conn = getConnection();
			
			// 해당 아이디가 장바구니에 해당 물건을 담아놓은 총 개수를 cnt변수에 넣음
			sql = "SELECT SUM(PRODUCT_COUNT) FROM cart WHERE PRODUCT_NUMBER = ? AND USER_ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, product_number);
			pstmt.setString(2, user_id);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				cnt = rs.getInt(1) + product_count;
			}else {
				cnt = product_count;
			}
			
			// 해당 상품 재고를 확인
			sql = "SELECT PRODUCT_STOCK FROM product WHERE PRODUCT_NUMBER = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, product_number);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				stock = rs.getInt(1);
			}
			
			if (stock >= cnt) {
				re = 1; // 재고수량이 더 많을 경우
			}else {
				re = -1; // 재고수량이 부족한 경우
			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (rs != null) {rs.close();}
				if (pstmt != null) {pstmt.close();}
				if (conn != null) {conn.close();}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return re;
	}
	
	// 재고수량을 확인해 장바구니에 추가 가능 여부를 확인하는 메서드 (장바구니에서 수정 할 때)
	public int checkStockEdit(int product_number, int product_count) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		int cnt = 0;
		int stock = 0;
		int re = -1;
		
		try {
			conn = getConnection();
			
			// 해당 상품 재고를 확인
			sql = "SELECT PRODUCT_STOCK FROM product WHERE PRODUCT_NUMBER = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, product_number);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				stock = rs.getInt(1);
			}
			
			if (stock >= cnt) {
				re = 1; // 재고수량이 더 많을 경우
			}else {
				re = -1; // 재고수량이 부족한 경우
			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (rs != null) {rs.close();}
				if (pstmt != null) {pstmt.close();}
				if (conn != null) {conn.close();}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return re;
	}
	
	// cart_number와 일치하는 cart의 정보를 가져오는 메소드
	public CartBean getCart(int cart_number) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT CART_NUMBER, USER_ID, PRODUCT_NUMBER, PRODUCT_COUNT FROM cart WHERE CART_NUMBER = ?";
		
		CartBean cart = new CartBean();
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cart_number);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				cart.setCart_number(cart_number);
				cart.setUser_id(rs.getString("user_id"));
				cart.setProduct_number(rs.getInt("product_number"));
				cart.setProduct_count(rs.getInt("product_count"));
			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (rs != null) {rs.close();}
				if (pstmt != null) {pstmt.close();}
				if (conn != null) {conn.close();}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return cart;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
=======
package cart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class CartDBBean {
	private static CartDBBean instance = new CartDBBean();
	
	// CartDBBean 객체 생성 메서드
	public static CartDBBean getinstance() {
		return instance;
	}
	
	// db와 연결하는 메서드
	public Connection getConnection() throws Exception {
		Context ctx = new InitialContext();
		DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/oracle");
		
		return ds.getConnection();
	}
	
	// 장바구니를 db에 저장하는 메서드
	public int insertCart(String user_id, int product_number, int product_count) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		
		int re = -1;
		int number = 0;
		int count = 0;
		
		try {
			conn = getConnection();

			// cart_number(장바구니 번호)를 세팅하기 위한 쿼리
			sql = "SELECT MAX(CART_NUMBER) FROM cart";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if (rs.next()) { // 장바구니에 상품이 있을 경우
				number = rs.getInt(1) + 1;
			}else {
				number = 1; // 장바구니가 비어있을 경우
			}
			
			// product_count를 세팅하기 위한 쿼리
			sql = "SELECT PRODUCT_COUNT FROM cart WHERE USER_ID = ? AND PRODUCT_NUMBER = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);
			pstmt.setInt(2, product_number);
			rs = pstmt.executeQuery();
			
			if (rs.next()) { // 장바구니에 상품이 있을 경우
				count = rs.getInt(1) + product_count;
				
				sql = "UPDATE cart SET PRODUCT_COUNT = ? WHER USER_ID = ? AND PRODUCT_NUMBER = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, count);
				pstmt.setString(2, user_id);
				pstmt.setInt(3, product_number);
				
				re = pstmt.executeUpdate();
				re = 1;
			}else { // 장바구니가 비어있을 경우
				sql = "INSERT INTO cart(CART_NUMBER, USER_ID, PRODUCT_NUMBER, PRODUCT_COUNT) VALUES(?,?,?,?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, number);
				pstmt.setString(2, user_id);
				pstmt.setInt(3, product_number);
				pstmt.setInt(4, product_count);
				
				re = pstmt.executeUpdate();
				re = 1;
			}
			
			System.out.println("추가 성공");
		} catch (SQLException ex) {
			System.out.println("추가 실패");
			ex.printStackTrace();
		} finally {
			try {
				if (rs != null) {rs.close();}
				if (pstmt != null) {pstmt.close();}
				if (conn != null) {conn.close();}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return re;
	}
	
	// user_id와 일치하는 cart의 정보를 가져오는 메서드
	public ArrayList<CartBean> listCart(String user_id) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT CART_NUMBER, PRODUCT_NUMBER, PRODUCT_COUNT FROM cart WHERE USER_ID = ?";
		
		ArrayList<CartBean> cartArr = new ArrayList<CartBean>();
		CartBean cart = new CartBean();
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				cart.setCart_number(rs.getInt("cart_number"));
				cart.setProduct_number(rs.getInt("product_number"));
				cart.setProduct_count(rs.getInt("product_count"));
				
				cartArr.add(cart);
			}
			
			System.out.println("조회 성공");
		} catch (SQLException ex) {
			System.out.println("조회 실패");
			ex.printStackTrace();
		} finally {
			try {
				if (rs != null) {rs.close();}
				if (pstmt != null) {pstmt.close();}
				if (conn != null) {conn.close();}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return cartArr;
	}
	
	// cart_number에 해당되는 열을 삭제하는 메서드
	public int deleteCart(int cart_number) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM cart WHERE CART_NUMBER = ?";
		int re = -1;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cart_number);
			re = pstmt.executeUpdate();
			re = 1;
			
			System.out.println("삭제 성공");
		} catch (SQLException ex) {
			System.out.println("삭제 실패");
			ex.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {pstmt.close();}
				if (conn != null) {conn.close();}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return re;
	}
	
	// 구매수량을 수정하는 메서드
	public int editCart(int product_count, int cart_number) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE cart SET PRODUCT_COUNT = ? WHERE CART_NUMBER = ?";
		int re = -1;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, product_count);
			pstmt.setInt(2, cart_number);
			re = pstmt.executeUpdate();
			re = 1;
			
			System.out.println("수정 성공");
		} catch (SQLException ex) {
			System.out.println("수정 실패");
			ex.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {pstmt.close();}
				if (conn != null) {conn.close();}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return re;
	}
	
	// 재고수량을 확인해 장바구니에 추가 가능 여부를 확인하는 메서드 (장바구니에 추가 할 때)
	public int checkStock(int product_number, int product_count, String user_id) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		int cnt = 0;
		int stock = 0;
		int re = -1;
		
		try {
			conn = getConnection();
			
			// 해당 아이디가 장바구니에 해당 물건을 담아놓은 총 개수를 cnt변수에 넣음
			sql = "SELECT SUM(PRODUCT_COUNT) FROM cart WHERE PRODUCT_NUMBER = ? AND USER_ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, product_number);
			pstmt.setString(2, user_id);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				cnt = rs.getInt(1) + product_count;
			}else {
				cnt = product_count;
			}
			
			// 해당 상품 재고를 확인
			sql = "SELECT PRODUCT_STOCK FROM product WHERE PRODUCT_NUMBER = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, product_number);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				stock = rs.getInt(1);
			}
			
			if (stock >= cnt) {
				re = 1; // 재고수량이 더 많을 경우
			}else {
				re = -1; // 재고수량이 부족한 경우
			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (rs != null) {rs.close();}
				if (pstmt != null) {pstmt.close();}
				if (conn != null) {conn.close();}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return re;
	}
	
	// 재고수량을 확인해 장바구니에 추가 가능 여부를 확인하는 메서드 (장바구니에서 수정 할 때)
	public int checkStockEdit(int product_number, int product_count) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		int cnt = 0;
		int stock = 0;
		int re = -1;
		
		try {
			conn = getConnection();
			
			// 해당 상품 재고를 확인
			sql = "SELECT PRODUCT_STOCK FROM product WHERE PRODUCT_NUMBER = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, product_number);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				stock = rs.getInt(1);
			}
			
			if (stock >= cnt) {
				re = 1; // 재고수량이 더 많을 경우
			}else {
				re = -1; // 재고수량이 부족한 경우
			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (rs != null) {rs.close();}
				if (pstmt != null) {pstmt.close();}
				if (conn != null) {conn.close();}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return re;
	}
	
	// cart_number와 일치하는 cart의 정보를 가져오는 메소드
	public CartBean getCart(int cart_number) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT CART_NUMBER, USER_ID, PRODUCT_NUMBER, PRODUCT_COUNT FROM cart WHERE CART_NUMBER = ?";
		
		CartBean cart = new CartBean();
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cart_number);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				cart.setCart_number(cart_number);
				cart.setUser_id(rs.getString("user_id"));
				cart.setProduct_number(rs.getInt("product_number"));
				cart.setProduct_count(rs.getInt("product_count"));
			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (rs != null) {rs.close();}
				if (pstmt != null) {pstmt.close();}
				if (conn != null) {conn.close();}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return cart;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
>>>>>>> a5a5679681f14cd843596c2c67a61d5d4b237f04
