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
public class Order extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY) // 한 명의 회원은 여러 번 주문을 할 수 있으므로, 다대일 단방향 매핑을 한다.
    @JoinColumn(name = "member_id")
    private Member member;

    private LocalDateTime orderDate; // 주문일

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus; // 주문상태

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY) // 주문 상품 엔티티와 일대다 매핑을 한다.
    private List<OrderItem> orderItems = new ArrayList<>();
    // 외래키인 order_id 가 order_item 테이블에 있으므로, 연관관계의 주인은 OrderItem 엔티티다.
    // Order 엔티티가 주인이 아니므로, "mappedBy" 속성으로 연관 관계의 주인을 설정한다.
    // 속성의 값으로 "order" 를 적어준 이유는 OrderItem 에 있는 Order 에 의해 관리된다는 의미로 해석하면 된다.
    // -> 연관관계의 주인의 필드인 order 를 mappedBy 값으로 설정한다.

    // CascadeType.ALL 은 부모 엔티티의 영속성 상태 변화를 자식 엔티티에 모두 전이하는 옵션이다.
    // orphanRemoval = true 는 고아객체를 삭제하는 옵션이다.

    public void addOrderItem(OrderItem orderItem) { // orderItems 에는 주문 상품 정보들을 담아준다. orderItem 객체를 order 객체의 orderItems 에 추가한다.
        orderItems.add(orderItem);
        orderItem.setOrder(this); // Order 엔티티와 OrderItem 엔티티가 양방향 참조 관계이므로, orderItem 객체에도 order 객체를 설정한다.
    }

    public static Order createOrder(Member member, List<OrderItem> orderItemList) {
        Order order = new Order();
        order.setMember(member); // 상품을 주문한 회원의 정보를 설정한다.
        for (OrderItem orderItem : orderItemList) { // 상품 페이지에서는 1개의 상품을 주문하지만, 장바구니 페이지에서는 한 번에 여러 개의 상품을 주문할 수 있다.
            // 따라서, 여러 개의 주문 상품을 담을 수 있도록, 리스트 형태로 파라미터 값을 받으며 주문 객체에 orderItem 객체를 추가한다.
            order.addOrderItem(orderItem);
        }
        order.setOrderStatus(OrderStatus.ORDER); // 주문 상태를 "ORDER" 로 설정한다.
        order.setOrderDate(LocalDateTime.now()); // 현재 시간을 주문시간으로 설정한다.

        return order;
    }

    public int getTotalPrice() { // 총 주문 금액을 구하는 메서드이다.
        int totalPrice = 0;

        for (OrderItem orderItem : orderItems) {
            totalPrice += orderItem.getTotalPrice();
        }
        return totalPrice;
    }

    public void cancelOrder() {
        this.orderStatus = OrderStatus.CANCEL;

        for (OrderItem orderItem : orderItems) {
            orderItem.cancel();
        }
    }
}
