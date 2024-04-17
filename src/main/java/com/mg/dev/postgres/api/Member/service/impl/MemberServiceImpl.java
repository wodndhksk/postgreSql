package com.mg.dev.postgres.api.Member.service.impl;

import com.mg.dev.postgres.api.Member.MemberEntity;
import com.mg.dev.postgres.api.Member.MemberFavoriteEntity;
import com.mg.dev.postgres.api.Member.dto.MemberFavoriteShopDto;
import com.mg.dev.postgres.api.Member.dto.MemberReqDto;
import com.mg.dev.postgres.api.Member.repository.MemberFavoriteShopRepository;
import com.mg.dev.postgres.api.Member.repository.MemberRepository;
import com.mg.dev.postgres.api.Member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Component
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;
    private final MemberFavoriteShopRepository favoriteShopRepository;

    @Override
    public void insertMember(MemberReqDto dto) {
        MemberEntity member = MemberEntity.builder()
                .name(dto.getName())
                .nickname(dto.getNickname())
                .birthday(dto.getBirthday())
                .build();
        memberRepository.save(member);
    }

    @Override
    public void insertMemberFavoriteShop(MemberFavoriteShopDto dto) {
//        if(isDuplicate(dto) > 0) {
//            log.info("중복!");
//        }else {

//            MemberEntity member = new MemberEntity();
//            member.setId(dto.getMemberId());
//            member.setShopList()
//            MemberFavoriteEntity entity = MemberFavoriteEntity.builder()
//                    .member(dto.getMemberId())
//                    .build();
//            favoriteShopRepository.save();
//        }

    }

    /**
     * 중복 확인
     */
//    private List<MemberFavoriteEntity> isDuplicate(MemberFavoriteShopDto dto) {
//        return favoriteShopRepository.memberFavoriteShopDupCount(dto);
//    }
}
