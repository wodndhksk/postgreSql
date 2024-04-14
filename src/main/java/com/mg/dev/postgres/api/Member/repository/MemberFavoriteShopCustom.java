package com.mg.dev.postgres.api.Member.repository;

import com.mg.dev.postgres.api.Member.dto.MemberFavoriteShopDto;

public interface MemberFavoriteShopCustom {
    int memberFavoriteShopDupCount(MemberFavoriteShopDto dto);
}
