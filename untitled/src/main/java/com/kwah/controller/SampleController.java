package com.kwah.controller;

import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Log4j
public class SampleController {

    @RequestMapping("/index")
    public ModelAndView index(){
        log.info("index controller start!!");

        ModelAndView mav = new ModelAndView();
        mav.addObject("title", "Spring Test");
        mav.addObject("content", "Hello World!!");
        mav.setViewName("index");

        return mav;
    }
}
