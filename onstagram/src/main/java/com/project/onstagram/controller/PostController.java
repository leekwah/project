package com.project.onstagram.controller;

import com.project.onstagram.dto.PageRequestDTO;
import com.project.onstagram.dto.PageResponseDTO;
import com.project.onstagram.dto.PostDTO;
import com.project.onstagram.dto.PostListReplyCountDTO;
import com.project.onstagram.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/board")
@Log4j2
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping("/list")
    public void list(PageRequestDTO pageRequestDTO, Model model) {
        // PageResponseDTO<BoardDTO> responseDTO = boardService.list(pageRequestDTO);

        PageResponseDTO<PostListReplyCountDTO> responseDTO = postService.listWithReplyCount(pageRequestDTO);

        log.info(responseDTO);

        model.addAttribute("responseDTO", responseDTO);
    }

    @GetMapping("/post")
    public void registerGET() {}

    @PostMapping("/post")
    public String registerPost(@Valid PostDTO postDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        log.info("post Post register ..........");

        if (bindingResult.hasErrors()) {
            log.info("has errors ..........");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());

            return "redirect:/post/register";
        }

        log.info(postDTO);

        Long bno = postService.register(postDTO);

        redirectAttributes.addAttribute("result", bno);

        return "redirect:/board/list";
    }

    @GetMapping({"/read", "/modify"})
    public void read(Long bno, PageRequestDTO pageRequestDTO, Model model){
        PostDTO boardDTO = postService.readOne(bno);

        log.info(boardDTO);

        model.addAttribute("dto", boardDTO);
    }

    @PostMapping("/modify")
    public String modify(PageRequestDTO pageRequestDTO, @Valid PostDTO postDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        log.info("board modify post .........." + postDTO);

        if (bindingResult.hasErrors()) {
            log.info("has errors ..........");

            String link = pageRequestDTO.getLink();

            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            redirectAttributes.addFlashAttribute("pno", postDTO.getPno());

            return "redirect:/board/modify?"+link;
        }

        postService.modify(postDTO);

        redirectAttributes.addFlashAttribute("result", "modified");
        redirectAttributes.addAttribute("pno", postDTO.getPno());

        return "redirect:/board/read";
    }

    @PostMapping("/remove")
    public String remove(Long pno, RedirectAttributes redirectAttributes) {
        log.info("remove post .......... " + pno);

        postService.remove(pno);
        redirectAttributes.addFlashAttribute("result", "removed");

        return "redirect:/board/list";
    }
}
