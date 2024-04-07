package com.mg.dev.postgres.api.Store.service;

import com.mg.dev.postgres.api.Store.dto.StoreDto;

import java.util.List;

public interface StoreService {

    void insert(List<StoreDto> param);

    List<StoreDto> searchStores(StoreDto param);
}
