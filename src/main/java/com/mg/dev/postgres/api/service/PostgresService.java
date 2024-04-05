package com.mg.dev.postgres.api.service;

import com.mg.dev.postgres.dto.PostgresSearchDto;

import java.util.List;

public interface PostgresService {
    List<PostgresSearchDto> search();

    void insert(List<PostgresSearchDto> dto);
}
