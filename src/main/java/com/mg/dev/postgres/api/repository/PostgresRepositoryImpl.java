package com.mg.dev.postgres.api.repository;

import com.mg.dev.postgres.api.PostgresEntity;
import com.mg.dev.postgres.api.QPostgresEntity;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import static com.mg.dev.postgres.api.QPostgresEntity.postgresEntity;

@Slf4j
public class PostgresRepositoryImpl implements PostgresRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public PostgresRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<PostgresEntity> search() {
        QPostgresEntity postgresEntitySub = new QPostgresEntity("postgresEntitySub");
        return queryFactory
                .selectFrom(postgresEntity)
                .where(postgresEntity.num.in(
                        JPAExpressions.select(postgresEntitySub.num)
                                .from(postgresEntitySub)
                                .where(postgresEntitySub.num.gt(5))
                )).fetch();
    }

}
