package com.project.greenbook.dto;

public class MemDTO {
    String mem_id;
    String mem_pwd;
    String mem_pwdchk;
    String mem_name;
    String mem_phone1;
    String mem_phone2;
    String mem_phone3;
    String mem_email;
    int mem_postcode;
    String mem_address;
    String mem_extraAddress;
    String mem_detailAddress;

    public String getMem_id() { return mem_id; }
    public void setMem_id(String mem_id) { this.mem_id = mem_id; }
    public String getMem_pwd() { return mem_pwd; }
    public void setMem_pwd(String mem_pwd) { this.mem_pwd = mem_pwd; }
    public String getMem_pwdchk() { return mem_pwdchk; }
    public void setMem_pwdchk(String mem_pwdchk) { this.mem_pwdchk = mem_pwdchk; }
    public String getMem_name() { return mem_name; }
    public void setMem_name(String mem_name) { this.mem_name = mem_name; }
    public String getMem_phone1() { return mem_phone1;}
    public void setMem_phone1(String mem_phone1) { this.mem_phone1 = mem_phone1; }
    public String getMem_phone2() { return mem_phone2;}
    public void setMem_phone2(String mem_phone2) { this.mem_phone2 = mem_phone2; }
    public String getMem_phone3() { return mem_phone3; }
    public void setMem_phone3(String mem_phone3) { this.mem_phone3 = mem_phone3; }
    public String getMem_email() { return mem_email; }
    public void setMem_email(String mem_email) { this.mem_email = mem_email; }
    public int getMem_postcode() { return mem_postcode; }
    public void setMem_postcode(int mem_postcode) { this.mem_postcode = mem_postcode; }
    public String getMem_address() { return mem_address; }
    public void setMem_address(String mem_address) { this.mem_address = mem_address; }
    public String getMem_extraAddress() { return mem_extraAddress; }
    public void setMem_extraAddress(String mem_extraAddress) { this.mem_extraAddress = mem_extraAddress; }
    public String getMem_detailAddress() { return mem_detailAddress; }
    public void setMem_detailAddress(String mem_detailAddress) { this.mem_detailAddress = mem_detailAddress; }

    public MemDTO() { }

    public MemDTO(String mem_id, String mem_pwd, String mem_name, String mem_phone1, String mem_phone2, String mem_phone3, String mem_email, int mem_postcode, String mem_address, String mem_extraAddress, String mem_detailAddress) {
        this.mem_id = mem_id;
        this.mem_pwd = mem_pwd;
        this.mem_name = mem_name;
        this.mem_phone1 = mem_phone1;
        this.mem_phone2 = mem_phone2;
        this.mem_phone3 = mem_phone3;
        this.mem_email = mem_email;
        this.mem_postcode = mem_postcode;
        this.mem_address = mem_address;
        this.mem_extraAddress = mem_extraAddress;
        this.mem_detailAddress = mem_detailAddress;
    }
}
