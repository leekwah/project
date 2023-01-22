package com.leekwah.shop.repository;

import com.leekwah.shop.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long>, QuerydslPredicateExecutor<Item> {
    // item 이름으로 찾기
    List<Item> findByItemNm(String itemNm);
    // LessThan 조건 처리
    List<Item> findByPriceLessThan(Integer price);
    // LessThan + OrderBy 로 정렬 처리
    List<Item> findByPriceLessThanOrderByPriceDesc(Integer price);

    // @Query 를 이용한 검색 처리 // Item 이 대문자인 이유는 Item.java 의 Entity Class 기 때문에
    @Query("SELECT i FROM Item i WHERE i.itemDetail like %:itemDetail% ORDER BY i.price DESC")
    List<Item> findByItemDetail(@Param("itemDetail") String itemDetail);

    // Native Query 를 이용한 @Query
    @Query(value = "SELECT * FROM item i WHERE i.item_detail like %:itemDetail% ORDER BY i.price DESC", nativeQuery = true)
    List<Item> findByItemDetailByNative(@Param("itemDetail") String itemDetail);

    // QuerydslPredicateExecutor 를 이용한 상품 조회
    // extends 를 통해서 QuerydslPredicateExecutor<Item> 을 상속한다.


}
