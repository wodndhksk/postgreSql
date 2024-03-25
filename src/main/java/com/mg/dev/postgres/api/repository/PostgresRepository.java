package com.mg.dev.postgres.api.repository;

import com.mg.dev.postgres.api.PostgresEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostgresRepository extends JpaRepository<PostgresEntity, Long>, PostgresRepositoryCustom {
}
