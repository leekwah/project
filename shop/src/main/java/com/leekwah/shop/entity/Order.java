package com.leekwah.shop.entity;

import com.leekwah.shop.constant.OrderStatus;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders") // order 키워드가 정의되어 있기 때문에, orders 로 테이블 명을 설정한다.
@Data
public class Order {

    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    @ManyToOne // 한 명의 회원은 여러 번 주문을 할 수 있으므로, 다대일 단방향 매핑을 한다.
    @JoinColumn(name = "member_id")
    private Member member;

    private LocalDateTime orderDate; // 주문일

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus; // 주문상태

    @OneToMany(mappedBy = "order") // 주문 상품 엔티티와 일대다 매핑을 한다.
    // 외래키인 order_id 가 order_item 테이블에 있으므로, 연관관계의 주인은 OrderItem 엔티티다.
    // Order 엔티티가 주인이 아니므로, "mappedBy" 속성으로 연관 관계의 주인을 설정한다.
    // 속성의 값으로 "order" 를 적어준 이유는 OrderItem 에 있는 Order 에 의해 관리된다는 의미로 해석하면 된다.
    // -> 연관관계의 주인의 필드인 order 를 mappedBy 값으로 설정한다.
    private List<OrderItem> orderItems = new ArrayList<>();

    private LocalDateTime regTime;

    private LocalDateTime updateTime;
}
