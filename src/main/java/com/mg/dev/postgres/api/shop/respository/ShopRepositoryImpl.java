package com.mg.dev.postgres.api.shop.respository;

import com.mg.dev.postgres.api.shop.dto.QShopResDto;
import com.mg.dev.postgres.api.shop.dto.ShopReqDto;
import com.mg.dev.postgres.api.shop.dto.ShopResDto;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import static com.mg.dev.postgres.api.shop.QShopEntity.*;

@Slf4j
public class ShopRepositoryImpl implements ShopRepositoryCustom{
    private final JPAQueryFactory queryFactory;

    public ShopRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
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
                .where(
                        nameEq(param)
                                .or(cityEq(param))
                                .or(addrEq(param))
                                .or(numberEq(param))
                )
                .fetch();
    }

    private static BooleanExpression nameEq(ShopReqDto param) {
        return shopEntity.name.eq(param.getName());
    }
    private static BooleanExpression cityEq(ShopReqDto param) {
        return shopEntity.city.eq(param.getCity());
    }
    private static BooleanExpression addrEq(ShopReqDto param) {
        return shopEntity.addr.eq(param.getAddr());
    }
    private static BooleanExpression numberEq(ShopReqDto param) {
        return shopEntity.number.eq(param.getNumber());
    }
}
