package com.mg.dev.postgres.api.shop;

import com.mg.dev.postgres.api.Member.MemberEntity;
import com.mg.dev.postgres.api.Member.MemberFavoriteEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * 가게 entity
 */
@Entity
@ToString(exclude = "member")
@Getter
@Setter
@Table(name = "shop")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ShopEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shop_id")
    private Long id;

    private String name;

    private String city;

    @Column(length = 500)
    private String addr;

    @Column(length = 500)
    private String link;

    @Column(length = 50)
    private String number;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private MemberEntity member;

    @OneToMany(mappedBy = "shop")
    private List<MemberFavoriteEntity> memberfavoriteList;

    //카테고리
    //메뉴


    @Builder
    public ShopEntity(String name, String city, String addr, String link, String number) {
        this.name = name;
        this.city = city;
        this.addr = addr;
        this.link = link;
        this.number = number;
    }
}
