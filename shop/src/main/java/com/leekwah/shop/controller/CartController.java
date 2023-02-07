package com.leekwah.shop.controller;

import com.leekwah.shop.dto.CartDetailDto;
import com.leekwah.shop.dto.CartItemDto;
import com.leekwah.shop.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @PostMapping(value = "/cart")
    public @ResponseBody ResponseEntity order(@RequestBody @Valid CartItemDto cartItemDto, BindingResult bindingResult, Principal principal) {

        if (bindingResult.hasErrors()) { // 장바구니에 담을 정보는 받는 cartItemDto 객체에 데이터 바인딩 시 에러가 있는 지 검사한다.
            StringBuilder sb = new StringBuilder();
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            for (FieldError fieldError : fieldErrors) {
                sb.append(fieldError.getDefaultMessage());
            }
            return new ResponseEntity<String>(sb.toString(), HttpStatus.BAD_REQUEST);
        }

        String email = principal.getName(); // 현재 로그인한 회원이 이메일 정보를 변수에 저장한다.
        Long cartItemId;

        try {
            cartItemId = cartService.addCart(cartItemDto, email); // 화면으로부터 넘어온 장바구니에 담을 상품 정보와 현재 로그인한 회원의 이메일 정보를 이용하여 장바구니에 상품을 담는 로직을 호출한다.
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<Long>(cartItemId, HttpStatus.OK); // 결과값으로 생성된 장바구니 상품 아이디와 요청이 성공했다는 HTTP 응답 상태 코드를 반환한다.
    }

    @GetMapping(value = "/cart")
    public String orderHist(Principal principal, Model model) {
        List<CartDetailDto> cartDetailDtoList = cartService.getCartList(principal.getName()); // 현재 로그인한 사용자의 이메일 정보를 이용하여, 장바구니에 담겨있는 상품 정보를 조회한다.
        model.addAttribute("cartItems", cartDetailDtoList); // 조회한 장바구니 상품 정보를 뷰로 전달합니다.
        return "cart/cartList";
    }

    @PatchMapping(value = "/cartItem/{cartItemId}") // HTTP 메서드에서 PATCH 는 요청된 자원의 일부를 업데이트할 때 사용한다. 장바구니 상품의 수량만 업데이트하기 때문에 @PatchMapping 을 사용한다.
    public @ResponseBody ResponseEntity updateCartItem(@PathVariable("cartItemId") Long cartItemId, int count, Principal principal) {

        if (count <= 0) { // 장바구니에 담겨있는 상품의 개수를 0개 이하로 업데이트 요청을 할 때 에러 메시지를 담아서 반환한다.
            return new ResponseEntity<String>("최소 1개 이상 담아주세요.", HttpStatus.BAD_REQUEST);
        } else if (!cartService.validateCartItem(cartItemId, principal.getName())) { // 수정 권한을 체크한다.
            return new ResponseEntity<String>("수정 권한이 없습니다.", HttpStatus.FORBIDDEN);
        }

        cartService.updateCartItemCount(cartItemId, count); // 장바구니 상품의 개수를 업데이트한다.
        return new ResponseEntity<Long>(cartItemId, HttpStatus.OK);
    }

    @DeleteMapping(value = "/cartItem/{cartItemId}") // HTTP 메서드에서 DELETE 의 경우 요청된 자원을 삭제할 때 사용한다. 장바구니 상품을 삭제하기 때문에 @DeleteMapping 을 사용한다.
    public @ResponseBody ResponseEntity deleteCartItem(@PathVariable("cartItemId") Long cartItemId, Principal principal) {

        if (!cartService.validateCartItem(cartItemId, principal.getName())) { // 수정 권한을 체크한다.
            return new ResponseEntity<String>("수정 권한이 없습니다.", HttpStatus.FORBIDDEN);
        }

        cartService.deleteCartItem(cartItemId); // 해당 장바구니 상품을 삭제한다.
        return new ResponseEntity<Long>(cartItemId, HttpStatus.OK);
    }
}
