package com.leekwah.shop.service;

import com.leekwah.shop.entity.ItemImg;
import com.leekwah.shop.repository.ItemImgRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.util.StringUtils;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
@Transactional
public class ItemImgService {

    @Value("${itemImgLocation}")
    private String itemImgLocation;

    private final ItemImgRepository itemImgRepository;

    private final FileService fileService;

    public void saveItemImg(ItemImg itemImg, MultipartFile itemImgFile) throws Exception {
        String oriImgName = itemImgFile.getOriginalFilename();
        String imgName = "";
        String imgUrl = "";

        // 파일 업로드
        if (!StringUtils.isEmpty(oriImgName)) {
            imgName = fileService.uploadFile(itemImgLocation, oriImgName, itemImgFile.getBytes()); // 2
            imgUrl = "/images/item/" + imgName; // 3
        }

        // 상품 이미지 정보 저장
        itemImg.updateItemImg(oriImgName, imgName, imgUrl); // 4
        itemImgRepository.save(itemImg); // 5
    }

    public void updateItemImg(Long itemImgId, MultipartFile itemImgFile) throws Exception {

        if (!itemImgFile.isEmpty()) { // 상품 이미지 수정 시, 상품 이미지를 업데이트 함
            ItemImg savedItemImg = itemImgRepository.findById(itemImgId).orElseThrow(EntityNotFoundException::new); // 상품 이미지 아이디를 이용하여, 기존 저장 상품 이미지 엔티티를 조회함

            // 기존 이미지 파일 삭제
            if (!StringUtils.isEmpty(savedItemImg.getImgName())) { // 기존에 등록된 상품 이미지 파일이 있을 경우 해당 파일을 삭제함
                fileService.deleteFile(itemImgLocation+"/"+savedItemImg.getImgName());
            }

            String oriImgName = itemImgFile.getOriginalFilename();
            String imgName = fileService.uploadFile(itemImgLocation, oriImgName, itemImgFile.getBytes()); // 업데이트한 상품 이미지 파일을 업로드한다.
            String imgUrl = "/images/item/" + imgName;
            savedItemImg.updateItemImg(oriImgName, imgName, imgUrl); // 변경된 상품 이미지 정보를 세팅한다.
            // 상품 등록처럼 itemImagRepository.sav() 로직을 호칠하지 않는다는 것이다.
            // 영속상태 이므로, 데이터를 변경하는 것만으로 변경 감지 기능이 동작하여 트랜잭션이 끝날 때, update 쿼리가 실행되기 때문이다.
        }
    }
}
