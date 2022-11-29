package com.project.onstagram.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {
    private Long pno;
    private String title;
    private LocalDate dueDate;
    private boolean finished;
}
