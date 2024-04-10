package com.mg.dev.postgres.api.shop.respository;

import com.mg.dev.postgres.api.shop.dto.QShopResDto;
import com.mg.dev.postgres.api.shop.dto.ShopReqDto;
import com.mg.dev.postgres.api.shop.dto.ShopResDto;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.function.Supplier;

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
    private BooleanBuilder isParamBlank(String param, BooleanExpression expression) {
        BooleanExpression booleanExpression = param.isBlank() ? null : expression;
        return nullSafeBuilder(() -> booleanExpression);
    }


    private BooleanBuilder nameEq(ShopReqDto param) {
        return isParamBlank(param.getName(), shopEntity.name.eq(param.getName()));
    }
    private BooleanBuilder cityEq(ShopReqDto param) {
        return isParamBlank(param.getCity(), shopEntity.city.eq(param.getCity()));
    }
    private BooleanBuilder addrContain(ShopReqDto param) {
        return isParamBlank(param.getAddr(), shopEntity.addr.contains(param.getAddr()));
    }
    private BooleanBuilder numberEq(ShopReqDto param) {
        return isParamBlank(param.getNumber(), shopEntity.number.eq(param.getNumber()));
    }


    /**
     * querydsl 조건절 null 문제 해결 (공통화 필요)
     * @param f
     * @return
     */
    public static BooleanBuilder nullSafeBuilder(Supplier<BooleanExpression> f) {
        try {
            return new BooleanBuilder(f.get());
        } catch (IllegalArgumentException e) {
            return new BooleanBuilder();
        }
    }
}
