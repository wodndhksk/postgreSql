package com.mg.dev.postgres.api.Member;

import com.mg.dev.postgres.api.shop.ShopEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@ToString(exclude = "shopList")
@Getter
@Table(name = "member_favorite", uniqueConstraints = {
        @UniqueConstraint(name = "constraintName", columnNames = {"member_id", "shop_id"})
})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberFavoriteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_favorite_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private MemberEntity member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shop_id")
    private ShopEntity shop;

}
