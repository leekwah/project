package com.leekwah.shop.service;

import com.leekwah.shop.repository.CartItemRepository;
import com.leekwah.shop.repository.CartRepository;
import com.leekwah.shop.repository.ItemRepository;
import com.leekwah.shop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CartService {

    private final ItemRepository itemRepository;
    private final MemberRepository memberRepository;
    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;


}
