package com.leekwah.shop.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "cart_item")
@Data
public class CartItem {

    @Id
    @GeneratedValue
    @Column(name = "cart_item_id")
    private Long id;

    @ManyToOne // 하나의 장바구니에는 여러개의 상품을 담을 수 있으므로, 다대일 관계로 매핑한다.
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @ManyToOne // 하나의 상품은 여러 장바구니의 장바구니 상품으로 담길 수 있으므로 마찬가지로 다대일 관계로 매핑한다.
    @JoinColumn(name = "item_id")
    private Item item;

    private int count; // 장바구니에 몇 개 저장할 지의 개수

}
