package com.project.greenbook.service;

import com.project.greenbook.dao.MemberDAO;
import com.project.greenbook.dto.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class MemberServiceImpl implements MemberService{
    @Autowired
    private MemberDAO memberDAO;

    @Override
    public String loginCheck(MemberDTO dto, HttpSession session) {
        String name = memberDAO.loginCheck(dto);

        if (name != null) { // 세션 변수 저장
            session.setAttribute("member_id", dto.getMember_id());
            session.setAttribute("member_name", name);
        }

        return name;
    }

    @Override
    public void logout(HttpSession session) {
        session.invalidate(); // 세션 초기화
    }
}
