package com.mg.dev.postgres.api.Store.service.impl;

import com.mg.dev.postgres.api.Store.StoreEntity;
import com.mg.dev.postgres.api.Store.dto.StoreDto;
import com.mg.dev.postgres.api.Store.respository.StoreRepository;
import com.mg.dev.postgres.api.Store.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;

    /**
     * Store 정보 여러개 저장
     * @param param
     */
    @Override
    public void insert(List<StoreDto> param) {
        List<StoreEntity> result = param.stream().map((dto) -> {
            StoreEntity store = StoreEntity.builder()
                    .name(dto.getName())
                    .city(dto.getCity())
                    .addr(dto.getAddr())
                    .link(dto.getLink())
                    .number(dto.getNumber())
                    .build();
            return store;
        }).collect(Collectors.toList());

        storeRepository.saveAll(result);
    }

    @Override
    public List<StoreDto> searchStores(StoreDto param) {
        return null;
    }
}
