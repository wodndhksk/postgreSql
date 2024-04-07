package com.mg.dev.postgres.api.Member;

import com.mg.dev.postgres.api.Store.StoreEntity;
import com.mg.dev.postgres.common.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Member entity
 */
@Entity
@ToString(exclude = "stores")
@Getter
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
    private List<StoreEntity> stores;
}