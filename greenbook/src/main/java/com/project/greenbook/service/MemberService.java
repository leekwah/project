package com.project.greenbook.service;

import com.project.greenbook.dto.MemberDTO;

import javax.servlet.http.HttpSession;

public interface MemberService {
    public String loginCheck(MemberDTO dto, HttpSession session);
    public void logout(HttpSession session);
}
