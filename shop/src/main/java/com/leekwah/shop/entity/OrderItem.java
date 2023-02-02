package com.leekwah.shop.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class OrderItem extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY) // 하나의 상품은 여러 주문 상품으로 들어갈 수 있으므로, 주문 상품 기준으로 다대일 단방향 매핑을 설정한다.
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY) // 한 번의 주문에 여러개 상품을 주문할 수 있으므로, 주문 상품 엔티티와 주문 엔티티를 다대일 단방향 매핑을 설정한다.
    @JoinColumn(name = "order_id")
    private Order order;

    private int orderPrice; // 주문가격

    private int count; // 주문수량

    public static OrderItem createOrderItem(Item item, int count) {
        OrderItem orderItem = new OrderItem();
        orderItem.setItem(item); // 주문 상품을 설정한다.
        orderItem.setCount(count); // 주문 수량을 설정한다.
        orderItem.setOrderPrice(item.getPrice()); // 현재 시간 기준으로 상품 가격을 주문 가격으로 설정한다.

        item.removeStock(count); // 주문 수량만큼 상품의 재고 수량을 감소시킨다.
        return orderItem;
    }

    public int getTotalPrice() { // 주문 가격과 주문 수량을 곱해서 해당 상품을 주문한 총 가격을 계산하는 메서드이다.
        return orderPrice * count;
    }

    public void cancel(){ // 주문 취소 시 주문 수량만큼 상품의 재고를 더해준다.
        this.getItem().addStock(count);
    }
}
