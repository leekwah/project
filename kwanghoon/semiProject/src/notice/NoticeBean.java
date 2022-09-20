package notice;

import java.sql.Timestamp;

public class NoticeBean {
	private int n_num;
	private String n_title;
	private String n_content;
	private Timestamp n_date;
	private String n_pwd;
	private String n_ip;
	private int n_hit;
	
	// 페이징
	public static int pageSize = 10;
	public static int pageCount = 1;
	public static int pageNum = 1; 
	
	// 페이지 목록을 만드는 메서드
	public static String pageNumber(int limit) {
		String str = ""; // retrun value
		int temp = (pageNum - 1) % limit; // 시작 페이지를 구하기 위함
		int startPage = pageNum - temp; // 시작 페이지 설정 1 - 0 = 1
		
		if ((startPage - limit) > 0) {
			// notice_list.jsp로 부터 시작
			str="<a href='notice_list.jsp?pageNum=" + (startPage - 1) +"'>[<<]</a>&nbsp;&nbsp;";
		} 
		
		for (int i = startPage; i < (startPage + limit); i++) {
			if (i  == pageNum) {
				str += "["+i+"]&nbsp;&nbsp";
			} else {
				str += "<a href='notice_list.jsp?pageNum="+i+"'>"+"["+i+"]</a>&nbsp;&nbsp;";
			}
			if (i >= pageCount ) break;
		}
		
		if ((startPage + limit) <= pageCount) {
			str += "<a href='notice_list.jsp?pageNum="+(startPage + limit) + "'>[>>]</a>";
		}
		return str;
	}

	public int getN_num() { return n_num; }
	public void setN_num(int n_num) { this.n_num = n_num; }
	public String getN_title() { return n_title; }
	public void setN_title(String n_title) { this.n_title = n_title; }
	public String getN_content() { return n_content; }
	public void setN_content(String n_content) { this.n_content = n_content; }
	public Timestamp getN_date() { return n_date; }
	public void setN_date(Timestamp n_date) { this.n_date = n_date; }
	public String getN_pwd() { return n_pwd; }
	public void setN_pwd(String n_pwd) { this.n_pwd = n_pwd; }
	public String getN_ip() { return n_ip; }
	public void setN_ip(String n_ip) { this.n_ip = n_ip; }
	public int getN_hit() { return n_hit; }
	public void setN_hit(int n_hit) { this.n_hit = n_hit; }
	
}
