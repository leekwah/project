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
	
	public int getUser_grade() {
		return user_grade;
	}
	public void setUser_grade(int user_grade) {
		this.user_grade = user_grade;
	}
	private Timestamp user_regdate;
	
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
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public Timestamp getUser_regdate() {
		return user_regdate;
	}
	public void setUser_regdate(Timestamp user_regdate) {
		this.user_regdate = user_regdate;
	}
}