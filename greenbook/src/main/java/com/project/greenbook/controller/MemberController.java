package com.project.greenbook.controller;

import com.project.greenbook.dto.MemberDTO;
import com.project.greenbook.service.MemberService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;

@Controller
@Log4j
public class MemberController {
    @Autowired
    private MemberService memberService;

    @RequestMapping("/list")
    public String list(Model model) {
        log.info("MemberController.list() start");

        ArrayList<MemberDTO> memberList = memberService.list();
        model.addAttribute("memberList", memberList);

        log.info("MemberController.list() end");
        return "list";

    }

    @RequestMapping("/login")
    public String login() {
        return "member/login";
    }

    @RequestMapping("/register")
    public String register() {
        return "member/register";
    }

    @RequestMapping("/register_Yn")
    public String registerYn(@RequestParam HashMap<String, String> param) {
        log.info("MemberController.registerYn() start");

        memberService.register(param);

        log.info("MemberController.registerYn() end");
        return "redirect:login";
    }

}
