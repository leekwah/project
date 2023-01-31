package com.leekwah.shop.repository;

import com.leekwah.shop.constant.ItemSellStatus;
import com.leekwah.shop.dto.ItemSearchDto;
import com.leekwah.shop.dto.MainItemDto;
import com.leekwah.shop.dto.QMainItemDto;
import com.leekwah.shop.entity.Item;
import com.leekwah.shop.entity.QItem;
import com.leekwah.shop.entity.QItemImg;
import com.querydsl.core.QueryResults;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.thymeleaf.util.StringUtils;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.List;

public class ItemRepositoryCustomImpl implements ItemRepositoryCustom { // ItemRepositoryCustom 을 상속받는다.

    private JPAQueryFactory queryFactory; // 동적 쿼리를 생성하기 위해서 JPAQueryFactory 클래스를 사용한다.

    public ItemRepositoryCustomImpl(EntityManager em) { // JPAQueryFactory 의 생성자로 EntityManager 객체를 넣는다.
        this.queryFactory = new JPAQueryFactory(em);
    }

    private BooleanExpression searchSellStatusEq(ItemSellStatus searchSellStatus) { // 상품 판매 상태 조건이 전체(null)일 경우에는 null 을 리턴한다.
        return searchSellStatus == null ? null : QItem.item.itemSellStatus.eq(searchSellStatus); // 결과값이 null 이면 WHERE 절에서 해당 조건은 무시된다.
        // 상품 판매 상태 조건이 null 이 아니라 판매중 or 품절 상태라면 해당 조건의 상품만 조회한다.
    }

    private BooleanExpression regDtsAfter(String searchDateType) { // searchDateType 의 값에 따라서 dateTime 의 값을 이전 시간의 값으로 세팅 후, 해당 시간 이후로 등록된 상품만 조회한다.
        LocalDateTime dateTime = LocalDateTime.now();

        if (StringUtils.equals("all", searchDateType) || searchDateType == null) {
            return null;
        } else if (StringUtils.equals("1d", searchDateType)) {
            dateTime = dateTime.minusDays(1);
        } else if (StringUtils.equals("1w", searchDateType)) {
            dateTime = dateTime.minusWeeks(1);
        } else if (StringUtils.equals("1m", searchDateType)) {
            dateTime = dateTime.minusMonths(1);
        } else if (StringUtils.equals("6m", searchDateType)) {
            dateTime = dateTime.minusMonths(6);
        }

        return QItem.item.regTime.after(dateTime);
    }

    private BooleanExpression searchByLike(String searchBy, String searchQuery) { // searchBy 의 값에 따라서 상품명에 검색어를 포함하고 있는 상품 또는 상품 생성자의 아이디에 검색어를 포함하고 있는 상품을 조회하도록 조건 값을 반환한다.

        if (StringUtils.equals("itemNm", searchBy)) {
            return QItem.item.itemNm.like("%" + searchBy + "%");
        } else if (StringUtils.equals("createdBy", searchBy)) {
            return QItem.item.createdBy.like("%" + searchBy + "%");
        }

        return null;
    }

    @Override
    public Page<Item> getAdminItemPage(ItemSearchDto itemSearchDto, Pageable pageable) {
        QueryResults<Item> results = queryFactory // queryFactory 를 이용해서 쿼리를 생성한다. 쿼리문을 직접 작성할 때의 형태와 문법이 비슷한 것을 볼 수 있다.
                .selectFrom(QItem.item) // selectFrom() : 상품 데이터를 조회하기 위해서 QItem 의 item 을 지정한다.
                .where(regDtsAfter(itemSearchDto.getSearchDateType()), // where() : BooleanExpression 반환하는 조건문들을 넣어준다. ',' 단위로 넣어줄 경우 AND 조건으로 인식한다.
                        searchSellStatusEq(itemSearchDto.getSearchSellStatus()),
                        searchByLike(itemSearchDto.getSearchBy(),itemSearchDto.getSearchQuery()))
                .orderBy(QItem.item.id.desc())
                .offset(pageable.getOffset()) // offset() : 데이터를 가지고 올 시작 인덱스를 지정한다.
                .limit(pageable.getPageSize()) // limit() : 한 번에 가지고 올 최대 개수를 지정한다.
                .fetchResults(); // fetchResults() : 조회한 리스트 및 전체 개수를 포함하는 QueryResults 를 반환한다. 상품 데이터 리스트 조회 및 상품 데이터 전체 개수를 조회하는 2번의 쿼리문이 실행된다.

        List<Item> content = results.getResults();
        long total = results.getTotal();
        return new PageImpl<>(content, pageable, total); // 조회한 데이터를 Page 클래스의 구현체인 PageImpl 객체로 반환한다.
    }

    private BooleanExpression itemNmLike(String searchQuery) { // 검색어가 null 이 아니면, 상품명에 해당 검색어가 포함되는 상품을 조회하는 조건을 반환한다.
        return StringUtils.isEmpty(searchQuery) ? null : QItem.item.itemNm.like("%" + searchQuery + "%");
    }

    @Override
    public Page<MainItemDto> getMainItemPage(ItemSearchDto itemSearchDto, Pageable pageable) {

        QItem item = QItem.item;
        QItemImg itemImg = QItemImg.itemImg;

        QueryResults<MainItemDto> results = queryFactory
                .select(
                        new QMainItemDto( // QMainItemDto 의 생성자에 반환할 값들을 넣어준다. @QueryProjection 을 사용하면, DTO 로 바로 조회가 가능하다. 엔티티 조회 후 DTO 로 변환하는 과정을 줄일 수 있다.
                                item.id,
                                item.itemNm,
                                item.itemDetail,
                                itemImg.imgUrl,
                                item.price
                        )
                )
                .from(itemImg)
                .join(itemImg.item, item) // itemImg 와 item 을 내부조인한다.
                .where(itemImg.repImgYn.eq("Y")) // 상품 이미지의 경우 대표 상품 이미지만 불러온다.
                .where(itemNmLike(itemSearchDto.getSearchQuery()))
                .orderBy(item.id.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetchResults();

        List<MainItemDto> content = results.getResults();
        long total = results.getTotal();

        return new PageImpl<>(content, pageable, total);
    }
}
