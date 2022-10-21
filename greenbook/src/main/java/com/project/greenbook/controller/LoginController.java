package com.project.greenbook.controller;

import com.project.greenbook.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@Controller
public class LoginController {
    @Autowired
    private LoginService service;
    @RequestMapping("/register")
    public String register() {
        return "login/register";
    }
    @RequestMapping("/registerOk")
    public String registerOk(@RequestParam HashMap<String, String> param) {

        service.register(param);

        return "redirect:login";
    }
    @RequestMapping("/login")
    public String login() {

        return "login/login";
    }
    @RequestMapping("/loginOk")
    public String loginOk() {
        return "redirect:login/login";
    }
}
