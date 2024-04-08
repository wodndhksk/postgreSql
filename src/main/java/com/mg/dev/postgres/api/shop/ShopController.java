package com.mg.dev.postgres.api.shop;

import com.mg.dev.postgres.api.shop.dto.ShopReqDto;
import com.mg.dev.postgres.api.shop.dto.ShopResDto;
import com.mg.dev.postgres.api.shop.service.ShopService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/shop")
public class ShopController {
    private final ShopService shopService;

    /**
     * 테스트 데이터 insert
     */
    @PostConstruct
    public void testInsert() {
        List<ShopReqDto> list = new ArrayList<>();
        int max = 10;
        String testNm = "test-";

        for(int i=0; i<max; i++){
            ShopReqDto dto = ShopReqDto.builder()
                    .name(testNm + i)
                    .city("testCity" + i)
                    .addr("testAddress" + i)
                    .number(UUID.randomUUID().toString())
                    .link("010-1111-111"+i)
                    .build();
            list.add(dto);
        }
        shopService.insert(list);
    }

    @GetMapping("")
    public String shop() {
        return "shop";
    }

    @PostMapping("/search")
    public List<ShopResDto> searchShops(@RequestBody ShopReqDto shopReqDto){
        log.info("shopReqDto={}", shopReqDto);
        return shopService.searchStores(shopReqDto);
    }

}
