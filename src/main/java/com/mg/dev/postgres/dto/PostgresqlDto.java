package com.mg.dev.postgres.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostgresqlDto {
    private int num;
    private String title;
    private String name;
    private String description;

    @Builder
    public PostgresqlDto(int num, String title, String name, String description) {
        this.num = num;
        this.title = title;
        this.name = name;
        this.description = description;
    }
}
