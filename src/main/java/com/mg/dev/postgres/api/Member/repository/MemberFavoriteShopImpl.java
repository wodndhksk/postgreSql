package com.mg.dev.postgres.api.Member.repository;

import com.mg.dev.postgres.api.Member.MemberFavoriteEntity;
import com.mg.dev.postgres.api.Member.dto.MemberFavoriteShopDto;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import static com.mg.dev.postgres.api.Member.QMemberFavoriteEntity.memberFavoriteEntity;

@Slf4j
public class MemberFavoriteShopImpl implements MemberFavoriteShopCustom {
    private final JPAQueryFactory queryFactory;

    public MemberFavoriteShopImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

//    @Override
    public int memberFavoriteShopDupCount(MemberFavoriteShopDto dto) {
        List<MemberFavoriteEntity> fetch = queryFactory
                .selectFrom(memberFavoriteEntity)
                .where(
                        memberFavoriteEntity.member.id.eq(dto.getMemberId())
                                .and(memberFavoriteEntity.shop.id.eq(dto.getShopId()))
                )
                .fetch();

        return 0;
    }
}
