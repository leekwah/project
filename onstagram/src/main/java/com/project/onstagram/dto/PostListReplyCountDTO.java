package com.project.onstagram.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PostListReplyCountDTO {
    private Long pno;
    private String title;
    private String writer;
    private LocalDateTime regDate;

    private Long replyCount;
}
