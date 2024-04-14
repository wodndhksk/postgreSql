package com.mg.dev.postgres.api.Member.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class MemberFavoriteShopDto {
    private Long memberId;
    private Long ShopId;

    @Builder
    public MemberFavoriteShopDto(Long memberId, Long shopId) {
        this.memberId = memberId;
        ShopId = shopId;
    }
}
