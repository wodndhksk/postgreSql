package com.mg.dev.postgres.api.Store.service;

import com.mg.dev.postgres.api.Store.dto.ShopDto;

import java.util.List;

public interface ShopService {

    void insert(List<ShopDto> param);

    List<ShopDto> searchStores(ShopDto param);
}
