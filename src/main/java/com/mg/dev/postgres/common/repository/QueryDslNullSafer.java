package com.mg.dev.postgres.common.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.stereotype.Component;

import java.util.function.Supplier;

@Component
public class QueryDslNullSafer {
    /**
     * querydsl 조건절 null 문제 해결 (공통화 필요)
     * @param f
     * @return
     */
    public BooleanBuilder nullSafeBuilder(Supplier<BooleanExpression> f) {
        try {
            return new BooleanBuilder(f.get());
        } catch (IllegalArgumentException e) {
            return new BooleanBuilder();
        }
    }

    public String strNullSafe(String str) {
        return str != null? str : "";
    }
}
