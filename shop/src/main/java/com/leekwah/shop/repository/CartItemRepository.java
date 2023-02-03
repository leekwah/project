package com.leekwah.shop.repository;

import com.leekwah.shop.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    CartItem findByCartIdAndItemId(Long cartId, Long itemId); // cartId 와 itemId 를 이용해서 상품이 장바구니에 들어있는지 조회한다.
}
