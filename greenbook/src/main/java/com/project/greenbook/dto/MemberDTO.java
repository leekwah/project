package com.project.greenbook.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class MemberDTO {
    private String member_id;
    private String member_pwd;
    private String member_phone;
    private String member_name;
    private String member_email;
    private int member_postcode;
    private String member_address;
    private String member_extraAddress;
    private String member_detailAddress;

    public MemberDTO() { }

    public MemberDTO(String member_id, String member_pwd, String member_phone, String member_name, String member_email, int member_postcode, String member_address, String member_extraAddress, String member_detailAddress) {
        this.member_id = member_id;
        this.member_pwd = member_pwd;
        this.member_phone = member_phone;
        this.member_name = member_name;
        this.member_email = member_email;
        this.member_postcode = member_postcode;
        this.member_address = member_address;
        this.member_extraAddress = member_extraAddress;
        this.member_detailAddress = member_detailAddress;
    }
}
