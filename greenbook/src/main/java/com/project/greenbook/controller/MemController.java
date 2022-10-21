package com.project.greenbook.controller;

import com.project.greenbook.dto.MemDTO;
import com.project.greenbook.service.MemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;

@Controller
public class MemController {
    @Autowired
    private MemService service;
    @RequestMapping("/register")
    public String register() {
        return "login/register";
    }
    @RequestMapping("/register_ok")
    public String registerOk(@RequestParam HashMap<String, String> param) {

        service.register(param);

        return "login/register_ok";
    }
    @RequestMapping("/login")
    public String login() {

        return "login/login";
    }

    @RequestMapping("login_yn")
    public String loginYn(@RequestParam HashMap<String, String> param, Model model) {
        ArrayList<MemDTO> dto = service.loginYn(param);
        String pw = param.get("mem_pwd");

        if (dto.isEmpty()) {
            return "redirect:login";
        } else {
            if (pw.equals(dto.get(0).getMem_pwd())) {
                return "redirect:/login_ok";
            } else {
                return "redirect:login";
            }
        }
    }

    @RequestMapping("/login_ok")
    public String loginOk(Model model) {

        ArrayList<MemDTO> loginLog = service.list();
        model.addAttribute("loginLog", loginLog);

        return "login/login_ok";

    }
}
