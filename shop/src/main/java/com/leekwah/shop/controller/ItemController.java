package com.leekwah.shop.controller;

import com.leekwah.shop.dto.ItemFormDto;
import com.leekwah.shop.dto.ItemSearchDto;
import com.leekwah.shop.entity.Item;
import com.leekwah.shop.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @GetMapping(value = "/admin/item/new")
    public String itemForm(Model model) {
        model.addAttribute("itemFormDto", new ItemFormDto());
        return "/item/itemForm";
    }

    @PostMapping(value = "/admin/item/new")
    public String itemNew(@Valid ItemFormDto itemFormDto, BindingResult bindingResult, Model model, @RequestParam("itemImgFile") List<MultipartFile> itemImgFileList ) {

        if (bindingResult.hasErrors()) { // 상품 등록 시 필수 값이 없다면 다시 상품 등록 페이지로 전환한다.
            return "/item/itemForm";
        }

        if (itemImgFileList.get(0).isEmpty() && itemFormDto.getId() == null) { // 상품 등록 시 첫 번째 이미지가 없다면, 에러 메시지와 함께 상품 등록 페이지로 전환한다.
            // 상품의 첫 번째 이미지는 메인 페이지에서 보여줄 상품 이미지로 사용하기 위해서 필수 값으로 지정해둔다.
            model.addAttribute("errorMessage", "첫 번째 상품 이미지는 필수 입력 값 입니다.");
            return "/item/itemForm";
        }

        try {
            itemService.saveItem(itemFormDto, itemImgFileList); // 상품 저장 로직을 호출한다. 매개 변수로 상품 정보와 상품 이미지 정보를 담고 있는 itemImgFileList 를 넘겨준다.
        } catch (Exception e) {
            model.addAttribute("errorMessage", "상품 등록 중 에러가 발생하였습니다.");
            return "/item/itemForm";
        }

        return "redirect:/"; // 상품이 정상적으로 등록되었다면, 메인 페이지로 이동한다.
    }

    @GetMapping(value = "/admin/item/{itemId}")
    public String itemDtl(@PathVariable("itemId") Long itemId, Model model) {

        try {
            ItemFormDto itemFormDto = itemService.getItemDtl(itemId);
            model.addAttribute("itemFormDto", itemFormDto);
        } catch (EntityNotFoundException e) {
            model.addAttribute("errorMessage", "존재하지 않는 상품입니다.");
            model.addAttribute("itemFormDto", new ItemFormDto());
            return "item/itemForm";
        }

        return "item/itemForm";
    }

    @PostMapping(value = "/admin/item/{itemId}")
    public String itemUpdate(@Valid ItemFormDto itemFormDto, BindingResult bindingResult, @RequestParam("itemImgFile") List<MultipartFile> itemImgFileList, Model model) {

        if (bindingResult.hasErrors()) {
            return "item/itemForm";
        }

        if (itemImgFileList.get(0).isEmpty() && itemFormDto.getId() == null) { // 아이템 이미지가 없거나, 아이디가 0일 경우
            model.addAttribute("errorMessage", "첫번째 상품 이미지는 필수 입력 값 입니다.");
            return "item/itemForm";
        }

        try {
            itemService.updateItem(itemFormDto, itemImgFileList); // 상품 수정 로직 호출
        } catch (Exception e) {
            model.addAttribute("errorMessage", "상품 수정 중 에러가 발생하였습니다.");
            return "item/itemForm";
        }

        return "redirect:/";
    }

    @GetMapping(value = {"/admin/items", "/admin/items/{page}"})
    public String itemManage(ItemSearchDto itemSearchDto, @PathVariable("page") Optional<Integer> page, Model model){

        Pageable pageable = PageRequest.of(page.isPresent() ? page.get() : 0, 3); // 페이징을 위해서 PageRequest.of() 메서드를 통해 Pageable 객체를 생성한다.
        // 첫 번째 파라미터는 조회할 페이지 번호, 두 번째 파라미터로는 한 번에 가지고 올 데이터 수, URL 경로에 페이지 번호가 있으면 해당 페이지 조회, 페이지 번호가 없으면 0 페이지를 조회하도록 설정한다.

        Page<Item> items = itemService.getAdminItemPage(itemSearchDto, pageable); // 조회 조건과 페이징 정보를 파라미터로 넘겨서 Page<Item> 객체를 반환 받는다.

        model.addAttribute("items", items); // 조회한 상품 데이터 및 페이징 정보를 뷰에 전달한다.
        model.addAttribute("itemSearchDto", itemSearchDto); // 페이지 전환 시 기존 검색 조건을 유지한 채 이동할 수 있도록 뷰에 다시 전달한다.
        model.addAttribute("maxPage", 5); // 상품 관리 메뉴 하단에 보여줄 페이지 번호의 최대 개수를 설정한다.

        return "item/itemMng";
    }

    @GetMapping(value = "/item/{itemId}")
    public String itemDtl(Model model, @PathVariable("itemId") Long itemId) {
        ItemFormDto itemFormDto = itemService.getItemDtl(itemId);
        model.addAttribute("item", itemFormDto);
        return "item/itemDtl";
    }
}

