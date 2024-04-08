package com.mg.dev.postgres.api.shop.respository;

import com.mg.dev.postgres.api.shop.dto.ShopReqDto;
import com.mg.dev.postgres.api.shop.dto.ShopResDto;

import java.util.List;

public interface ShopRepositoryCustom {
    List<ShopResDto> shopEntityList(ShopReqDto param);
}
