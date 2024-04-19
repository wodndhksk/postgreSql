package com.mg.dev.postgres.api.Member.repository;

import com.mg.dev.postgres.api.Member.MemberFavoriteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberFavoriteShopRepository extends JpaRepository<MemberFavoriteEntity, Long>, MemberFavoriteShopCustom {

//    List<MemberFavoriteEntity> findDuplicateByMemberAndShop(MemberFavoriteEntity entity);
}
