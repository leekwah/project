package com.leekwah.shop.dto;

import com.leekwah.shop.constant.ItemSellStatus;
import lombok.Data;

@Data
public class ItemSearchDto {

    private String searchDateType; // 현재 시간과 상품 등록일을 비교해서 상품 데이터를 조회한다.

    private ItemSellStatus searchSellStatus; // 상품 판매 상태를 기준으로 상품 데이터를 조회한다.

    private String searchBy; // 상품을 조회할 때, 어떤 유형으롲 조회할지 선택한다.

    private String searchQuery = ""; // 조회할 검색어 저장 변수

}
