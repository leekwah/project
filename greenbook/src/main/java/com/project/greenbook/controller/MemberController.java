package com.project.greenbook.controller;

import com.project.greenbook.dto.MemberDTO;
import com.project.greenbook.service.MemberService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;

@Controller
public class MemberController {
    @Autowired
    private MemberService memberService;

    @RequestMapping("/login")
    public String login() {

        return "member/login";
    }
    @RequestMapping("/loginCheck")
    public String loginCheck(HttpServletRequest request, @RequestParam HashMap<String, String> param, Model model) {
        HttpSession session = request.getSession();
        ArrayList<MemberDTO> dtos = memberService.loginCheck(param);
        model.addAttribute("loginCheck", dtos);
        String address = dtos.get(0).getMember_address();
        String name = dtos.get(0).getMember_name();

        String pw = param.get("member_pwd");
        System.out.println(address);
        System.out.println(name);

        if (dtos.isEmpty()) {
            return "redirect:login";
        } else {
            if (pw.equals(dtos.get(0).getMember_pwd())) {
                session.setAttribute("member_id",param.get("member_id"));
                return "redirect:loginOk";
            }
            return "redirect:login";
        }
    }
    @RequestMapping("/loginOk")
    public String loginOk(HttpServletRequest request, @RequestParam HashMap<String, String> param, Model model) {
        HttpSession session = request.getSession();
        param.put("member_id",(String) session.getAttribute("member_id"));

        ArrayList<MemberDTO> dtos = memberService.loginCheck(param);
        String address = dtos.get(0).getMember_address();
        String name = dtos.get(0).getMember_name();

        String pw = param.get("member_pwd");

        model.addAttribute("memberInfo",dtos);

        return "member/login_ok";
    }

    @RequestMapping("/logout")
    public ModelAndView logout(HttpSession session, ModelAndView mav) {
        memberService.logout(session);
        mav.setViewName("member/login");
        mav.addObject("message", "logout");
        return mav;
    }

    @RequestMapping("/signUp")
    public String signUp() {
        return "member/signup";
    }

    @RequestMapping("/signUpOk")
    public String signUpOk(@RequestParam HashMap<String, String> param, Model model) {
        memberService.signUp(param);

        return "redirect:login";
    }

    // 마이페이지
    @RequestMapping("/mypage")
    public String myPage(HttpServletRequest request, @RequestParam HashMap<String, String> param, Model model) {
        HttpSession session = request.getSession();
        param.put("member_id",(String) session.getAttribute("member_id"));

        ArrayList<MemberDTO> dtos = memberService.loginCheck(param);
        model.addAttribute("memberInfo",dtos);

        return "member/mypage";
    }

    //아이디 중복확인
    @RequestMapping(value = "/member/overlay",  method = RequestMethod.POST)
    public @ResponseBody HashMap<String, Object> overlay(Model model, @RequestParam String id) {
        return memberService.overlay(id);
    }

    //이메일 중복확인
    @RequestMapping(value = "/member/emoverlay",  method = RequestMethod.POST)
    public @ResponseBody HashMap<String, Object> emoverlay( Model model, @RequestParam String email) {
        return memberService.emoverlay(email);
    }

    @RequestMapping("/memberModify")
    public String modify(HttpServletRequest request, @RequestParam HashMap<String, String> param, Model model) {
        HttpSession session = request.getSession();
        param.put("member_id",(String) session.getAttribute("member_id"));

        ArrayList<MemberDTO> dtos = memberService.loginCheck(param);
        model.addAttribute("memberInfo", dtos);

        return "member/modify";
    }
    @RequestMapping("/memberModifyUpdate")
    public String memberModify(HttpServletRequest request, @RequestParam HashMap<String, String> param, Model model) {
        HttpSession session = request.getSession();
        param.put("member_id",(String) session.getAttribute("member_id"));

        ArrayList<MemberDTO> dtos = memberService.loginCheck(param);
        model.addAttribute("memberInfo", dtos);

        memberService.memberModify(param);

        return "redirect:mypage";
    }
    @RequestMapping("/withdrawal")
    public String withdrawal(HttpServletRequest request, @RequestParam HashMap<String, String> param, Model model) {
        HttpSession session = request.getSession();

        memberService.withdrawal(param);
        return "redirect:login";
    }
}
