package com.project.greenbook.dto;

public class LoginDTO {
    String user_id;
    String user_pwd;
    String user_name;
    int user_tel1;
    int user_tel2;
    int user_tel3;
    String user_email;
    int postcode;
    String address;
    String extraAddress;
    String detailAddress;

    public String getUser_id() { return user_id; }
    public void setUser_id(String user_id) { this.user_id = user_id; }
    public String getUser_pwd() { return user_pwd; }
    public void setUser_pwd(String user_pwd) { this.user_pwd = user_pwd; }
    public String getUser_name() { return user_name; }
    public void setUser_name(String user_name) { this.user_name = user_name; }
    public int getUser_tel1() { return user_tel1; }
    public void setUser_tel1(int user_tel1) { this.user_tel1 = user_tel1; }
    public int getUser_tel2() { return user_tel2; }
    public void setUser_tel2(int user_tel2) { this.user_tel2 = user_tel2; }
    public int getUser_tel3() { return user_tel3; }
    public void setUser_tel3(int user_tel3) { this.user_tel3 = user_tel3; }
    public String getUser_email() { return user_email; }
    public void setUser_email(String user_email) { this.user_email = user_email; }
    public int getPostcode() { return postcode; }
    public void setPostcode(int postcode) { this.postcode = postcode; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getExtraAddress() { return extraAddress; }
    public void setExtraAddress(String extraAddress) { this.extraAddress = extraAddress; }
    public String getDetailAddress() { return detailAddress; }
    public void setDetailAddress(String detailAddress) { this.detailAddress = detailAddress; }

    public LoginDTO () {}

    public LoginDTO(String user_id, String user_pwd, String user_name, int user_tel1, int user_tel2, int user_tel3, String user_email, int postcode, String address, String extraAddress, String detailAddress) {
        this.user_id = user_id;
        this.user_pwd = user_pwd;
        this.user_name = user_name;
        this.user_tel1 = user_tel1;
        this.user_tel2 = user_tel2;
        this.user_tel3 = user_tel3;
        this.user_email = user_email;
        this.postcode = postcode;
        this.address = address;
        this.extraAddress = extraAddress;
        this.detailAddress = detailAddress;
    }
}
