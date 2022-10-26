package com.project.greenbook.controller;

import com.project.greenbook.dao.MemberDAO;
import com.project.greenbook.dto.MemberDTO;
import com.project.greenbook.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;

@Controller
public class MemberController {
    @Autowired
    private MemberService memberService;
    @RequestMapping("/")
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("title", "Spring Test");
        mav.addObject("content", "EL TEST");
        mav.setViewName("index");

        return mav;
    }


    @RequestMapping("/login")
    public String login() {

        return "member/login";
    }

    @RequestMapping("/loginCheck")
    public String loginCheck(@RequestParam HashMap<String, String> param, Model model) {
        ArrayList<MemberDTO> dtos = memberService.loginCheck(param);
        String pw = param.get("member_pwd");

        if (dtos.isEmpty()) {
            return "redirect:login";
        } else {
            if (pw.equals(dtos.get(0).getMember_pwd())) {
                return "redirect:loginOk";
            }
            return "redirect:login";
        }
    }

    @RequestMapping("/loginOk")
    public String loginOk(Model model) {
        model.addAttribute("member_name", "유저");

        return "member/login_ok";
    }
    @RequestMapping("/logOut")
    public ModelAndView logout(HttpSession session, ModelAndView mav) {
        memberService.logout(session);
        mav.setViewName("member/login");
        mav.addObject("message", "logout");
        return mav;
    }

    @RequestMapping("/signUp")
    public String signUp() {

        return "member/sign_up";
    }

    @RequestMapping("/signUpOk")
    public String signUpOk(@RequestParam HashMap<String, String> param, Model model) {
        memberService.signUp(param);

        return "redirect:login";
    }
    @RequestMapping("/myPage")
    public String myPage() {
        return "member/mypage";
    }
}
