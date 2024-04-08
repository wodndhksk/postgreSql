package com.mg.dev.postgres.api.Store.service.impl;

import com.mg.dev.postgres.api.Store.ShopEntity;
import com.mg.dev.postgres.api.Store.dto.ShopDto;
import com.mg.dev.postgres.api.Store.respository.ShopRepository;
import com.mg.dev.postgres.api.Store.service.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ShopServiceImpl implements ShopService {

    private final ShopRepository shopRepository;

    /**
     * Store 정보 여러개 저장
     * @param param
     */
    @Override
    public void insert(List<ShopDto> param) {
        List<ShopEntity> result = param.stream().map((dto) -> {
            ShopEntity store = ShopEntity.builder()
                    .name(dto.getName())
                    .city(dto.getCity())
                    .addr(dto.getAddr())
                    .link(dto.getLink())
                    .number(dto.getNumber())
                    .build();
            return store;
        }).collect(Collectors.toList());

        shopRepository.saveAll(result);
    }

    @Override
    public List<ShopDto> searchStores(ShopDto param) {
        return null;
    }
}
