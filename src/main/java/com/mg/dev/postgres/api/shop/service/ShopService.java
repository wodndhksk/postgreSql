package com.mg.dev.postgres.api.shop.service;

import com.mg.dev.postgres.api.shop.dto.ShopReqDto;
import com.mg.dev.postgres.api.shop.dto.ShopResDto;

import java.util.List;

public interface ShopService {

    void insert(List<ShopReqDto> param);

    List<ShopResDto> searchStores(ShopReqDto param);
}
