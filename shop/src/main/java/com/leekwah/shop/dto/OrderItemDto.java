package com.leekwah.shop.dto;

import com.leekwah.shop.entity.OrderItem;
import lombok.Data;

@Data
public class OrderItemDto {
    private String itemNm; // 상품명

    private int count; // 주문 수량

    private int orderPrice; // 주문 금액

    private String imgUrl; // 상품 이미지 경로

    public OrderItemDto(OrderItem orderItem, String imgUrl) { // OderItemDto 클래스의 생성자로, orderItem 객체와 이미지 경로를 파라미터로 받아서 멤버 변수 값을 설정한다.
        this.itemNm = orderItem.getItem().getItemNm();
        this.count = orderItem.getCount();
        this.orderPrice = orderItem.getOrderPrice();
        this.imgUrl = imgUrl;

    }

}
