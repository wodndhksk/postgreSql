package com.mg.dev.postgres.api.Member;

import com.mg.dev.postgres.api.Member.dto.MemberFavoriteShopDto;
import com.mg.dev.postgres.api.Member.dto.MemberReqDto;
import com.mg.dev.postgres.api.Member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;

    @GetMapping("")
    public String index() {
        return "member";
    }

    @PostMapping("/insert")
    public void insertMember(@RequestBody MemberReqDto reqDto) {
        log.info("insertMember={}", reqDto);
        memberService.insertMember(reqDto);
    }

    @PostMapping("/favorite")
    public void insertFavorite(@RequestBody MemberFavoriteShopDto reqDto) {
        log.info("insertFavorite={}", reqDto);
        memberService.insertMemberFavoriteShop(reqDto);
    }

}
