package com.mg.dev.postgres.api.Member.service;

import com.mg.dev.postgres.api.Member.dto.MemberFavoriteShopDto;
import com.mg.dev.postgres.api.Member.dto.MemberReqDto;

public interface MemberService {
    void insertMember(MemberReqDto dto);

    void insertMemberFavoriteShop(MemberFavoriteShopDto dto);
}
