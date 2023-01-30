package com.leekwah.shop.repository;

import com.leekwah.shop.constant.ItemSellStatus;
import com.leekwah.shop.dto.ItemSearchDto;
import com.leekwah.shop.entity.Item;
import com.leekwah.shop.entity.QItem;
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

    private BooleanExpression searchByLike(String searchBy, String searchQuery) { // 6

        if (StringUtils.equals("itemNm", searchBy)) {
            return QItem.item.itemNm.like("%" + searchBy + "%");
        } else if (StringUtils.equals("createdBy", searchBy)) {
            return QItem.item.createdBy.like("%" + searchBy + "%");
        }

        return null;
    }

    @Override
    public Page<Item> getAdminItemPage(ItemSearchDto itemSearchDto, Pageable pageable) {
        QueryResults<Item> results = queryFactory
                .selectFrom(QItem.item)
                .where(regDtsAfter(itemSearchDto.getSearchDateType()),
                        searchSellStatusEq(itemSearchDto.getSearchSellStatus()),
                        searchByLike(itemSearchDto.getSearchBy(),itemSearchDto.getSearchQuery()))
                .orderBy(QItem.item.id.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetchResults();

        List<Item> content = results.getResults();
        long total = results.getTotal();
        return new PageImpl<>(content, pageable, total);
    }
}
