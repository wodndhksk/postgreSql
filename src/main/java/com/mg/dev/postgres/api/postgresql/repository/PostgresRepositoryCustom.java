package com.mg.dev.postgres.api.postgresql.repository;

import com.mg.dev.postgres.api.postgresql.PostgresEntity;

import java.util.List;

public interface PostgresRepositoryCustom {

    List<PostgresEntity> search();
}
