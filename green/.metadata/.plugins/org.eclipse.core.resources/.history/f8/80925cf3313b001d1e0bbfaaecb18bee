package member;

import java.sql.Timestamp;

public class MemberBean {
	private String user_id;
	private String user_pwd;
	private String user_name;
	private String user_phone1;
	private String user_phone2;
	private String user_phone3;
	private String user_email;
	private String user_pcode;
	private String user_raddr;
	private String user_jibun;
	private String user_detailaddr;
	private int user_grade;	
	private Timestamp user_regdate;
	
	public static int pageSize=10;
	public static int pageCount=1;
	public static int pageNum=1;
	
	public static String s_user_id;
	
	public static String pageNumber(int limit) {
		String str="";
		int startPage = pageNum;
		if(startPage > 1) {
			startPage = pageNum -1;
		} else {
			startPage = 1;
		}
		
		//if(startPage - limit>0) {
		if(startPage > 1) {
			int temp=startPage-limit;
			if(temp <= 0) {
				temp=1;
			}
			str="<a href = 'adminIndex.jsp?pageNum="+(temp)+"&search_user_id="+s_user_id+"&pages=listMember'>[이전]</a>&nbsp;&nbsp";
		}
		
		for(int i=startPage;i<(startPage+limit);i++) {
			if(i==pageNum) {
				str +="["+i+"]&nbsp&nbsp";
			} else {
				str+="<a href='adminIndex.jsp?pageNum="+i+"&search_user_id="+s_user_id+"&pages=listMember'>["+i+"]</a>&nbsp;&nbsp;";
			}
			if(i>=pageCount)break;
		}
		
		if(startPage + limit<=pageCount) {
			str+="<a href = 'adminIndex.jsp?pageNum="+(startPage+limit)+"&search_user_id="+s_user_id+"&pages=listMember'>[다음]</a>&nbsp;&nbsp";
		}
		
		return str;
	}
	
	public static String pageNumber(int limit, String url) {
		String str = "";
		int temp = (pageNum-1) % limit;
		int startPage = pageNum - temp;
		
		if(startPage - limit > 0) {
			str ="<li class=\"page-item\"><a class=\"page-link\" href ='"+url+".jsp?pageNum="+(startPage-limit)+"&pages=member_list'>이전</a></li>";
		}
		for (int i = startPage; i < (startPage+limit); i++) {//안쪽 페이지 번호
			str+="<li class=\"page-item\"><a class=\"page-link\" href='"+url+".jsp?pageNum="+i+"&pages=member_list'>"+i+"</a></li>";
			if (i >= pageCount) { 
				break;
			}
		}
		if ((startPage + limit) <= pageCount) {
			str += "<li class=\"page-item\"><a class=\"page-link\" href = '"+url+".jsp?pageNum="+(startPage+limit)+"&pages=member_list'>다음</a></li>";
		}
		return str;
	}
	
	
	
	public String getUser_phone1() {
		return user_phone1;
	}
	
	public void setUser_phone1(String user_phone1) {
		this.user_phone1 = user_phone1;
	}
	
	public String getUser_phone2() {
		return user_phone2;
	}
	
	public void setUser_phone2(String user_phone2) {
		this.user_phone2 = user_phone2;
	}
	
	public String getUser_phone3() {
		return user_phone3;
	}
	
	public void setUser_phone3(String user_phone3) {
		this.user_phone3 = user_phone3;
	}

	public Timestamp getUser_regdate() {
		return user_regdate;
	}
	public void setUser_regdate(Timestamp user_regdate) {
		this.user_regdate = user_regdate;
	}

	/*
	 * public String getUser_grade() { return user_grade; } public void
	 * setUser_grade(String user_grade) { this.user_grade = user_grade; }
	 */
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_pwd() {
		return user_pwd;
	}
	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_pcode() {
		return user_pcode;
	}

	public void setUser_pcode(String user_pcode) {
		this.user_pcode = user_pcode;
	}

	public String getUser_raddr() {
		return user_raddr;
	}

	public void setUser_raddr(String user_raddr) {
		this.user_raddr = user_raddr;
	}

	public String getUser_jibun() {
		return user_jibun;
	}

	public void setUser_jibun(String user_jibun) {
		this.user_jibun = user_jibun;
	}

	public String getUser_detailaddr() {
		return user_detailaddr;
	}

	public void setUser_detailaddr(String user_detailaddr) {
		this.user_detailaddr = user_detailaddr;
	}

	public int getUser_grade() {
		return user_grade;
	}

	public void setUser_grade(int user_grade) {
		this.user_grade = user_grade;
	}
	
}