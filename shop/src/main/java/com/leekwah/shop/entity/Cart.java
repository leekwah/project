package com.leekwah.shop.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "cart")
@Data
public class Cart {
    @Id
    @Column(name = "cart_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER) // Member 엔티티와 일대일로 매핑
    @JoinColumn(name = "member_id") // 매핑할 외래키 이름을 지정
    private Member member;

}
