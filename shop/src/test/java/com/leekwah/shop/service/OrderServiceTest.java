package com.leekwah.shop.service;

import com.leekwah.shop.constant.ItemSellStatus;
import com.leekwah.shop.constant.OrderStatus;
import com.leekwah.shop.dto.OrderDto;
import com.leekwah.shop.entity.Item;
import com.leekwah.shop.entity.Member;
import com.leekwah.shop.entity.Order;
import com.leekwah.shop.entity.OrderItem;
import com.leekwah.shop.repository.ItemRepository;
import com.leekwah.shop.repository.MemberRepository;
import com.leekwah.shop.repository.OrderRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@TestPropertySource(locations = "classpath:application-test.properties")
class OrderServiceTest {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    MemberRepository memberRepository;

    public Item saveItem() {
        Item item = new Item();
        item.setItemNm("테스트상품");
        item.setPrice(10000);
        item.setItemDetail(" 테스트 상품 상세 설명");
        item.setItemSellStatus(ItemSellStatus.SELL);
        item.setStockNumber(100);

        return itemRepository.save(item);
    }

    public Member saveMember () {
        Member member = new Member();
        member.setEmail("test@test.com");
        return memberRepository.save(member);
    }

    @Test
    @DisplayName("주문 테스트")
    public void order() {
        Item item = saveItem();
        Member member = saveMember();

        OrderDto orderDto = new OrderDto();
        orderDto.setCount(10); // 주문 수량을 설정한다.
        orderDto.setItemId(item.getId()); // 주문할 상품을 설정한다.

        Long orderId = orderService.order(orderDto, member.getEmail()); // 주문 로직 호출 결과 생성된 주문 번호를 orderId 변수에 저장한다.

        Order order = orderRepository.findById(orderId)
                .orElseThrow(EntityNotFoundException::new); // 주문 번호를 이용하여 저장된 주문 정보를 조회한다.

        List<OrderItem> orderItems = order.getOrderItems();

        int totalPrice = orderDto.getCount() * item.getPrice(); // 주문한 상품의 총 가격을 구한다.

        assertEquals(totalPrice, order.getTotalPrice()); // 주문한 상품의 총 가격과 데이터베이스에 저장된 상품의 가격을 비교하여, 같으면 테스트가 성공적으로 종료된다.
    }

    @Test
    @DisplayName("주문 취소 테스트")
    public void cancelOrder() {
        Item item = saveItem(); // 테스트를 위해서 상품 데이터를 생성한다.
        Member member = saveMember(); // 테스트를 위해서 회원 데이터를 생성한다.

        OrderDto orderDto = new OrderDto();
        orderDto.setCount(10);
        orderDto.setItemId(item.getId());
        Long orderId = orderService.order(orderDto, member.getEmail()); // 테스트를 위해서 주문 데이터를 생성한다. 주문 개수는 총 10개이다.

        Order order = orderRepository.findById(orderId)
                .orElseThrow(EntityNotFoundException::new); // 생성한 주문 엔티티를 조회한다.
        orderService.cancelOrder(orderId); // 주문을 취소한다.

        assertEquals(OrderStatus.CANCEL, order.getOrderStatus()); // 취소된 상태라면 통과한다.
        assertEquals(100, item.getStockNumber()); // 취소 후 상품 재고가 처음 재고 개수와 동일하면 테스트 통과
    }
}