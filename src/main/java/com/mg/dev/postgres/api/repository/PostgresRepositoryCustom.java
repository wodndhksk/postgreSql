package com.mg.dev.postgres.api.repository;

import com.mg.dev.postgres.api.PostgresEntity;

import java.util.List;

public interface PostgresRepositoryCustom {

    List<PostgresEntity> search();
}
