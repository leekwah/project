package com.project.onstagram.domain;

import lombok.*;

import java.time.LocalDate;

@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PostVO {
    private Long pno;
    private String title;
    private LocalDate dueDate;
    private boolean finished;
}
