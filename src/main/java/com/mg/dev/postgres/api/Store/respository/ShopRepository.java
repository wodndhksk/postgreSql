package com.mg.dev.postgres.api.Store.respository;

import com.mg.dev.postgres.api.Store.ShopEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository extends JpaRepository<ShopEntity, Long> {
}
