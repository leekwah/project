package com.leekwah.shop.controller;

import com.leekwah.shop.dto.MemberFormDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ItemController {

    @GetMapping(value = "/admin/item/new")
    public String itemForm(Model model) {
        model.addAttribute("itemFormDto", new MemberFormDto());
        return "/item/itemForm";
    }


}
