package com.mg.dev.postgres.api.Store.respository;

import com.mg.dev.postgres.api.Store.StoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<StoreEntity, Long> {
}
