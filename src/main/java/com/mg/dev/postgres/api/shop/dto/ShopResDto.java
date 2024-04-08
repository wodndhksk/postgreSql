package com.mg.dev.postgres.api.shop.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;

@Getter
public class ShopResDto {
    private String name;
    private String city;
    private String addr;
    private String number;
    private String link;

    @QueryProjection
    public ShopResDto(String name, String city, String addr, String number, String link) {
        this.name = name;
        this.city = city;
        this.addr = addr;
        this.number = number;
        this.link = link;
    }
}
