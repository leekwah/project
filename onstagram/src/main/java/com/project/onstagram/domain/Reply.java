package com.project.onstagram.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Reply", indexes = {
        @Index(name = "idx_reply_post_pno", columnList = "post_pno")
})
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "post")
public class Reply extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rno;

    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;

    private String replyText;
    private String replyer;

    public void changeText(String text){
        this.replyText = text;
    }
}
