package com.mg.dev.postgres.api.shop.respository;

import com.mg.dev.postgres.api.shop.ShopEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository extends JpaRepository<ShopEntity, Long>, ShopRepositoryCustom {

}
