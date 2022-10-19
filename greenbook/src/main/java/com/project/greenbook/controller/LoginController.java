package com.project.greenbook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    @RequestMapping("/login")
    public String login() {
        return "/login/login";
    }
    @RequestMapping("/login_yn")
    public String loginYn() {

        return "/login/login_ok";
    }
}
