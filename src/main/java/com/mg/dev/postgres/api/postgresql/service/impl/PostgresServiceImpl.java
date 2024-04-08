package com.mg.dev.postgres.api.postgresql.service.impl;

import com.mg.dev.postgres.aop.annotation.LogTrace;
import com.mg.dev.postgres.api.postgresql.PostgresEntity;
import com.mg.dev.postgres.api.postgresql.service.PostgresService;
import com.mg.dev.postgres.api.postgresql.repository.PostgresRepository;
import com.mg.dev.postgres.dto.PostgresqlDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class PostgresServiceImpl implements PostgresService {
    private final PostgresRepository postgresRepository;
    @LogTrace
    @Override
    public List<PostgresqlDto> search() {
        List<PostgresEntity> entities = postgresRepository.search();
        List<PostgresqlDto> searchDtoList = entities.stream().map((e) -> {
            PostgresqlDto searchDto = PostgresqlDto.builder()
                    .num(e.getNum())
                    .title(e.getTitle())
                    .name(e.getName())
                    .description(e.getDescription())
                    .build();
            return searchDto;
        }).collect(Collectors.toList());

        return searchDtoList;
    }

    @Override
    public void insert(List<PostgresqlDto> dto) {
        List<PostgresEntity> entities = dto.stream().map((d) -> {
            PostgresEntity entity = PostgresEntity.builder()
                    .num(d.getNum())
                    .title(d.getTitle())
                    .name(d.getName())
                    .description(d.getDescription())
                    .build();
            return entity;
        }).collect(Collectors.toList());
        // 저장
        postgresRepository.saveAll(entities);
    }
}
