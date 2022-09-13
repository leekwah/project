package magic.Board;

import magic.Board.BoardBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDBBean {
    // ------------------------ 핵심내용 ---------------------------
    private static BoardDBBean instance = new BoardDBBean();
    // 전역 MemberDBBean 객체 레퍼런스를 리턴하는 메서드
    public static BoardDBBean getInstance() { return instance; }
    // 쿼리작업에 사용할 커넥션 객체를 리턴하는 메서드
    public Connection getConnection() throws Exception {
        Context ctx = new InitialContext();
        DataSource ds = (DataSource) ctx.lookup("java:comp/env/MYSQL");
        return ds.getConnection(); // 재사용을 위해 만들어 놓음
    }

    public int insertBoard(BoardBean board) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = ""; // 2가지의 sql 문
        int re = -1;
        int number; // 게시판 번호를 위한 int

        // DATABASE를 처리하기 위해서 TRY-CATCH문 사용
        try {
            conn = getConnection();
            sql = "SELECT max(b_id) FROM boardt"; // 최대값 구하기
            pstmt = conn.prepareStatement(sql); // sql문 호출 후 객체로 받음
            rs = pstmt.executeQuery(); // SELECT는 executeQuery() 메서드를 사용한다.
            // 이후에 ResultSet 의 변수인 rs 로 대입한다.

            if(rs.next()) { // 글이 있는 경우
                number = rs.getInt(1) +1; // getInt(1) 은 1번째 컬럼을 의미한다.
                // 따라서, 다음과 같이 쓸 수도 있다. number = rs.getInt("MAX(B_ID)") + 1;
                // 값이 있을 경우에는 +1 이 된다.
            }else { // 글이 없는 경우
                number = 1;
            }
            // number 를 INSERT 때 대입하면 된다.

            sql = "INSERT INTO BOARDT VALUES(?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql); // sql 문 재설정

            // insert시에 어떤 값이 들어가는지 보기 위해서 console 에 출력 (Null 출력 테스트용)
            System.out.println(board.getB_name());
            System.out.println(board.getB_email());
            System.out.println(board.getB_email());
            System.out.println(board.getB_content());

            // sql 문의 ?에 넣는 값을 setString으로 지정한다.
            // 인덱스와, member.getSOMTHING() 메서드를 활용
            pstmt.setInt(1, number);
            pstmt.setString(2, board.getB_name());
            pstmt.setString(3, board.getB_email());
            pstmt.setString(4, board.getB_title());
            pstmt.setString(5, board.getB_content());

            // Query를 전부 등록 후에는 executeUpdate() 메서드 실행
            pstmt.executeUpdate();

            System.out.println("추가성공");
            re = 1;

        }catch(SQLException ex){
            System.out.println("추가 실패");
            ex.printStackTrace();
        } finally {
            try {
                if(pstmt != null) pstmt.close();
                if(conn != null) conn.close();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
        return re;
    }
}