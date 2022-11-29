package com.project.onstagram.dao;

import com.project.onstagram.domain.PostVO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class PostDAOTests {
    private PostDAO postDAO;

    @BeforeEach
    public void ready() {
        postDAO = new PostDAO();
    }
    @Test
    public void testTime() throws Exception {
        System.out.println(postDAO.getTime());
    }

    @Test
    public void testInsert() throws Exception {
        PostVO postVO = PostVO.builder()
                .title("Sample title")
                .dueDate(LocalDate.of(2022,11,30))
                .build();

        postDAO.insert(postVO);
    }

}
