package com.mg.dev.postgres.api.shop.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class ShopReqDto {
    private String name;
    private String city;
    private String addr;
    private String number;
    private String link;

    @Builder
    public ShopReqDto(String name, String city, String addr, String number, String link) {
        this.name = name;
        this.city = city;
        this.addr = addr;
        this.number = number;
        this.link = link;
    }
}
