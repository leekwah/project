package com.leekwah.shop.dto;

import com.leekwah.shop.entity.ItemImg;
import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class ItemImgDto {

    private Long id;

    private String imgName;

    private String oriImgName;

    private String imgUrl;

    private String repImgYn;

    private static ModelMapper modelMapper = new ModelMapper(); // 멤버변수로 modelMapper 를 사용한다.

    public static ItemImgDto of(ItemImg itemImg) { // ItemImg 엔티티 객체를 파라미터로 받아서, ItemImg 객체의 자료형과 멤버변수의 이름이 같을 때, ItemImgDTO 로 값을 복사해서 반환한다.
        return modelMapper.map(itemImg, ItemImgDto.class); // static 메서드로 선언해 ItemImgDto 객체를 생성하지 않아도 호출할 수 있도록 한다.
    }
}
