package com.leekwah.shop.repository;

import com.leekwah.shop.entity.Order;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("SELECT o FROM Order o WHERE o.member.email = :email ORDER BY o.orderDate DESC ")
    List<Order> findOrders(@Param("email")String email, Pageable pageable); // 현재 로그인한 사용자의 주문 데이터를 페이징 조건에 맞춰서 조회한다.

    @Query("SELECT count(o) FROM Order o WHERE o.member.email = :email ")
    Long countOrder(@Param("email") String email); // 현재 로그인한 회원의 주문 개수가 몇 개인지 조회한다.
}
