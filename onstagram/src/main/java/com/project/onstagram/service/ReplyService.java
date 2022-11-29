package com.project.onstagram.service;


import com.project.onstagram.dto.PageRequestDTO;
import com.project.onstagram.dto.PageResponseDTO;
import com.project.onstagram.dto.ReplyDTO;

public interface ReplyService {
    Long register(ReplyDTO replyDTO);
    ReplyDTO read(Long rno);
    void modify(ReplyDTO replyDTO);
    void remove(Long rno);
    PageResponseDTO<ReplyDTO> getListOfPost(Long pno, PageRequestDTO pageRequestDTO);
}
