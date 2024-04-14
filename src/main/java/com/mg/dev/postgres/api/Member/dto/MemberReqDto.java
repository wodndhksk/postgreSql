package com.mg.dev.postgres.api.Member.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
@NoArgsConstructor
public class MemberReqDto {
    private String name;
    private String nickname;
    private LocalDateTime birthday;

    @Builder
    public MemberReqDto(String name, String nickname, LocalDateTime birthday) {
        this.name = name;
        this.nickname = nickname;
        this.birthday = birthday;
    }
}
