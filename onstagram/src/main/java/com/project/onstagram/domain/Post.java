package com.project.onstagram.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Post extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pno; // post number

    @Column(length = 500, nullable = false) // 칼럼 길이와 null 허용여부
    private String title;

    @Column(length = 2000, nullable = false)
    private String content;

    @Column(length = 50, nullable = false)
    private String writer;

    public void change(String title, String content){
        this.title = title;
        this.content = content;
    }
}
