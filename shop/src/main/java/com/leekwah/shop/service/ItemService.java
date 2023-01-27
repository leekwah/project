package com.leekwah.shop.service;

import com.leekwah.shop.dto.ItemFormDto;
import com.leekwah.shop.dto.ItemImgDto;
import com.leekwah.shop.entity.Item;
import com.leekwah.shop.entity.ItemImg;
import com.leekwah.shop.repository.ItemImgRepository;
import com.leekwah.shop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ItemService {

    private final ItemRepository itemRepository;
    private final ItemImgService itemImgService;
    private final ItemImgRepository itemImgRepository;

    public Long saveItem(ItemFormDto itemFormDto, List<MultipartFile> itemImgFileList) throws Exception {

        // 상품 등록
        Item item = itemFormDto.createItem(); // 상품 등록 폼으로부터 입력 받은 데이터를 이용하여, item 객체를 생성한다.
        itemRepository.save(item); // 상품 데이터를 저장한다.

        // 이미지 등록
        for (int i=0; i< itemImgFileList.size(); i++) {
            ItemImg itemImg = new ItemImg();
            itemImg.setItem(item);

            if (i == 0) { // 첫 번째 이미지일 경우, 대표 상품 이미지 여부 값을 "Y"로 세팅하고, 나머지 상품 이미지는 "N"으로 설정한다.
                itemImg.setRepImgYn("Y");
            } else {
                itemImg.setRepImgYn("N");
            }

            itemImgService.saveItemImg(itemImg, itemImgFileList.get(i)); // 상품의 이미지 정보를 저장한다.
        }

        return item.getId();
    }

    @Transactional(readOnly = true) // 상품 데이터를 읽어오는 트랜잭션을 읽기 전용으로 설정한다. 이럴 경우 JPA 가 더티체킹(변경감지)을 수행하지 않아서 성능을 향상시킬 수 있다.
    public ItemFormDto getItemDtl(Long itemId) {

        List<ItemImg> itemImgList = itemImgRepository.findByItemIdOrderByIdAsc(itemId);
        List<ItemImgDto> itemImgDtoList = new ArrayList<>();

        for (ItemImg itemImg : itemImgList) {
            ItemImgDto itemImgDto = ItemImgDto.of(itemImg);
            itemImgDtoList.add(itemImgDto);
        }

        Item item = itemRepository.findById(itemId).orElseThrow(EntityNotFoundException::new);
        ItemFormDto itemFormDto = ItemFormDto.of(item);
        itemFormDto.setItemImgDtoList(itemImgDtoList);

        return itemFormDto;
    }
}
