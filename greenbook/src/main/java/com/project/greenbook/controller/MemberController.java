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
@Log4j
public class MemberController {
    @Autowired
    private MemberService memberService;

    @RequestMapping("/login")
    public String login() {

        return "member/login";
    }

    @RequestMapping("/loginCheck")
    public String loginCheck(HttpServletRequest request,@RequestParam HashMap<String, String> param, Model model) {

        ArrayList<MemberDTO> dtos = memberService.loginCheck(param);
        String pw = param.get("member_pwd");
        HttpSession session = request.getSession();
        if (dtos.isEmpty()) {
            return "redirect:login";
        } else {
            if (pw.equals(dtos.get(0).getMember_pwd())) {
                session.setAttribute("member_id",param.get("member_id"));
                return "redirect:/";
            }
            return "redirect:login";
        }
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        memberService.logout(session);
        return "redirect:/";
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

    @RequestMapping("/mypage")
    public String myPage() {
        return "member/mypage";
    }

    //아이디 중복확인
    @ResponseBody
    @RequestMapping(value = "/singup", method = RequestMethod.GET)
    public void registerGET() throws Exception {}

    @ResponseBody
    @RequestMapping(value = "/idCheck", method = RequestMethod.POST)
    public int idCheck(String member_id) throws Exception {
        int result = memberService.idCheck(member_id);
        return result;
    }

}
