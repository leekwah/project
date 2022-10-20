package com.project.greenbook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    @RequestMapping("/register")
    public String register() {

        return "login/register";
    }
    @RequestMapping("/login")
    public String login() {

        return "login/login";
    }
    @RequestMapping("/loginOk")
    public String loginOk() {
        return "login/login_ok";
    }
}
