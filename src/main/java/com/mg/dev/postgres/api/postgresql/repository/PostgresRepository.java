package com.mg.dev.postgres.api.postgresql.repository;

import com.mg.dev.postgres.api.postgresql.PostgresEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostgresRepository extends JpaRepository<PostgresEntity, Long>, PostgresRepositoryCustom {
}
