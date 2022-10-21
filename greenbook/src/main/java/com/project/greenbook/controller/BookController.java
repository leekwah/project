package com.project.greenbook.controller;

import com.project.greenbook.dto.BookDTO;
import com.project.greenbook.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;

@Controller
public class BookController {
    @Autowired
    private BookService service;
    @RequestMapping("/list")
    public String list(Model model) {
        System.out.println("BookController.list() start");

        ArrayList<BookDTO> booklist = service.list();
        model.addAttribute("booklist", booklist);

        return "list";
    }
    @RequestMapping("/write_view")
    public String write_view(Model model) {
        return "write_view";
    }
    @RequestMapping("/write")
    public String write(@RequestParam HashMap<String, String> param) {
        service.write(param);

        return "redirect:list";
    }
    @RequestMapping("/")
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("title", "Spring Test");
        mav.addObject("content", "EL test");
        mav.setViewName("index");

        return mav;
    }
}
