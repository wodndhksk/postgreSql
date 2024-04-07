package com.mg.dev.postgres.api.Store;

import com.mg.dev.postgres.api.Member.MemberEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 가게 entity
 */
@Entity
@ToString(exclude = "member")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StoreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id")
    private Long id;

    private String name;

    private String city;

    @Column(length = 500)
    private String addr;

    @Column(length = 500)
    private String link;

    @Column(length = 25)
    private String number;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private MemberEntity member;

    //카테고리
    //메뉴


    @Builder
    public StoreEntity(String name, String city, String addr, String link, String number) {
        this.name = name;
        this.city = city;
        this.addr = addr;
        this.link = link;
        this.number = number;
    }
}