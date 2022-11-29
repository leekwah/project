package com.project.onstagram.service;

import com.project.onstagram.dto.PageRequestDTO;
import com.project.onstagram.dto.PageResponseDTO;
import com.project.onstagram.dto.PostDTO;
import com.project.onstagram.dto.PostListReplyCountDTO;

public interface PostService {
    Long register(PostDTO postDTO);
    PostDTO readOne (Long pno);
    void modify(PostDTO postDTO);
    void remove(Long pno);
    PageResponseDTO<PostDTO> list(PageRequestDTO pageRequestDTO);
    PageResponseDTO<PostListReplyCountDTO> listWithReplyCount(PageRequestDTO pageRequestDTO);
}
