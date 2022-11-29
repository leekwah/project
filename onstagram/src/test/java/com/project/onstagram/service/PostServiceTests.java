package com.project.onstagram.service;

import com.project.onstagram.dto.PostDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

@Log4j2
public class PostServiceTests {

    private PostService postService;

    @BeforeEach
    public void ready() {
        postService = PostService.INSTANCE;
    }

    @Test
    public void testRegister() throws Exception {

        PostDTO postDTO = PostDTO.builder()
                .title("JDBC TEST TITLE")
                .dueDate(LocalDate.now())
                .build();

        log.info("--------------------------------------------------");
        log.info(postDTO);

        postService.register(postDTO);
    }
}
