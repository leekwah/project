package com.project.greenbook.controller;

import com.project.greenbook.dto.MemberDTO;
import com.project.greenbook.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/member/*")
public class MemberController {
    @Autowired
    private MemberService memberService;
    @RequestMapping("login.do")
    public String login() {
        return "member/login";
    }

    @RequestMapping("loginCheck.do")
    public ModelAndView loginCheck(@ModelAttribute MemberDTO dto, HttpSession session) {
        String name = memberService.loginCheck(dto, session);
        ModelAndView mav = new ModelAndView();

        if (name != null) { // 로그인 성공 시
            mav.setViewName("home"); // 뷰의 이름을 "home"으로 설정
        } else { // 로그인 실패 시
            mav.setViewName("member/login");
            mav.addObject("message", "error");
        }
        return mav;
    }

    @RequestMapping("logout.do")
    public ModelAndView logout(HttpSession session, ModelAndView mav) {
        memberService.logout(session);
        mav.setViewName("member/login");
        mav.addObject("message", "logout");
        return mav;
    }
}
