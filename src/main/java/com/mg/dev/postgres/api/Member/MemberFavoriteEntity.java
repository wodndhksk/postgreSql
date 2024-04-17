package com.mg.dev.postgres.api.Member;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
//@ToString(exclude = "shopList")
@Getter
//@Table(name = "member_favorite", uniqueConstraints = {
//        @UniqueConstraint(name = "constraintName", columnNames = {"member_id", "shop_id"})
//})
@Table(name = "member_favorite")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberFavoriteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_favorite_id")
    private Long id;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "member_id")
//    @Column(name = "member_id")
//    private MemberEntity member;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "shop_id")
//    @Column(name = "shop_id")
//    private ShopEntity shop;
//
//    @Builder
//    public MemberFavoriteEntity(MemberEntity member, ShopEntity shop) {
//        this.member = member;
//        this.shop = shop;
//    }
}
