package com.leekwah.shop.repository;

import com.leekwah.shop.dto.ItemSearchDto;
import com.leekwah.shop.dto.MainItemDto;
import com.leekwah.shop.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ItemRepositoryCustom {

    Page<Item> getAdminItemPage(ItemSearchDto itemSearchDto, Pageable pageable);
    // 상품 조회 조건을 담고있는 itemSearchDto 객체와 페이징 정보를 담고 있는 pageable 객체를 파라미터로 받는 getAdminItemPage 메서드를 정의한다.

    Page<MainItemDto> getMainItemPage(ItemSearchDto itemSearchDto, Pageable pageable);
}
