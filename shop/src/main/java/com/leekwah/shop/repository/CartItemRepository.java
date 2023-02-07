package com.leekwah.shop.repository;

import com.leekwah.shop.dto.CartDetailDto;
import com.leekwah.shop.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    CartItem findByCartIdAndItemId(Long cartId, Long itemId); // cartId 와 itemId 를 이용해서 상품이 장바구니에 들어있는지 조회한다.

    @Query("SELECT new com.leekwah.shop.dto.CartDetailDto(ci.id, i.itemNm, i.price, ci.count, im.imgUrl) FROM CartItem ci, ItemImg im JOIN ci.item i WHERE ci.cart.id = :cartId AND im.item.id = ci.item.id AND im.repImgYn = 'Y' ORDER BY ci.regTime DESC ") // 생성자를 이용하여 DTO 를 반환할 때는 "new com.leekwah.shop.dto.CartDetailDto(...) 처럼 new 키워드와 해당 DTO 의 패키지, 클래스명을 적어준다.
    List<CartDetailDto> findCartDetailDtoList(Long cartId); // 또한 생성자의 파라미터 순서는 DTO 클래스에 명시한 순서대로 넣어줘야한다.
}
