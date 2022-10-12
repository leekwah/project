package cs;

import java.sql.Timestamp;

public class NoticeBean {
	private int n_num;
	private String n_title;
	private String n_content;
	private Timestamp n_date;
	private int n_hit;
	private String n_pwd;
	private String n_ip;
	private String user_id;
	private int before;
	private int after;

	public static int pageSize=10;
	public static int pageCount=1;
	public static int pageNum=1;
	

	public static String pageNumber(int limit) {
		String str = "";
		int temp = (pageNum-1)%limit;
		int startPage = pageNum - temp; // 시작 페이지 > 한번에 보여지는 페이지 번호의 처음 숫자
		
		if ((startPage - limit) > 0) { // 시작 페이지가
			str = "<li class=\"page-item\"><a class=\"page-link\" href = 'adminIndex.jsp?pageNum="+(startPage-1)+"&pages=noticeList'>이전</a></li>";
		}
		for (int i = startPage; i < (startPage+limit) ; i++) {
			str+="<li class=\"page-item\"><a class=\"page-link\" href='adminIndex.jsp?pageNum="+i+"&pages=noticeList'>"+i+"</a></li>";
			if (i >= pageCount) { 
				break;
			}
		}
		if ((startPage + limit) <= pageCount) {
			str += "<li class=\"page-item\"><a class=\"page-link\" href = 'adminIndex.jsp?pageNum="+(startPage+limit)+"&pages=noticeList'>다음</a></li>";
		}
		return str;
	}
	public static String userPageNumber(int limit) {
		String str = "";
		int temp = (pageNum-1)%limit;
		int startPage = pageNum - temp; // 시작 페이지 > 한번에 보여지는 페이지 번호의 처음 숫자
		
		if ((startPage - limit) > 0) { // 시작 페이지가
			str = "<li class=\"page-item\"><a class=\"page-link\" href = 'noticeList_u.jsp?pageNum="+(startPage-1)+"'>이전</a></li>";
		}
		for (int i = startPage; i < (startPage+limit) ; i++) {
			str+="<li class=\"page-item\"><a class=\"page-link\" href='noticeList_u.jsp?pageNum="+i+"'>"+i+"</a></li>";
			if (i >= pageCount) { 
				break;
			}
		}
		if ((startPage + limit) <= pageCount) {
			str += "<li class=\"page-item\"><a class=\"page-link\" href = 'noticeList_u.jsp?pageNum="+(startPage+limit)+"'>다음</a></li>";
		}
		return str;
	}
	
	public int getBefore() {
		return before;
	}


	public void setBefore(int before) {
		this.before = before;
	}


	public int getAfter() {
		return after;
	}


	public void setAfter(int after) {
		this.after = after;
	}


	public int getN_num() {
		return n_num;
	}


	public void setN_num(int n_num) {
		this.n_num= n_num;
	}


	public String getN_title() {
		return n_title;
	}


	public void setN_title(String n_title) {
		this.n_title = n_title;
	}


	public String getN_content() {
		return n_content;
	}


	public void setN_content(String n_content) {
		this.n_content = n_content;
	}


	public Timestamp getN_date() {
		return n_date;
	}


	public void setN_date(Timestamp n_date) {
		this.n_date = n_date;
	}


	public int getN_hit() {
		return n_hit;
	}


	public void setN_hit(int n_hit) {
		this.n_hit = n_hit;
	}


	public String getN_pwd() {
		return n_pwd;
	}


	public void setN_pwd(String n_pwd) {
		this.n_pwd = n_pwd;
	}


	public String getN_ip() {
		return n_ip;
	}


	public void setN_ip(String n_ip) {
		this.n_ip = n_ip;
	}


	public String getUser_id() {
		return user_id;
	}


	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	
	
}
