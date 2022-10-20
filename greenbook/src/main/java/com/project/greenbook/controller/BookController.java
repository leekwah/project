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

        System.out.println("BookController.list() end");
        return "list";
    }

    @RequestMapping("/write_view")
    public String write_view(Model model) {
        System.out.println("BookController.write_view() start");

        System.out.println("BookController.write_view() end");
        return "write_view"; // 여기로 가서 글쓰기 form을 생성할 것이다.
    }

    @RequestMapping("/write")
    public String write(@RequestParam HashMap<String, String> param) {
        System.out.println("BookController.write() start");

        service.write(param);

        System.out.println("BookController.write() end");
        return "redirect:list"; // list로 가려면, redirect를 통해서 가야한다.
    }
    @RequestMapping("/")
    public ModelAndView index() {

        ModelAndView mav = new ModelAndView();
        mav.addObject("title", "Spring Test");
        mav.addObject("content", "EL TEST");
        mav.setViewName("index");

        return mav;
    }
}
