package com.mg.dev.postgres.api.postgresql.service;

import com.mg.dev.postgres.dto.PostgresqlDto;

import java.util.List;

public interface PostgresService {
    List<PostgresqlDto> search();

    void insert(List<PostgresqlDto> dto);
}
