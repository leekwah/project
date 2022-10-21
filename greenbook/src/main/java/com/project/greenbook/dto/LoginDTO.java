package com.project.greenbook.dto;

public class LoginDTO {
    String user_id;
    String user_pwd;
    String user_pwdchk;
    String user_name;
    int user_phone1;
    int user_phone2;
    int user_phone3;
    String user_email;
    int user_postcode;
    String user_address;
    String user_extraAddress;
    String user_detailAddress;

    public String getUser_id() { return user_id; }
    public void setUser_id(String user_id) { this.user_id = user_id; }
    public String getUser_pwd() { return user_pwd; }
    public void setUser_pwd(String user_pwd) { this.user_pwd = user_pwd; }

    public String getUser_pwdchk() { return user_pwdchk; }
    public void setUser_pwdchk(String user_pwdchk) { this.user_pwdchk = user_pwdchk; }
    public String getUser_name() { return user_name; }
    public void setUser_name(String user_name) { this.user_name = user_name; }
    public int getUser_phone1() { return user_phone1; }
    public void setUser_phone1(int user_phone1) { this.user_phone1 = user_phone1; }
    public int getUser_phone2() { return user_phone2; }
    public void setUser_phone2(int user_phone2) { this.user_phone2 = user_phone2; }
    public int getUser_phone3() { return user_phone3; }
    public void setUser_phone3(int user_phone3) { this.user_phone3 = user_phone3; }
    public String getUser_email() { return user_email; }
    public void setUser_email(String user_email) { this.user_email = user_email; }
    public int getUser_postcode() { return user_postcode; }
    public void setUser_postcode(int user_postcode) { this.user_postcode = user_postcode; }
    public String getUser_address() { return user_address; }
    public void setUser_address(String user_address) { this.user_address = user_address; }
    public String getUser_extraAddress() { return user_extraAddress; }
    public void setUser_extraAddress(String user_extraAddress) { this.user_extraAddress = user_extraAddress; }
    public String getUser_detailAddress() { return user_detailAddress; }
    public void setUser_detailAddress(String user_detailAddress) { this.user_detailAddress = user_detailAddress; }
    public LoginDTO() { }

    public LoginDTO(String user_id, String user_pwd, String user_name, int user_phone1, int user_phone2, int user_phone3, String user_email, int user_postcode, String user_address, String user_extraAddress, String user_detailAddress) {
        this.user_id = user_id;
        this.user_pwd = user_pwd;
        this.user_name = user_name;
        this.user_phone1 = user_phone1;
        this.user_phone2 = user_phone2;
        this.user_phone3 = user_phone3;
        this.user_email = user_email;
        this.user_postcode = user_postcode;
        this.user_address = user_address;
        this.user_extraAddress = user_extraAddress;
        this.user_detailAddress = user_detailAddress;
    }
}
