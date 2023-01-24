package com.leekwah.shop.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-test.properties")
class ItemControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("상품 등록 페이지 권한 테스트")
    @WithMockUser(username = "admin", roles = "ADMIN") // 회원 이름이 admin 이고 ROLE 이 ADMIN 인 유저가 로그인 상태로 진행되게 함
    public void itemFormTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/admin/item/new")) // 상품 등록 페이지에 요청을 get
                .andDo(print()) // 요청과 응답 메시지를 확인할 수 있도록 콘솔창에 보여줌
                .andExpect(status().isOk()); // 응답 상태 코드가 정상유무 판독
    }

    @Test
    @DisplayName("상품 등록 페이지 일반 회원 접근 테스트")
    @WithMockUser(username = "user", roles = "USER") // 회원 이름이 admin 이고 ROLE 이 ADMIN 인 유저가 로그인 상태로 진행되게 함
    public void itemFormNotAdminTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/admin/item/new")) // 상품 등록 페이지에 요청을 get
                .andDo(print()) // 요청과 응답 메시지를 확인할 수 있도록 콘솔창에 보여줌
                .andExpect(status().isForbidden()); // 응답 상태 코드가 정상유무 판독
    }
}