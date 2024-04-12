package com.mg.dev.postgres.api.shop.respository;

import com.mg.dev.postgres.api.shop.dto.QShopResDto;
import com.mg.dev.postgres.api.shop.dto.ShopReqDto;
import com.mg.dev.postgres.api.shop.dto.ShopResDto;
import com.mg.dev.postgres.common.repository.QueryDslNullSafer;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.List;

import static com.mg.dev.postgres.api.shop.QShopEntity.*;

@Slf4j
public class ShopRepositoryImpl implements ShopRepositoryCustom{
    private final JPAQueryFactory queryFactory;
    private final QueryDslNullSafer nullSafer;

    @Autowired
    public ShopRepositoryImpl(EntityManager em, QueryDslNullSafer nullSafer) {
        this.queryFactory = new JPAQueryFactory(em);
        this.nullSafer = nullSafer;
    }

    /**
     * Shop 정보로 조회
     * @param param
     * @return
     */
    @Override
    public List<ShopResDto> shopEntityList(ShopReqDto param) {
        return queryFactory
                .select(new QShopResDto(
                        shopEntity.name,
                        shopEntity.city,
                        shopEntity.addr,
                        shopEntity.number,
                        shopEntity.link
                        ))
                .from(shopEntity)
                .where((
                            nameEq(param)
                            .or(cityEq(param))
                            .or(numberEq(param))
                        ).and(addrContain(param))
                )
                .fetch();
    }

    /**
     * BooleanExpression 가 아닌 BooleanBuilder 를 return 시킨 이유:
     * 1. where 절의 조건 값이 null 일 경우 NullPointException 발생 (null.or(cityEq(param)..) 가 될수 없기에)
     * 2. where 절 조건이 많을 경우 BooleanBuilder 를 사용하는게 유리하다.
     */
    private BooleanBuilder paramNullSafer(BooleanExpression expression) {
        return nullSafer.nullSafeBuilder(() -> expression);
    }

    /**
     * nameEq(param)이 null 이 되는 상황 방지 (null.or() 오류 방지)
     * @param param
     * @return
     */
    private BooleanBuilder nameEq(ShopReqDto param) {
        return paramNullSafer(StringUtils.hasText(param.getName())?
                shopEntity.name.eq(param.getName()) : null);
    }
    private BooleanExpression cityEq(ShopReqDto param) {
        return StringUtils.hasText(param.getCity())?
                shopEntity.city.eq(param.getCity()) : null;
    }
    private BooleanExpression addrContain(ShopReqDto param) {
        return StringUtils.hasText(param.getAddr())?
                shopEntity.addr.contains(param.getAddr()) : null;
    }
    private BooleanExpression numberEq(ShopReqDto param) {
        return StringUtils.hasText(param.getNumber())?
                shopEntity.number.eq(param.getNumber()) : null;
    }
}
