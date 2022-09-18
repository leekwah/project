package cs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.sql.DataSource;


public class BoardDBBean {
	private static BoardDBBean boardDBBean = new BoardDBBean();
	
	public static BoardDBBean getInstance() {
		return boardDBBean;
	}
	
	public Connection getConnection() throws Exception{
		Connection conn = ((DataSource)(new InitialContext().lookup("java:comp/env/jdbc/oracle"))).getConnection();
		return conn;
	}
	
	/*
	 * 작성자 : 이민하
	 * 일  시 : 2022.09.05
	 * 데이터 삽입문 
	 * */
	public int insertBoard(BoardBean board) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int re=-1;
		String sql;
		int number;
		int id = board.getB_id();
		int ref = board.getB_ref();
		int step = board.getB_step();
		int level = board.getB_level();
		
		try {
			conn = getConnection();
			sql = "SELECT MAX(B_ID) FROM BOARDT";
			pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				number = rs.getInt(1)+1;
			} else {
				number = 1;
			}
			if(id != 0) {
				pstmt.clearParameters();
				sql="update boardt set b_step = b_step+1 where b_ref= ? and b_step > ?";
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, ref);
				pstmt.setInt(2, step);
				pstmt.executeUpdate();
				step=step+1;
				level=level+1;
			} else {
				ref=number;
				step=0;
				level=0;
			}
			sql = "";
			
			
			
			pstmt.clearParameters();//insert에 2개 추가 2022.09.13
			sql = "INSERT INTO boardt VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";//b_ref, b_step, b_level 구현해야됨
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, number);
			pstmt.setString(2, board.getB_name());
			pstmt.setString(3, board.getB_email());
			pstmt.setString(4, board.getB_title());
			pstmt.setString(5, board.getB_content());
			pstmt.setTimestamp(6, board.getB_date());
			pstmt.setInt(7, board.getB_hit());
			pstmt.setString(8, board.getB_pwd());
			pstmt.setString(9, board.getB_ip());
			pstmt.setInt(10, ref);
			pstmt.setInt(11, step);
			pstmt.setInt(12, level);
			pstmt.setString(13,board.getB_fname());//숫자를 추가해야한다.
			pstmt.setInt(14, board.getB_fsize());
			pstmt.setString(15,board.getB_rfname());
			
			pstmt.executeUpdate();
			re=1;
			
		}catch(SQLException ex){
			System.out.println("추가 실패");
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
	
	public BoardBean getBorad(int id, boolean hitadd) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "update boardt\r\n" + 
				"   set b_hit = b_hit+1\r\n" + 
				" where b_id = ?"; 
		
		BoardBean board = new BoardBean();
		try {
			conn = getConnection();
			if(hitadd) {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, id);
				pstmt.executeUpdate();	
				pstmt.clearParameters();
			}
			
			sql = "   select b_id\r\n" + 
					"      , b_name\r\n" + 
					"      , b_email\r\n" + 
					"      , b_title\r\n" + 
					"      , b_content\r\n" + 
					"      , b_date\r\n" + 
					"      , b_hit\r\n" + 
					"      , b_pwd\r\n" + 
					"      , b_ip\r\n" + 
					"      , b_ref\r\n" + 
					"      , b_step\r\n" + 
					"      , b_level\r\n" + 
					"      , b_fname\r\n" + //2개 추가 2022.09.13 file
					"      , b_fsize\r\n" + 
					"      , b_rfname\r\n" +
					"   from boardt\r\n" + 
					"  where b_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				
				board.setB_id(rs.getInt("b_id"));
				board.setB_name(rs.getString("b_name"));
				board.setB_email(rs.getString("b_email"));
				board.setB_title(rs.getString("b_title"));
				board.setB_content(rs.getString("b_content"));
				board.setB_date(rs.getTimestamp("b_date"));
				board.setB_hit(rs.getInt("b_hit"));
				board.setB_pwd(rs.getString("b_pwd"));
				board.setB_ip(rs.getString("b_ip"));
				board.setB_ref(rs.getInt("b_ref"));
				board.setB_step(rs.getInt("b_step"));
				board.setB_level(rs.getInt("b_level"));
				board.setB_fname(rs.getString("b_fname"));//2개 추가
				board.setB_fsize(rs.getInt("b_fsize"));
				board.setB_rfname(rs.getString("b_rfname"));
			}

		}catch(SQLException ex){
			System.out.println("조회 실패");
			ex.printStackTrace();
		}finally{
			try{
				if(rs != null)rs.close();
				if(pstmt != null)pstmt.close();
				if(conn != null)conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		return board;
	}
	
	
	
	public ArrayList<BoardBean> listBoard(String pageNumber) throws Exception{
		ArrayList<BoardBean> boardlist = new ArrayList<>();
		Connection conn = null;
		Statement stmt= null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		ResultSet pageSet = null;
		int dbCount=0;
		int absolutePage=0;
		String sql=""; 
		String sql2=""; 
		sql = "select b_id\r\n" + 
					"      , b_name\r\n" + 
					"      , b_email\r\n" + 
					"      , b_title\r\n" + 
					"      , b_content\r\n" + 
					"      , b_date\r\n" + 
					"      , b_hit\r\n" + 
					"      , b_pwd\r\n" + 
					"      , b_ip\r\n" + 
					"      , b_ref\r\n" + 
					"      , b_step\r\n" + 
					"      , b_level\r\n" + 
					"      , b_fname\r\n" +//2개 추가 2022.09.13 file 
					"      , b_fsize\r\n" + 
					"      , b_rfname\r\n" + 
					"   from boardt\r\n" + 
					"  order by b_ref desc, b_step asc";
		
		sql2="SELECT COUNT(B_ID) FROM BOARDT";
		try {
			conn = getConnection();
			
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			pageSet=stmt.executeQuery(sql2);
			
			if(pageSet.next()) {
				dbCount = pageSet.getInt(1);
				pageSet.close();
			}
			
			if(dbCount%BoardBean.pageSize==0) { //dbCount => 총 숫자 , pageSize =10 => ex) 84%10 = 4
				BoardBean.pageCount = dbCount / BoardBean.pageSize; //80/10=> 8
			} else {
				BoardBean.pageCount = dbCount / BoardBean.pageSize +1;//84/10 +1=> 8+1 => 9
			}
			
			if(pageNumber != null) {
				BoardBean.pageNum = Integer.parseInt(pageNumber);
				absolutePage = (BoardBean.pageNum - 1) * BoardBean.pageSize +1;
			}
			rs=stmt.executeQuery(sql);
			if(rs.next()) {
				rs.absolute(absolutePage);
				int count = 0;
//				while(rs.next()){
				while(count<BoardBean.pageSize){
					BoardBean board = new BoardBean();
					
					board.setB_id(rs.getInt(1));
					board.setB_name(rs.getString(2));
					board.setB_email(rs.getString(3));
					board.setB_title(rs.getString(4));
					board.setB_content(rs.getString(5));
					board.setB_date(rs.getTimestamp(6));
					board.setB_hit(rs.getInt(7));
					board.setB_pwd(rs.getString(8));
					board.setB_ip(rs.getString(9));
					board.setB_ref(rs.getInt(10));
					board.setB_step(rs.getInt(11));
					board.setB_level(rs.getInt(12));
					board.setB_fname(rs.getString(13));//2개 추가
					board.setB_fsize(rs.getInt(14));
					board.setB_rfname(rs.getString(15));
					//사용하기 좋게 쿼리를 미리 다 가져오는 편이다.
					//미리 가져옴으로서 가져와서 사용하기 용이하다.
					
					boardlist.add(board);
					
					if(rs.isLast()) {
						break;
					} else {
						rs.next();
					}
					
					count++;
				}
			}
			
		}catch(SQLException ex){
			System.out.println("조회 실패");
			ex.printStackTrace();
		}finally{
			try{
				if(pstmt != null)pstmt.close();
				if(conn != null)conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return boardlist;
	}
	
	public int editBoard(BoardBean board) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String check_pw="";
		int re=-1;
		String sql;
		
		sql = "select b_pwd\r\n" + 
				"   from boardt\r\n" + 
				"  where b_id = ?";
		
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board.getB_id());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				check_pw=rs.getString(1);
			}
			if(check_pw.equals(board.getB_pwd())) {
				sql = "update boardt\r\n" + 
						"    set b_name = ?\r\n" + 
						"      , b_email = ?\r\n" + 
						"      , b_title = ?\r\n" + 
						"      , b_content = ?\r\n"+
						"  where b_id = ?";
				pstmt.clearParameters();
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, board.getB_name());
				pstmt.setString(2, board.getB_email());
				pstmt.setString(3, board.getB_title());
				pstmt.setString(4, board.getB_content());
				pstmt.setInt(5, board.getB_id());
				
				re=pstmt.executeUpdate();
				//System.out.println("@@@### re ====>"+re); //확인을 위한 것. 눈에 확 띄게 만든다.
				//성공하면 1, 실패하면 0
				System.out.println("변경 성공");
				re=1;
			}else {
				System.out.println("변경 실패");
				re=0;
			}
			
			
			
		}catch(SQLException ex){
			System.out.println("변경 실패");
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
	public int deleteBoard(int bid, String bpwd) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String b_pwdd=null;
		int re=-1;
		String sql = "select b_pwd\r\n" + 
				"   from boardt\r\n" + 
				"  where b_id = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, bid);
			
			rs=pstmt.executeQuery();
			//System.out.println("@@@### re ====>"+re); //확인을 위한 것. 눈에 확 띄게 만든다.
			//성공하면 1, 실패하면 0
			System.out.println("메소드 입력 성공");
			
			if(rs.next()) {
				b_pwdd=rs.getString(1);
			}
			
			System.out.println(b_pwdd);
			
			if(b_pwdd.equals(bpwd)) {
				sql = "DELETE FROM BOARDT WHERE B_ID = ?";
				pstmt.clearParameters();
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, bid);
				pstmt.executeUpdate();
				re=1;
				System.out.println("완벽한 삭제");
			} else {
				re = 0;
				System.out.println("삭제 실패");
			}
		}catch(SQLException ex){
			System.out.println("변경 실패");
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
	public int countWrite(int amount) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count=0;
		
		String sql = "SELECT COUNT(*) FROM BOARDT";
		try {
			conn = getConnection();
			pstmt=conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int pages;
		if(count%amount == 0) {
			pages = count/amount;			
		} else {
			pages= count/amount +1 ;
		}
		
		
		return pages;
	}
	
	public BoardBean getFileName(int bid) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select b_fname, b_rfname from boardt where b_id = ?"; 
		
		BoardBean board = new BoardBean();
		try {
			conn = getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				board.setB_fname(rs.getString("b_fname"));
				board.setB_rfname(rs.getString("b_rfname"));
			}

		}catch(SQLException ex){
			System.out.println("조회 실패");
			ex.printStackTrace();
		}finally{
			try{
				if(rs != null)rs.close();
				if(pstmt != null)pstmt.close();
				if(conn != null)conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		return board;
	}
}
