package com.mg.dev.postgres.api.Member;

import com.mg.dev.postgres.api.shop.ShopEntity;
import com.mg.dev.postgres.common.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Member entity
 */
@Entity
@ToString(exclude = "shopList")
@Getter
@Setter
@Table(name = "member")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberEntity extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(length = 100)
    private String name;

    @Column(length = 100)
    private String nickname;

    @Column(length = 100)
    private LocalDateTime birthday;

    @OneToMany(mappedBy = "member")
    private List<ShopEntity> shopList;

    @OneToMany(mappedBy = "member")
    private List<MemberFavoriteEntity> memberfavoriteList;

    @Builder
    public MemberEntity(String name, String nickname, LocalDateTime birthday, List<ShopEntity> shopList) {
        this.name = name;
        this.nickname = nickname;
        this.birthday = birthday;
        this.shopList = shopList;
    }
}
